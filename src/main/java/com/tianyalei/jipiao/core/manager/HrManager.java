package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MHrDepartmentEntity;
import com.tianyalei.jipiao.core.model.MHrEmployeeEntity;
import com.tianyalei.jipiao.core.model.MHrOrganizationEntity;
import com.tianyalei.jipiao.core.model.MHrRelationalEntity;
import com.tianyalei.jipiao.core.model.base.BaseEntity;
import com.tianyalei.jipiao.core.repository.HrDepartmentRepository;
import com.tianyalei.jipiao.core.repository.HrEmployeeRepository;
import com.tianyalei.jipiao.core.repository.HrOrganizationRepository;
import com.tianyalei.jipiao.core.repository.HrRelationalRepository;
import com.tianyalei.jipiao.global.aop.CreateUserAnnotation;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import com.tianyalei.jipiao.global.excel.ExcelUtils;
import com.xiaoleilu.hutool.util.CollectionUtil;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/9.
 */
@Service
public class HrManager {
    @Resource
    private HrDepartmentRepository hrDepartmentRepository;
    @Resource
    private HrOrganizationRepository hrOrganizationRepository;
    @Resource
    private HrEmployeeRepository hrEmployeeRepository;
    @Resource
    private HrRelationalRepository hrRelationalRepository;


    //比对的项目包含：键重复的（组织结构ID，部门ID，职工ID，HR编号），身份证格式错误

    public <T extends BaseEntity> BaseData deal(HttpServletResponse response, MultipartFile file, boolean preview,
                                                Class<T> object) {
        //解析来的excel所有数据
        List<T> list = parseFile(file, object);
        if (preview) {
            return ResultGenerator.genSuccessResult(list);
        } else {
            List<T> failureList = saveAndReturnFailure(list);
            if (CollectionUtil.isEmpty(failureList))  {
                return ResultGenerator.genSuccessResult("上传成功");
            } else {
                ExcelUtils.writeExcel(response, failureList, object);
                return null;
            }
        }
    }


    private <T extends BaseEntity> List<T> parseFile(MultipartFile file, Class<T> clazz) {
        return ExcelUtils.readExcel("", clazz, file);
    }

    public <T extends BaseEntity> List<T> saveAndReturnFailure(List<T> list) {
        List<T> failureList = new ArrayList<>();
        for (T t : list) {
            try {
                if (t instanceof MHrDepartmentEntity) {
                    //addDept((MHrDepartmentEntity) t);
                    eventPublisher.publishEvent(new HrEvent(t));
                } else if (t instanceof MHrEmployeeEntity) {
                    addEmployee((MHrEmployeeEntity) t);
                } else if (t instanceof MHrOrganizationEntity) {
                    addOrgz((MHrOrganizationEntity) t);
                } else if (t instanceof MHrRelationalEntity) {
                    addRelation((MHrRelationalEntity) t);
                }
            } catch (Exception e) {
                //如果有id重复的，就会失败，把失败的都存起来
                failureList.add(t);
            }
        }
        return failureList;
    }

    @Resource
    private ApplicationEventPublisher eventPublisher;

    @CreateUserAnnotation
    @EventListener(HrEvent.class)
    public void addDept(HrEvent hrEvent) {
        if (hrEvent.getSource() instanceof MHrDepartmentEntity) {
            hrDepartmentRepository.save((MHrDepartmentEntity)hrEvent.getSource());
        }

    }

    @CreateUserAnnotation
    private void addOrgz(MHrOrganizationEntity organizationEntity) {
        hrOrganizationRepository.save(organizationEntity);
    }

    @CreateUserAnnotation
    private void addEmployee(MHrEmployeeEntity employeeEntity) {
        hrEmployeeRepository.save(employeeEntity);
    }

    @CreateUserAnnotation
    private void addRelation(MHrRelationalEntity relationalEntity) {
        hrRelationalRepository.save(relationalEntity);
    }

    private class HrEvent extends ApplicationEvent {
        //Object baseEntity;

        public HrEvent(Object source) {
            super(source);
            //this.baseEntity =source;
        }
    }
}
