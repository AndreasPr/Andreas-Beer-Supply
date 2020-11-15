package com.andreasgroup.andreasbeersupply.events;

import com.andreasgroup.andreasbeersupply.web.model.BeerDto;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 * Created on 15/Nov/2020 to andreas-beer-supply
 */
@Data
@RequiredArgsConstructor
@Builder
public class BeerEvent implements Serializable {

    static final long serialVersionUID = -7225693773567796173L;

    private final BeerDto beerDto;
}
