package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MCompanyDepartmentApproverEntity;
import com.tianyalei.jipiao.core.repository.CompanyDepartmentApproverRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Service
public class CompanyDepartmentApproverManager {
    @Resource
    private CompanyDepartmentApproverRepository companyDepartmentApproverRepository;


    public MCompanyDepartmentApproverEntity add(MCompanyDepartmentApproverEntity mCompanyEntity) {
        return save(mCompanyEntity);
    }

    public MCompanyDepartmentApproverEntity update(MCompanyDepartmentApproverEntity mCompanyEntity) {
        return save(mCompanyEntity);
    }

    public MCompanyDepartmentApproverEntity delete(Integer id) {
        MCompanyDepartmentApproverEntity entity = find(id);
        entity.setIsEnable(false);
        return update(entity);
    }

    private MCompanyDepartmentApproverEntity save(MCompanyDepartmentApproverEntity mCompanyDepartmentApproverEntity) {
        return companyDepartmentApproverRepository.save(mCompanyDepartmentApproverEntity);
    }

    public MCompanyDepartmentApproverEntity find(Integer id) {
        return companyDepartmentApproverRepository.getOne(id);
    }

    public List<MCompanyDepartmentApproverEntity> findByDeptId(Integer deptId) {
        return companyDepartmentApproverRepository.findByDepartmentId(deptId);
    }
}
