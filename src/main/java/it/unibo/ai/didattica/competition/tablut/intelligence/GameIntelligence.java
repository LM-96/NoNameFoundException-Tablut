package it.unibo.ai.didattica.competition.tablut.intelligence;

import it.unibo.ai.didattica.competition.tablut.domain.Action;
import it.unibo.ai.didattica.competition.tablut.domain.State;
import it.unibo.ai.didattica.competition.tablut.intelligence.heuristic.HeuristicVisitable;
import it.unibo.ai.didattica.competition.tablut.intelligence.search.TreeSearch;

/**
 * The intelligence of the game that use a certain search algorithm
 */
public interface GameIntelligence {

    /**
     * The main method of the intelligence that ask it to think about the
     * next move to choose.
     * It returns an action that the intelligence suggest looking on
     * the current state.
     * This method could suspend the caller until the intelligence ends to
     * think
     * @return the action that the intelligence thought it was right
     */
    public Action think();

    /**
     * Clears the intelligence and make it able to start a new game
     * @param initial the initial state
     */
    public void init(State initial);

    /**
     * Changes the mind of the intelligence changing its search algorithm on
     * the tree of states
     * @param searchAlgorithm the new search algorithm
     */
    public void changeSearchAlgorithm(TreeSearch<HeuristicVisitable<ReachableState>> searchAlgorithm);

    /**
     * Tells to the intelligence the new state of the game
     * @param currentState the current state of the game
     */
    public void updateState(State currentState);
}
