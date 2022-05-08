package it.unibo.ai.didattica.competition.tablut.woods;

import java.util.Objects;

public abstract class AbstractTreeNode<T> implements TreeNode<T> {

    private TreeNode<T> father;
    private T droplet;

    public AbstractTreeNode(TreeNode<T> father, T droplet) {
        this.father = father;
        this.droplet = droplet;
    }

    public AbstractTreeNode(TreeNode<T> father) {
        this(father, null);
    }

    public AbstractTreeNode(T droplet) {
        this(null,droplet);
    }

    @Override
    public boolean hasFather() {
        return father != null;
    }

    @Override
    public TreeNode<T> getFather() {
        return father;
    }

    @Override
    public void setFather(TreeNode<T> father) {
        this.father = father;
    }

    @Override
    public T getDroplet() {
        return droplet;
    }

    @Override
    public void setDroplet(T droplet) {
        this.droplet = droplet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractTreeNode<?> that = (AbstractTreeNode<?>) o;
        return Objects.equals(father, that.father) && Objects.equals(droplet, that.droplet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(father, droplet);
    }
}
