package acal.report.model;

import acal.commons.Prices;
import lombok.Builder;
import lombok.Data;
import lombok.val;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class Invoice {

    private String number;
    private LocalDateTime payedAt;
    private LocalDateTime duoDate;
    private LocalDateTime createdAt;
    private LocalDateTime period;
    private Link link;
    private BigDecimal partnerValue;
    private BigDecimal otherValues;
    private WaterMeter waterMeter;


    public BigDecimal totalValue(){
        return partnerValue.add(waterValue());
    }

    public BigDecimal waterValue(){
        return BigDecimal.valueOf(useFullConsumption()).multiply(Prices.water);
    }


    public Double useFullConsumption() {
        val consumptionTotal = BigDecimal.valueOf(consumptionTotal());

        if (consumptionTotal.compareTo(Prices.freeTierWater) > 0) {
            return consumptionTotal.subtract(Prices.freeTierWater).doubleValue();
        }

        return consumptionTotal.doubleValue();
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
