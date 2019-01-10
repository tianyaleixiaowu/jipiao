package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MMemberAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MMemberAddressRepository extends JpaRepository<MMemberAddressEntity, Integer>,JpaSpecificationExecutor<MMemberAddressEntity> {
    }