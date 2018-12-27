package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MMemberCallEntity;
import com.tianyalei.jipiao.core.repository.MemberCallRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MemberCallSingleManager {
    @Resource
    private MemberCallRepository memberCallRepository;

    public void add(MMemberCallEntity mMemberCallEntity) {
        memberCallRepository.save(mMemberCallEntity);
    }

    public void update(MMemberCallEntity mMemberCallEntity) {
        memberCallRepository.save(mMemberCallEntity);
    }
}
