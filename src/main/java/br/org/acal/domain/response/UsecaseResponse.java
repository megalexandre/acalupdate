package br.org.acal.domain.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class UsecaseResponse {
    private boolean success;
    private List<String> errors;
}
