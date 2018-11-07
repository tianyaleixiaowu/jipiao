package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MMemberBalanceCompanyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 会员结算单位
 * @author wuweifeng wrote on 2018/11/1.
 */
public interface MemberBalanceCompanyRepository extends JpaRepository<MMemberBalanceCompanyEntity, Integer> {

    Page<MMemberBalanceCompanyEntity> findByCardNum(String cardNum, Pageable pageable);

    /**
     * 一个cardNum应该只有一条数据在这个表里。TravelLevelID是可以修改的，差旅等级
     */
    List<MMemberBalanceCompanyEntity> findByCardNum(String cardNum);
}
