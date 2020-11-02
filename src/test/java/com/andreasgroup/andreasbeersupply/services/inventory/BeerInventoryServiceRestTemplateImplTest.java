package com.andreasgroup.andreasbeersupply.services.inventory;

import com.andreasgroup.andreasbeersupply.bootstrap.LoaderOfBeer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created on 01/Nov/2020 to andreas-beer-supply
 */
//@Disabled
@SpringBootTest
public class BeerInventoryServiceRestTemplateImplTest {

    @Autowired
    BeerInventoryService beerInventoryService;

    @BeforeEach
    void setUp(){}

    @Test
    void getOnhandInventory(){
        Integer qoh = beerInventoryService.getOnhandInventory(LoaderOfBeer.BEER_1_UUID);
        System.out.println(qoh);
    }

}
