package com.gihanz.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Builder
public class JwtResponse {

    private String token;
}
