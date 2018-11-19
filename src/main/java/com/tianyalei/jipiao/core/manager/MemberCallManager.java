package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MMemberCallEntity;
import com.tianyalei.jipiao.core.request.MemberAddRequestModel;
import com.tianyalei.jipiao.global.util.CommonUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * 手机号存储
 * @author wuweifeng wrote on 2018/11/1.
 */
@Service
public class MemberCallManager {
    @Resource
    private MemberCallSingleManager memberCallSingleManager;

    void parse(MemberAddRequestModel mMemberEntity) {
        MMemberCallEntity mMemberCallEntity = new MMemberCallEntity();
        mMemberCallEntity.setCardNum(mMemberEntity.getCardNum());
        mMemberCallEntity.setCallPhone(CommonUtil.aesEncode(mMemberEntity.getCellPhone()));
        memberCallSingleManager.add(mMemberCallEntity);
        if (!StringUtils.isEmpty(mMemberEntity.getBackupCellPhone())) {
            MMemberCallEntity mMemberCallEntity1 = new MMemberCallEntity();
            mMemberCallEntity1.setCardNum(mMemberEntity.getCardNum());
            mMemberCallEntity1.setCallPhone(CommonUtil.aesEncode(mMemberEntity.getBackupCellPhone()));
            memberCallSingleManager.add(mMemberCallEntity1);
        }
        if (!StringUtils.isEmpty(mMemberEntity.getPhoneNum())) {
            MMemberCallEntity mMemberCallEntity1 = new MMemberCallEntity();
            mMemberCallEntity1.setCardNum(mMemberEntity.getCardNum());
            mMemberCallEntity1.setCallPhone(CommonUtil.aesEncode(mMemberEntity.getPhoneNum()));
            memberCallSingleManager.add(mMemberCallEntity1);
        }
    }

}
