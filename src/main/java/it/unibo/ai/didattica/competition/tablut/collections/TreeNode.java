package it.unibo.ai.didattica.competition.tablut.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class TreeNode<T> {

    public final List<TreeNode<T>> childred = new LinkedList<>();
    public T obj;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode<?> treeNode = (TreeNode<?>) o;
        return Objects.equals(childred, treeNode.childred) && Objects.equals(obj, treeNode.obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(childred, obj);
    }
}
