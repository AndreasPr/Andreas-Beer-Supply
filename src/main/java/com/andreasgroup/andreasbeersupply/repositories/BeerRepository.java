package com.andreasgroup.andreasbeersupply.repositories;

import com.andreasgroup.andreasbeersupply.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

/**
 * Created on 22/Oct/2020 to andreas-beer-supply
 */
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {





}
