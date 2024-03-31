package com.novacasa.Nova_Casa.controller.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthDTO {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("email")
    private String email;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("perfis")
    private List<String> perfis;

    private String expiresIn;

}
