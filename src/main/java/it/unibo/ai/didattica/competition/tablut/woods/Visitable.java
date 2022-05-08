package it.unibo.ai.didattica.competition.tablut.woods;

import java.util.function.Function;

/**
 * Represent an object that can be <i>visited</i>.
 * A visit to a <tt>Visitable</tt> object produces a result
 * that is stored and can be retrieved
 * @param <T> the type of the object
 * @param <R> the type of the expected visit result
 */
public interface Visitable<T, R> {

    /**
     * Returns the object that can be visited
     * @return the object that can be visited
     */
    public T getObject();

    /**
     * Sets the object that can be visited and delete
     * any already present visit result
     * @param object the object that can be visited and delete
     */
    public void setObject(T object);

    /**
     * Returns the result of the last visit or <tt>null</tt>
     * if the object has never been visited
     * @return
     */
    public R getVisitResult();

    /**
     * Visits the object by simply putting the result then
     * return this result
     * @param result the result of the visit
     * @return the result of the visit
     */
    public R setVisitResult(R result);

    /**
     * Visits this object and returns the result of the visit
     * @param visitor the visitor that takes the object and
     *                produces the result
     * @return the result of the visit
     */
    public R visit(Function<T, R> visitor);

    /**
     * Returns <tt>true</tt> if the object has been visited
     * at least once, <tt>false</tt> otherwise
     * @return <tt>true</tt> if the object has been visited
     *      * at least once, <tt>false</tt> otherwise
     */
    public boolean isVisited();

    /**
     * Returns <tt>true</tt> if the object is never been
     * visited, <tt>false</tt> otherwhise
     * @return <tt>true</tt> if the object is never been
     *      * visited, <tt>false</tt> otherwhise
     */
    public boolean isNotYetVisited();

}
