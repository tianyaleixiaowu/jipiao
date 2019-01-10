package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MMemberLeaderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MMemberLeaderRepository extends JpaRepository<MMemberLeaderEntity, Integer>,JpaSpecificationExecutor<MMemberLeaderEntity> {
    }