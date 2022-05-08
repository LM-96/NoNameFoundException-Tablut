package it.unibo.ai.didattica.competition.tablut.woods;

import it.unibo.ai.didattica.competition.tablut.woods.TreeNode;

import java.util.List;

/**
 * Represent a component able to generate leaves using a node
 * as source putting them into it
 * @param <S> the type of the droplet of the node
 */
public interface LeavesGenerator<S> {

    /**
     * Generate al possible leaves starting from a node and add
     * them to it.
     * The generation logic is given by the implementation class.
     * @param father the starting node for the generation
     * @return the generated nodes
     */
    public List<TreeNode<S>> generateLeaves(TreeNode<S> father);

}
