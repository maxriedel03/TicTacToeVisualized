import java.awt.*;

public class TicTacToeButton {
    private final int height;
    private final int width;

    private final int posX;
    private final int posY;
    private final int graphicsOffset = 20;


    private int currentPlayer = 0; // 0 = None; 1 = Player1 --> X; 2 = Player2 --> O

    public TicTacToeButton(int height, int width, int posX, int posY) {
        this.height = height;
        this.width = width;
        this.posX = posX;
        this.posY = posY;
    }

    public TicTacToeButton(int posX, int posY) {
        this(50, 50, posX, posY);
    }

    public  TicTacToeButton(){
        this(50, 50, 0, 0);
    }

    public void paintTicTacToeButton(Graphics g){

            g.setColor(Color.BLACK);
            g.drawRect(posX, posY, width, height);
            paintSymbol(g);


    }
    private void paintSymbol(Graphics g){
        switch (currentPlayer) {
            case 1 -> drawX(g);
            case 2 -> drawCircle(g);
            default -> {
            }
        }
    }

    private void drawCircle(Graphics g) {
        g.drawArc(posX  +graphicsOffset, posY + graphicsOffset,
                width - 2 * graphicsOffset, height - 2 * graphicsOffset,
                90, 360);

    }

    private void drawX(Graphics g) {
        g.drawLine(posX + graphicsOffset, posY + graphicsOffset,
                posX + width - graphicsOffset, posY + height - graphicsOffset);
        g.drawLine(posX + width - graphicsOffset, posY + graphicsOffset ,
                posX + graphicsOffset, posY + height - graphicsOffset);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        if(currentPlayer <= 2 && currentPlayer >= 0)
            this.currentPlayer = currentPlayer;
    }
    public boolean isClicked(int x, int y, int playerToMove) {
        boolean isClicked = false;
        if (x >= this.posX && x < this.posX + width && y >= this.posY
                && y < this.posY + height) {
            isClicked = true;
            setCurrentPlayer(playerToMove);
        }
        return isClicked;
    }


}
