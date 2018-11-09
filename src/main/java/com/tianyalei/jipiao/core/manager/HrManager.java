package com.tianyalei.jipiao.core.manager;

import com.tianyalei.jipiao.core.model.base.BaseEntity;
import com.tianyalei.jipiao.global.bean.BaseData;
import com.tianyalei.jipiao.global.excel.ExcelUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author wuweifeng wrote on 2018/11/9.
 */
@Service
public class HrManager {
    //比对的项目包含：键重复的（组织结构ID，部门ID，职工ID，HR编号），身份证格式错误

    public <T extends BaseEntity> BaseData deal(MultipartFile file, boolean preview, boolean enable, Class<T> object)
            throws Exception {
        parseFile(file, object);
        return null;
    }



    private <T extends BaseEntity> List<T>  parseFile(MultipartFile file, Class<T> clazz) throws Exception {
        //FileOutputStream out = new FileOutputStream("./" + file.getOriginalFilename());
        //out.write(file.getBytes());
        //out.flush();
        //out.close();
        //File targetFile = new File("./" + file.getOriginalFilename());

        return ExcelUtils.readExcel("", clazz, file);
    }
}
