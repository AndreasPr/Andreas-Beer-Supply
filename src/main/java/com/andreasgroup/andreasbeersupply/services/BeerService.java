package com.andreasgroup.andreasbeersupply.services;

import com.andreasgroup.brewery.model.BeerDto;
import com.andreasgroup.brewery.model.BeerPagedList;
import com.andreasgroup.brewery.model.BeerStyleEnum;
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

    BeerDto getByUpc(String upc);
}
