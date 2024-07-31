package Scenarios.TicTacToe;

import java.util.*;

import Scenarios.TicTacToe.dao.Player;
import Scenarios.TicTacToe.dao.Symbol;
import Scenarios.TicTacToe.enums.SymbolType;
import Scenarios.TicTacToe.utility.Utilities;

public class Game {

    Deque<Player> turn;
    Player winner;

    public Game(int boardSize) {
        Utilities.BOARD_SIZE = boardSize;
        Utilities.board = new Symbol[Utilities.BOARD_SIZE][Utilities.BOARD_SIZE];

        for (int i = 0; i < Utilities.BOARD_SIZE; i++)
            for (int j = 0; j < Utilities.BOARD_SIZE; j++)
                Utilities.board[i][j] = new Symbol(null);

        Player user1 = new Player("user1", SymbolType.O);
        Player user2 = new Player("user2", SymbolType.X);

        System.out.println("User1 symbol : " + user1.getPlayerSymbol());
        System.out.println("User2 symbol : " + user2.getPlayerSymbol());

        turn = new ArrayDeque<>();
        turn.addLast(user1);
        turn.addLast(user2);

        winner = null;
    }

    public void start() {
        int n = Utilities.BOARD_SIZE;

        boolean gameOver = false;
        while (!gameOver) {

            Player currentPlayer = turn.peekFirst();
            turn.removeFirst();

            System.out.println(currentPlayer.getPlayerId() + " turn - ");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the row number - ");
            int row = scanner.nextInt();
            while (row < 0 || row > n - 1) {
                System.out.println("Invalid row number. Please enter a number between 0 and " + (n - 1) + ".");
                row = scanner.nextInt();
            }
            System.out.println("Enter the column number - ");
            int col = scanner.nextInt();
            while (col < 0 || col > n - 1) {
                System.out.println("Invalid column number. Please enter a number between 0 and " + (n - 1) + ".");
                col = scanner.nextInt();
            }

            if (Utilities.board[row][col].symbolType != null) {
                System.out.println("Slot is already occupied. Please choose another slot.");
                turn.addFirst(currentPlayer);
                continue;
            }

            Utilities.board[row][col].symbolType = currentPlayer.getPlayerSymbol();

            if (isMatchTie())
                gameOver = true;

            if (isWinnerFound()) {
                gameOver = true;
                winner = currentPlayer;
            }

            printBoardStatus();

            turn.addLast(currentPlayer);
        }

        if (isMatchTie())
            System.out.println("Match Tie!");
        else
            System.out.println("Player " + winner.getPlayerId() + " wins!");
    }

    private void printBoardStatus() {
        int n = Utilities.BOARD_SIZE;
        System.out.println("Current Board Status:");

        for (int i = 0; i < n; i++) {
            System.out.print(" | ");
            for (int j = 0; j < n; j++) {
                SymbolType symbolType = Utilities.board[i][j].symbolType;
                System.out.print((symbolType == null ? " " : symbolType) + " | ");
            }
            System.out.println("\n--------------");
        }
    }

    private boolean isMatchTie() {
        int n = Utilities.BOARD_SIZE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Utilities.board[i][j].symbolType == null)
                    return false;
            }
        }

        return true;
    }

    private boolean isWinnerFound() {
        int n = Utilities.BOARD_SIZE;

        // Column wise check
        for (int i = 0; i < n; i++) {
            SymbolType symbol = Utilities.board[0][i].symbolType;
            if (symbol == null)
                continue;
            boolean areAllSame = true;
            for (int j = 1; j < n; j++) {
                if (Utilities.board[j][i].symbolType == null) {
                    areAllSame = false;
                    break;
                }
                if (Utilities.board[j][i].symbolType != symbol)
                    areAllSame = false;
            }
            if (areAllSame)
                return true;
        }

        // Row wise check
        for (int i = 0; i < n; i++) {
            SymbolType symbol = Utilities.board[i][0].symbolType;
            if (symbol == null)
                continue;
            boolean areAllSame = true;
            for (int j = 1; j < n; j++) {
                if (Utilities.board[i][j].symbolType == null) {
                    areAllSame = false;
                    break;
                }
                if (Utilities.board[i][j].symbolType != symbol)
                    areAllSame = false;
            }
            if (areAllSame)
                return true;
        }

        // Diagonal check
        SymbolType symbol = Utilities.board[0][0].symbolType;
        boolean areAllSame = true;
        if (symbol != null) {
            for (int i = 1; i < n; i++) {
                if (Utilities.board[i][i].symbolType == null) {
                    areAllSame = false;
                    break;
                }
                if (Utilities.board[i][i].symbolType != symbol)
                    areAllSame = false;
            }
            if (areAllSame)
                return true;
        }

        // Anti Diagonal check
        symbol = Utilities.board[0][n - 1].symbolType;
        areAllSame = true;
        if (symbol != null) {
            for (int i = 1; i < n; i++) {
                if (Utilities.board[i][n - (i + 1)].symbolType == null) {
                    areAllSame = false;
                    break;
                }
                if (Utilities.board[i][n - (i + 1)].symbolType != symbol)
                    areAllSame = false;
            }
            if (areAllSame)
                return true;
        }

        return false;
    }

}
