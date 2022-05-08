package it.unibo.ai.didattica.competition.tablut.intelligence.search;

import it.unibo.ai.didattica.competition.tablut.intelligence.heuristic.HeuristicFunction;
import it.unibo.ai.didattica.competition.tablut.intelligence.heuristic.HeuristicVisitable;
import it.unibo.ai.didattica.competition.tablut.woods.*;

import java.util.Iterator;

/**
 * Implements the {@link TreeSearch} interface to provide a search using the
 * <b>minimax</b> algorithm as its complete form, searching looking all the way
 * to the bottom of the tree. This class is called <i>static</i> meaning
 * that the tree must be populated before passing it to search function
 * @param <S> the type of the droplets of the leaves of the tree
 */
public class StaticMinimaxHeuristicTreeSearch<S>
    extends AbstractHeuristicTreeSearch<S>
{
    public StaticMinimaxHeuristicTreeSearch(HeuristicFunction<S> heuristic) {
        super(heuristic);
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
