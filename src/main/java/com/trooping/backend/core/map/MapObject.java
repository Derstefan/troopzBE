package com.trooping.backend.core.map;

import com.trooping.backend.core.team.Team;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;
@Data
@AllArgsConstructor
public abstract class MapObject {

    private final UUID uuid = UUID.randomUUID();
    private String name;
    private Pos pos;
    private Team team;
}
