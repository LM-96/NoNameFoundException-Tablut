package it.unibo.ai.didattica.competition.tablut.intelligence.heuristic;

/**
 * Represents an object able to calculate an heuristic value
 * on a certain type
 * @param <S> the type to be used for heuristic calculation
 */
public interface HeuristicFunction<S> {

    public static int WIN_VALUE = Integer.MAX_VALUE;
    public static int LOSE_VALUE = Integer.MIN_VALUE;
    public static int DRAW_VALUE = 0;

    /**
     * Applies the heuristic function using the passed object
     * @param object the input for the heuristic
     * @return the result of the calculation
     */
    public abstract int apply(S object);

}
