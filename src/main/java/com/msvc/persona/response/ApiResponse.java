package com.msvc.persona.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@AllArgsConstructor
@Builder
public class ApiResponse {

    private String message;

    private boolean success;

    private HttpStatus status;

}
