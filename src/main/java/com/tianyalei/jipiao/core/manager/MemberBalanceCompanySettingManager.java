//package com.tianyalei.jipiao.core.manager;
//
//import com.tianyalei.jipiao.core.model.MMemberBalanceCompanySettingEntity;
//import com.tianyalei.jipiao.core.repository.MemberBalanceCompanySettingRepository;
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
//public class MemberBalanceCompanySettingManager {
//    @Resource
//    private MemberBalanceCompanySettingRepository memberBalanceCompanySettingRepository;
//
//    public MMemberBalanceCompanySettingEntity add(MMemberBalanceCompanySettingEntity mMemberBalanceCompanySettingEntity) {
//        return memberBalanceCompanySettingRepository.save(mMemberBalanceCompanySettingEntity);
//    }
//
//    public MMemberBalanceCompanySettingEntity update(MMemberBalanceCompanySettingEntity mMemberBalanceCompanySettingEntity) {
//        return memberBalanceCompanySettingRepository.save(mMemberBalanceCompanySettingEntity);
//    }
//
//    public void delete(Integer id) {
//        memberBalanceCompanySettingRepository.deleteById(id);
//    }
//
//    public MMemberBalanceCompanySettingEntity find(Integer id) {
//        return memberBalanceCompanySettingRepository.getOne(id);
//    }
//
//    public SimplePage<MMemberBalanceCompanySettingEntity> list(Integer id, Pageable pageable) {
//        Page<MMemberBalanceCompanySettingEntity> page = memberBalanceCompanySettingRepository
//                .findByMemberBalanceCompanyId(id, pageable);
//        return new SimplePage<>(page.getTotalPages(), page.getTotalElements(), page.getContent());
//    }
//}
