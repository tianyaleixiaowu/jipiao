package com.tianyalei.jipiao.global.aop;

import com.tianyalei.jipiao.core.model.MOperationLogEntity;
import com.tianyalei.jipiao.core.model.base.BaseEntity;
import com.tianyalei.jipiao.core.model.base.BaseIdEntity;
import com.xiaoleilu.hutool.json.JSONUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

/**
 * @author wuweifeng wrote on 2017/10/23.
 */
@Aspect
@Component
@Order(2)
public class SavePointAspect {
    @Resource
    private OperationLogManager operationLogManager;

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Pointcut("execution(public * com.tianyalei.jipiao.core.manager.*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String userId = "";
        String userName = "";
        Object tempUserId = request.getAttribute("userId");
        if (tempUserId != null) {
            userId = tempUserId.toString();
            Object o = request.getAttribute("userName");
            if (o != null) {
                userName = o.toString();
            }
        }

        String method = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringTypeName();

        Object[] obj = joinPoint.getArgs();
        for (Object o : obj) {
            if (!(o instanceof BaseIdEntity)) {
                continue;
            }
            BaseEntity baseIdEntity = (BaseEntity) o;

            //添加系统日志
            MOperationLogEntity operationLogEntity = new MOperationLogEntity();
            if (!method.contains("add") && !method.contains("update") && !method.contains("delete")) {
                continue;
            }

            if (method.contains("add")) {
                baseIdEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));
                operationLogEntity.setOperationType("add");
            } else if (method.contains("update")) {
                baseIdEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));
                operationLogEntity.setOperationType("update");
            } else if (method.contains("delete")) {
                operationLogEntity.setOperationType("delete");
            }

            baseIdEntity.setCreateUserId(userId);
            baseIdEntity.setCreateRealName(userName);
            baseIdEntity.setUpdateTime(new Timestamp(System.currentTimeMillis()));

            String jsonContent = JSONUtil.toJsonStr(o);
            operationLogEntity.setContent(jsonContent);
            operationLogEntity.setSucceed(true);

            //如："cardNum":"123445","createUserId":"1"
            if (jsonContent.contains("cardNum")) {
                int index = jsonContent.indexOf("cardNum");
                int douhaoIndex = jsonContent.indexOf(",", index);
                String cardNum = jsonContent.substring(index, douhaoIndex).replace("\"", "");
                //keyword内容是操作的对象的cardNum
                operationLogEntity.setKeyword(cardNum);
            } else {
                if (baseIdEntity instanceof BaseIdEntity) {
                    operationLogEntity.setKeyword("Id:" + ((BaseIdEntity) baseIdEntity).getId());
                }
            }

            operationLogEntity.setTitle(className.replace("com.tianyalei.jipiao.core.manager.", "") + "." + method);

            operationLogEntity.setCreateUserId(userId + "");
            operationLogEntity.setCreateRealName(userName);
            operationLogEntity.setCreateUserName(userName);
            operationLogEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));
            request.setAttribute("operationLogEntity", operationLogEntity);
        }

    }


    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {

    }

    //后置异常通知
    @AfterThrowing(throwing = "ex", pointcut = "webLog()")
    public void throwExceptions(JoinPoint jp, Exception ex) {
        logger.info("方法异常时执行.....");
        MOperationLogEntity operationLogEntity = getFromJoinPoint(jp);
        if (operationLogEntity == null) {
            return;
        }
        operationLogEntity.setSucceed(false);
        operationLogManager.operationLog(operationLogEntity);
        

    }

    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
    @After("webLog()")
    public void after(JoinPoint jp) {
        MOperationLogEntity operationLogEntity = getFromJoinPoint(jp);
        if (operationLogEntity == null) {
            return;
        }
        operationLogManager.operationLog(operationLogEntity);
//        logger.info("方法最后执行.....");
    }

    private MOperationLogEntity getFromJoinPoint(JoinPoint jp) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        return  (MOperationLogEntity) request.getAttribute("operationLogEntity");
    }
}
