package br.org.acal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Optional;

@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentFilter {

    private String number;
    private LocalDateTime createdAtStart;
    private LocalDateTime createAtEnd;

    public Optional<LocalDateTime> createdAtStart(){
        return Optional.ofNullable(createdAtStart);
    }

    public Optional<LocalDateTime> createdAtEnd(){
        return Optional.ofNullable(createAtEnd);
    }

    public Optional<String> period() {
        return Optional.ofNullable(number);
    }
}
