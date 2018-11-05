package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MMemberEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
public interface MemberRepository extends JpaRepository<MMemberEntity, Integer>, JpaSpecificationExecutor<MMemberEntity> {

    Page<MMemberEntity> findByCardNum(String cardNum, Pageable pageable);
}
