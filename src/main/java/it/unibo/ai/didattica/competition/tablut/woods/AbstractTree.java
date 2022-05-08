package it.unibo.ai.didattica.competition.tablut.woods;

import javax.annotation.Nonnull;

public abstract class AbstractTree<T, N extends TreeNode<T>> implements Tree<T> {

    protected N root;

    public AbstractTree(N root) {
        this.root = root;
    }

    @Override
    public N getRoot() {
        return root;
    }

    @Override
    public void setRoot(@Nonnull TreeNode<T> root) {
        if(!this.root.getClass().isInstance(root))
            throw new IllegalArgumentException("Invalid root type class [" + root.getClass().getSimpleName() +
                    "]. Expected: " + this.root.getClass().getSimpleName());
        this.root = (N) root;
    }
}