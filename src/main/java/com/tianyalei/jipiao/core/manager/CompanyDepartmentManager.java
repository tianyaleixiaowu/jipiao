package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MCompanyDepartmentEntity;
import com.tianyalei.jipiao.core.repository.CompanyDepartmentRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Service
public class CompanyDepartmentManager {
    @Resource
    private CompanyDepartmentRepository companyDepartmentRepository;

    public String findName(Integer deptId) {
        MCompanyDepartmentEntity entity = find(deptId);
        if (entity == null) {
            return "缺失";
        }
        return entity.getDepartmentName();
    }

    public MCompanyDepartmentEntity find(Integer id) {
        return companyDepartmentRepository.getOne(id);
    }

    public MCompanyDepartmentEntity add(MCompanyDepartmentEntity mCompanyDepartmentEntity) {
        return companyDepartmentRepository.save(mCompanyDepartmentEntity);
    }

    public MCompanyDepartmentEntity update(MCompanyDepartmentEntity mCompanyDepartmentEntity) {
        return companyDepartmentRepository.save(mCompanyDepartmentEntity);
    }

    public void delete(Integer id) {
        companyDepartmentRepository.deleteById(id);
    }

    public List<MCompanyDepartmentEntity> findByCompanyId(Integer companyId) {
        return companyDepartmentRepository.findByCompanyIdAndIsEnableTrue(companyId);
    }


}
