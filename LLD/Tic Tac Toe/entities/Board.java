package entities;

import enums.Symbol;
import exceptions.InvalidMoveException;

public class Board{
    private final int size;
    private int movesCount;
    private final Cell[][] board;

    public Board(int size){
        this.size = size;
        movesCount = 0;
        board = new Cell[size][size];
        initializeBoard();
    }

    private void initializeBoard(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                board[i][j] = new Cell();
            }
        }
    }

    public boolean placeSymbol(int row, int col, Symbol symbol){
        if(row < 0 || row >= size || col < 0 || col >= size){
            throw new InvalidMoveException("Move out of bounds");
        }
        if(board[row][col].getSymbol() != Symbol.EMPTY){
            throw new InvalidMoveException("Cell already occupied");
        }
        board[row][col].setSymbol(symbol);
        movesCount++;
        return true;
    }

    public Cell getCell(int row, int col){
        if(row < 0 || row >= size || col < 0 || col >= size){
            throw new InvalidMoveException("Move out of bounds");
        }
        return board[row][col];
    }

    public boolean isFull() {
        return movesCount == size * size;
    }

     public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < size; i++) {
            System.out.print("| ");
            for (int j = 0; j < size; j++) {
                Symbol symbol = board[i][j].getSymbol();
                System.out.print(symbol.getChar() + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public int getSize() {
        return size;
    }
}