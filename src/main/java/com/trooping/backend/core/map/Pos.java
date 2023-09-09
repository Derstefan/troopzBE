package com.trooping.backend.core.map;

public class Pos {
    private float x;
    private float y;

    public Pos(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }

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
