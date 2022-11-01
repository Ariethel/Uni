package it.sesalab.minimaxgames.tictactoe;

import it.sesalab.minimaxgames.ai.Board;
import it.sesalab.minimaxgames.ai.Move;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TicTacToeBoard implements Board {

    public static final String X = "X";
    public static final String O = "O";
    public static final String EMPTY = " ";

    private final String[][] board;

    private TicTacToeBoard(String[][] board) {
        this.board = board;
    }

    public static TicTacToeBoard createTicTacToeBoard(int boardDimension) {
        String[][] board = new String[boardDimension][boardDimension];
        for (String[] boardRow : board) {
            Arrays.fill(boardRow, EMPTY);
        }
        return new TicTacToeBoard(board);
    }

    public List<Move> generateNextMoves() {
        if(isGameFinished()){
            return Collections.emptyList();
        }

        List<Move> nextMoves = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j].equals(EMPTY)){
                    nextMoves.add(new TicTacToeMove(this,i,j,nextSeedToPlace()));
                }
            }
        }
        return nextMoves;
    }

    private String nextSeedToPlace() {
        int nOfX = 0;
        int nOfO = 0;
        for (String[] row: board) {
            for(String cell: row){
                if(cell.equals(X)){
                    nOfX++;
                }

                if (cell.equals(O)){
                    nOfO++;
                }
            }
        }
        return (nOfX - nOfO) == 1 ? O : X;
    }

    public int utility() {
        if(hasWon(O)){
            return 1;
        }

        if (hasWon(X)){
            return -1;
        }

        return 0;

    }

    public boolean hasWon(String player) {
        // Check for N-in-a-row on the rows and columns
        for(int i = 0; i < board.length; i++){
            boolean verticalWin = true, horizontalWin = true;
            for(int j = 0; j < board.length; j++){
                if(!board[i][j].equals(player)) {
                    horizontalWin = false;
                }
                if(!board[j][i].equals(player)) {
                    verticalWin = false;
                }
                if(!(horizontalWin || verticalWin)) {
                    break;
                }
            }
            if(horizontalWin || verticalWin)
                return true;
        }

        // If there was a N-in-a-row on the rows or columns
        // the method would have returned by now, so we're
        // going to check the diagonals

        // Check for N-in-a-row on both the diagonals
        boolean diagonalWinOne = true, diagonalWinTwo = true;
        for(int n = 0; n < board.length; n++){
            int row = board.length - 1 - n;
            if(!board[n][n].equals(player)) {
                diagonalWinOne = false;
            }
            if(!board[row][n].equals(player)) {
                diagonalWinTwo = false;
            }
            if(!(diagonalWinOne || diagonalWinTwo)) {
                break;
            }
        }

        // If either one of the diagonals has N-in-a-row, then there's a winner
        // Otherwise, no one has won yet
        return diagonalWinOne || diagonalWinTwo;
    }


    public boolean isTie() {
        boolean result = true;
        for (String[] row: board) {
            for (String cell: row ) {
                if(cell.equals(EMPTY)){
                    result = false;
                    break;
                }
            }
        }
        return result && !hasWon(X) && !hasWon(O);
    }

    public boolean isGameFinished(){
        return hasWon(X) || hasWon(O) || isTie();
    }

    public String getWinner() {
        if(hasWon(X)){
            return "X";
        }

        if(hasWon(O)){
            return "O";
        }

        return "NONE";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-----\n");
        for (String[] row : board) {
            sb.append("|");
            for(String cell : row){
                sb.append(cell);
                sb.append("|");
            }
            sb.append("\n");
            sb.append("-----\n");
        }
        return sb.toString();
    }

    public boolean isFreeCell(int row, int col) {
        return board[row][col].equals(EMPTY);
    }

    public static class TicTacToeMove implements Move {

        private final TicTacToeBoard currentBoard;
        private final int row;
        private final int col;
        private final String seedToPlace;

        public TicTacToeMove(TicTacToeBoard currentBoard, int row, int col, String seedToPlace) {
            this.currentBoard = currentBoard;
            this.row = row;
            this.col = col;
            this.seedToPlace = seedToPlace;
        }

        public void execute() {
            currentBoard.board[row][col] = seedToPlace;
        }

        public void undo() {
            currentBoard.board[row][col] = EMPTY;
        }

        @Override
        public String toString() {
            return "Place "+ seedToPlace +" in ("+row+","+col+")";
        }
    }
}
