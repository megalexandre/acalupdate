package br.org.acal.application.screen.link.model;

import br.org.acal.commons.enumeration.StatusPaymentInvoice;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JComboBoxStatus {

    private String name;
    private StatusPaymentInvoice status;

    public static JComboBoxStatus of(StatusPaymentInvoice status){
        return JComboBoxStatus.builder().
                name(status.getDescription()).
                status(status)
                .build();
    }

    public static JComboBoxStatus clearData(){
        return JComboBoxStatus.builder()
                .name("Selecione")
                .status(null)
                .build();
    }
    @Override
    public String toString() {
        return name;
    }

}