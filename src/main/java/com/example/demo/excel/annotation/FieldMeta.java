package com.example.demo.excel.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface FieldMeta {

    /**
     * excel中显示的标题名称
     *
     * @return
     */
    String title() default "";

    /**
     * excel中列的排序
     *
     * @return
     */
    int order() default 0;
}
