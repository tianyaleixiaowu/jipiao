package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MTicketOfficeDistributionAreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* 配送区域表
* @author Bai
* @date 2019/01/08 11:55
*/
public interface MTicketOfficeDistributionAreaRepository extends JpaRepository<MTicketOfficeDistributionAreaEntity, Integer>,JpaSpecificationExecutor<MTicketOfficeDistributionAreaEntity> {
    }