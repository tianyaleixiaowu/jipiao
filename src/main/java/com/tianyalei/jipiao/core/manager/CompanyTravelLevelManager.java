package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MCompanyTravelLevelEntity;
import com.tianyalei.jipiao.core.repository.CompanyTravelLevelRepository;
import com.tianyalei.jipiao.global.bean.SimplePage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Service
public class CompanyTravelLevelManager {
    @Resource
    private CompanyTravelLevelRepository companyTravelLevelRepository;
    @Resource
    private CompanyTravelSettingHotelCityManager companyTravelSettingHotelCityManager;



    public MCompanyTravelLevelEntity add(MCompanyTravelLevelEntity mCompanyEntity) {
        try {
            MCompanyTravelLevelEntity entity = companyTravelLevelRepository.save(mCompanyEntity);
            //将city的数据，插入到M_CompanyTravelSettingHotelCity表
            if ("2".equals(mCompanyEntity.getLevelType())) {
                String cities = mCompanyEntity.getCities();
                companyTravelSettingHotelCityManager.add(entity.getId(), cities);
            }

            return entity;
        } catch (Exception e) {
            return null;
        }

    }

    public MCompanyTravelLevelEntity enable(Integer id, Boolean enable) {
        MCompanyTravelLevelEntity entity = find(id);
        entity.setIsEnable(enable);
        return companyTravelLevelRepository.save(entity);
    }

    public MCompanyTravelLevelEntity find(Integer id) {
        return companyTravelLevelRepository.getOne(id);
    }

    public String findName(Integer id) {
        if (id == null || id == 0) {
            return "";
        }
        return find(id).getLevelName();
    }

    public SimplePage<MCompanyTravelLevelEntity> findByCompanyId(Integer companyId, int pp, int size, boolean city) {
        if (size == 0) {
            size = 10;
        }
        Pageable pageable = PageRequest.of(pp, size);
        Page<MCompanyTravelLevelEntity> page;
        if (!city) {
            page = companyTravelLevelRepository.findByCompanyIdAndLevelType
                    (companyId, "1",
                            pageable);
        } else {
            page = companyTravelLevelRepository.findByCompanyIdAndLevelType(companyId,  "2",
                    pageable);
        }

        return new SimplePage<>(page.getTotalPages(), page
                .getTotalElements(), page.getContent());
    }
}
