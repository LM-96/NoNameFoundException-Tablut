package it.unibo.ai.didattica.competition.tablut.intelligence.search;

import it.unibo.ai.didattica.competition.tablut.intelligence.heuristic.HeuristicFunction;
import it.unibo.ai.didattica.competition.tablut.intelligence.heuristic.HeuristicVisitable;

public abstract class AbstractHeuristicTreeSearch<S>
    implements TreeSearch<HeuristicVisitable<S>>
{

    protected HeuristicFunction<S> heuristic;

    public AbstractHeuristicTreeSearch(HeuristicFunction<S> heuristic) {
        this.heuristic = heuristic;
    }

    public HeuristicFunction<S> getHeuristic() {
        return this.heuristic;
    }

}
