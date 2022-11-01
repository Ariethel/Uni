package it.sesalab.minimaxgames.tictactoe;

import it.sesalab.minimaxgames.ai.MinimaxAI;
import it.sesalab.minimaxgames.ai.Move;

import java.util.Scanner;

public class TicTacToeGame {

    TicTacToeBoard board;
    MinimaxAI ai;
    int boardDimension;

    public TicTacToeGame(int boardDimension){
        this.boardDimension = boardDimension;
        board = TicTacToeBoard.createTicTacToeBoard(boardDimension);
        ai = new MinimaxAI();
    }

    public void handleTurn(int playerChoice){
        if(!handlePlayerMove(playerChoice)){
            System.out.println("Selected Cell is occupied !");
            return;
        }
        printBoard();
        if(board.isGameFinished()){
            System.out.println(board.getWinner() + " WON!");
            return;
        }

        System.out.println("Computer's turn:");
        handleAiMove();
        printBoard();
        if(board.isGameFinished()){
            System.out.println(board.getWinner() + " WON!");
        }
    }

    public boolean isFinished(){
        return board.isGameFinished();
    }

    private void handleAiMove() {
        Move aiMove = ai.findBestMove(board);
        aiMove.execute();
    }

    public void printBoard() {
        System.out.println(board.toString());
    }

    private boolean handlePlayerMove(int playerChoice) {
        int row = playerChoice / boardDimension;
        int col = playerChoice % boardDimension;

        if(!board.isFreeCell(row,col)){
            return false;
        }
        Move playerMove = new TicTacToeBoard.TicTacToeMove(board,row,col,TicTacToeBoard.X);
        playerMove.execute();
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("TIC TAC TOE !");
            System.out.print("Enter board dimension (greater than 2): ");
            int boardDimension = sc.nextInt();

            TicTacToeGame game = new TicTacToeGame(boardDimension);

            game.printBoard();

            while (!game.isFinished()) {
                System.out.print("Enter choice (1-"+boardDimension*boardDimension+"):");
                int playerChoice = -1;
                while (!isValidChoice(playerChoice, boardDimension)) {
                    playerChoice = sc.nextInt() - 1;
                    if (!isValidChoice(playerChoice, boardDimension)) {
                        System.out.println("ENTER A VALID NUMBER BETWEEN 1 AND "+boardDimension*boardDimension+"!");
                    }
                }
                game.handleTurn(playerChoice);
            }
        } while(playAgain(sc));
    }

    private static boolean playAgain(Scanner sc) {
        System.out.print("Play again (y/n)? ");
        String playerChoice = sc.next();
        return playerChoice.equalsIgnoreCase("y");
    }

    private static boolean isValidChoice(int playerChoice, int boardDimension) {
        return playerChoice >= 0 && playerChoice < boardDimension*boardDimension;
    }
}
