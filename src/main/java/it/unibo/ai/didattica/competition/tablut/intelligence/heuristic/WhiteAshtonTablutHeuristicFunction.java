package it.unibo.ai.didattica.competition.tablut.intelligence.heuristic;

import it.unibo.ai.didattica.competition.tablut.domain.State;
import it.unibo.ai.didattica.competition.tablut.intelligence.ReachableState;

public class WhiteAshtonTablutHeuristicFunction implements HeuristicFunction<ReachableState> {

    @Override
    public int apply(ReachableState reachableState) {
        State state = reachableState.getState();
        switch (state.getTurn()) {
            case DRAW:
                return 0;
            case WHITEWIN:
                return WIN_VALUE;
            case BLACKWIN:
                return LOSE_VALUE;
        }

        return 0;
    }
}
