package states;

import entities.Game;
import entities.Player;
import enums.GameStatus;
import enums.Symbol;
import exceptions.InvalidMoveException;

public class InProgressState implements GameState{
    @Override
    public void handleMove(Game game, Player player, int row, int col) {
        if (player != game.getCurrentPlayer()) {
            throw new InvalidMoveException("It's not " + player.getName() + "'s turn. It's " + game.getCurrentPlayer().getName() + "'s turn.");
        }


        game.getBoard().placeSymbol(row, col, player.getSymbol());

        if (game.checkWinner(player)) {
            game.setWinner(player);
            game.setStatus(player.getSymbol() == Symbol.X ? GameStatus.WINNER_X : GameStatus.WINNER_O);
            game.setState(new WinnerState());
        } else if (game.getBoard().isFull()) {
            game.setStatus(GameStatus.DRAW);
            game.setState(new DrawState());
        } else {
            game.switchPlayer();
        }
    }
}