package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MMemberExtendEntity;
import com.tianyalei.jipiao.core.repository.MemberExtendRepository;
import com.tianyalei.jipiao.core.request.MemberAddRequestModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * remark相关
 * @author wuweifeng wrote on 2018/11/6.
 */
@Service
public class MemberExtendManager {
    @Resource
    private MemberExtendRepository memberExtendRepository;

    public void add(MMemberExtendEntity mMemberExtendEntity) {
        save(mMemberExtendEntity);
    }

    public void update(MMemberExtendEntity mMemberExtendEntity) {
        save(mMemberExtendEntity);
    }

    public MMemberExtendEntity findByCardNum(String cardNum) {
        return memberExtendRepository.findByCardNum(cardNum);
    }

    public String findRemarkByCardNum(String cardNum) {
        MMemberExtendEntity mMemberExtendEntity = findByCardNum(cardNum);
        if (mMemberExtendEntity == null) {
            return null;
        }
        return mMemberExtendEntity.getRemark();
    }

    /**
     * 新增或修改remark
     */
    public void parse(MemberAddRequestModel memberAddRequestModel) {
        MMemberExtendEntity mMemberExtendEntity = memberExtendRepository.findByCardNum(memberAddRequestModel
                .getCardNum());
        if (mMemberExtendEntity == null) {
            mMemberExtendEntity = new MMemberExtendEntity();
            mMemberExtendEntity.setCardNum(memberAddRequestModel.getCardNum());
            mMemberExtendEntity.setRemark(memberAddRequestModel.getRemark());
            add(mMemberExtendEntity);
        } else {
            mMemberExtendEntity.setRemark(memberAddRequestModel.getRemark());
            update(mMemberExtendEntity);
        }
    }

    private void save(MMemberExtendEntity mMemberExtendEntity) {
        memberExtendRepository.save(mMemberExtendEntity);
    }
}
