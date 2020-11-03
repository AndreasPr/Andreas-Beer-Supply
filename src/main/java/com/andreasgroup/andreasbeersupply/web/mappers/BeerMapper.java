package com.andreasgroup.andreasbeersupply.web.mappers;

import com.andreasgroup.andreasbeersupply.domain.Beer;
import com.andreasgroup.andreasbeersupply.web.model.BeerDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

/**
 * Created on 23/Oct/2020 to andreas-beer-supply
 */
@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {

    BeerDto BeerToBeerDto(Beer beer);

    BeerDto BeerToBeerDtoWithInventory(Beer beer);

    Beer BeerDtoToBeer(BeerDto beerDto);
}
