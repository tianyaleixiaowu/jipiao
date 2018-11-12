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
                eventPublisher.publishEvent(new HrEvent(t));
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
        Object object = hrEvent.getSource();
        if (object instanceof MHrDepartmentEntity) {
            if (hrDepartmentRepository.existsById(((MHrDepartmentEntity) object).getDepId())) {
                throw new RuntimeException();
            }

            hrDepartmentRepository.save((MHrDepartmentEntity) object);
        } else if (object instanceof MHrOrganizationEntity) {
            if (hrOrganizationRepository.existsById(((MHrOrganizationEntity) object).getOrgId())) {
                throw new RuntimeException();
            }
            hrOrganizationRepository.save((MHrOrganizationEntity) object);
        } else if (object instanceof MHrEmployeeEntity) {
            if (hrEmployeeRepository.existsById(((MHrEmployeeEntity) object).getEmployeeId())) {
                throw new RuntimeException();
            }
            hrEmployeeRepository.save((MHrEmployeeEntity) object);
        } else if (object instanceof MHrRelationalEntity) {
            MHrRelationalEntity oo = (MHrRelationalEntity) object;
            MHrRelationalEntity entity = hrRelationalRepository.findFirstByDeptIdAndEmployeeId(oo.getDeptId(),
                    oo.getEmployeeId());
            if (entity != null) {
                throw new RuntimeException();
            }
            hrRelationalRepository.save(oo);
        }

    }

    private class HrEvent extends ApplicationEvent {
        public HrEvent(Object source) {
            super(source);
        }
    }
}
