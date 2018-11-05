package com.tianyalei.jipiao.global.aop;

import com.tianyalei.jipiao.core.model.MOperationLogEntity;
import com.tianyalei.jipiao.core.repository.OperationLogRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 操作日志
 * @author wuweifeng wrote on 2018/11/1.
 */
@Service
public class OperationLogManager {
    @Resource
    private OperationLogRepository operationLogRepository;

    public MOperationLogEntity operationLog(MOperationLogEntity mOperationLogEntity) {
        return operationLogRepository.save(mOperationLogEntity);
    }

    //public MOperationLogEntity update(MOperationLogEntity MOperationLogEntity) {
    //    return memberAddressRepository.save(MOperationLogEntity);
    //}


    //public MOperationLogEntity find(Integer id) {
    //    return operationLogRepository.getOne(id);
    //}

    //public SimplePage<MOperationLogEntity> list(String cardNum, Pageable pageable) {
    //    Page<MOperationLogEntity> page = memberAddressRepository.findByCardNum(cardNum, pageable);
    //    return new SimplePage<>(page.getTotalPages(), page.getTotalElements(), page.getContent());
    //}
}
