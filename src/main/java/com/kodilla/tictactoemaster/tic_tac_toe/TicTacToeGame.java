package com.kodilla.tictactoemaster.tic_tac_toe;

import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.print("Podaj swoje imię: ");
//        String name = scanner.nextLine();
//        System.out.println("Witaj, " + name + "!");


        Board board = new Board();
        char currentPlayer = 'X';
        boolean gameOn = true;


        while (gameOn) {
        board.printBoard();
        System.out.println("Player " + currentPlayer + "'s turn");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board.makeMove(row, col, currentPlayer)) {
                if(board.checkWin(currentPlayer)) {
                    board.printBoard();
                    System.out.println("Gracz " + currentPlayer + " wygrywa!");
                    gameOn = false;
                } else if (board.isFull()) {
                    board.printBoard();
                    System.out.println("Remis");
                    gameOn = false;
                } else {
                    currentPlayer = (currentPlayer == 'X' ? 'O' : 'X');
                }
            } else {
                System.out.println("Nieprawidłowy ruch, spróbuj ponownie.");
            }
        }
        scanner.close();
    }
}
