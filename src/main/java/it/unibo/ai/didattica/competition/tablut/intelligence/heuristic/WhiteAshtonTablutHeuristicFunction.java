package it.unibo.ai.didattica.competition.tablut.intelligence.heuristic;

import it.unibo.ai.didattica.competition.tablut.domain.State;
import it.unibo.ai.didattica.competition.tablut.intelligence.ReachableState;

public class WhiteAshtonTablutHeuristicFunction implements HeuristicFunction<ReachableState> {

    private int totWhitePawns;
    private int totBlackPawns;
    private int boardRows;
    private int boardCols;

    private State.Pawn[][] board;
    private State state;
    private int row;
    private int col;

    private int blackPawnsOn;
    private int capturedBlackPawns;
    private int whitePawnsOn;
    private int capturedWhitePawns;
    private Coordinate kingPos;

    public WhiteAshtonTablutHeuristicFunction(int totWhitePawns, int totBlackPawns,
                                              int boardRows, int boardCols) {
        this.totWhitePawns = totWhitePawns;
        this.totBlackPawns = totBlackPawns;
        this.boardRows = boardRows;
        this.boardCols = boardCols;
    }

    public WhiteAshtonTablutHeuristicFunction() {
        this(AshtonTablutHeuristic.TOT_WHITE_PAWNS,
                AshtonTablutHeuristic.TOT_BLACK_PAWNS,
                AshtonTablutHeuristic.BOARD_ROWS,
                AshtonTablutHeuristic.BOARD_COLS);
    }

    @Override
    public int apply(ReachableState reachableState) {
        state = reachableState.getState().clone();
        switch (state.getTurn()) {
            case DRAW:
                return 0;
            case WHITEWIN:
                return WIN_VALUE;
            case BLACKWIN:
                return LOSE_VALUE;
        }

        /* COUNT PAWNS ON THE BOARD ******************************************* */
        whitePawnsOn = 0; blackPawnsOn = 0;
        for(row = 0; row < boardRows; row++) {
            for(col = 0; col < boardCols; col++) {
                switch (board[row][col]) {
                    case WHITE:
                    {
                        whitePawnsOn++;
                        break;
                    }
                    case BLACK:
                    {
                        blackPawnsOn++;
                        break;
                    }
                    case KING:{
                        kingPos.row = row;
                        kingPos.col = col;
                    }
                }
            }
        }

        capturedBlackPawns = totBlackPawns - blackPawnsOn;
        capturedWhitePawns = totWhitePawns - whitePawnsOn;

        return 0;
    }
}
