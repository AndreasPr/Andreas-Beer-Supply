package com.andreasgroup.andreasbeersupply.events;

import com.andreasgroup.brewery.model.BeerDto;
import lombok.*;

import java.io.Serializable;

/**
 * Created on 15/Nov/2020 to andreas-beer-supply
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerEvent implements Serializable {

    static final long serialVersionUID = -7225693773567796173L;

    private BeerDto beerDto;
}
