package it.unibo.ai.didattica.competition.tablut.intelligence.search;

import it.unibo.ai.didattica.competition.tablut.intelligence.heuristic.HeuristicFunction;
import it.unibo.ai.didattica.competition.tablut.intelligence.heuristic.HeuristicVisitable;
import it.unibo.ai.didattica.competition.tablut.woods.Tree;
import it.unibo.ai.didattica.competition.tablut.woods.TreeNode;

import java.util.Iterator;

/**
 * Implements the {@link TreeSearch} interface to provide a search using the
 * <b>alpha beta pruning</b> algorithm, searching looking all the way
 * to the bottom of the tree. This class is called <i>static</i> meaning
 * that the tree must be populated before passing it to search function
 * @param <S> the type of the droplets of the leaves of the tree
 */
public class StaticAlphaBetaHeuristicTreeSearch<S>
    extends AbstractHeuristicTreeSearch<S>
{
    public StaticAlphaBetaHeuristicTreeSearch(HeuristicFunction<S> heuristic) {
        super(heuristic);
    }

    @Override
    public TreeNode<HeuristicVisitable<S>> search(Tree<HeuristicVisitable<S>> tree) {
        return alphabeta(tree.getRoot());
    }

    private TreeNode<HeuristicVisitable<S>> alphabeta(TreeNode<HeuristicVisitable<S>> node) {
        int v = max(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
        TreeNode<HeuristicVisitable<S>> curr = null;
        Iterator<TreeNode<HeuristicVisitable<S>>> iterator = node.leavesIterator();
        while(iterator.hasNext()) {
            curr = iterator.next();
            if(curr.getDroplet().getVisitResult() == v) {
                return curr;
            }
        }

        return curr;
     }

    private int min(TreeNode<HeuristicVisitable<S>> node, int alpha, int beta) {
        HeuristicVisitable<S> v = node.getDroplet();
        if(node.getLeaves().isEmpty()) {
            return v.setVisitResult(heuristic.apply(v.getObject()));
        }
        v.setVisitResult(Integer.MAX_VALUE);
        Iterator<TreeNode<HeuristicVisitable<S>>> iterator = node.leavesIterator();
        while(iterator.hasNext()) {
            v.setVisitResult(Math.min(v.getVisitResult(), max(iterator.next(), alpha, beta)));
            if(v.getVisitResult() >= beta)
                return v.getVisitResult();
            else
                alpha = Math.max(alpha, v.getVisitResult());
        }
        return v.getVisitResult();
    }

    private int max(TreeNode<HeuristicVisitable<S>> node, int alpha, int beta) {
        HeuristicVisitable<S> v = node.getDroplet();
        if(node.getLeaves().isEmpty()) {
            return v.setVisitResult(heuristic.apply(v.getObject()));
        }
        v.setVisitResult(Integer.MIN_VALUE);
        Iterator<TreeNode<HeuristicVisitable<S>>> iterator = node.leavesIterator();
        while(iterator.hasNext()) {
            v.setVisitResult(Math.max(v.getVisitResult(), min(iterator.next(), alpha, beta)));
            if(v.getVisitResult() <= alpha)
                return v.getVisitResult();
            else
                beta = Math.min(beta, v.getVisitResult());
        }
        return v.getVisitResult();
    }

}
