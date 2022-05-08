package it.unibo.ai.didattica.competition.tablut.intelligence.search;

import it.unibo.ai.didattica.competition.tablut.intelligence.heuristic.HeuristicFunction;
import it.unibo.ai.didattica.competition.tablut.intelligence.heuristic.HeuristicVisitable;
import it.unibo.ai.didattica.competition.tablut.woods.LeavesGenerator;

public abstract class AbstractHeurAGTreeSearch<S>
        extends AbstractHeuristicTreeSearch<S>
{

    protected LeavesGenerator<HeuristicVisitable<S>> generator;


    public AbstractHeurAGTreeSearch(HeuristicFunction heuristic,
                                    LeavesGenerator<HeuristicVisitable<S>> generator) {
        super(heuristic);
        this.generator = generator;
    }

    public LeavesGenerator<HeuristicVisitable<S>> getGenerator() {
        return this.generator;
    }
}
