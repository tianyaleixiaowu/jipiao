package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MMemberExtendEntity;
import com.tianyalei.jipiao.core.repository.MemberExtendRepository;
import com.tianyalei.jipiao.core.request.MemberAddRequestModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wuweifeng wrote on 2018/11/6.
 */
@Service
public class MemberExtendManager {
    @Resource
    private MemberExtendRepository memberExtendRepository;

    public void add(MMemberExtendEntity mMemberExtendEntity) {
        memberExtendRepository.save(mMemberExtendEntity);
    }

    public void parse(MemberAddRequestModel memberAddRequestModel) {
        MMemberExtendEntity mMemberExtendEntity = new MMemberExtendEntity();
        mMemberExtendEntity.setCardNum(memberAddRequestModel.getCardNum());
        mMemberExtendEntity.setRemark(memberAddRequestModel.getRemark());
        add(mMemberExtendEntity);
    }
}
