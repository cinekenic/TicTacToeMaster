package com.kodilla.tictactoemaster.tic_tac_toe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    @Test
    void testWinOInRows(){
    Board board = new Board();
    board.makeMove(0, 0, 'O');
    board.makeMove(0, 1, 'O');
    board.makeMove(0, 2, 'O');
        assertTrue(board.checkWin('O'));
    }

    @Test
    void testWinOInColumns(){
        Board board = new Board();
        board.makeMove(0, 0, 'O');
        board.makeMove(0, 1, 'O');
        board.makeMove(0, 2, 'O');
        assertTrue(board.checkWin('O'));
    }

    @Test
    void testWinOInDiagonals(){
        Board board = new Board();
        board.makeMove(0, 0, 'O');
        board.makeMove(0, 1, 'O');
        board.makeMove(0, 2, 'O');
        assertTrue(board.checkWin('O'));
    }

    @Test
    void testWinXInRows(){
        Board board = new Board();
        board.makeMove(0, 0, 'X');
        board.makeMove(0, 1, 'X');
        board.makeMove(0, 2, 'X');
        assertTrue(board.checkWin('X'));
    }

    @Test
    void testWinXInColumns(){
        Board board = new Board();
        board.makeMove(0, 0, 'X');
        board.makeMove(0, 1, 'X');
        board.makeMove(0, 2, 'X');
        assertTrue(board.checkWin('X'));
    }

    @Test
    void testWinXInDiagonals(){
        Board board = new Board();
        board.makeMove(0, 0, 'X');
        board.makeMove(0, 1, 'X');
        board.makeMove(0, 2, 'X');
        assertTrue(board.checkWin('X'));
    }

    @Test
    void testDraw(){
        Board board = new Board();
        board.makeMove(0, 0, 'X');
        board.makeMove(0, 1, 'O');
        board.makeMove(0, 2, 'X');
        board.makeMove(1, 0, 'X');
        board.makeMove(1, 1, 'O');
        board.makeMove(1, 2, 'O');
        board.makeMove(2, 0, 'O');
        board.makeMove(2, 1, 'X');
        board.makeMove(2, 2, 'X');
        assertTrue(board.isFull());
        assertFalse(board.checkWin('X'));
        assertFalse(board.checkWin('O'));
    }

    @Test
    void testInvalidMoveThrowsException() {
        Board board = new Board();
        board.makeMove(0, 0, 'X');
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            board.makeMove(0, 0, 'O');
        });
        assertEquals("Pole jest już zajęte!", exception.getMessage());
    }
}
