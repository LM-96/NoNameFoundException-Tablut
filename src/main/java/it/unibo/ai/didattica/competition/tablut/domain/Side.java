package it.unibo.ai.didattica.competition.tablut.domain;

public enum Side {
    LEFT, UP, RIGHT, BOTTOM;

    public static final int LEFT_I = 0;
    public static final int UP_I = 1;
    public static final int RIGHT_I = 2;
    public static final int BOTTOM_I = 3;

    public static Side fromInt(int value) {
        switch (value) {
            case LEFT_I: return LEFT;
            case UP_I: return UP;
            case RIGHT_I: return RIGHT;
            case BOTTOM_I:return BOTTOM;
            default:
                throw new IllegalArgumentException("Invalid number for side: " + value);
        }
    }

    public int toInt() {
        switch (this) {
            case LEFT: return LEFT_I;
            case UP: return UP_I;
            case RIGHT: return RIGHT_I;
            case BOTTOM: return BOTTOM_I;
        }
        return -1;
    }
}
