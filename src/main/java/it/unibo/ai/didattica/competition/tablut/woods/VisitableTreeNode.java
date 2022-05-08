package it.unibo.ai.didattica.competition.tablut.woods;

import java.util.function.Function;

/**
 * A simple interface that represents a node that contains a {@link Visitable}
 * droplets. The interface contains some utility methods to make easier the
 * access to the {@link Visitable} object owned by the droplet
 * @param <T> the type of the object represented by the droplet
 * @param <R> the type of the result of the visit
 */
public interface VisitableTreeNode<T, R> extends TreeNode<Visitable<T, R>> {

    default T getObject() {
        return getDroplet().getObject();
    }

    default void setVisitResult(R result) {
        getDroplet().setVisitResult(result);
    }

    default R visit(Function<T, R> visitor) {
        return getDroplet().visit(visitor);
    }

    default R getVisitResult() {
        return getDroplet().getVisitResult();
    }

    default boolean isVisited() {
        return getDroplet().isVisited();
    }

    default boolean isNotYetVisited() {
        return getDroplet().isNotYetVisited();
    }
}
