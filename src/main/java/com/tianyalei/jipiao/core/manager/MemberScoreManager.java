//package com.tianyalei.jipiao.core.manager;
//
//import com.tianyalei.jipiao.core.model.MMemberScoreEntity;
//import com.tianyalei.jipiao.core.repository.MemberScoreRepository;
//import com.tianyalei.jipiao.global.bean.SimplePage;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//
///**
// * @author wuweifeng wrote on 2018/11/1.
// */
//@Service
//public class MemberScoreManager {
//    @Resource
//    private MemberScoreRepository memberScoreRepository;
//
//    public MMemberScoreEntity add(MMemberScoreEntity mMemberScoreEntity) {
//        return memberScoreRepository.save(mMemberScoreEntity);
//    }
//
//    public MMemberScoreEntity update(MMemberScoreEntity mMemberCreditCardEntity) {
//        return memberScoreRepository.save(mMemberCreditCardEntity);
//    }
//
//    public void delete(Integer id) {
//        memberScoreRepository.deleteById(id);
//    }
//
//    public MMemberScoreEntity find(Integer id) {
//        return memberScoreRepository.getOne(id);
//    }
//
//    public SimplePage<MMemberScoreEntity> list(String cardNum, Pageable pageable) {
//        Page<MMemberScoreEntity> page = memberScoreRepository.findByScoreType(cardNum, pageable);
//        return new SimplePage<>(page.getTotalPages(), page.getTotalElements(), page.getContent());
//    }
//}
