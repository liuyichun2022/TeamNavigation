package com.dash.navigation.repository;

import com.dash.navigation.domain.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CardRepository.
 *
 * @author Jason.liu
 * @date 2024-02-04
 */
public interface SettingRepository extends JpaRepository<Setting, String> {

}
