package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MMemberEntity;
import com.tianyalei.jipiao.core.repository.MemberRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MemberSingleManager {

    @Resource
    private MemberRepository memberRepository;

    public MMemberEntity add(MMemberEntity mMemberEntity) {
        return memberRepository.save(mMemberEntity);
    }

    public MMemberEntity update(MMemberEntity mMemberEntity) {
        return memberRepository.save(mMemberEntity);
    }
}
