import java.util.ArrayList;

public class Game {
    protected ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);

    }

    public int round(String name1, String name2) {
        Player player1 = null;
        Player player2 = null;
        for (Player player : players) {
            if (player.getName().equals(name1)) {
                player1 = player;
            } else if (player.getName().equals(name2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException("Пользователь " + name1 + " не найден");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Пользователь " + name2 + " не найден");
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }

}
