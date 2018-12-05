package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MCompanyTravelSettingEntity;
import com.tianyalei.jipiao.core.model.MCompanyTravelSettingHotelEntity;
import com.tianyalei.jipiao.core.repository.CompanyTravelSettingRepository;
import com.tianyalei.jipiao.core.request.CompanyTravelSettingRequestModel;
import com.tianyalei.jipiao.core.request.HotelModel;
import com.tianyalei.jipiao.core.response.CompanyTravelSettingResponseVO;
import com.xiaoleilu.hutool.util.BeanUtil;
import com.xiaoleilu.hutool.util.CollectionUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 差旅等级设置
 *
 * @author wuweifeng wrote on 2018/11/1.
 */
@Service
public class CompanyTravelSettingManager {
    @Resource
    private CompanyTravelSettingRepository companyTravelSettingRepository;
    @Resource
    private CompanyTravelSettingSingleManager companyTravelSettingSingleManager;
    @Resource
    private CompanyTravelLevelManager companyTravelLevelManager;
    @Resource
    private CompanyTravelSettingHotelManager companyTravelSettingHotelManager;

    @Transactional(rollbackFor = Exception.class)
    public void addOrUpdate(CompanyTravelSettingRequestModel companyTravelSettingRequestModel, boolean add) {
        MCompanyTravelSettingEntity entity = findByTravelLevelId(companyTravelSettingRequestModel.getTravelLevelId());
        if (entity == null) {
            entity = new MCompanyTravelSettingEntity();
        }
        entity.setTravelLevelId(companyTravelSettingRequestModel.getTravelLevelId());
        entity.setPlaneLevel(companyTravelSettingRequestModel.getPlaneLevel());
        entity.setTrainLevel(companyTravelSettingRequestModel.getTrainLevel());
        if (add) {
            companyTravelSettingSingleManager.add(entity);
            if (!CollectionUtil.isEmpty(companyTravelSettingRequestModel.getHotels())) {
                return;
            }
            //添加hotel相关
            for (HotelModel hotelModel : companyTravelSettingRequestModel.getHotels()) {
                MCompanyTravelSettingHotelEntity settingHotelEntity = new MCompanyTravelSettingHotelEntity();
                BeanUtil.copyProperties(hotelModel, settingHotelEntity);
                settingHotelEntity.setTravelLevelId(companyTravelSettingRequestModel.getTravelLevelId());
                companyTravelSettingHotelManager.add(settingHotelEntity);
            }
        } else {
            companyTravelSettingSingleManager.update(entity);

            if (!CollectionUtil.isEmpty(companyTravelSettingRequestModel.getHotels())) {
                return;
            }
            companyTravelSettingHotelManager.deleteByTravelLevelId(companyTravelSettingRequestModel.getTravelLevelId());
            //添加hotel相关
            for (HotelModel hotelModel : companyTravelSettingRequestModel.getHotels()) {
                MCompanyTravelSettingHotelEntity settingHotelEntity = new MCompanyTravelSettingHotelEntity();
                BeanUtil.copyProperties(hotelModel, settingHotelEntity);
                settingHotelEntity.setTravelLevelId(companyTravelSettingRequestModel.getTravelLevelId());
                companyTravelSettingHotelManager.add(settingHotelEntity);
            }

        }

    }

    public MCompanyTravelSettingEntity add(MCompanyTravelSettingEntity companyTravelSettingEntity) {
        return companyTravelSettingRepository.save(companyTravelSettingEntity);
    }

    public MCompanyTravelSettingEntity update(MCompanyTravelSettingEntity companyTravelSettingEntity) {
        return companyTravelSettingRepository.save(companyTravelSettingEntity);
    }

    public MCompanyTravelSettingEntity find(Integer id) {
        return companyTravelSettingRepository.getOne(id);
    }

    public MCompanyTravelSettingEntity findByTravelLevelId(Integer travelLevelId) {
        return companyTravelSettingRepository.findFirstByTravelLevelId(travelLevelId);
    }

    public CompanyTravelSettingResponseVO findVoByTravelLevelId(Integer travelLevelId) {
        MCompanyTravelSettingEntity settingEntity = findByTravelLevelId(travelLevelId);
        CompanyTravelSettingResponseVO vo = new CompanyTravelSettingResponseVO();
        //如果还没设置过，就返回个空
        if (settingEntity == null) {
            return vo;
        }
        BeanUtil.copyProperties(settingEntity, vo);

        List<MCompanyTravelSettingHotelEntity> hotelEntityList = companyTravelSettingHotelManager.findByTravelLevelId
                (travelLevelId);

        List<HotelModel> hotels = new ArrayList<>();
        for (MCompanyTravelSettingHotelEntity entity : hotelEntityList) {
            HotelModel hotelModel = new HotelModel();
            BeanUtil.copyProperties(entity, hotelModel);
            hotelModel.setLevelName(companyTravelLevelManager.find(hotelModel.getCityLevelId()).getLevelName());
            hotels.add(hotelModel);
        }
        vo.setHotels(hotels);
        return vo;
    }

}
