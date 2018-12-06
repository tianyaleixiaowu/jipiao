package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MCompanyDepartmentApproverEntity;
import com.tianyalei.jipiao.core.repository.CompanyDepartmentApproverRepository;
import com.tianyalei.jipiao.global.bean.SimplePage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    public SimplePage<MCompanyDepartmentApproverEntity> findByDeptId(Integer deptId, int pp , int size) {
        if (size == 0) {
            size = 10;
        }
        Pageable pageable = PageRequest.of(pp, size);
        Page<MCompanyDepartmentApproverEntity> page = companyDepartmentApproverRepository.findByDepartmentId(deptId,
                pageable);
        return new SimplePage<>(page.getTotalPages(), page
                .getTotalElements(), page.getContent());
    }

    public SimplePage<MCompanyDepartmentApproverEntity> findByCompanyId(Integer companyId, int pp, int size) {
        if (size == 0) {
            size = 10;
        }
        Pageable pageable = PageRequest.of(pp, size);
        Page<MCompanyDepartmentApproverEntity> page = companyDepartmentApproverRepository.findByCompanyId(companyId,
                pageable);
        return new SimplePage<>(page.getTotalPages(), page
                .getTotalElements(), page.getContent());
    }
}
