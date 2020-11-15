package com.andreasgroup.andreasbeersupply.events;

import com.andreasgroup.andreasbeersupply.web.model.BeerDto;

/**
 * Created on 15/Nov/2020 to andreas-beer-supply
 */
public class NewInventoryEvent extends BeerEvent{

    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
