package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.MMemberCardNumEntity;
import com.tianyalei.jipiao.core.repository.MemberCardNumRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wuweifeng wrote on 2018/11/1.
 */
@Service
public class MemberCardNumManager {
    @Resource
    private MemberCardNumRepository memberCardNumRepository;


    public MMemberCardNumEntity findFirstCardNum() {
        return memberCardNumRepository.findFirstByOrderById();
    }

    public void deleteByCardNum(String cardNum) {
        memberCardNumRepository.deleteByCardNum(cardNum);
    }

}
