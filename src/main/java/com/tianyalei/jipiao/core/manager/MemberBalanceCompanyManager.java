package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MMemberBalanceCompanyEntity;
import com.tianyalei.jipiao.core.repository.MemberBalanceCompanyRepository;
import com.tianyalei.jipiao.core.request.MemberAddRequestModel;
import com.tianyalei.jipiao.core.response.MemberBalanceListResponseVO;
import com.tianyalei.jipiao.global.bean.SimplePage;
import com.xiaoleilu.hutool.util.BeanUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Service
public class MemberBalanceCompanyManager {
    @Resource
    private MemberBalanceCompanyRepository memberBalanceCompanyRepository;
    @Resource
    private CompanyManager companyManager;
    @Resource
    private MemberBalanceCompanySingleManager memberBalanceCompanySingleManager;
    @Resource
    private CompanyTravelLevelManager companyTravelLevelManager;

    public void addOrUpdate(MMemberBalanceCompanyEntity tempEntity) {
        MMemberBalanceCompanyEntity entity = memberBalanceCompanyRepository.findByCardNumAndCompanyId
                (tempEntity.getCardNum(), tempEntity.getCompanyId()
                );
        if (entity == null) {
            entity = new MMemberBalanceCompanyEntity();
            entity.setCardNum(tempEntity.getCardNum());
            entity.setCompanyId(tempEntity.getCompanyId());
            entity.setCompanyName(companyManager.findName(tempEntity.getCompanyId()));
            entity.setIsEnable(true);
            entity.setTravelLevelId(tempEntity.getTravelLevelId());

            memberBalanceCompanySingleManager.add(entity);
        } else {
            entity.setCompanyName(companyManager.findName(tempEntity.getCompanyId()));
            entity.setIsEnable(true);
            entity.setTravelLevelId(tempEntity.getTravelLevelId());

            memberBalanceCompanySingleManager.update(entity);
        }
    }

    public void addOrUpdate(MemberAddRequestModel memberAddRequestModel) {
        MMemberBalanceCompanyEntity entity = new MMemberBalanceCompanyEntity();
        BeanUtil.copyProperties(memberAddRequestModel, entity);
        entity.setCompanyName(companyManager.findName(memberAddRequestModel.getCompanyId()));
        addOrUpdate(entity);
    }

    public void delete(Integer id) {
        memberBalanceCompanyRepository.deleteById(id);
    }

    public MemberBalanceListResponseVO find(Integer id) {
        MMemberBalanceCompanyEntity entity = memberBalanceCompanyRepository.getOne(id);
        return parse(entity);
    }

    public List<MMemberBalanceCompanyEntity> findByCardNum(String cardNum) {
        return memberBalanceCompanyRepository.findByCardNumOrderByIdDesc
                (cardNum);
    }

    public SimplePage<MemberBalanceListResponseVO> list(String cardNum, Pageable pageable) {
        Page<MMemberBalanceCompanyEntity> page = memberBalanceCompanyRepository
                .findByCardNumOrderByIdDesc(cardNum, pageable);

        return new SimplePage<>(page.getTotalPages(), page.getTotalElements(), page.getContent().stream()
                .map(this::parse).collect(Collectors.toList()));
    }

    private MemberBalanceListResponseVO parse(MMemberBalanceCompanyEntity entity) {
        MemberBalanceListResponseVO vo = new MemberBalanceListResponseVO();
        BeanUtil.copyProperties(entity, vo);
        vo.setTravelLevelName(companyTravelLevelManager.find(entity.getTravelLevelId()).getLevelName());
        return vo;
    }
}
