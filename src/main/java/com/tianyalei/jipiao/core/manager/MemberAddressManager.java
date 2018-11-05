//package com.tianyalei.jipiao.core.manager;
//
//import com.tianyalei.jipiao.core.model.MMemberAddressEntity;
//import com.tianyalei.jipiao.core.repository.MemberAddressRepository;
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
//public class MemberAddressManager {
//    @Resource
//    private MemberAddressRepository memberAddressRepository;
//
//    public MMemberAddressEntity add(MMemberAddressEntity mMemberAddressEntity) {
//        return memberAddressRepository.save(mMemberAddressEntity);
//    }
//
//    public MMemberAddressEntity update(MMemberAddressEntity mMemberAddressEntity) {
//        return memberAddressRepository.save(mMemberAddressEntity);
//    }
//
//    public void delete(Integer id) {
//        memberAddressRepository.deleteById(id);
//    }
//
//    public MMemberAddressEntity find(Integer id) {
//        return memberAddressRepository.getOne(id);
//    }
//
//    public SimplePage<MMemberAddressEntity> list(String cardNum, Pageable pageable) {
//        Page<MMemberAddressEntity> page = memberAddressRepository.findByCardNum(cardNum, pageable);
//        return new SimplePage<>(page.getTotalPages(), page.getTotalElements(), page.getContent());
//    }
//}
