package tictactoe;

// AB: Definisi abstract class untuk mendefinisikan kerangka papan permainan
public abstract class AbstractBoard {
    public abstract boolean placeMark(int row, int col, Player player); // AB: Metode abstrak
    public abstract boolean checkWin(Player player); // AB: Metode abstrak
    public abstract boolean isFull(); // AB: Metode abstrak
    public abstract void printBoard(); // AB: Metode abstrak
}
