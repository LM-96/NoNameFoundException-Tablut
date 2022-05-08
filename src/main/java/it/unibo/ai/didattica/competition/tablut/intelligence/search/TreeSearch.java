package it.unibo.ai.didattica.competition.tablut.intelligence.search;

import it.unibo.ai.didattica.competition.tablut.woods.Tree;
import it.unibo.ai.didattica.competition.tablut.woods.TreeNode;

public interface TreeSearch<T> {

    /**
     * Search a node from a tree.
     * The logic of the search is given by the implementation class
     * @param tree the tree to be used for search
     * @return the found node of the tree
     */
    public TreeNode<T> search(Tree<T> tree);

}
