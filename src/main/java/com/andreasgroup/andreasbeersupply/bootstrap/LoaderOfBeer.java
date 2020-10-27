package com.andreasgroup.andreasbeersupply.bootstrap;

import com.andreasgroup.andreasbeersupply.domain.Beer;
import com.andreasgroup.andreasbeersupply.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created on 22/Oct/2020 to andreas-beer-supply
 */
@Component
public class LoaderOfBeer implements CommandLineRunner {

    public static final String UPC_1 = "1234505836271";
    public static final String UPC_2 = "9482067317593";

    private final BeerRepository beerRepository;

    public LoaderOfBeer(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0){

            beerRepository.save(Beer
                    .builder()
                    .beerName("Alpha Beer")
                    .beerStyle("GOSE")
                    .quantityToBeerProvider(200)
                    .upc(UPC_1)
                    .price(new BigDecimal("20.32"))
                    .minOnHand(15)
                    .build());

            beerRepository.save(Beer
                    .builder()
                    .beerName("Heineken")
                    .beerStyle("SAISON")
                    .quantityToBeerProvider(300)
                    .upc(UPC_2)
                    .price(new BigDecimal("30.32"))
                    .minOnHand(11)
                    .build());
        }
    }
}
