package Scenarios.TicTacToe.dao;

import Scenarios.TicTacToe.enums.SymbolType;

public class Player {
    private String PlayerId;
    private SymbolType PlayerSymbol;

    public Player(String playerId, SymbolType playerSymbol) {
        this.PlayerId = playerId;
        this.PlayerSymbol = playerSymbol;
    }

    public SymbolType getPlayerSymbol() {
        return PlayerSymbol;
    }

    public String getPlayerId() {
        return PlayerId;
    }

    public void setPlayerId(String playerId) {
        this.PlayerId = playerId;
    }

    public void setPlayerSymbol(SymbolType playerSymbol) {
        this.PlayerSymbol = playerSymbol;
    }

}
