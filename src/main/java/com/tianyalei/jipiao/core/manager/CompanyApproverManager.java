package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MCompanyApproverEntity;
import com.tianyalei.jipiao.core.repository.CompanyApproverRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    public List<MCompanyApproverEntity> findByCompanyId(Integer companyId) {
        return companyApproverRepository.findByCompanyId(companyId);
    }
}
