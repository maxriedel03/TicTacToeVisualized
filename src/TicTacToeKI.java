public class TicTacToeKI{

    public static final int[][] MISSING_ONE_HORIZONTAL = {{1,0,1},{1,1,0},{0,1,1}};

    public static int[] calculateNextTurn(int[][] field){
        return checkForEasyWin(field);
    }

    private static int[] checkForEasyWin(int[][] field){
        int[] fieldForEasyWin = new int[2];
        return fieldForEasyWin;
    }
}
