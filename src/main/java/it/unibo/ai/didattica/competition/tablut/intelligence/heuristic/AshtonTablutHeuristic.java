package it.unibo.ai.didattica.competition.tablut.intelligence.heuristic;

import it.unibo.ai.didattica.competition.tablut.domain.Side;

import java.util.*;

public interface AshtonTablutHeuristic {

    public static final int TOT_WHITE_PAWNS = 8;
    public static final int TOT_BLACK_PAWNS = 16;
    public static final int BOARD_ROWS = 9;
    public static final int BOARD_COLS = 9;

    public static final Map<Side, Coordinate[]> CITADELS_BY_SIDE = getCitadelsBySide();
    public static final Coordinate[][] CITADELS_BY_SIDE_I = fromSideMapToMatrix(CITADELS_BY_SIDE);
    public static final Coordinate[] CITADELS = fromSideMapToFlatValueArray(CITADELS_BY_SIDE);
    private static Map<Side, Coordinate[]> getCitadelsBySide() {
        Map<Side, Coordinate[]> res = new HashMap<>();
        Coordinate[] LEFT_CITADELS = {new Coordinate(3, 0), new Coordinate(4, 0),
                new Coordinate(5, 0), new Coordinate(4, 1)};
        Coordinate[] UP_CITADELS = {new Coordinate(8, 3), new Coordinate(8, 4),
                new Coordinate(8, 5), new Coordinate(7, 4)};
        Coordinate[] RIGHT_CITADELS = {new Coordinate(3, 8), new Coordinate(4, 8),
                new Coordinate(5, 8), new Coordinate(4, 7)};
        Coordinate[] BOTTOM_CITADELS = {new Coordinate(0, 3), new Coordinate(0, 4),
                new Coordinate(0, 5), new Coordinate(1, 4)};
        res.put(Side.LEFT, LEFT_CITADELS);
        res.put(Side.UP, UP_CITADELS);
        res.put(Side.RIGHT, RIGHT_CITADELS);
        res.put(Side.BOTTOM, BOTTOM_CITADELS);
        return res;
    }


    public static Coordinate TRONE = new Coordinate(4, 4);

    public static Map<Side, Coordinate[]> ESCAPES_BY_SIDE = getEscapesBySide();
    public static Coordinate[][] ESCAPES_BY_SIDE_I = fromSideMapToMatrix(ESCAPES_BY_SIDE);
    public static Coordinate[] ESCAPES = fromSideMapToFlatValueArray(ESCAPES_BY_SIDE);
    public static Map<Side, Coordinate[]> getEscapesBySide() {
        Map<Side, Coordinate[]> res = new HashMap<>();
        Coordinate[] LEFT_ESCAPES = {new Coordinate(1, 0), new Coordinate(2, 0),
                new Coordinate(6, 0), new Coordinate(7, 0)};
        Coordinate[] UP_ESCAPES = {new Coordinate(8, 1), new Coordinate(8, 2),
                new Coordinate(8, 6), new Coordinate(8, 7)};
        Coordinate[] RIGHT_ESCAPES = {new Coordinate(1, 8), new Coordinate(2, 8),
                new Coordinate(6, 8), new Coordinate(7, 8)};
        Coordinate[] BOTTOM_ESCAPES = {new Coordinate(0, 1), new Coordinate(0, 2),
                new Coordinate(0, 6), new Coordinate(0, 7)};
        res.put(Side.LEFT, LEFT_ESCAPES);
        res.put(Side.UP, UP_ESCAPES);
        res.put(Side.RIGHT, RIGHT_ESCAPES);
        res.put(Side.BOTTOM, BOTTOM_ESCAPES);
        return res;
    }

    private static Coordinate[] fromSideMapToFlatValueArray(Map<Side, Coordinate[]> map) {
        return map.values()
                .stream()
                .flatMap(Arrays::stream)
                .toArray(Coordinate[]::new);
    }

    private static Coordinate[][] fromSideMapToMatrix(Map<Side, Coordinate[]> map) {
        List<Coordinate[]> res = new ArrayList<>();
        map
                .forEach((key, value) -> res.add(key.toInt(), value));
        return res.toArray(Coordinate[][]::new);
    }

}
