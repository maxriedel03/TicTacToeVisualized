import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

public class TicTacToe extends TicTacToeBasis{

    private TicTacToeButton[][] field = new TicTacToeButton[3][3];

    private final int PLAYER1;
    private final int PLAYER2;
    private int playerToMove;
    private final JFrame f;
    private final JLabel l;

    public TicTacToe(JFrame f, JLabel l){
        super();
        this.f = f;
        this.l = l;
        PLAYER1 = 1;
        PLAYER2 = 2;
        playerToMove = PLAYER1;
        for (int i = 0; i < field.length; i++){
            for (int j = 0; j < field.length; j++){
                field[i][j] = new TicTacToeButton(100, 100, i*100 + 5, j*100 + 5);
                //field[i][j].setCurrentPlayer(0);
            }
        }

    }

    public void updateLabel(){
        l.setText("Player to move: " + playerToMove);
    }

    public void mouseClicked(MouseEvent e){
        int x, y;
        x = e.getX();
        y = e.getY();
        System.out.println("Mouse clicked at: " + x + " " + y);
        mouseClicked(x, y);
        if(Logic.checkForWin(field)){
            JOptionPane.showMessageDialog(f,
                    "Congrats Player " + playerToMove + " won");
        }
        if(playerToMove == 1)
            playerToMove = PLAYER2;
        else
            playerToMove = PLAYER1;

        updateLabel();
    }

    private void mouseClicked(int x, int y) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if(field[i][j].getCurrentPlayer() == 0)
                    field[i][j].isClicked(x, y, playerToMove);
            }
        }
        f.repaint();
    }
    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g); // bitte nicht ändern

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j].paintTicTacToeButton(g);
            }
        }
    }


/*
    public static void chooseGameStyle(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Play against friend: 1, Play against KI: 2");
        int playStyle = sc.nextInt();
        while(playStyle != 1 && playStyle != 2){
            System.out.println("Keine Zulässige Spielvariante");
            playStyle = sc.nextInt();
        }
        if (playStyle == 1)
            playGameWithoutKI();
        else
            playGameWithKI();
    }

    public static void playGameWithKI(){
        boolean gameWon = false;
        boolean playerWon = false;
        while(!gameWon){
            Logic.playerTurn(1, field);
            Logic.outputField(field);
            gameWon = Logic.checkForWin(field);
            if(gameWon){
                playerWon = true;
                break;
            }
            Logic.kiTurn(field);
            gameWon = Logic.checkForWin(field);
        }
        if(playerWon)
            System.out.println("Congrats Player 1, you won against the KI!");
        else
            System.out.println("You will win next time!");
    }


    public static void playGameWithoutKI(){
        int playerToTurn = PLAYER1;
        boolean gameWon = false;
        while(!gameWon){
            Logic.playerTurn(playerToTurn, field);
            Logic.outputField(field);
            gameWon = Logic.checkForWin(field);
            if(!gameWon){
                if(playerToTurn == PLAYER1)
                    playerToTurn = PLAYER2;
                else
                    playerToTurn = PLAYER1;
            }
        }
        System.out.printf("Congrats Player %d you won!", playerToTurn);
    }*/
}
