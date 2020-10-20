package com.andreasgroup.andreasbeersupply.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Created on 20/Oct/2020 to andreas-beer-supply
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    private String beerName;
    private BeerStyleEnum beerStyle;
    private Long upc;
    private Integer quantityOnHand;
    private BigDecimal price;
    private UUID id;
    private Integer version;
    private OffsetDateTime createdDate;
    private OffsetDateTime lastModifiedDate;
}
