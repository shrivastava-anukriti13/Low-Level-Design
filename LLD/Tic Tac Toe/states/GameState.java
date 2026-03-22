package states;

import entities.Game;
import entities.Player;

public interface GameState{
    void handleMove(Game game, Player player, int row, int col);
}