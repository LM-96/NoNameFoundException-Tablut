package it.unibo.ai.didattica.competition.tablut.intelligence;

import it.unibo.ai.didattica.competition.tablut.domain.Action;
import it.unibo.ai.didattica.competition.tablut.domain.State;
import it.unibo.ai.didattica.competition.tablut.intelligence.heuristic.HeuristicVisitable;
import it.unibo.ai.didattica.competition.tablut.intelligence.search.TreeSearch;
import it.unibo.ai.didattica.competition.tablut.util.StateUtil;
import it.unibo.ai.didattica.competition.tablut.woods.LeavesGenerator;
import it.unibo.ai.didattica.competition.tablut.woods.Tree;
import it.unibo.ai.didattica.competition.tablut.woods.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class TransposedGameIntelligence implements GameIntelligence {

    private Tree<HeuristicVisitable<ReachableState>> stateTree;
    private TreeSearch<HeuristicVisitable<ReachableState>> searchAlgorithm;

    private TreeNode<HeuristicVisitable<ReachableState>> currentState;
    private Map<String, TreeNode<HeuristicVisitable<ReachableState>>> transpositionTable;

    public TransposedGameIntelligence(
            TreeSearch<HeuristicVisitable<ReachableState>> searchAlgorithm) {
        this.searchAlgorithm = searchAlgorithm;
        this.transpositionTable = new HashMap<>();
    }

    @Override
    public Action think() {
        return searchAlgorithm.search(stateTree)
                .getDroplet().getObject().getCauseAction();
    }

    @Override
    public void init(State initial) {
        currentState = StateUtil.asHVRSTreeNode(initial);
        transpositionTable.clear();
        stateTree = currentState.newTree();
    }

    @Override
    public void changeSearchAlgorithm(TreeSearch<HeuristicVisitable<ReachableState>> searchAlgorithm) {
        this.searchAlgorithm = searchAlgorithm;
    }

    @Override
    public void updateState(State currentState) {
        this.currentState = transpositionTable.get(currentState);
        if(this.currentState == null)
            this.currentState = StateUtil.asHVRSTreeNode(currentState);

        stateTree = this.currentState.newTree();
    }

}
