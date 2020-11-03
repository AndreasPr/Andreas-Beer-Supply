package com.andreasgroup.andreasbeersupply.services;

import com.andreasgroup.andreasbeersupply.web.model.BeerDto;
import com.andreasgroup.andreasbeersupply.web.model.BeerPagedList;
import com.andreasgroup.andreasbeersupply.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

/**
 * Created on 26/Oct/2020 to andreas-beer-supply
 */
public interface BeerService {

    BeerDto getById(UUID beerId, Boolean showInventoryOnHand);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);
}
