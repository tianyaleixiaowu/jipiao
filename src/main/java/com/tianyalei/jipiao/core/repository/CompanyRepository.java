package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MCompanyEntity;
import com.tianyalei.jipiao.core.model.RegionBeanTree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
public interface CompanyRepository extends JpaRepository<MCompanyEntity, Integer>, JpaSpecificationExecutor<MCompanyEntity> {
    MCompanyEntity findByCompanyName(String name);

    @Query(value = "select CompanyName from M_Company where CompanyName in(?1)",nativeQuery = true)
    List<Object[]> findByCompanyNameiIn(List<String> r);
}
