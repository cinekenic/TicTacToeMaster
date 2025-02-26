package com.kodilla.tictactoemaster.tic_tac_toe;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;

public class TicTacToeGame extends Application {
    private Board board;
    private Button[][] buttons;
    private char currentPlayer;
    private int size;
    private int winCondition;

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);

        Button btn3x3 = new Button("Graj na planszy 3x3");
        btn3x3.setOnAction(e -> initializeGame(primaryStage, 3, 3));

        Button btn10x10 = new Button("Graj na planszy 10x10");
        btn10x10.setOnAction(e -> initializeGame(primaryStage, 10, 5));

        root.getChildren().addAll(btn3x3, btn10x10);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tic Tac Toe - Wybór planszy");
        primaryStage.show();
    }

    private void initializeGame(Stage primaryStage, int boardSize, int winCond){
        this.size = boardSize;
        this.winCondition = winCond;
        board = new Board(size, winCondition);
        buttons = new Button[size][size];
        currentPlayer = 'X';

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Button button = new Button(" ");
                button.setMinSize(50, 50);
                final int row = i;
                final int col = j;
                button.setOnAction(e -> makeMove(row, col, button));
                buttons[i][j] = button;
                gridPane.add(button, j, i);
            }
        }

        Scene scene = new Scene(gridPane, size * 50, size * 50);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tic Tac Toe - Plansza " + size + "x" + size);
    }

    private void makeMove(int row, int col, Button button){
        if (board.makeMove(row, col, currentPlayer)) {
            button.setText(String.valueOf(currentPlayer));
            if (board.checkWin(currentPlayer)) {
                System.out.println("Gracz " + currentPlayer + " wygrywa!");
                disableBoard();
                return;
            } else if (board.isFull()) {
                System.out.println("Remis!");
                disableBoard();
                return;
            }
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            if(currentPlayer == 'O'){
                makeComputerMove();
            }
        }
    }

    private void makeComputerMove(){
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(size);
            col = random.nextInt(size);
        } while (buttons[row][col].getText().equals("X") || buttons[row][col].getText().equals("O"));
        makeMove(row, col, buttons[row][col]);
    }

    private void disableBoard(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttons[i][j].setDisable(true);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
