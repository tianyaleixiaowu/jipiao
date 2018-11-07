package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MCompanyEntity;
import com.tianyalei.jipiao.core.repository.CompanyRepository;
import com.tianyalei.jipiao.core.request.CompanyAddRequestModel;
import com.tianyalei.jipiao.core.request.CompanyQueryRequestModel;
import com.tianyalei.jipiao.core.response.CompanyListResponseVO;
import com.tianyalei.jipiao.global.bean.SimplePage;
import com.tianyalei.jipiao.global.cache.DictCache;
import com.tianyalei.jipiao.global.specify.Criteria;
import com.tianyalei.jipiao.global.specify.Restrictions;
import com.xiaoleilu.hutool.util.BeanUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Service
public class CompanyManager {
    @Resource
    private CompanyRepository companyRepository;
    @Resource
    private DictCache dictCache;

    public String findName(Integer companyId) {
        MCompanyEntity companyEntity = find(companyId);
        if (companyEntity == null) {
            return "缺失";
        }
        return companyEntity.getCompanyName();
    }

    public MCompanyEntity add(MCompanyEntity mCompanyEntity) {
        return save(mCompanyEntity);
    }

    public MCompanyEntity update(MCompanyEntity mCompanyEntity) {
        return save(mCompanyEntity);
    }

    public void delete(Integer id) {
        MCompanyEntity entity = find(id);
        entity.setIsEnable(false);
        delete(entity);
    }

    public void delete(MCompanyEntity companyEntity) {
        save(companyEntity);
    }

    private MCompanyEntity save(MCompanyEntity companyEntity) {
        return companyRepository.save(companyEntity);
    }

    public MCompanyEntity find(Integer id) {
        return companyRepository.getOne(id);
    }

    public MCompanyEntity addOrUpdate(CompanyAddRequestModel model, boolean add) {
        Optional<MCompanyEntity> companyEntity = companyRepository.findById(model.getId());
        MCompanyEntity mCompanyEntity;
        if (companyEntity.isPresent()) {
            mCompanyEntity = new MCompanyEntity();
        } else {
            mCompanyEntity = companyEntity.get();
        }

        BeanUtil.copyProperties(model, mCompanyEntity, BeanUtil.CopyOptions.create().setIgnoreNullValue(true));
        mCompanyEntity.setLevel(level(mCompanyEntity.getParentId()));

        if (add) {
            add(mCompanyEntity);
        } else {
            update(mCompanyEntity);
        }

        return mCompanyEntity;
    }

    private byte level(String parentId) {
        Integer tempParentId = Integer.valueOf(parentId);
        if (tempParentId == 0) {
            return 1;
        }
        MCompanyEntity entity = companyRepository.getOne(tempParentId);
        return (byte) (entity.getLevel() + 1);
    }

    /**
     * 查询公司
     */
    public SimplePage<CompanyListResponseVO> list(CompanyQueryRequestModel requestModel) {
        Criteria<MCompanyEntity> criteria = new Criteria<>();
        if (!StringUtils.isEmpty(requestModel.getCompanyName())) {
            //判断是中文还是英文
            if (requestModel.getCompanyName().getBytes().length == requestModel.getCompanyName().length()) {
                criteria.add(Restrictions.like("pinYin", requestModel.getCompanyName(), true));
            } else {
                criteria.add(Restrictions.like("companyName", requestModel.getCompanyName(), true));
            }
        }
        criteria.add(Restrictions.eq("isEnable", requestModel.getEnable(), true));
        criteria.add(Restrictions.eq("panelname", requestModel.getPanelname(), true));

        Pageable pageable = PageRequest.of(requestModel.getPage(), requestModel.getSize(), Sort
                .Direction.DESC, "id");
        Page<MCompanyEntity> ecContactEntities = companyRepository.findAll(criteria, pageable);
        return new SimplePage<>(ecContactEntities.getTotalPages(), ecContactEntities.getTotalElements(),
                ecContactEntities.getContent().stream().map(this::parse).collect(Collectors.toList()));
    }

    private CompanyListResponseVO parse(MCompanyEntity entity) {
        CompanyListResponseVO vo = new CompanyListResponseVO();
        BeanUtil.copyProperties(entity, vo);
        vo.setPanelnameValue(dictCache.findByGroupIdAndKey(53, vo.getPanelname()));
        vo.setApproveTypeValue(dictCache.findByGroupIdAndKey(61, vo.getApproveType()));
        vo.setTravelControlTypeValue(dictCache.findByGroupIdAndKey(55, vo.getTravelControlType()));
        vo.setServerTypeValue(dictCache.findByGroupIdAndKey(58, vo.getServerType()));
        return vo;
    }

}
