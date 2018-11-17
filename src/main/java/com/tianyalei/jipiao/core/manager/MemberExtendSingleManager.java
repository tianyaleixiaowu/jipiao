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
public class MemberExtendSingleManager {
    @Resource
    private MemberExtendRepository memberExtendRepository;

    public void add(MMemberExtendEntity mMemberExtendEntity) {
        save(mMemberExtendEntity);
    }

    public void update(MMemberExtendEntity mMemberExtendEntity) {
        save(mMemberExtendEntity);
    }

    private void save(MMemberExtendEntity mMemberExtendEntity) {
        memberExtendRepository.save(mMemberExtendEntity);
    }
}
