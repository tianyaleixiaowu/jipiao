package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MHrEmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
public interface HrEmployeeRepository extends JpaRepository<MHrEmployeeEntity, String> {
}
