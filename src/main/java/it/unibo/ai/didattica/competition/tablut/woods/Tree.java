package it.unibo.ai.didattica.competition.tablut.woods;

/**
 * General representation of a tree.
 * All leaves of the tree has a <b>droplet</b> that is an owned object that
 * can be retrieved while accessing a node
 * @param <T> the type of the <tt>droplet</tt> of all leaves of the tree
 */
public interface Tree<T> {

    /**
     * Returns the root of this three
     * @return the root node of this three
     */
    public TreeNode<T> getRoot();

    /**
     * Sets the root of this three
     * @param root the new root node of this three
     */
    public void setRoot(TreeNode<T> root);
}
