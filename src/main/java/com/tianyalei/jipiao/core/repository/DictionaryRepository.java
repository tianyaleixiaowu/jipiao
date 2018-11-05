package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MDictionaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
public interface DictionaryRepository extends JpaRepository<MDictionaryEntity, Integer> {
    List<MDictionaryEntity> findByGroupId(int groupId);
}
