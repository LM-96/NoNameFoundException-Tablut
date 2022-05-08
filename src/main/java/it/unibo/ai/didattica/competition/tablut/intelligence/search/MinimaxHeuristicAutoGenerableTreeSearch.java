package it.unibo.ai.didattica.competition.tablut.intelligence.search;

import it.unibo.ai.didattica.competition.tablut.intelligence.heuristic.HeuristicFunction;
import it.unibo.ai.didattica.competition.tablut.intelligence.heuristic.HeuristicVisitable;
import it.unibo.ai.didattica.competition.tablut.woods.LeavesGenerator;
import it.unibo.ai.didattica.competition.tablut.woods.Tree;
import it.unibo.ai.didattica.competition.tablut.woods.TreeNode;

import java.util.Iterator;

/**
 * Implements the {@link TreeSearch} interface to provide a search using the
 * <b>minimax</b> algorithm as its complete form, searching looking all the way
 * to the bottom of the tree. This class use a {@link LeavesGenerator} in order
 * to dynamically generate the leaves of the nodes
 * @param <S> the type of the droplets of the leaves of the tree
 */
public class MinimaxHeuristicAutoGenerableTreeSearch<S>
    extends AbstractHeurAGTreeSearch<S>
{

    public MinimaxHeuristicAutoGenerableTreeSearch(HeuristicFunction<S> heuristic,
                                                   LeavesGenerator<HeuristicVisitable<S>> generator) {
        super(heuristic, generator);
    }

    @Override
    public TreeNode<HeuristicVisitable<S>> search(Tree<HeuristicVisitable<S>> tree) {
        return minimax(tree.getRoot());
    }

    private TreeNode<HeuristicVisitable<S>> minimax(TreeNode<HeuristicVisitable<S>> node) {
        int max = Integer.MIN_VALUE;
        TreeNode<HeuristicVisitable<S>> res = null;
        TreeNode<HeuristicVisitable<S>> curr = null;
        Iterator<TreeNode<HeuristicVisitable<S>>> iterator = node.leavesIterator();
        while(iterator.hasNext()) {
            curr = iterator.next();
            if(min(curr) > max) {
                res = curr;
            }
        }

        return res;
     }

    private int min(TreeNode<HeuristicVisitable<S>> node) {
        HeuristicVisitable<S> v = node.getDroplet();
        /* AUTOGENERATION : */ generator.generateLeaves(node);
        if(node.getLeaves().isEmpty()) {
            return v.setVisitResult(heuristic.apply(v.getObject()));
        }
        v.setVisitResult(Integer.MAX_VALUE);
        Iterator<TreeNode<HeuristicVisitable<S>>> iterator = node.leavesIterator();
        while(iterator.hasNext()) {
            v.setVisitResult(Math.min(v.getVisitResult(), max(iterator.next())));
        }
        return v.getVisitResult();
    }

    private int max(TreeNode<HeuristicVisitable<S>> node) {
        HeuristicVisitable<S> v = node.getDroplet();
        /* AUTOGENERATION : */ generator.generateLeaves(node);
        if(node.getLeaves().isEmpty()) {
            return v.setVisitResult(heuristic.apply(v.getObject()));
        }
        v.setVisitResult(Integer.MIN_VALUE);
        Iterator<TreeNode<HeuristicVisitable<S>>> iterator = node.leavesIterator();
        while(iterator.hasNext()) {
            v.setVisitResult(Math.max(v.getVisitResult(), min(iterator.next())));
        }
        return v.getVisitResult();
    }

}
