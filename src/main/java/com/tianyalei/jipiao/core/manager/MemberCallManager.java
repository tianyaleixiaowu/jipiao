package com.tianyalei.jipiao.core.manager;

import com.alibaba.fastjson.JSONObject;
import com.tianyalei.jipiao.core.model.MMemberCallEntity;
import com.tianyalei.jipiao.core.model.MMemberEntity;
import com.tianyalei.jipiao.core.repository.MemberCallRepository;
import com.tianyalei.jipiao.core.repository.MemberRepository;
import com.tianyalei.jipiao.core.request.MemberAddRequestModel;
import com.tianyalei.jipiao.global.util.CommonUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 手机号存储
 * @author wuweifeng wrote on 2018/11/1.
 */
@Service
public class MemberCallManager {
    @Resource
    private MemberCallSingleManager memberCallSingleManager;
    @Resource
    private MemberCallRepository memberCallRepository;
    @Resource
    private MemberRepository memberRepository;

    void parse(MemberAddRequestModel mMemberEntity) {
        if (!StringUtils.isEmpty(mMemberEntity.getCellPhone())) {
            MMemberCallEntity mMemberCallEntity = new MMemberCallEntity();
            mMemberCallEntity.setCardNum(mMemberEntity.getCardNum());
            mMemberCallEntity.setCallPhone(CommonUtil.aesEncode(mMemberEntity.getCellPhone()));
            memberCallSingleManager.add(mMemberCallEntity);
        }
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

    /**
     * CellPhone，BackupCellPhone，PhoneNum，不存在新增，存在更新保持3条
     * @param mMemberEntity
     */
    void parseUpdate(MemberAddRequestModel mMemberEntity) {
        MMemberEntity member = memberRepository.findByCardNum(mMemberEntity.getCardNum());
        //查询手机号和cardnum存在否
        List<MMemberCallEntity> list = memberCallRepository.findByCardNum(mMemberEntity.getCardNum());
        //循环对比哪个需要更新或新增
        list.stream().forEach(m -> {
            if(StringUtils.isEmpty(member.getCellPhone())){
                MMemberCallEntity entity = new MMemberCallEntity();
                entity.setCardNum(mMemberEntity.getCardNum());
                entity.setCallPhone(CommonUtil.aesEncode(mMemberEntity.getCellPhone()));
                memberCallSingleManager.add(entity);
            }else{
                if(m.getCallPhone().equals(member.getCellPhone())){
                    if(!StringUtils.isEmpty(mMemberEntity.getCellPhone())){
                        m.setCallPhone(CommonUtil.aesEncode(mMemberEntity.getCellPhone()));
                        memberCallSingleManager.update(m);
                    }
                }
            }
            if(StringUtils.isEmpty(member.getBackupCellPhone())){
                MMemberCallEntity entity = new MMemberCallEntity();
                entity.setCardNum(mMemberEntity.getCardNum());
                entity.setCallPhone(CommonUtil.aesEncode(mMemberEntity.getBackupCellPhone()));
                memberCallSingleManager.add(entity);
            }else{
                if(m.getCallPhone().equals(member.getBackupCellPhone())){
                    if(!StringUtils.isEmpty(mMemberEntity.getBackupCellPhone())){
                        m.setCallPhone(CommonUtil.aesEncode(mMemberEntity.getBackupCellPhone()));
                        memberCallSingleManager.update(m);
                    }
                }
            }
            if(StringUtils.isEmpty(member.getPhoneNum())){
                MMemberCallEntity entity = new MMemberCallEntity();
                entity.setCardNum(mMemberEntity.getCardNum());
                entity.setCallPhone(CommonUtil.aesEncode(mMemberEntity.getPhoneNum()));
                memberCallSingleManager.add(entity);
            }else{
                if(m.getCallPhone().equals(member.getPhoneNum())){
                    if(!StringUtils.isEmpty(mMemberEntity.getPhoneNum())){
                        m.setCallPhone(CommonUtil.aesEncode(mMemberEntity.getPhoneNum()));
                        memberCallSingleManager.update(m);
                    }
                }
            }
        });

    }

}
