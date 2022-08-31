import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void forceComparison() {

        Player player1 = new Player(1, "Иван", 1030);
        Player player2 = new Player(2, "Евгений", 1150);
        Player player3 = new Player(3, "Олег", 2005);

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        int actual = game.round(player1.getName(), player2.getName());
        int expected = 2;
    }

    @Test
    public void firstPlayerForce() {

        Player player1 = new Player(1, "Иван", 1030);
        Player player2 = new Player(2, "Евгений", 1150);
        Player player3 = new Player(3, "Олег", 1150);

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        int actual = game.round(player2.getName(), player3.getName());
        int expected = 0;
    }

    @Test
    public void equalForce() {

        Player player1 = new Player(1, "Иван", 2000);
        Player player2 = new Player(2, "Евгений", 1150);
        Player player3 = new Player(3, "Олег", 1150);

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        int actual = game.round(player1.getName(), player2.getName());
        int expected = 1;
    }

    @Test
    public void unregistered() {

        Player player1 = new Player(1, "Иван", 2000);
        Player player2 = new Player(2, "Евгений", 1150);
        Player player3 = new Player(3, "Олег", 1150);

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), "Александр");
        });
    }
    @Test
    public void unregisteredFirstPlayer() {

        Player player1 = new Player(1, "Иван", 2000);
        Player player2 = new Player(2, "Евгений", 1150);
        Player player3 = new Player(3, "Олег", 1150);

        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Александр", player2.getName());
        });

    }

    //Для 100% покрытия тестирую set и get
    @Test
    public void testSetId() {
        Player player = new Player();
        player.setId(1);
        assertEquals(player.getId(), 1);
    }
    @Test
    public void testSetName() {
        Player player = new Player();
        player.setName("Ivan");
        assertEquals(player.getName(), "Ivan");
    }

    @Test
    public void testSetStrength() {
        Player player = new Player();
        player.setStrength(1000);
        assertEquals(player.getStrength(), 1000);
    }
}
