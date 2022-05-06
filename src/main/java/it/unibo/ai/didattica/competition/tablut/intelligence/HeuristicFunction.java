package it.unibo.ai.didattica.competition.tablut.intelligence;

import it.unibo.ai.didattica.competition.tablut.domain.State;

public interface HeuristicFunction {

    public int apply(State state);

}
