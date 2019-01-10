package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MMemberPassengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* 会员（因公出行）常用乘机人表
* @author Bai
* @date 2019/01/07 11:38
*/
public interface MMemberPassengerRepository extends JpaRepository<MMemberPassengerEntity, Integer>,JpaSpecificationExecutor<MMemberPassengerEntity> {
    }