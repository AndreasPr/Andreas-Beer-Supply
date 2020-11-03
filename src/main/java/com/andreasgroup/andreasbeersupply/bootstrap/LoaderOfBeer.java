package com.andreasgroup.andreasbeersupply.bootstrap;

import com.andreasgroup.andreasbeersupply.domain.Beer;
import com.andreasgroup.andreasbeersupply.repositories.BeerRepository;
import com.andreasgroup.andreasbeersupply.web.model.BeerStyleEnum;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created on 22/Oct/2020 to andreas-beer-supply
 */
//@Component
public class LoaderOfBeer implements CommandLineRunner {

    public static final String BEER_UPC_1 = "0631234200036";
    public static final String BEER_UPC_2 = "0631234300019";
    public static final String BEER_UPC_3 = "0083783375213";
    public static final UUID BEER_1_UUID = UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb");
    public static final UUID BEER_2_UUID = UUID.fromString("a712d914-61ea-4623-8bd0-32c0f6545bfd");
    public static final UUID BEER_3_UUID = UUID.fromString("026cc3c8-3a0c-4083-a05b-e908048c1b08");

    private final BeerRepository beerRepository;

    public LoaderOfBeer(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(beerRepository.count() == 0){
            loadBeerObjects();
        }
    }

    private void loadBeerObjects() {

        Beer b1 = Beer
                .builder()
                .beerName("Alpha Beer")
                .beerStyle(BeerStyleEnum.GOSE.name())
                .quantityToBrew(200)
                .upc(BEER_UPC_1)
                .price(new BigDecimal("20.32"))
                .minOnHand(12)
                .build();

        Beer b2 = Beer
                .builder()
                .beerName("Heineken")
                .beerStyle(BeerStyleEnum.SAISON.name())
                .quantityToBrew(200)
                .upc(BEER_UPC_2)
                .price(new BigDecimal("30.32"))
                .minOnHand(12)
                .build();

        Beer b3 = Beer
                .builder()
                .beerName("Fix")
                .beerStyle(BeerStyleEnum.IPA.name())
                .quantityToBrew(200)
                .upc(BEER_UPC_3)
                .price(new BigDecimal("20.32"))
                .minOnHand(12)
                .build();

        beerRepository.save(b1);
        beerRepository.save(b2);
        beerRepository.save(b3);
    }
}
