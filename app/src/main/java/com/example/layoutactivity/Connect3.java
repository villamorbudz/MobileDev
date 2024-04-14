package com.example.layoutactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class Connect3 extends AppCompatActivity {


    private Button[] btns;
    private Button[] clickable;

    boolean player1Turn = true;
    int board[][] = new int[5][5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect3);

        btns = new Button[]{
                findViewById(R.id.cell00Btn),
                findViewById(R.id.cell01Btn),
                findViewById(R.id.cell02Btn),
                findViewById(R.id.cell03Btn),
                findViewById(R.id.cell04Btn),
                findViewById(R.id.cell10Btn),
                findViewById(R.id.cell11Btn),
                findViewById(R.id.cell12Btn),
                findViewById(R.id.cell13Btn),
                findViewById(R.id.cell14Btn),
                findViewById(R.id.cell20Btn),
                findViewById(R.id.cell21Btn),
                findViewById(R.id.cell22Btn),
                findViewById(R.id.cell23Btn),
                findViewById(R.id.cell24Btn),
                findViewById(R.id.cell30Btn),
                findViewById(R.id.cell31Btn),
                findViewById(R.id.cell32Btn),
                findViewById(R.id.cell33Btn),
                findViewById(R.id.cell34Btn),
                findViewById(R.id.cell40Btn),
                findViewById(R.id.cell41Btn),
                findViewById(R.id.cell42Btn),
                findViewById(R.id.cell43Btn),
                findViewById(R.id.cell44Btn),
        };

        clickable = new Button[5];
        System.arraycopy(btns, 0, clickable, 0, 5);

        for (Button button : clickable) {
            button.setOnClickListener(this::dropPiece);
        }

        findViewById(R.id.resetBtn).setOnClickListener(this::resetGame);
    }

    private void dropPiece(View view) {
        String cell = getResources().getResourceEntryName(view.getId());
        int row = cell.charAt(4) - '0';
        int col = cell.charAt(5) - '0';

        checkBottomCell(row, col);
    }

    private void checkBottomCell(int row, int col) {
        if(row < 4 && board[row][col] == 0) {
            if(board[row + 1][col] != 0) {
                setCell(row, col);
            } else {
                checkBottomCell(row + 1, col);
            }
        } else if (row == 4 && board[row][col] == 0) {
            setCell(row, col);
        }
    }


    private void setCell(int row, int col) {
        if(player1Turn) {
            board[row][col] = 1;
        } else {
            board[row][col] = 2;
        }
        TextView gameInfo = findViewById(R.id.gameInfoText);
        Button targetCell = null;
        switch(row) {
            case 0:
                switch(col) {
                    case 0:
                        targetCell = findViewById(R.id.cell00Btn);
                        break;
                    case 1:
                        targetCell = findViewById(R.id.cell01Btn);
                        break;
                    case 2:
                        targetCell = findViewById(R.id.cell02Btn);
                        break;
                    case 3:
                        targetCell = findViewById(R.id.cell03Btn);
                        break;
                    case 4:
                        targetCell = findViewById(R.id.cell04Btn);
                        break;
                }
                break;
            case 1:
                switch(col) {
                    case 0:
                        targetCell = findViewById(R.id.cell10Btn);
                        break;
                    case 1:
                        targetCell = findViewById(R.id.cell11Btn);
                        break;
                    case 2:
                        targetCell = findViewById(R.id.cell12Btn);
                        break;
                    case 3:
                        targetCell = findViewById(R.id.cell13Btn);
                        break;
                    case 4:
                        targetCell = findViewById(R.id.cell14Btn);
                        break;
                }
                break;
            case 2:
                switch(col) {
                    case 0:
                        targetCell = findViewById(R.id.cell20Btn);
                        break;
                    case 1:
                        targetCell = findViewById(R.id.cell21Btn);
                        break;
                    case 2:
                        targetCell = findViewById(R.id.cell22Btn);
                        break;
                    case 3:
                        targetCell = findViewById(R.id.cell23Btn);
                        break;
                    case 4:
                        targetCell = findViewById(R.id.cell24Btn);
                        break;
                }
                break;
            case 3:
                switch(col) {
                    case 0:
                        targetCell = findViewById(R.id.cell30Btn);
                        break;
                    case 1:
                        targetCell = findViewById(R.id.cell31Btn);
                        break;
                    case 2:
                        targetCell = findViewById(R.id.cell32Btn);
                        break;
                    case 3:
                        targetCell = findViewById(R.id.cell33Btn);
                        break;
                    case 4:
                        targetCell = findViewById(R.id.cell34Btn);
                        break;
                }
                break;
            case 4:
                switch(col) {
                    case 0:
                        targetCell = findViewById(R.id.cell40Btn);
                        break;
                    case 1:
                        targetCell = findViewById(R.id.cell41Btn);
                        break;
                    case 2:
                        targetCell = findViewById(R.id.cell42Btn);
                        break;
                    case 3:
                        targetCell = findViewById(R.id.cell43Btn);
                        break;
                    case 4:
                        targetCell = findViewById(R.id.cell44Btn);
                        break;
                }
                break;
        }
        if(player1Turn) {
            targetCell.setBackgroundColor(0xFFFF0000);
            targetCell.setText("");
            gameInfo.setTextColor(0xFFFFD800);
            gameInfo.setText("Player 2's Turn");
        } else {
            targetCell.setBackgroundColor(0xFFFFD800);
            targetCell.setText("");
            gameInfo.setTextColor(0xFFFF0000);
            gameInfo.setText("Player 1's Turn");
        }

        int gameResult = checkGameStatus();
        if(gameResult == 0) {
            player1Turn = !player1Turn;
        } else {
            for(Button c : clickable) {
                c.setClickable(false);
            }
            switch (gameResult) {
                case 1:
                    gameInfo.setTextColor(0xFFFF0000);
                    gameInfo.setText("PLAYER 1 WINS!");
                    break;
                case 2:
                    gameInfo.setTextColor(0xFFFFD800);
                    gameInfo.setText("PLAYER 2 WINS!");
                    break;
            }
        }
    }

    private void resetGame(View view) {
        for(int[] cell : board) {
            Arrays.fill(cell, 0);
        }

        for(Button btn: btns) {
            btn.setBackgroundColor(0xFFFFFFFF);
        }

        for(Button c : clickable) {
            c.setClickable(true);
        }

        player1Turn = true;
        TextView gameInfo = findViewById(R.id.gameInfoText);
        gameInfo.setText("Player 1's Turn");
    }

    private int checkGameStatus() {
        for (int i = 0; i <= 5 - 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] != 0 && board[i][j] == board[i + 1][j] && board[i][j] == board[i + 2][j]) {
                    return board[i][j];
                }
                if (board[j][i] != 0 && board[j][i] == board[j][i + 1] && board[j][i] == board[j][i + 2]) {
                    return board[j][i];
                }
            }
        }

        for (int i = 0; i <= 5 - 3; i++) {
            for (int j = 0; j <= 5 - 3; j++) {
                if (board[i][j] != 0 && board[i][j] == board[i + 1][j + 1] && board[i][j] == board[i + 2][j + 2]) {
                    return board[i][j];
                }
            }
        }

        for (int i = 0; i <= 5 - 3; i++) {
            for (int j = 2; j < 5; j++) {
                if (board[i][j] != 0 && board[i][j] == board[i + 1][j - 1] && board[i][j] == board[i + 2][j - 2]) {
                    return board[i][j];
                }
            }
        }
        return 0;
    }


}