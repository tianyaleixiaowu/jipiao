package com.tianyalei.jipiao.core.controller;

import com.tianyalei.jipiao.core.manager.HrManager;
import com.tianyalei.jipiao.core.model.MHrDepartmentEntity;
import com.tianyalei.jipiao.core.model.MHrEmployeeEntity;
import com.tianyalei.jipiao.core.model.MHrOrganizationEntity;
import com.tianyalei.jipiao.core.model.MHrRelationalEntity;
import com.tianyalei.jipiao.core.request.HrDepartmentRequest;
import com.tianyalei.jipiao.core.request.HrEmployeeRequest;
import com.tianyalei.jipiao.core.request.HrOrganizationRequest;
import com.tianyalei.jipiao.core.request.HrRelationRequest;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.bean.ResultGenerator;
import com.tianyalei.jipiao.global.excel.ExcelUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/9.
 */
@RestController
@RequestMapping("hr")
public class HrController {
    @Resource
    private HrManager hrManager;

    @RequestMapping("/department")
    public BaseData hrDepartment(HttpServletResponse response, @RequestParam("file") MultipartFile file, Boolean
            preview, Boolean enable)
            throws Exception {
        if (preview == null) {
            preview = false;
        }
        if (enable == null) {
            enable = true;
        }
        return hrManager.deal(response, file, preview, MHrDepartmentEntity.class);
    }

    @RequestMapping("/department/batch")
    public BaseData hrDepartmentBatch(@RequestBody HrDepartmentRequest hrDepartment, HttpServletResponse response)
            throws Exception {
        List<MHrDepartmentEntity> list = hrManager.saveAndReturnFailure(hrDepartment.getList());
        ExcelUtils.writeExcel(response, list, MHrDepartmentEntity.class);
        return ResultGenerator.genSuccessResult(list);
    }

    @RequestMapping("/employee")
    public BaseData hremployee(HttpServletResponse response, @RequestParam("file") MultipartFile file, Boolean
            preview, Boolean enable) throws Exception {
        if (preview == null) {
            preview = false;
        }
        if (enable == null) {
            enable = true;
        }
        return hrManager.deal(response, file, preview, MHrEmployeeEntity.class);
    }

    @RequestMapping("/employee/batch")
    public BaseData hremployeeBatch(@RequestBody HrEmployeeRequest hrEmployeeRequest, HttpServletResponse response) {
        List<MHrEmployeeEntity> list = hrManager.saveAndReturnFailure(hrEmployeeRequest.getList());
        ExcelUtils.writeExcel(response, list, MHrEmployeeEntity.class);
        return ResultGenerator.genSuccessResult(list);
    }

    @RequestMapping("/organization")
    public BaseData organization(HttpServletResponse response, @RequestParam("file") MultipartFile file, Boolean
            preview, Boolean enable) throws Exception {
        if (preview == null) {
            preview = false;
        }
        if (enable == null) {
            enable = true;
        }
        return hrManager.deal(response, file, preview, MHrOrganizationEntity.class);
    }

    @RequestMapping("/organization/batch")
    public BaseData hrorganizationBatch(@RequestBody HrOrganizationRequest hrOrganizationRequest, HttpServletResponse response) {
        List<MHrOrganizationEntity> list = hrManager.saveAndReturnFailure(hrOrganizationRequest.getList());
        ExcelUtils.writeExcel(response, list, MHrOrganizationEntity.class);
        return ResultGenerator.genSuccessResult(list);
    }

    @RequestMapping("/relational")
    public BaseData relational(HttpServletResponse response, @RequestParam("file") MultipartFile file, Boolean
            preview, Boolean enable) throws Exception {
        if (preview == null) {
            preview = false;
        }
        if (enable == null) {
            enable = true;
        }
        return hrManager.deal(response, file, preview, MHrRelationalEntity.class);
    }

    @RequestMapping("/relational/batch")
    public BaseData hroionBatch(@RequestBody HrRelationRequest hrRelationRequest, HttpServletResponse
            response) {
        List<MHrRelationalEntity> list = hrManager.saveAndReturnFailure(hrRelationRequest.getList());
        ExcelUtils.writeExcel(response, list, MHrRelationalEntity.class);
        return ResultGenerator.genSuccessResult(list);
    }
}
