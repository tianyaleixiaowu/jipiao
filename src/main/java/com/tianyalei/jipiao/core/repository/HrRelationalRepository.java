package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MHrRelationalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
public interface HrRelationalRepository extends JpaRepository<MHrRelationalEntity, Integer> {
    MHrRelationalEntity findFirstByDeptIdAndEmployeeId(String deptId, String employId);
}
