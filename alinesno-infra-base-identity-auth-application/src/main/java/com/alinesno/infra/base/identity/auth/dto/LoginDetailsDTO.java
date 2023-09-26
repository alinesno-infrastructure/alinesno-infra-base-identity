package com.alinesno.infra.base.identity.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginDetailsDTO {

    private String redirect;
    private String mode;
    private String client;
}
