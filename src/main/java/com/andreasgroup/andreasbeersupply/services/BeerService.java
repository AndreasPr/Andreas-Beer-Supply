package com.andreasgroup.andreasbeersupply.services;

import com.andreasgroup.andreasbeersupply.web.model.BeerDto;

import java.util.UUID;

/**
 * Created on 26/Oct/2020 to andreas-beer-supply
 */
public interface BeerService {

    BeerDto getById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

}
