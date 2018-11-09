package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.HrManager;
import com.tianyalei.jipiao.core.model.MHrDepartmentEntity;
import com.tianyalei.jipiao.global.bean.BaseData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author wuweifeng wrote on 2018/11/9.
 */
@RestController
@RequestMapping("hr")
public class HrController {
    @Resource
    private HrManager hrManager;

    @RequestMapping("/department")
    public BaseData hrDepartment(@RequestParam("file") MultipartFile file, boolean preview, boolean enable)
            throws Exception {
        hrManager.deal(file, preview, enable, MHrDepartmentEntity.class);
        return null;
    }

    @RequestMapping("/employee")
    public BaseData hremployee(@RequestParam("file") MultipartFile file) throws Exception {
         return null;
    }

    @RequestMapping("/organization")
    public BaseData organization(@RequestParam("file") MultipartFile file) throws Exception {
        return null;
    }

    @RequestMapping("/relational")
    public BaseData relational(@RequestParam("file") MultipartFile file) throws Exception {
        return null;
    }
}
