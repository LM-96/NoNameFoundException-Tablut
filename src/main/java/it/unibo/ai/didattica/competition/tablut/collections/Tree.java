package it.unibo.ai.didattica.competition.tablut.collections;

import java.util.Objects;

public class Tree<T> {

    private TreeNode<T> root;

    public Tree(TreeNode<T> root) {
        this.root = root;
    }

    public Tree() {
        this(new TreeNode<>());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree<?> tree = (Tree<?>) o;
        return Objects.equals(root, tree.root);
    }

    @Override
    public int hashCode() {
        return Objects.hash(root);
    }
}
