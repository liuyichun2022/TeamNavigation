package com.dash.navigation.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * ChangePassword.
 *
 * @author Jason.liu
 * @date 2024-02-04
 */
@Getter
@Setter
public class ChangePassword {

    private String oldPassword;

    private String newPassword;
}
