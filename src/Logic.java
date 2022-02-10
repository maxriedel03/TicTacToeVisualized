import java.util.Arrays;
import java.util.Scanner;

public class Logic {

    public static boolean checkForWin(TicTacToeButton[][] field){
        boolean won = false;
            for(int j = 0; j < 3; j++){
                if (field[j][0].getCurrentPlayer() == field[j][1].getCurrentPlayer()
                        && field[j][2].getCurrentPlayer() == field[j][0].getCurrentPlayer()
                        && field[j][1].getCurrentPlayer() != 0)
                won = true;
        }
        for (int i = 0;!won && i < 3; i++){
            if(field[0][i].getCurrentPlayer() == field[1][i].getCurrentPlayer()
                    && field[0][i].getCurrentPlayer() == field[2][i].getCurrentPlayer()
                    && field[0][i].getCurrentPlayer() != 0 && field[0][i].getCurrentPlayer() != 0)
                won = true;
        }
        if(!won){
            if(((field[0][0].getCurrentPlayer() == field[1][1].getCurrentPlayer()
                    && field[0][0].getCurrentPlayer() == field[2][2].getCurrentPlayer()) ||
                    (field[0][2].getCurrentPlayer() == field[1][1].getCurrentPlayer()
                            && field[0][2].getCurrentPlayer() == field[2][0].getCurrentPlayer()))
                    && field[1][1].getCurrentPlayer() != 0)
                won = true;
        }
        return won;
    }

    public static void kiTurn(int[][] field){
        int[] bestTurn;
        bestTurn = TicTacToeKI.calculateNextTurn(field);
        field[bestTurn[0]][bestTurn[1]] = 2;
    }

}
