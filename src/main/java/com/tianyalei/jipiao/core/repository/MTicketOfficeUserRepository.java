package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MTicketOfficeUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* 票台用户表
* @author Bai
* @date 2019/01/08 11:55
*/
public interface MTicketOfficeUserRepository extends JpaRepository<MTicketOfficeUserEntity, Integer>,JpaSpecificationExecutor<MTicketOfficeUserEntity> {
    }