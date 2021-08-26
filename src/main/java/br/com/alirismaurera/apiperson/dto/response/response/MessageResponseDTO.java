package br.com.alirismaurera.apiperson.dto.response.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDTO {

    private String message;
}
