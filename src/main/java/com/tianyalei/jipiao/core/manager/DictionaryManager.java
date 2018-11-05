package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MDictionaryEntity;
import com.tianyalei.jipiao.core.repository.DictionaryRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Service
public class DictionaryManager {
    @Resource
    private DictionaryRepository dictionaryRepository;

    public List<MDictionaryEntity> findByGroupId(int groupId) {
        return dictionaryRepository.findByGroupId(groupId);
    }

    public List<MDictionaryEntity> findAll() {
        return dictionaryRepository.findAll();
    }
}
