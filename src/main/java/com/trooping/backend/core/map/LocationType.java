package com.trooping.backend.core.map;

public enum LocationType {
    VILLAGE(
        "Village"
    ),
    TOWN(
        "Town"
    ),
    CITY(
        "City"
    ),
    ENCAMPMENT(
        "Encampment"
    ),
    FORTRESS(
        "Fortress"
    );

    private final String name;
    LocationType(String name) {
        this.name = name;
    };
};
