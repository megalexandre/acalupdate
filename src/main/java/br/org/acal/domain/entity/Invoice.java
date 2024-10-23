 package br.org.acal.domain.entity;

import br.org.acal.commons.Prices;
import br.org.acal.commons.enumeration.StatusPaymentInvoice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.val;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.LocalDateTime.now;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

    private String number;
    private LocalDateTime payedAt;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime period;
    private Link link;
    private BigDecimal partnerValue;
    private BigDecimal otherValues;
    private WaterMeter waterMeter;

    public boolean isPayed(){
        return payedAt != null;
    }

    public StatusPaymentInvoice status(){

        if(payedAt != null ){
            return StatusPaymentInvoice.PAYED;
        } else if (dueDate.isAfter(now())){
            return StatusPaymentInvoice.OPEN;
        }

        return StatusPaymentInvoice.OVERDUE;
    }

    public String payedAtAsString(){
        if(payedAt != null){
            return payedAt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        return null;
    }

    public Period period(){
        return Period.of(period);
    }

    public BigDecimal totalValue(){
        var waterValue =  waterValue();
        var water  = waterValue() == null ? BigDecimal.ZERO : waterValue;
        var partner = partnerValue == null ? BigDecimal.ZERO : partnerValue;
        var other = otherValues == null ? BigDecimal.ZERO : otherValues;

        return water.add(partner).add(other);
    }

    public BigDecimal waterValue(){
        return BigDecimal.valueOf(useFullConsumption()).multiply(Prices.water);
    }


    public Double useFullConsumption() {
        val consumptionTotal = BigDecimal.valueOf(consumptionTotal());

        if (consumptionTotal.compareTo(Prices.freeTierWater) > 0) {
            return consumptionTotal.subtract(Prices.freeTierWater).doubleValue();
        }

        return 0.0;
    }

    public Double consumptionTotal(){
        return consumptionEnd() - consumptionStart();
    }

    public Double consumptionStart(){
        return waterMeter != null && waterMeter.getConsumptionStart() != null ? waterMeter.getConsumptionStart() : 0.0;
    }

    public Double consumptionEnd(){
        return waterMeter != null && waterMeter.getConsumptionEnd() != null ? waterMeter.getConsumptionEnd() : 0.0;
    }

    public Customer customer() { return link.getCustomer(); }

    public Address address(){
        return link.getAddress();
    }

    public Category category(){
        return link.getCategory();
    }

}
