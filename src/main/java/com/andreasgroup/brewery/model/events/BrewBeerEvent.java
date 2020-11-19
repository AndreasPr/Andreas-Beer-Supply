package com.andreasgroup.brewery.model.events;

import com.andreasgroup.brewery.model.BeerDto;
import lombok.NoArgsConstructor;

/**
 * Created on 15/Nov/2020 to andreas-beer-supply
 */
@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent {

    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
