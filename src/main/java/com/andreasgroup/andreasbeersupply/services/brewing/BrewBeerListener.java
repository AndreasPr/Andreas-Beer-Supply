package com.andreasgroup.andreasbeersupply.services.brewing;

import com.andreasgroup.andreasbeersupply.config.JmsConfig;
import com.andreasgroup.andreasbeersupply.domain.Beer;
import com.andreasgroup.andreasbeersupply.events.BrewBeerEvent;
import com.andreasgroup.andreasbeersupply.events.NewInventoryEvent;
import com.andreasgroup.andreasbeersupply.repositories.BeerRepository;
import com.andreasgroup.brewery.model.BeerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 15/Nov/2020 to andreas-beer-supply
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class BrewBeerListener {

    private final BeerRepository beerRepository;
    private final JmsTemplate jmsTemplate;

    @Transactional
    @JmsListener(destination = JmsConfig.BREWING_REQUEST_QUEUE)
    public void listen(BrewBeerEvent event){
        BeerDto beerDto = event.getBeerDto();

        Beer beer = beerRepository.getOne(beerDto.getId());
        beerDto.setQuantityOnHand(beer.getQuantityToBrew());

        NewInventoryEvent newInventoryEvent = new NewInventoryEvent(beerDto);
        log.debug("Brewed beer" + beer.getMinOnHand() + " : QOH: " + beerDto.getQuantityOnHand());

        jmsTemplate.convertAndSend(JmsConfig.NEW_INVENTORY_QUEUE, newInventoryEvent);
    }


}