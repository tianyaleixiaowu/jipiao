package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MHtChinaCityEntity;
import com.tianyalei.jipiao.core.repository.HtCityRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/7.
 */
@Service
public class ChinaCityManager {
    @Resource
    private HtCityRepository cityRepository;

    public List<MHtChinaCityEntity> findAll() {
        return cityRepository.findAll();
    }
}
