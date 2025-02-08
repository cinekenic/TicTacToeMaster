package com.kodilla.tictactoemaster.tic_tac_toe;

import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.print("Podaj swoje imię: ");
//        String name = scanner.nextLine();
//        System.out.println("Witaj, " + name + "!");


        Board board = new Board();
        board.printBoard();



    }
}
