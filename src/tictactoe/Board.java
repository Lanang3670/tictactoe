package tictactoe;

import java.util.Arrays;

// PW: Board mewarisi AbstractBoard
public class Board extends AbstractBoard {
    private final Player[][] board; // EN: Mengenkapsulasi data papan permainan

    public Board() {
        board = new Player[3][3]; // Inisialisasi papan kosong
    }

    @Override
    public boolean placeMark(int row, int col, Player player) { // PO: Mengimplementasikan metode abstrak dari AbstractBoard
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != null) {
            return false; // Jika posisi tidak valid atau sudah diisi
        }
        board[row][col] = player;
        return true;
    }

    @Override
    public boolean checkWin(Player player) { // PO: Mengimplementasikan metode abstrak dari AbstractBoard
        // Cek baris, kolom, dan diagonal
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || // Baris
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) { // Kolom
                return true;
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) || // Diagonal utama
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);   // Diagonal sekunder
    }

    @Override
    public boolean isFull() { // PO: Mengimplementasikan metode abstrak dari AbstractBoard
        return Arrays.stream(board).flatMap(Arrays::stream).allMatch(cell -> cell != null);
    }

    @Override
    public void printBoard() { // PO: Mengimplementasikan metode abstrak dari AbstractBoard
        System.out.println("  0 1 2"); // Header kolom
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " "); // Nomor baris
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] == null ? "-" : board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
