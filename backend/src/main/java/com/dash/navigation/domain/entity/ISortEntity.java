package com.dash.navigation.domain.entity;

import java.io.Serializable;

/**
 * BaseSort.
 *
 * @author Jason.liu
 * @date 2024-02-04
 */
public interface ISortEntity<T> extends Serializable {

    /**
     * getSort
     *
     * @return Integer
     */
    Integer getSort();

    /**
     * setSort
     *
     * @param sort v
     * @return T
     */
    T setSort(Integer sort);

}
