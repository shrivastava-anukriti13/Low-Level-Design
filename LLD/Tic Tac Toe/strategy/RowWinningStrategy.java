package strategy;

import entities.Board;
import entities.Player;

public class RowWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Player player) {
        for(int i=0; i<board.getSize(); i++){
            boolean rowWin = true;
            for(int j=0; j<board.getSize(); j++){
                if(board.getCell(i, j).getSymbol() != player.getSymbol()){
                    rowWin = false;
                    break;
                }
            }
            if(rowWin){
                return true;
            }
        }
        return false;
    }
}