package it.unibo.ai.didattica.competition.tablut.woods;

import java.util.function.Function;

/**
    * Represent an object that can be <i>visited</i>.
    * A visit to a <tt>Visitable</tt> object produces a result
    * that is stored and can be retrieved
    * @param <T> the type of the object
    * @param <R> the type of the expected visit result
 */
public class VisitableObject<T, R> implements Visitable<T, R>{

    private T object;
    private R visitResult;

    public VisitableObject(T object) {
        this.object = object;
    }

    @Override
    public T getObject() {
        return object;
    }

    @Override
    public void setObject(T object) {
        this.object = object;
        this.visitResult = null;
    }

    @Override
    public R getVisitResult() {
        return visitResult;
    }

    @Override
    public R setVisitResult(R result) {
        this.visitResult = result;
        return visitResult;
    }

    @Override
    public R visit(Function<T, R> visitor) {
        this.visitResult = visitor.apply(object);
        return this.visitResult;
    }

    @Override
    public boolean isVisited() {
        return visitResult != null;
    }

    @Override
    public boolean isNotYetVisited() {
        return visitResult == null;
    }
}
