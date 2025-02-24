package com.kodilla.tictactoemaster.tic_tac_toe;

import java.util.Random;

class Board {
    private char[][] board;
    private int size;
    private int winCondition;

    public Board(int size, int winCondition) {
        this.size = size;
        this.winCondition = winCondition;
        board = new char[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        System.out.println("-".repeat(size * 4 + 1));
        for (int i = 0; i < size; i++) {
            System.out.print("| ");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n" + "-".repeat(size * 4 + 1));
        }
    }

    public boolean makeMove(int row, int col, char player) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            throw new IllegalArgumentException("Nieprawidłowe współrzędne!");
        }
        if (board[row][col] != ' ') {
            throw new IllegalArgumentException("Pole jest już zajęte!");
        }
        board[row][col] = player;
        return true;
    }


    public boolean checkWin(char player) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (checkDirection(i, j, 1, 0, player) ||
                        checkDirection(i, j, 0, 1, player) ||
                        checkDirection(i, j, 1, 1, player) ||
                        checkDirection(i, j, 1, -1, player)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDirection(int row, int col, int rowStep, int colStep, char player) {
        int count = 0;
        for (int i = 0; i < winCondition; i++) {
            int newRow = row + i * rowStep;
            int newCol = col + i * colStep;
            if (newRow >= 0 && newRow < size && newCol >= 0 && newCol < size && board[newRow][newCol] == player) {
                count++;
            } else {
                break;
            }
        }
        return count == winCondition;
    }


    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public int[] getRandomMove() {
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(size);
            col = random.nextInt(size);
        } while (board[row][col] != ' ');
        return new int[]{row, col};
    }
}
