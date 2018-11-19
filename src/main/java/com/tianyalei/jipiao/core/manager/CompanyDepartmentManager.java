package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MCompanyDepartmentEntity;
import com.tianyalei.jipiao.core.repository.CompanyDepartmentRepository;
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
public class CompanyDepartmentManager {
    @Resource
    private CompanyDepartmentRepository companyDepartmentRepository;

    public String findName(Integer deptId) {
        try {
            MCompanyDepartmentEntity entity = find(deptId);
            if (entity == null) {
                return "缺失";
            }
            return entity.getDepartmentName();
        } catch (Exception e) {
            return "缺失";
        }

    }

    public MCompanyDepartmentEntity find(Integer id) {
        return companyDepartmentRepository.getOne(id);
    }

    public MCompanyDepartmentEntity add(MCompanyDepartmentEntity mCompanyDepartmentEntity) {
        return save(mCompanyDepartmentEntity);
    }

    public MCompanyDepartmentEntity update(MCompanyDepartmentEntity mCompanyDepartmentEntity) {
        return save(mCompanyDepartmentEntity);
    }

    private MCompanyDepartmentEntity save(MCompanyDepartmentEntity mCompanyDepartmentEntity) {
        return companyDepartmentRepository.save(mCompanyDepartmentEntity);
    }

    public void delete(Integer id) {
        MCompanyDepartmentEntity entity = find(id);
        entity.setIsEnable(false);
        update(entity);
    }

    public SimplePage<MCompanyDepartmentEntity> findByCompanyId(Integer companyId, int pp, int size) {
        if (size == 0) {
            size = 10;
        }
        Pageable pageable = PageRequest.of(pp, size);
        Page<MCompanyDepartmentEntity> page = companyDepartmentRepository.findByCompanyIdAndIsEnableTrue(companyId, pageable);
        return new SimplePage<>(page.getTotalPages(), page
                .getTotalElements(), page.getContent());
    }


}
