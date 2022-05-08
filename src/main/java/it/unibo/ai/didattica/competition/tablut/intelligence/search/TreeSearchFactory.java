package it.unibo.ai.didattica.competition.tablut.intelligence.search;

import it.unibo.ai.didattica.competition.tablut.intelligence.heuristic.HeuristicFunction;
import it.unibo.ai.didattica.competition.tablut.intelligence.heuristic.HeuristicVisitable;
import it.unibo.ai.didattica.competition.tablut.woods.LeavesGenerator;

public interface TreeSearchFactory {

    public static String DEEPEN_ALPHA_BETA_AG = "DEEPEN_ALPHA_BETA_AG";

    /**
     * Creates an {@link AbstractHeuristicTreeSearch} instance from a string
     * that represents the desired type
     * @param searchType the subtype of the {@link AbstractHeuristicTreeSearch}
     * @param params the required objects for the constructor
     * @return the instance of {@link AbstractHeuristicTreeSearch}
     * @throws IllegalArgumentException if the subtype is not valid or not supported or
     * if the <tt>params</tt> passed as argument are not valid for the required type
     */
    @SuppressWarnings("unchecked")
    public static <S> AbstractHeuristicTreeSearch<S> create(
            String searchType, Class<S> typeClass, Object...params) {
        try{
            switch (searchType) {
                case DEEPEN_ALPHA_BETA_AG: {
                    HeuristicFunction<S> heuristic = (HeuristicFunction<S>) params[0];
                    LeavesGenerator<HeuristicVisitable<S>> generator =
                            (LeavesGenerator<HeuristicVisitable<S>>) params[1];
                    if(params.length >= 3) {
                        return new DeepenAlphaBetaHeurAGTreeSearch<S>(heuristic, generator, (int) params[2]);
                    } else
                        return new DeepenAlphaBetaHeurAGTreeSearch<S>(heuristic, generator);
                }
                default:
                    throw new IllegalArgumentException("Unsupported search type \'" + searchType + "\'");
            }
        } catch (ClassCastException cce) {
            throw new IllegalArgumentException("Invalid params", cce);
        } catch (IndexOutOfBoundsException ioobe) {
            throw new IllegalArgumentException("Invalid param number for type \'" + searchType + "\'");
        }
    }

}
