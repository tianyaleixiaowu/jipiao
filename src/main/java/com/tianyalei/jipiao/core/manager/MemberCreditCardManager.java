//package com.tianyalei.jipiao.core.manager;
//
//import com.tianyalei.jipiao.core.model.MMemberCreditCardEntity;
//import com.tianyalei.jipiao.core.repository.MemberCreditCardRepository;
//import com.tianyalei.jipiao.global.bean.SimplePage;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//
//import javax.annotation.Resource;
//
///**
// * @author wuweifeng wrote on 2018/11/1.
// */
//@Service
//public class MemberCreditCardManager {
//    @Resource
//    private MemberCreditCardRepository memberCreditCardRepository;
//
//    public MMemberCreditCardEntity add(MMemberCreditCardEntity mMemberCreditCardEntity) {
//        return memberCreditCardRepository.save(mMemberCreditCardEntity);
//    }
//
//    public MMemberCreditCardEntity update(MMemberCreditCardEntity mMemberCreditCardEntity) {
//        return memberCreditCardRepository.save(mMemberCreditCardEntity);
//    }
//
//    public void delete(Integer id) {
//        memberCreditCardRepository.deleteById(id);
//    }
//
//    public MMemberCreditCardEntity find(Integer id) {
//        return memberCreditCardRepository.getOne(id);
//    }
//
//    public SimplePage<MMemberCreditCardEntity> list(String cardNum, Pageable pageable) {
//        Page<MMemberCreditCardEntity> page = memberCreditCardRepository.findByCardNum(cardNum, pageable);
//        return new SimplePage<>(page.getTotalPages(), page.getTotalElements(), page.getContent());
//    }
//}
