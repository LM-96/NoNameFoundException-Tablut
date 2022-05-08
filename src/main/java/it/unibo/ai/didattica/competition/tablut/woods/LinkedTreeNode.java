package it.unibo.ai.didattica.competition.tablut.woods;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class LinkedTreeNode<T>  extends AbstractTreeNode<T> implements TreeNode<T>{

    private List<TreeNode<T>> leaves;

    public LinkedTreeNode(T droplet) {
        super(droplet);
        this.leaves = new LinkedList<>();
    }

    public LinkedTreeNode(TreeNode<T> father, T droplet) {
        super(father, droplet);
        this.leaves = new LinkedList<>();
    }

    public LinkedTreeNode() {
        this(null, null);
    }


    @Override
    public List<TreeNode<T>> getLeaves() {
        return leaves;
    }

    @Override
    public void appendLeaf(TreeNode<T> leaf) {
        leaves.add(leaf);
        TreeNode<T> father = leaf.getFather();
        if(father != null) father.remove(leaf);
        leaf.setFather(this);
    }

    @Override
    public TreeNode<T> newLeaf() {
        TreeNode<T> leaf = newLeaf(null);
        leaves.add(leaf);
        leaf.setFather(this);
        return leaf;
    }

    @Override
    public TreeNode<T> newLeaf(T droplet) {
        TreeNode<T> leaf = new LinkedTreeNode<>(droplet);
        leaves.add(leaf);
        leaf.setFather(this);
        return leaf;
    }

    @Override
    public boolean remove(TreeNode<T> leaf) {
        boolean removed = leaves.remove(leaf);
        if(removed)
            leaf.setFather(null);
        return removed;
    }

    @Override
    public boolean orphanize() {
        boolean alreadyOrphan = (!this.hasFather());
        if(!alreadyOrphan) {
            this.getFather().remove(this);
            this.setFather(null);
        }
        return alreadyOrphan;
    }

    @Override
    public Iterator<TreeNode<T>> leavesIterator() {
        return leaves.iterator();
    }

    @Override
    public LinkedTree<T> newTree() {
        orphanize();
        return new LinkedTree<T>(this);
    }

    @Override
    public Tree<T> newSubTree() {
        return new LinkedTree<T>(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LinkedTreeNode<?> that = (LinkedTreeNode<?>) o;
        return Objects.equals(leaves, that.leaves);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), leaves);
    }
}
