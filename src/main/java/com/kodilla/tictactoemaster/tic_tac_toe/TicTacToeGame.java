package com.kodilla.tictactoemaster.tic_tac_toe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz tryb gry: (1) 3x3 (2) 10x10 do pięciu");

//        System.out.print("Podaj swoje imię: ");
//        String name = scanner.nextLine();
//        System.out.println("Witaj, " + name + "!");

        int choice = scanner.nextInt();
        int size = (choice == 1) ? 3 : 10;
        int winCondition = (choice == 1) ? 3 : 5;

        Board board = new Board(size, winCondition);
        char currentPlayer = 'X';
        boolean gameOn = true;


        while (gameOn) {
        board.printBoard();
//        System.out.println("Player " + currentPlayer + "'s turn");
//            int row = scanner.nextInt();
//            int col = scanner.nextInt();
            int row = -1, col = -1;
            boolean validInput = false;

            if (currentPlayer == 'X') {
                while (!validInput) {
                    try {
                        System.out.println("Gracz X, podaj wiersz i kolumnę (0-" + (size - 1) + "):");
                        row = scanner.nextInt();
                        col = scanner.nextInt();
                        validInput = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Nieprawidłowe dane, podaj dwie liczby.");
                        scanner.nextLine();
                    }
                }
            }else {
                System.out.println("Komputer wykonuje ruch...");
                int[] move = board.getRandomMove();
                row = move[0];
                col = move[1];
            }

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
