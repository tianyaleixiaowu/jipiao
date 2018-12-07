package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MCompanyTravelLevelEntity;
import com.tianyalei.jipiao.core.model.MCompanyTravelSettingEntity;
import com.tianyalei.jipiao.core.model.MCompanyTravelSettingHotelEntity;
import com.tianyalei.jipiao.core.repository.CompanyTravelSettingRepository;
import com.tianyalei.jipiao.core.request.CompanyTravelSettingRequestModel;
import com.tianyalei.jipiao.core.request.HotelModel;
import com.tianyalei.jipiao.core.response.CompanyTravelSettingResponseVO;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import com.tianyalei.jipiao.global.bean.SimplePage;
import com.tianyalei.jipiao.global.cache.DictCache;
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
    @Resource
    private DictCache dictCache;

    @Transactional(rollbackFor = Exception.class)
    public BaseData addOrUpdate(CompanyTravelSettingRequestModel companyTravelSettingRequestModel, boolean add) {
        try {
            MCompanyTravelSettingEntity entity = findByTravelLevelId(companyTravelSettingRequestModel
                    .getTravelLevelId());
            if (entity == null) {
                entity = new MCompanyTravelSettingEntity();
            }
            entity.setTravelLevelId(companyTravelSettingRequestModel.getTravelLevelId());
            entity.setPlaneLevel(companyTravelSettingRequestModel.getPlaneLevel());
            entity.setTrainLevel(companyTravelSettingRequestModel.getTrainLevel());
            if (add) {
                companyTravelSettingSingleManager.add(entity);
                if (CollectionUtil.isEmpty(companyTravelSettingRequestModel.getHotels())) {
                    return ResultGenerator.genSuccessResult();
                }
                //添加hotel相关
                for (HotelModel hotelModel : companyTravelSettingRequestModel.getHotels()) {
                    if (hotelModel.getCityLevelId() == null || hotelModel.getCurrency() == null || hotelModel
                            .getHotelFeeValue() == null) {
                        return ResultGenerator.genFailResult("差旅酒店各属性不能为空");
                    }

                    MCompanyTravelSettingHotelEntity settingHotelEntity = new MCompanyTravelSettingHotelEntity();
                    BeanUtil.copyProperties(hotelModel, settingHotelEntity);
                    settingHotelEntity.setTravelLevelId(companyTravelSettingRequestModel.getTravelLevelId());
                    companyTravelSettingHotelManager.add(settingHotelEntity);
                }
            } else {
                companyTravelSettingSingleManager.update(entity);

                if (CollectionUtil.isEmpty(companyTravelSettingRequestModel.getHotels())) {
                    return ResultGenerator.genSuccessResult();
                }
                companyTravelSettingHotelManager.deleteByTravelLevelId(companyTravelSettingRequestModel
                        .getTravelLevelId());
                //添加hotel相关
                for (HotelModel hotelModel : companyTravelSettingRequestModel.getHotels()) {
                    if (hotelModel.getCityLevelId() == null || hotelModel.getCurrency() == null || hotelModel
                            .getHotelFeeValue() == null) {
                        return ResultGenerator.genFailResult("差旅酒店各属性不能为空");
                    }
                    MCompanyTravelSettingHotelEntity settingHotelEntity = new MCompanyTravelSettingHotelEntity();
                    BeanUtil.copyProperties(hotelModel, settingHotelEntity);
                    settingHotelEntity.setTravelLevelId(companyTravelSettingRequestModel.getTravelLevelId());
                    companyTravelSettingHotelManager.add(settingHotelEntity);
                }

            }
            return ResultGenerator.genSuccessResult();
        } catch (Exception e) {
            return ResultGenerator.genFailResult("不能添加重复数据或空数据");
        }

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
            return null;
        }
        BeanUtil.copyProperties(settingEntity, vo);
        vo.setPlaneLevelValue(dictCache.findByGroupIdAndKey(62, vo.getPlaneLevel()));
        vo.setTrainLevelValue(dictCache.findByGroupIdAndKey(63, vo.getTrainLevel()));
        vo.setLevelName(companyTravelLevelManager.findName(travelLevelId));

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

    public SimplePage<CompanyTravelSettingResponseVO> findVOsByCompanyId(Integer companyId) {
        List<MCompanyTravelLevelEntity> entities = companyTravelLevelManager.findByCompanyId(companyId);

        List<CompanyTravelSettingResponseVO> vos = new ArrayList<>();
        for (MCompanyTravelLevelEntity entity : entities) {
            if (!entity.getIsEnable()) {
                continue;
            }
            CompanyTravelSettingResponseVO vo = findVoByTravelLevelId(entity.getId());
            if (vo != null) {
                vos.add(vo);
            }
        }

        return new SimplePage<>(1, vos.size(), vos);

    }


}
