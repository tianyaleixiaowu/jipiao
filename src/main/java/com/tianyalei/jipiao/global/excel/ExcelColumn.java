package com.tianyalei.jipiao.global.excel;

import java.lang.annotation.*;

/**
 * @author wuweifeng wrote on 2018/11/9.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelColumn {

    String value() default "";

    int col() default 0;
}