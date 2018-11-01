package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wuweifeng wrote on 2018/3/7.
 */
public interface UserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByAccount(String account);
}
