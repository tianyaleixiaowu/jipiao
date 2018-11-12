package com.tianyalei.jipiao.global.aop;

import com.tianyalei.jipiao.core.model.base.BaseEntity;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

/**
 * @author wuweifeng wrote on 2017/10/23.
 */
@Aspect
@Component
@Order(2)
public class CreateUserAspect {

    @Around("@annotation(createUserAnnotation)")
    public Object around(ProceedingJoinPoint pjp, CreateUserAnnotation createUserAnnotation) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String userId = request.getAttribute("userId").toString();
        String userName = request.getAttribute("userName").toString();

        Object[] obj = pjp.getArgs();
        for (Object o : obj) {
            if (!(o instanceof ApplicationEvent)) {
                continue;
            }
            BaseEntity baseIdEntity = (BaseEntity) ((ApplicationEvent) o).getSource();
            baseIdEntity.setCreateUserId(userId);
            baseIdEntity.setCreateRealName(userName);
            baseIdEntity.setCreateTime(new Timestamp(System.currentTimeMillis()));
            baseIdEntity.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        }
        return pjp.proceed();
    }

}
