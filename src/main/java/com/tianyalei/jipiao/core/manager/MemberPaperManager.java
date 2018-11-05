//package com.tianyalei.jipiao.core.manager;
//
//import com.tianyalei.jipiao.core.model.MMemberPaperEntity;
//import com.tianyalei.jipiao.core.repository.MemberPaperRepository;
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
//public class MemberPaperManager {
//    @Resource
//    private MemberPaperRepository memberPaperRepository;
//
//    public MMemberPaperEntity add(MMemberPaperEntity mMemberPaperEntity) {
//        return memberPaperRepository.save(mMemberPaperEntity);
//    }
//
//    public MMemberPaperEntity update(MMemberPaperEntity mMemberPaperEntity) {
//        return memberPaperRepository.save(mMemberPaperEntity);
//    }
//
//    public void delete(Integer id) {
//        memberPaperRepository.deleteById(id);
//    }
//
//    public MMemberPaperEntity find(Integer id) {
//        return memberPaperRepository.getOne(id);
//    }
//
//    public SimplePage<MMemberPaperEntity> list(String cardNum, Pageable pageable) {
//        Page<MMemberPaperEntity> page = memberPaperRepository.findByCardNum(cardNum, pageable);
//        return new SimplePage<>(page.getTotalPages(), page.getTotalElements(), page.getContent());
//    }
//}
