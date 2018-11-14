package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MCompanyApproverEntity;
import com.tianyalei.jipiao.core.repository.CompanyApproverRepository;
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
public class CompanyApproverManager {
    @Resource
    private CompanyApproverRepository companyApproverRepository;


    public MCompanyApproverEntity add(MCompanyApproverEntity mCompanyEntity) {
        return save(mCompanyEntity);
    }

    public MCompanyApproverEntity update(MCompanyApproverEntity mCompanyEntity) {
        return save(mCompanyEntity);
    }

    public MCompanyApproverEntity delete(Integer id) {
        MCompanyApproverEntity entity = find(id);
        entity.setIsEnable(false);
        return update(entity);
    }

    private MCompanyApproverEntity save(MCompanyApproverEntity mCompanyApproverEntity) {
        return companyApproverRepository.save(mCompanyApproverEntity);
    }

    public MCompanyApproverEntity find(Integer id) {
        return companyApproverRepository.getOne(id);
    }

    public SimplePage<MCompanyApproverEntity> findByCompanyId(Integer companyId, int pp, int size) {
        if (size == 0) {
            size = 10;
        }
        Pageable pageable = PageRequest.of(pp, size);
        Page<MCompanyApproverEntity> page = companyApproverRepository.findByCompanyId(companyId,
                pageable);
        return new SimplePage<>(page.getTotalPages(), page
                .getTotalElements(), page.getContent());
    }
}
