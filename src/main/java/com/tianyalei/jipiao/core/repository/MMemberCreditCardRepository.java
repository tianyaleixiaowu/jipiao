package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MMemberCreditCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* 会员信用卡表
* @author Bai
* @date 2019/01/07 11:08
*/
public interface MMemberCreditCardRepository extends JpaRepository<MMemberCreditCardEntity, Integer>,JpaSpecificationExecutor<MMemberCreditCardEntity> {
    }