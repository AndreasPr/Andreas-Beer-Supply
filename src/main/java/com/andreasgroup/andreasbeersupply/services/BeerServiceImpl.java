package com.andreasgroup.andreasbeersupply.services;

import com.andreasgroup.andreasbeersupply.domain.Beer;
import com.andreasgroup.andreasbeersupply.repositories.BeerRepository;
import com.andreasgroup.andreasbeersupply.web.controller.NotFoundException;
import com.andreasgroup.andreasbeersupply.web.mappers.BeerMapper;
import com.andreasgroup.andreasbeersupply.web.model.BeerDto;
import com.andreasgroup.andreasbeersupply.web.model.BeerPagedList;
import com.andreasgroup.andreasbeersupply.web.model.BeerStyleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created on 26/Oct/2020 to andreas-beer-supply
 */
@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Cacheable(cacheNames = "beerListCache", condition = "#showInventoryOnHand==false")
    @Override
    public BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand) {

        System.out.println("I was called");

        BeerPagedList beerPagedList;
        Page<Beer> beerPage;

        if(!StringUtils.isEmpty(beerName) && !StringUtils.isEmpty(beerStyle)){
            beerPage = beerRepository.findAllByBeerNameAndBeerStyle(beerName, beerStyle, pageRequest);
        }
        else if (!StringUtils.isEmpty(beerName) && StringUtils.isEmpty(beerStyle)){
            //Searching beer name
            beerPage = beerRepository.findAllByBeerName(beerName, pageRequest);
        }
        else if(StringUtils.isEmpty(beerName) && !StringUtils.isEmpty(beerStyle)){
            //Searching beer style
            beerPage = beerRepository.findAllByBeerStyle(beerStyle, pageRequest);
        }
        else{
            beerPage = beerRepository.findAll(pageRequest);
        }

        if(showInventoryOnHand){
            beerPagedList = new BeerPagedList(beerPage
                    .getContent()
                    .stream()
                    .map(beerMapper::BeerToBeerDtoWithInventory)
                    .collect(Collectors.toList()),
                    PageRequest.of(beerPage.getPageable().getPageNumber(),
                            beerPage.getPageable().getPageSize()), beerPage.getTotalElements());
        }else{
            beerPagedList = new BeerPagedList(beerPage
                    .getContent()
                    .stream()
                    .map(beerMapper::BeerToBeerDto)
                    .collect(Collectors.toList()),
                    PageRequest.of(beerPage.getPageable().getPageNumber(),
                            beerPage.getPageable().getPageSize()), beerPage.getTotalElements());
        }

        return beerPagedList;
    }

    @Cacheable(cacheNames = "beerCache", key = "#beerId", condition = "#showInventoryOnHand==false")
    @Override
    public BeerDto getById(UUID beerId, Boolean showInventoryOnHand) {

        System.out.println("I was called");

        if(showInventoryOnHand){
            return beerMapper.BeerToBeerDtoWithInventory(beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
        }else{
            return beerMapper.BeerToBeerDto(beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
        }
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

    @Cacheable(cacheNames = "beerUpcCache", key = "#upc")
    @Override
    public BeerDto getByUpc(String upc) {
        return beerMapper.BeerToBeerDto(beerRepository.findByUpc(upc));
    }
}
