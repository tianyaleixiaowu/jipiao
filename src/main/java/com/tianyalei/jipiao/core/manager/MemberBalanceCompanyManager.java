package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MMemberBalanceCompanyEntity;
import com.tianyalei.jipiao.core.repository.MemberBalanceCompanyRepository;
import com.tianyalei.jipiao.core.request.MemberAddRequestModel;
import com.tianyalei.jipiao.global.bean.SimplePage;
import com.xiaoleilu.hutool.util.CollectionUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Service
public class MemberBalanceCompanyManager {
    @Resource
    private MemberBalanceCompanyRepository memberBalanceCompanyRepository;
    @Resource
    private CompanyManager companyManager;

    public MMemberBalanceCompanyEntity add(MMemberBalanceCompanyEntity mMemberBalanceCompanyEntity) {
        return memberBalanceCompanyRepository.save(mMemberBalanceCompanyEntity);
    }

    public void parse(MemberAddRequestModel memberAddRequestModel) {
        List<MMemberBalanceCompanyEntity> entities = memberBalanceCompanyRepository.findByCardNum
                (memberAddRequestModel.getCardNum());
        MMemberBalanceCompanyEntity entity;
        if (CollectionUtil.isEmpty(entities)) {
            entity = new MMemberBalanceCompanyEntity();
            entity.setCardNum(memberAddRequestModel.getCardNum());
            entity.setCompanyId(memberAddRequestModel.getCompanyId());
            entity.setCompanyName(companyManager.findName(memberAddRequestModel.getCompanyId()));
            entity.setIsEnable(true);
            entity.setTravelLevelId(memberAddRequestModel.getTravelLevelId());
            add(entity);
        } else {
            entity = entities.get(0);
            entity.setCompanyId(memberAddRequestModel.getCompanyId());
            entity.setCompanyName(companyManager.findName(memberAddRequestModel.getCompanyId()));
            entity.setTravelLevelId(memberAddRequestModel.getTravelLevelId());
            update(entity);
        }

    }

    public MMemberBalanceCompanyEntity update(MMemberBalanceCompanyEntity mMemberBalanceCompanyEntity) {
        return memberBalanceCompanyRepository.save(mMemberBalanceCompanyEntity);
    }

    public void delete(Integer id) {
        memberBalanceCompanyRepository.deleteById(id);
    }

    public MMemberBalanceCompanyEntity find(Integer id) {
        return memberBalanceCompanyRepository.getOne(id);
    }

    public MMemberBalanceCompanyEntity findByCardNum(String cardNum) {
        List<MMemberBalanceCompanyEntity> entities = memberBalanceCompanyRepository.findByCardNum
                (cardNum);

        if (CollectionUtil.isEmpty(entities)) {
            return null;
        }
        return entities.get(0);
    }

    public SimplePage<MMemberBalanceCompanyEntity> list(String cardNum, Pageable pageable) {
        Page<MMemberBalanceCompanyEntity> page = memberBalanceCompanyRepository
                .findByCardNum(cardNum, pageable);
        return new SimplePage<>(page.getTotalPages(), page.getTotalElements(), page.getContent());
    }
}
