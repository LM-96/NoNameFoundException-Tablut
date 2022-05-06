package it.unibo.ai.didattica.competition.tablut.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class TreeNode<T> {

    private List<TreeNode<T>> leaves;
    private T droplet;

    public TreeNode() {
        this.leaves = new LinkedList<>();
    }

    public TreeNode(T droplet) {
        this(new LinkedList<>(), droplet);
    }

    public TreeNode(List<TreeNode<T>> leaves, T droplet) {
        this.leaves = leaves;
        this.droplet = droplet;
    }

    public List<TreeNode<T>> getLeaves() {
        return leaves;
    }

    public void setLeaves(List<TreeNode<T>> leaves) {
        this.leaves = leaves;
    }

    public T getDroplet() {
        return droplet;
    }

    public void setDroplet(T droplet) {
        this.droplet = droplet;
    }

    public boolean hasLeaves() {
        return leaves.size() > 0;
    }

    public Tree newTree() {
        return new Tree(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode<?> treeNode = (TreeNode<?>) o;
        return Objects.equals(leaves, treeNode.leaves) && Objects.equals(droplet, treeNode.droplet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leaves, droplet);
    }
}
