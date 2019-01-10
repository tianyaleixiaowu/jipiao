package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MMemberRelationShipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* 会员亲属关系表
* @author Bai
* @date 2019/01/07 11:00
*/
public interface MMemberRelationShipRepository extends JpaRepository<MMemberRelationShipEntity, Integer>,JpaSpecificationExecutor<MMemberRelationShipEntity> {
    }