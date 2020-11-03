package com.andreasgroup.andreasbeersupply.web.mappers;

import com.andreasgroup.andreasbeersupply.domain.Beer;
import com.andreasgroup.andreasbeersupply.services.inventory.BeerInventoryService;
import com.andreasgroup.andreasbeersupply.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 01/Nov/2020 to andreas-beer-supply
 */
public abstract class BeerMapperDecorator implements BeerMapper{

    private BeerInventoryService beerInventoryService;
    private BeerMapper beerMapper;

    @Autowired
    public void setBeerInventoryService(BeerInventoryService beerInventoryService){
        this.beerInventoryService = beerInventoryService;
    }

    @Autowired
    public void setMapper(BeerMapper beerMapper){
        this.beerMapper = beerMapper;
    }

    @Override
    public BeerDto BeerToBeerDto(Beer beer){
        return beerMapper.BeerToBeerDto(beer);
    }

    @Override
    public Beer BeerDtoToBeer(BeerDto beerDto){
        return beerMapper.BeerDtoToBeer(beerDto);
    }

    @Override
    public BeerDto BeerToBeerDtoWithInventory(Beer beer) {
        BeerDto dto = beerMapper.BeerToBeerDto(beer);
        dto.setQuantityOnHand(beerInventoryService.getOnhandInventory(beer.getId()));
        return dto;
    }
}
