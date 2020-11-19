package com.andreasgroup.andreasbeersupply.events;

import com.andreasgroup.brewery.model.BeerDto;
import lombok.NoArgsConstructor;

/**
 * Created on 15/Nov/2020 to andreas-beer-supply
 */
@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent{

    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
