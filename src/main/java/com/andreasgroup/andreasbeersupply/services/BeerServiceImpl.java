package com.andreasgroup.andreasbeersupply.services;

import com.andreasgroup.andreasbeersupply.domain.Beer;
import com.andreasgroup.andreasbeersupply.repositories.BeerRepository;
import com.andreasgroup.andreasbeersupply.web.controller.NotFoundException;
import com.andreasgroup.andreasbeersupply.web.mappers.BeerMapper;
import com.andreasgroup.andreasbeersupply.web.model.BeerDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created on 26/Oct/2020 to andreas-beer-supply
 */
@AllArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getById(UUID beerId) {
        return beerMapper.BeerToBeerDto(beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return beerMapper.BeerToBeerDto(beerRepository.save(beerMapper.BeerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {

        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

        return beerMapper.BeerToBeerDto(beerRepository.save(beer));
    }
}
