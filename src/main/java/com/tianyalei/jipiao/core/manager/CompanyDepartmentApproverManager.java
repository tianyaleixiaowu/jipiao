package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MCompanyDepartmentApproverEntity;
import com.tianyalei.jipiao.core.repository.CompanyDepartmentApproverRepository;
import com.tianyalei.jipiao.core.response.CompanyDepartmentApproverVO;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import com.tianyalei.jipiao.global.bean.SimplePage;
import com.xiaoleilu.hutool.util.BeanUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.stream.Collectors;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Service
public class CompanyDepartmentApproverManager {
    @Resource
    private CompanyDepartmentApproverRepository companyDepartmentApproverRepository;
    @Resource
    private CompanyDepartmentManager companyDepartmentManager;


    public BaseData add(MCompanyDepartmentApproverEntity mCompanyEntity) {
        MCompanyDepartmentApproverEntity entity = companyDepartmentApproverRepository.findFirstByDepartmentIdAndCardNum
                (mCompanyEntity.getDepartmentId(),
                mCompanyEntity.getCardNum());
        if (entity != null) {
            return ResultGenerator.genFailResult("已存在审批人");
        }

        return ResultGenerator.genSuccessResult(save(mCompanyEntity));
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

    public SimplePage<CompanyDepartmentApproverVO> findByDeptId(Integer deptId, int pp , int size) {
        if (size == 0) {
            size = 10;
        }
        Pageable pageable = PageRequest.of(pp, size);
        Page<MCompanyDepartmentApproverEntity> page = companyDepartmentApproverRepository.findByDepartmentId(deptId,
                pageable);
        return new SimplePage<>(page.getTotalPages(), page
                .getTotalElements(), page.getContent().stream().map(this::parse).collect(Collectors.toList()));
    }

    public SimplePage<CompanyDepartmentApproverVO> findByCompanyId(Integer companyId, int pp, int size) {
        if (size == 0) {
            size = 10;
        }
        Pageable pageable = PageRequest.of(pp, size);
        Page<MCompanyDepartmentApproverEntity> page = companyDepartmentApproverRepository.findByCompanyId(companyId,
                pageable);
        return new SimplePage<>(page.getTotalPages(), page
                .getTotalElements(), page.getContent().stream().map(this::parse).collect(Collectors.toList()));
    }

    private CompanyDepartmentApproverVO parse(MCompanyDepartmentApproverEntity companyDepartmentApproverEntity) {
        CompanyDepartmentApproverVO vo = new CompanyDepartmentApproverVO();
        BeanUtil.copyProperties(companyDepartmentApproverEntity, vo);
        vo.setDeptName(companyDepartmentManager.findName(companyDepartmentApproverEntity.getDepartmentId()));
        return vo;
    }

    public BaseData validate(MCompanyDepartmentApproverEntity m){
        MCompanyDepartmentApproverEntity departmentIDAndCardNum = companyDepartmentApproverRepository.findByCompanyIdAndDepartmentIdAndCardNum(m.getCompanyId(),m.getDepartmentId(),m.getCardNum());
        if(departmentIDAndCardNum != null){
            return ResultGenerator.genFailResult("已存在审批人");
        }
        return null;
    }
}
