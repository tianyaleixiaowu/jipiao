package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MMemberAircardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* 会员常旅客卡
* @author Bai
* @date 2019/01/07 11:11
*/
public interface MMemberAircardRepository extends JpaRepository<MMemberAircardEntity, Integer>,JpaSpecificationExecutor<MMemberAircardEntity> {
    }