package com.andreasgroup.andreasbeersupply.events;

import com.andreasgroup.andreasbeersupply.web.model.BeerDto;

/**
 * Created on 15/Nov/2020 to andreas-beer-supply
 */
public class BrewBeerEvent extends BeerEvent{

    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}