package br.org.acal.application.telas.relatorios;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JComboBoxItem {

    private String number;
    private String name;
    @Override
    public String toString() {
        return name;
    }
}
