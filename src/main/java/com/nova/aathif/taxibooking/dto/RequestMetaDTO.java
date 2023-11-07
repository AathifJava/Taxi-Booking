package com.nova.aathif.taxibooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestMetaDTO {
    private int id;
    private String name;
    private String email;
}
