package it.unibo.ai.didattica.competition.tablut.woods;

import java.util.Iterator;
import java.util.List;

/**
 * A node of a tree that can have a <b>father</b>, a <b>droplet</b>
 * and one or more <b>leaves</b>
 * @param <T> the type of the droplet owned by the node
 */
public interface TreeNode<T> {

   /**
    * Returns the <i>droplet</i> associated to this node
    * @return the <i>droplet</i> associated to this node
    */
   public T getDroplet();

   /**
    * Sets the <i>droplet</i> associated to this node
    * @param droplet the <i>droplet</i> associated to this node
    */
   public void setDroplet(T droplet);

   /**
    * Returns the father of this node or <tt>null</tt> if this node
    * has no father
    * @return the father of this node or <tt>null</tt>
    */
   public TreeNode<T> getFather();

   /**
    * Sets the father of this node
    * @param father the father of this node
    */
   public void setFather(TreeNode<T> father);

   /**
    * Returns <<tt>true</tt> if this node has a father or <<tt>false</tt>
    * if not. If this node has a father, then it can be obtained by {@link #getFather()}
    * method
    * @return <<tt>true</tt> if this node has a father or <<tt>false</tt>
    *     * if not
    */
   public boolean hasFather();

   /**
    * Returns the {@link java.util.List} reference containing all the leaves
    * of this node. Modifying this list means modifying the leaves of the node.
    * @return the {@link java.util.List} reference containing all the leaves
    *     * of this node
    */
   public List<TreeNode<T>> getLeaves();

   /**
    * Appends the passed leaf to the leaves of this node. After this call,
    * the <tt>leaf</tt> passed has parameter has this node as father
    * @param leaf the leaf to be appended
    */
   public void appendLeaf(TreeNode<T> leaf);

   /**
    * Creates and appends a new leaf to this node. The new leaf has this node
    * as father
    * @return the new created leaf
    */
   public TreeNode<T> newLeaf();

   /**
    * Creates and appends a new leaf to this node with the passed <tt>droplet</tt>.
    * The new leaf has this node as father
    * @param droplet the <tt>droplet</tt>
    * @return the new leaf
    */
   public TreeNode<T> newLeaf(T droplet);

   /**
    * Detaches the passed leaf from this node, if present.
    * After this call, if this node had the leaf, then it now has no father
    * @param leaf the leaf to be detached
    * @return <tt>true</tt> if the leaf was attached to this node,
    * <tt>false</tt> if the node does not have this list
    */
   public boolean remove(TreeNode<T> leaf);

   /**
    * Makes this node an orphan so this node will have no father.
    * After this call, the old father of this node lost it.
    * @return <tt>true</tt> if this node was not an orphan before or
    * <tt>false</tt> if was already an orphan before
    */
   public boolean orphanize();

   /**
    * Returns an iterator over the leaves appended to this node
    * @return the iterator
    */
   public Iterator<TreeNode<T>> leavesIterator();

   /**
    * Returns a new tree with this node as root.
    * If this node was previously a leaf of another tree,
    * after this call it has no father and is removed from
    * the previous father leaves
    * @return a new tree with this node as root
    */
   public Tree<T> newTree();

   /**
    * Returns a new subtree that has this node as root.
    * The node does not lose his father, so this is a
    * subtree starting from this node
    * @return a new subtree that has this node as root
    */
   public Tree<T> newSubTree();



}
