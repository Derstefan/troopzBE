package com.trooping.backend.core.map;

public enum LocationType {
    VILLAGE(
        "Village",
        false
    ),
    TOWN(
        "Town",
        false
    ),
    CITY(
        "City",
        false
    ),
    ENCAMPMENT(
        "Encampment",
        true
    ),
    FORTRESS(
        "Fortress",
        true
    );

    private final String name;
    private final boolean recruitment;
    LocationType(String name, boolean recruitment) {
        this.name = name;
        this.recruitment = recruitment;
    };
};
