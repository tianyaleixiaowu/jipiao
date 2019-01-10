package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MMemberPaperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MemberPaperRepository extends JpaRepository<MMemberPaperEntity, Integer>,JpaSpecificationExecutor<MMemberPaperEntity> {
}
