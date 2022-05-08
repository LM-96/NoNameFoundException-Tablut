package it.unibo.ai.didattica.competition.tablut.intelligence.heuristic;

import it.unibo.ai.didattica.competition.tablut.woods.VisitableObject;

/**
 * Represents a {@link VisitableObject} in which the result of the visit
 * is an {@link Integer}, the type returned after applying an heuristic
 * function. So, this class represent an object that can be visited from
 * a heuristic and the result can be stored into it
 * @param <S>
 */
public class HeuristicVisitable<S> extends VisitableObject<S, Integer> {

    public HeuristicVisitable(S object) {
        super(object);
    }
}
