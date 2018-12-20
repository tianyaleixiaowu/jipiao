package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MHrOrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
public interface HrOrganizationRepository extends JpaRepository<MHrOrganizationEntity, String>,JpaSpecificationExecutor<MHrOrganizationEntity> {
    /**
     * 顶级
     * @return
     */
    @Query(value = "select OrgID, OrgName,`Level`,panelname from M_HROrganization where `Level` = 1 and LENGTH(OrgID) = 2 order by OrgId",nativeQuery = true)
    List<Object[]> findFatherId();

    /**
     * 子集
     * @param orgId 父id
     * @return
     */
    @Query(value = "select OrgID, OrgName,`Level`,panelname from M_HROrganization where OrgID like :orgId% order by OrgId",nativeQuery = true)
    List<Object[]> findSonList(@Param("orgId") String orgId);

    /**
     * 获取下级数据
     * @param orgId
     * @param leve
     * @return
     */
    @Query(value = "select OrgID, OrgName,`Level`,panelname from M_HROrganization where Level = :leve and OrgID like :orgId% order by OrgId",nativeQuery = true)
    List<Object[]> findByLevelList(@Param("orgId") String orgId, @Param("leve") Integer leve);
}
