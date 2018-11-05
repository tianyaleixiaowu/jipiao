//package com.tianyalei.jipiao.core.manager;
//
//import com.tianyalei.jipiao.core.model.MMemberPrivatePassengerEntity;
//import com.tianyalei.jipiao.core.repository.MemberPrivatePassengerRepository;
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
//public class MemberPrivatePassengerManager {
//    @Resource
//    private MemberPrivatePassengerRepository memberPrivatePassengerRepository;
//
//    public MMemberPrivatePassengerEntity add(MMemberPrivatePassengerEntity mMemberPrivatePassengerEntity) {
//        return memberPrivatePassengerRepository.save(mMemberPrivatePassengerEntity);
//    }
//
//    public MMemberPrivatePassengerEntity update(MMemberPrivatePassengerEntity mMemberPrivatePassengerEntity) {
//        return memberPrivatePassengerRepository.save(mMemberPrivatePassengerEntity);
//    }
//
//    public void delete(Integer id) {
//        memberPrivatePassengerRepository.deleteById(id);
//    }
//
//    public MMemberPrivatePassengerEntity find(Integer id) {
//        return memberPrivatePassengerRepository.getOne(id);
//    }
//
//    public SimplePage<MMemberPrivatePassengerEntity> list(String cardNum, Pageable pageable) {
//        Page<MMemberPrivatePassengerEntity> page = memberPrivatePassengerRepository.findByCardNum(cardNum, pageable);
//        return new SimplePage<>(page.getTotalPages(), page.getTotalElements(), page.getContent());
//    }
//}
