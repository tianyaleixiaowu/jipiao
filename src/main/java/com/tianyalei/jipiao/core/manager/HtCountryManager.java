package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MHtCountryEntity;
import com.tianyalei.jipiao.core.repository.HtCountryRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/6.
 */
@Service
public class HtCountryManager {
    @Resource
    private HtCountryRepository htCountryRepository;

    public List<MHtCountryEntity> findAll() {
        return htCountryRepository.findAll();
    }
}
