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
            }
        }
    }

    public void updateLabel(){
        l.setText("Player to move: " + playerToMove);
    }

    public void mouseClicked(MouseEvent e){
        int x, y;
        boolean won;
        x = e.getX();
        y = e.getY();
        System.out.println("Mouse clicked at: " + x + " " + y);
        mouseClicked(x, y);
        won = Logic.checkForWin(field);
        if(won){
            JOptionPane.showMessageDialog(f,
                    "Congrats Player " + playerToMove + " won");
            restartGame();
        }else{
            if(playerToMove == 1)
                playerToMove = PLAYER2;
            else
                playerToMove = PLAYER1;

            updateLabel();
        }
    }

    private void restartGame(){
        field = new TicTacToeButton[3][3];
        for (int i = 0; i < field.length; i++){
            for (int j = 0; j < field.length; j++){
                field[i][j] = new TicTacToeButton(100, 100, i*100 + 5, j*100 + 5);
            }
        }
        playerToMove = 1;
        updateLabel();
        f.repaint();
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
}
