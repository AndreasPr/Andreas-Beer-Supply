package com.andreasgroup.andreasbeersupply.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
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

    @NotBlank
    private String beerName;

    @NotNull
    private BeerStyleEnum beerStyle;

    @NotNull
    private String upc;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Positive
    @NotNull
    private BigDecimal price;

    private Integer quantityOnHand;

    @Null
    private UUID id;

    @Null
    private Integer version;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy:MM:dd'T'HH:mm:ssZ")
    @Null
    private OffsetDateTime createdDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy:MM:dd'T'HH:mm:ssZ")
    @Null
    private OffsetDateTime lastModifiedDate;
}
