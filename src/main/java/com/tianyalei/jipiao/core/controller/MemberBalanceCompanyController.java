package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.MemberBalanceCompanyManager;
import com.tianyalei.jipiao.core.model.MMemberBalanceCompanyEntity;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 结算单位
 * @author wuweifeng wrote on 2018/11/1.
 */
@RestController
@RequestMapping("memberBalanceCompany")
public class MemberBalanceCompanyController {
    @Resource
    private MemberBalanceCompanyManager memberBalanceCompanyManager;

    //@RequestMapping("/list")
    //public BaseData list() {
    //    return ResultGenerator.genSuccessResult(memberBalanceCompanyManager.list(MemberBalanceCompanyQueryRequestModel));
    //}

    @RequestMapping("/{cardNum}")
    public BaseData one(@PathVariable String cardNum, Integer page, Integer size) {
        if (page == null) {
            page = 0;
        }
        if (size == null) {
            size = 10;
        }
        Pageable pageable = PageRequest.of(page, size);
        return ResultGenerator.genSuccessResult(memberBalanceCompanyManager.list(cardNum, pageable));
    }

    @RequestMapping()
    public BaseData oneBalance(Integer id) {
        return ResultGenerator.genSuccessResult(memberBalanceCompanyManager.find(id));
    }

    @RequestMapping("/update")
    public BaseData update(MMemberBalanceCompanyEntity mMemberBalanceCompanyEntity) {
        if (mMemberBalanceCompanyEntity.getTravelLevelId() == 0) {
            return ResultGenerator.genFailResult("差旅等级不能为空");
        }
        memberBalanceCompanyManager.addOrUpdate(mMemberBalanceCompanyEntity);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/add")
    public BaseData save(MMemberBalanceCompanyEntity mMemberBalanceCompanyEntity) {
        if (mMemberBalanceCompanyEntity.getTravelLevelId() == 0) {
            return ResultGenerator.genFailResult("差旅等级不能为空");
        }
        memberBalanceCompanyManager.addOrUpdate(mMemberBalanceCompanyEntity);
        return ResultGenerator.genSuccessResult();
    }

}
