package Scenarios.TicTacToe.dao;

import Scenarios.TicTacToe.enums.SymbolType;

public class Symbol {
    public SymbolType symbolType;

    public Symbol() {
        this.symbolType = null;
    }

    public Symbol(SymbolType symbolType) {
        this.symbolType = symbolType;
    }

    public void setPlayerSymbol(SymbolType symbol) {
        this.symbolType = symbol;
    }
}
