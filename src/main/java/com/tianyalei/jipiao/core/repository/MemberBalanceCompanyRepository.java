package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MMemberBalanceCompanyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 会员结算单位
 * @author wuweifeng wrote on 2018/11/1.
 */
public interface MemberBalanceCompanyRepository extends JpaRepository<MMemberBalanceCompanyEntity, Integer> {

    Page<MMemberBalanceCompanyEntity> findByCardNumOrderByIdDesc(String cardNum, Pageable pageable);

    /**
     * TravelLevelID是可以修改的，差旅等级
     */
    List<MMemberBalanceCompanyEntity> findByCardNumOrderByIdDesc(String cardNum);

    MMemberBalanceCompanyEntity findFirstByCardNumAndCompanyId(String cardNum, Integer companyId);

    //修改状态批量
    @Modifying
    @Query(value = "update M_MemberBalanceCompany set IsEnable = :is where CardNum = :cardNum",nativeQuery = true)
    void updateIsEnable(@Param("cardNum") String cardNum,@Param("is") Byte is);
}
