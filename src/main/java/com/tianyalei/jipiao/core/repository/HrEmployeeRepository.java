package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.EmployeeListEntity;
import com.tianyalei.jipiao.core.model.MHrEmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
public interface HrEmployeeRepository extends JpaRepository<MHrEmployeeEntity, String> {

    /**
     * 总条数
     * @return
     */
    @Query(value = "SELECT " +
            "COUNT(1)" +
            " FROM " +
            "M_HREmployee a " +
            "LEFT JOIN M_HRRelational b ON a.EmployeeID = b.EmployeeID " +
            "LEFT JOIN M_HRDepartment c ON c.DepID = b.DeptID " +
            "LEFT JOIN M_HROrganization o ON c.OrgID = o.OrgID",nativeQuery = true)
    long findByCountAll();

    /**
     * 查询单位下的职工
     * @param orgId
     * @return
     */
    @Query(value = "SELECT " +
            "a.EmployeeID," +
            "a.RealName," +
            "a.HRCode," +
            "a.PaperNum," +
            "a.PhoneNum," +
            "a.TravelLevel" +
            " FROM " +
            "M_HREmployee a " +
            "LEFT JOIN M_HRRelational b ON a.EmployeeID = b.EmployeeID " +
            "LEFT JOIN M_HRDepartment c ON c.DepID = b.DeptID " +
            "LEFT JOIN M_HROrganization o ON c.OrgID = o.OrgID " +
            "WHERE o.OrgID = :orgId",nativeQuery = true)
    List<Object[]> findByOrgId(@Param("orgId") String orgId);

    List<MHrEmployeeEntity> findByEmployeeIdIn(List<String> empList);

    //转换人员使用的数据填充sql

    @Query(value = "select ID from M_CompanyDepartment where HRDeptID = (SELECT DeptID FROM M_HRRelational WHERE EmployeeID = :employeeId)",nativeQuery = true)
    Integer findByDeparmentId(@Param("employeeId") String employeeId);

    @Query(value = "select ID from M_CompanyTravelLevel where CompanyID = :companyID AND LevelType = :employeeId AND `Level` = 1",nativeQuery = true)
    Integer findByTraveLevel(@Param("companyID") Integer companyID, @Param("employeeId") Byte employeeId);
}
