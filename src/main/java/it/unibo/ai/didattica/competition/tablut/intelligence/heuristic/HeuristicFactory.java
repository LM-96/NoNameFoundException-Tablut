package it.unibo.ai.didattica.competition.tablut.intelligence.heuristic;

import javax.annotation.Nonnull;

public interface HeuristicFactory {

    public static <S> HeuristicFunction<S> create(@Nonnull String heuristicType, Class<S> type) {
        switch (heuristicType) {
            default:
                throw new IllegalArgumentException("Unsupported heuristic type \'" + heuristicType + "\'");
        }
    }

}
