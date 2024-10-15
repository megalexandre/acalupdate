package br.org.acal.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class UseCaseResponse {
    private boolean success;
    private List<String> errors;
}
