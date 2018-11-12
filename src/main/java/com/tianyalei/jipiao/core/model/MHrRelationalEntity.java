package com.tianyalei.jipiao.core.model;

import com.tianyalei.jipiao.core.model.base.BaseIdEntity;
import com.tianyalei.jipiao.global.excel.ExcelColumn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Entity
@Table(name = "M_HRRelational", catalog = "")
public class MHrRelationalEntity extends BaseIdEntity {
    @ExcelColumn(value = "部门ID", col = 1)
    private String deptId;
    @ExcelColumn(value = "职工ID", col = 2)
    private String employeeId;

    @Column(name = "DeptID")
    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    @Column(name = "EmployeeID")
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

}
