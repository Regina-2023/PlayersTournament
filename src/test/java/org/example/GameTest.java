package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    // побеждает 1ый игрок
    @Test
    public void whenPlayer1Win() {
        Player Regina = new Player(1, "Регина", 320);
        Player Maria = new Player(2, "Мария", 250);
        Game game = new Game();

        game.register(Regina);
        game.register(Maria);
        int actual = game.round("Регина", "Мария");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    // побеждает 2ой игрок
    @Test
    public void whenPlayer2Win() {
        Player Regina = new Player(1, "Регина", 200);
        Player Maria = new Player(2, "Мария", 250);
        Game game = new Game();

        game.register(Regina);
        game.register(Maria);
        int actual = game.round("Регина", "Мария");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    // когда силы равны
    @Test
    public void whenStrengthEqual() {
        Player Regina = new Player(1, "Регина", 250);
        Player Maria = new Player(2, "Мария", 250);
        Game game = new Game();

        game.register(Regina);
        game.register(Maria);
        int actual = game.round("Регина", "Мария");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    // когда 1го игрока не зарегистрировали
    @Test
    public void whenPlayer1NotExist() {
        Player Regina = new Player(1, "Регина", 320);
        Player Maria = new Player(2, "Мария", 250);
        Game game = new Game();

        game.register(Regina);
        game.register(Maria);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Павел", "Мария")
        );
    }

    // когда 2го игрока не зарегистрировали
    @Test
    public void whenPlayer2NotExist() {
        Player Regina = new Player(1, "Регина", 320);
        Player Maria = new Player(2, "Мария", 250);
        Game game = new Game();

        game.register(Regina);
        game.register(Maria);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Регина", "Павел")
        );
    }

    // когда обоих игроков не зарегистрировали
    @Test
    public void whenBothPlayerNotExist() {
        Player Regina = new Player(1, "Регина", 320);
        Player Maria = new Player(2, "Мария", 250);
        Game game = new Game();

        game.register(Regina);
        game.register(Maria);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Сергей", "Павел")
        );
    }
}