package com.andreasgroup.andreasbeersupply.web.mappers;

import com.andreasgroup.andreasbeersupply.domain.Beer;
import com.andreasgroup.andreasbeersupply.services.inventory.BeerInventoryService;
import com.andreasgroup.brewery.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 01/Nov/2020 to andreas-beer-supply
 */
public abstract class BeerMapperDecorator implements BeerMapper{

    private BeerInventoryService beerInventoryService;
    private BeerMapper mapper;

    @Autowired
    public void setBeerInventoryService(BeerInventoryService beerInventoryService){
        this.beerInventoryService = beerInventoryService;
    }

    @Autowired
    public void setMapper(BeerMapper mapper){
        this.mapper = mapper;
    }

    @Override
    public BeerDto BeerToBeerDto(Beer beer){
        return mapper.BeerToBeerDto(beer);
    }

    @Override
    public Beer BeerDtoToBeer(BeerDto beerDto){
        return mapper.BeerDtoToBeer(beerDto);
    }

    @Override
    public BeerDto BeerToBeerDtoWithInventory(Beer beer) {
        BeerDto dto = mapper.BeerToBeerDto(beer);
        dto.setQuantityOnHand(beerInventoryService.getOnhandInventory(beer.getId()));
        return dto;
    }
}
