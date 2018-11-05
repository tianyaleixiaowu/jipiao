//package com.tianyalei.jipiao.core.manager;
//
//import com.tianyalei.jipiao.core.model.MMemberAircardEntity;
//import com.tianyalei.jipiao.core.repository.MemberAirCardRepository;
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
//public class MemberAirCardManager {
//    @Resource
//    private MemberAirCardRepository memberAirCardRepository;
//
//    public MMemberAircardEntity add(MMemberAircardEntity mMemberAircardEntity) {
//        return memberAirCardRepository.save(mMemberAircardEntity);
//    }
//
//    public MMemberAircardEntity update(MMemberAircardEntity mMemberAircardEntity) {
//        return memberAirCardRepository.save(mMemberAircardEntity);
//    }
//
//    public void delete(Integer id) {
//        memberAirCardRepository.deleteById(id);
//    }
//
//    public MMemberAircardEntity find(Integer id) {
//        return memberAirCardRepository.getOne(id);
//    }
//
//    public SimplePage<MMemberAircardEntity> list(String cardNum, Pageable pageable) {
//        Page<MMemberAircardEntity> page = memberAirCardRepository.findByCardNum(cardNum, pageable);
//        return new SimplePage<>(page.getTotalPages(), page.getTotalElements(), page.getContent());
//    }
//}
