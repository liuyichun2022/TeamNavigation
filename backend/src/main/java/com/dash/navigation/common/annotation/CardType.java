package com.dash.navigation.common.annotation;

import com.dash.navigation.common.enums.CardTypeEnum;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * CardType.
 * @author Jason.liu
 * @date 2024-02-04
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CardType {

    /**
     * 数组，允许多个类型使用同一个实现
     *
     * @return CardTypeEnum
     */
    CardTypeEnum[] value();

}
