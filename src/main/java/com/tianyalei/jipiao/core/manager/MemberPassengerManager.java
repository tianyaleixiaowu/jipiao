//package com.tianyalei.jipiao.core.manager;
//
//import com.tianyalei.jipiao.core.model.MMemberPassengerEntity;
//import com.tianyalei.jipiao.core.repository.MemberPassengerRepository;
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
//public class MemberPassengerManager {
//    @Resource
//    private MemberPassengerRepository memberPassengerRepository;
//
//    public MMemberPassengerEntity add(MMemberPassengerEntity mMemberPassengerEntity) {
//        return memberPassengerRepository.save(mMemberPassengerEntity);
//    }
//
//    public MMemberPassengerEntity update(MMemberPassengerEntity mMemberPassengerEntity) {
//        return memberPassengerRepository.save(mMemberPassengerEntity);
//    }
//
//    public void delete(Integer id) {
//        memberPassengerRepository.deleteById(id);
//    }
//
//    public MMemberPassengerEntity find(Integer id) {
//        return memberPassengerRepository.getOne(id);
//    }
//
//    public SimplePage<MMemberPassengerEntity> list(String cardNum, Pageable pageable) {
//        Page<MMemberPassengerEntity> page = memberPassengerRepository.findByCardNum(cardNum, pageable);
//        return new SimplePage<>(page.getTotalPages(), page.getTotalElements(), page.getContent());
//    }
//}
