//package com.tianyalei.jipiao.core.manager;
//
//import com.tianyalei.jipiao.core.model.MMemberLeaderEntity;
//import com.tianyalei.jipiao.core.repository.MemberLeaderRepository;
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
//public class MemberLeaderManager {
//    @Resource
//    private MemberLeaderRepository memberLeaderRepository;
//
//    public MMemberLeaderEntity add(MMemberLeaderEntity mMemberLeaderEntity) {
//        return memberLeaderRepository.save(mMemberLeaderEntity);
//    }
//
//    public MMemberLeaderEntity update(MMemberLeaderEntity mMemberLeaderEntity) {
//        return memberLeaderRepository.save(mMemberLeaderEntity);
//    }
//
//    public void delete(Integer id) {
//        memberLeaderRepository.deleteById(id);
//    }
//
//    public MMemberLeaderEntity find(Integer id) {
//        return memberLeaderRepository.getOne(id);
//    }
//
//    public SimplePage<MMemberLeaderEntity> list(String cardNum, Pageable pageable) {
//        Page<MMemberLeaderEntity> page = memberLeaderRepository.findByCardNum(cardNum, pageable);
//        return new SimplePage<>(page.getTotalPages(), page.getTotalElements(), page.getContent());
//    }
//}
