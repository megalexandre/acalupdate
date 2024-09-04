package br.org.acal.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Document {

    private String type;
    private String number;


}

