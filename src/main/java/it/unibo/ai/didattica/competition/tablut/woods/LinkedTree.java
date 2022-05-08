package it.unibo.ai.didattica.competition.tablut.woods;

public class LinkedTree<T> extends AbstractTree<T, LinkedTreeNode<T>> {

    public LinkedTree(LinkedTreeNode<T> root) {
        super(root);
    }

    public static <T> LinkedTree<T> newTree() {
        return new LinkedTree<T>(new LinkedTreeNode<>());
    }

    public static <T> LinkedTree<T> newTree(T rootDroplet) {
        return new LinkedTree<T>(new LinkedTreeNode<>(rootDroplet));
    }

}
