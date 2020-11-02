package com.andreasgroup.andreasbeersupply.services.inventory;

import java.util.UUID;

/**
 * Created on 01/Nov/2020 to andreas-beer-supply
 */
public interface BeerInventoryService {

    Integer getOnhandInventory(UUID beerId);
}
