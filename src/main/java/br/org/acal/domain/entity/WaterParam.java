package br.org.acal.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WaterParam {
    private String number;
    private String name;
}
