package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.MemberBalanceCompanyManager;
import com.tianyalei.jipiao.core.model.MMemberBalanceCompanyEntity;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
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
    private MemberBalanceCompanyManager MemberBalanceCompanyManager;

    //@RequestMapping("/list")
    //public BaseData list() {
    //    return ResultGenerator.genSuccessResult(MemberBalanceCompanyManager.list(MemberBalanceCompanyQueryRequestModel));
    //}

    @RequestMapping("/{cardNum}")
    public BaseData one(@PathVariable String cardNum) {
        return ResultGenerator.genSuccessResult(MemberBalanceCompanyManager.findByCardNum(cardNum));
    }

    @RequestMapping("/update")
    public BaseData update(MMemberBalanceCompanyEntity mMemberBalanceCompanyEntity) {
        MemberBalanceCompanyManager.addOrUpdate(mMemberBalanceCompanyEntity);
        return ResultGenerator.genSuccessResult();
    }

    @RequestMapping("/add")
    public BaseData save(MMemberBalanceCompanyEntity mMemberBalanceCompanyEntity) {
        MemberBalanceCompanyManager.addOrUpdate(mMemberBalanceCompanyEntity);
        return ResultGenerator.genSuccessResult();
    }

}
