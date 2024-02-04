package com.dash.navigation.repository;

import com.dash.navigation.domain.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * NoticeRepository.
 *
 * @author Jason.liu
 * @date 2024-02-04
 */
public interface NoticeRepository extends JpaRepository<Notice, String> {

    /**
     * getMaxSort
     *
     * @return Integer
     */
    @Query("select coalesce(max(sort),0) from Notice")
    Integer getMaxSort();
}
