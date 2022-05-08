package it.unibo.ai.didattica.competition.tablut.intelligence.search;

import it.unibo.ai.didattica.competition.tablut.intelligence.heuristic.HeuristicFunction;
import it.unibo.ai.didattica.competition.tablut.intelligence.heuristic.HeuristicVisitable;
import it.unibo.ai.didattica.competition.tablut.woods.LeavesGenerator;
import it.unibo.ai.didattica.competition.tablut.woods.Tree;
import it.unibo.ai.didattica.competition.tablut.woods.TreeNode;

import java.util.Iterator;

/**
 * Implements the {@link TreeSearch} interface to provide a search using the
 * <b>alpha beta pruning</b> algorithm, searching looking all the way
 * to the bottom of the tree. This class is called <i>static</i> meaning
 * that the tree must be populated before passing it to search function.
 * This class is called <i>static</i> meaning that the tree must be
 * populated before passing it to search function
 * @param <S> the type of the droplets of the leaves of the tree
 */
public class DeepenAlphaBetaHeurAGTreeSearch<S>
    extends AbstractHeurAGTreeSearch<S>
{

    private int depth;

    public DeepenAlphaBetaHeurAGTreeSearch(HeuristicFunction<S> heuristic,
                                           LeavesGenerator<HeuristicVisitable<S>> generator,
                                           int depth) {
        super(heuristic, generator);
        this.depth = depth;
    }

    public DeepenAlphaBetaHeurAGTreeSearch(HeuristicFunction<S> heuristic,
                                           LeavesGenerator<HeuristicVisitable<S>> generator) {
        this(heuristic, generator, Integer.MAX_VALUE);
    }

    @Override
    public TreeNode<HeuristicVisitable<S>> search(Tree<HeuristicVisitable<S>> tree) {
        return alphabeta(tree.getRoot());
    }

    private TreeNode<HeuristicVisitable<S>> alphabeta(TreeNode<HeuristicVisitable<S>> node) {
        int v = max(node, depth, Integer.MIN_VALUE, Integer.MAX_VALUE);
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

    private int min(TreeNode<HeuristicVisitable<S>> node, int depth, int alpha, int beta) {
        HeuristicVisitable<S> v = node.getDroplet();
        /* AUTOGENERATION : */ generator.generateLeaves(node);
        if(depth <= 0 || node.getLeaves().isEmpty()) {
            return v.setVisitResult(heuristic.apply(v.getObject()));
        }
        v.setVisitResult(Integer.MAX_VALUE);
        Iterator<TreeNode<HeuristicVisitable<S>>> iterator = node.leavesIterator();
        while(iterator.hasNext()) {
            v.setVisitResult(Math.min(v.getVisitResult(), max(iterator.next(), depth - 1, alpha, beta)));
            if(v.getVisitResult() >= beta)
                return v.getVisitResult();
            else
                alpha = Math.max(alpha, v.getVisitResult());
        }
        return v.getVisitResult();
    }

    private int max(TreeNode<HeuristicVisitable<S>> node, int depth, int alpha, int beta) {
        HeuristicVisitable<S> v = node.getDroplet();
        /* AUTOGENERATION : */ generator.generateLeaves(node);
        if(depth<= 0 || node.getLeaves().isEmpty()) {
            return v.setVisitResult(heuristic.apply(v.getObject()));
        }
        v.setVisitResult(Integer.MIN_VALUE);
        Iterator<TreeNode<HeuristicVisitable<S>>> iterator = node.leavesIterator();
        while(iterator.hasNext()) {
            v.setVisitResult(Math.max(v.getVisitResult(), min(iterator.next(), depth - 1, alpha, beta)));
            if(v.getVisitResult() <= alpha)
                return v.getVisitResult();
            else
                beta = Math.min(beta, v.getVisitResult());
        }
        return v.getVisitResult();
    }

}
