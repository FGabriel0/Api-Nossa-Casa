package com.novacasa.Nova_Casa.enums;

import lombok.Getter;

@Getter
public enum ResponseStatusEnum {

    SUCCESS("success"), 
    ERROR("danger"), 
    INFO("info"), 
    WARNING("warning");

    private String description;

    private ResponseStatusEnum(String description) {
        this.description = description;
    }
}