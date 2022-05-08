package it.unibo.ai.didattica.competition.tablut.util;

import it.unibo.ai.didattica.competition.tablut.domain.State;
import it.unibo.ai.didattica.competition.tablut.intelligence.ReachableState;
import it.unibo.ai.didattica.competition.tablut.intelligence.heuristic.HeuristicVisitable;
import it.unibo.ai.didattica.competition.tablut.woods.LinkedTreeNode;
import it.unibo.ai.didattica.competition.tablut.woods.TreeNode;

public class StateUtil {

    public static TreeNode<HeuristicVisitable<ReachableState>> asHVRSTreeNode(State state) {
        return new LinkedTreeNode<HeuristicVisitable<ReachableState>>(
                new HeuristicVisitable<ReachableState>(new ReachableState(state)));
    }

}
