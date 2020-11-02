package com.andreasgroup.andreasbeersupply.web.controller;

import com.andreasgroup.andreasbeersupply.bootstrap.LoaderOfBeer;
import com.andreasgroup.andreasbeersupply.services.BeerService;
import com.andreasgroup.andreasbeersupply.web.model.BeerDto;
import com.andreasgroup.andreasbeersupply.web.model.BeerStyleEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created on 20/Oct/2020 to andreas-beer-supply
 */
@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerService;

    @Test
    void getBeerById() throws Exception{

        given(beerService.getById(any())).willReturn(getBeerDtoValidSample());

        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/beer/" + UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception{

        BeerDto beerDto = getBeerDtoValidSample();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        given(beerService.saveNewBeer(any())).willReturn(getBeerDtoValidSample());

        mockMvc.perform(
                post("/api/v1/beer/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception{

        given(beerService.updateBeer(any(), any())).willReturn(getBeerDtoValidSample());

        BeerDto beerDto = getBeerDtoValidSample();
        String beerDtoJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(
                put("/api/v1/beer/" + UUID.randomUUID().toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtoJson))
                .andExpect(status().isNoContent());
    }

    BeerDto getBeerDtoValidSample(){
        return BeerDto
                .builder()
                .beerName("Beer Test")
                .beerStyle(BeerStyleEnum.ALE)
                .price(new BigDecimal("12.56"))
                .upc(LoaderOfBeer.BEER_UPC_1)
                .build();
    }
}
