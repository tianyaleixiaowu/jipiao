package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MTicketOfficeTravelCompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* 差旅单位表
* @author Bai
* @date 2019/01/08 11:55
*/
public interface MTicketOfficeTravelCompanyRepository extends JpaRepository<MTicketOfficeTravelCompanyEntity, Integer>,JpaSpecificationExecutor<MTicketOfficeTravelCompanyEntity> {
    }