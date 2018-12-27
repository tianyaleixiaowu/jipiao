package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MMemberCallEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
public interface MemberCallRepository extends JpaRepository<MMemberCallEntity, Integer> {

    List<MMemberCallEntity> findByCardNum(String cardNum);
}
