package com.tianyalei.jipiao.core.repository;

import com.tianyalei.jipiao.core.model.MMemberCardNumEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
public interface MemberCardNumRepository extends JpaRepository<MMemberCardNumEntity, Integer> {

    MMemberCardNumEntity findFirstByOrderById();

    void deleteByCardNum(String cardNum);

}
