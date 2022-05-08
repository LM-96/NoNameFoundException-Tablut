package it.unibo.ai.didattica.competition.tablut.intelligence.search;

import it.unibo.ai.didattica.competition.tablut.intelligence.heuristic.HeuristicFunction;
import it.unibo.ai.didattica.competition.tablut.intelligence.heuristic.HeuristicVisitable;
import it.unibo.ai.didattica.competition.tablut.woods.LeavesGenerator;
import it.unibo.ai.didattica.competition.tablut.woods.TreeNode;

import java.util.Map;

public abstract class AbstractHeurAGTranspTreeSearch<S>
    extends AbstractHeurAGTreeSearch<S>
{

    protected Map<S, TreeNode<HeuristicVisitable<S>>> transpositionTable;

    public AbstractHeurAGTranspTreeSearch(
            HeuristicFunction heuristic,
            LeavesGenerator<HeuristicVisitable<S>> generator,
            Map<S, TreeNode<HeuristicVisitable<S>>> transpositionTable) {
        super(heuristic, generator);
    }

    public Map<S, TreeNode<HeuristicVisitable<S>>> getTranspositionTable() {
        return transpositionTable;
    }

    public void setTranspositionTable(Map<S, TreeNode<HeuristicVisitable<S>>> transpositionTable) {
        this.transpositionTable = transpositionTable;
    }
}
