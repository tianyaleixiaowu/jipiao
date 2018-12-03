package com.tianyalei.jipiao;

import com.tianyalei.jipiao.core.manager.MemberCardNumManager;
import com.tianyalei.jipiao.core.manager.MemberManager;
import com.tianyalei.jipiao.core.manager.SysUserManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JipiaoApplicationTests {
    @Resource
    private MemberManager memberManager;
    @Resource
    private MemberCardNumManager memberCardNumManager;
    @Resource
    private SysUserManager sysUserManager;

    @Test
    public void contextLoads() {
        //List<MMemberEntity> list = memberManager.findAll();
        //for (MMemberEntity entity : list) {
        //     entity.setPaperNum(CommonUtil.aesEncode(new CreateIDCardNo().getRandomID()));
        //     entity.setCellPhone(CommonUtil.aesEncode(CreateIDCardNo.getTelephone()));
        //    memberManager.save(entity);
        //}
        //String s =memberCardNumManager.findFirstCardNum().getCardNum();
        //System.out.println(s);
        //SysUser sysUser = new SysUser();
        //sysUser.setAa("sss");
        //sysUserManager.save(sysUser);
    }

}
