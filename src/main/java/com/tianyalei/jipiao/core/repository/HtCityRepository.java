package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MHtChinaCityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
public interface HtCityRepository extends JpaRepository<MHtChinaCityEntity, Integer> {
    MHtChinaCityEntity findByCityId(String cityId);
}
