package Scenarios.TicTacToe;

import java.util.*;

import Scenarios.TicTacToe.dao.Player;
import Scenarios.TicTacToe.dao.Symbol;
import Scenarios.TicTacToe.enums.SymbolType;
import Scenarios.TicTacToe.utility.Utilities;

public class Game {

    Deque<Player> turn;

    public Game(int boardSize, boolean wantCross, boolean wantFirstMove) {
        Utilities.BOARD_SIZE = boardSize;

        for (int i = 0; i < Utilities.BOARD_SIZE; i++)
            for (int j = 0; j < Utilities.BOARD_SIZE; j++)
                Utilities.board[i][j] = new Symbol(null);

        Player user = new Player("001", SymbolType.O);
        Player system = new Player("002", SymbolType.X);
        if (wantCross) {
            user.setPlayerSymbol(SymbolType.X);
            system.setPlayerSymbol(SymbolType.O);
        }

        turn = new ArrayDeque<>();
        turn.add(system);
        if (wantFirstMove)
            turn.addFirst(user);
        else
            turn.addLast(user);
    }

    public void start() {

        boolean gameOver = false;

        while (gameOver) {

        }

    }

    public boolean isWinnerFound() {
        int n = Utilities.BOARD_SIZE;

        for (int i = 0; i < n; i++) {
            SymbolType symbol = Utilities.board[0][i].symbolType;
            if (symbol == null)
                continue;
            for (int j = 1; j < n; j++) {
                if (Utilities.board[0][i].symbolType == null)
                    break;
            }
        }

        return false;
    }

}
