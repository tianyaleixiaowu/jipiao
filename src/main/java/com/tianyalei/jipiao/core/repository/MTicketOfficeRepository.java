package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MTicketOfficeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* 票台表
* @author Bai
* @date 2019/01/08 11:55
*/
public interface MTicketOfficeRepository extends JpaRepository<MTicketOfficeEntity, Integer>,JpaSpecificationExecutor<MTicketOfficeEntity> {
    }