package com.trooping.backend.core.map;

import lombok.Data;

//FIXME: The methods prevent to make this a Immutable class
@Data
public class Pos {
    private final float x;
    private final float y;

    public Pos add(Pos pos) {
        return new Pos(x + pos.x, y + pos.y);
    }

    public Pos times(float scalar) {
        return new Pos(x * scalar, y * scalar);
    }

    public Pos normalized() {
        float length = (float) Math.sqrt(x * x + y * y);
        if (length != 0) {
            return new Pos(x / length, y / length);
        } else {
            return new Pos(0, 0);
        }
    }

    public Pos minus(Pos pos) {
        return new Pos(x - pos.x, y - pos.y);
    }
}
