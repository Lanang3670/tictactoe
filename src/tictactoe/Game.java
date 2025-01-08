package tictactoe;

import java.util.Scanner;

public class Game { // Class utama untuk mengatur alur permainan
    private final AbstractBoard board; // PW: Board mewarisi AbstractBoard dan disimpan sebagai referensi tipe abstrak
    private Player currentPlayer;

    public Game() {
        board = new Board(); // PO: Menggunakan objek Board (yang merupakan implementasi konkret dari AbstractBoard)
        currentPlayer = Player.O; // Pemain O mulai duluan
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("     /// Selamat datang di Tic-Tac-Toe :D ///");
        System.out.println("=================================================");
        System.out.println("  Cara bermain: Masukkan angka 0, 1, atau 2 ");
        System.out.println("  untuk mengisi papan permainan yang kosong.");
        System.out.println("-------------------------------------------------\n");

        while (true) {
            System.out.println("Giliran Player " + currentPlayer);
            board.printBoard(); // PO: Memanggil metode printBoard() dari Board, implementasi konkret dari AbstractBoard

            System.out.print("Masukkan baris (0 / 1 / 2) >>> ");
            int row = scanner.nextInt();
            System.out.print("Masukkan kolom (0 / 1 / 2) >>> ");
            int col = scanner.nextInt();

            if (board.placeMark(row, col, currentPlayer)) { // PO: Memanggil metode placeMark() dari Board
                if (board.checkWin(currentPlayer)) { // PO: Memanggil metode checkWin() dari Board
                    board.printBoard();
                    System.out.println("Player " + currentPlayer + " menang!");
                    break;
                } else if (board.isFull()) { // PO: Memanggil metode isFull() dari Board
                    board.printBoard();
                    System.out.println("Permainan seri!");
                    break;
                }

                // Ganti giliran pemain
                currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X;
            } else {
                System.out.println("Langkah tidak valid. Coba lagi.");
            }
        }

        scanner.close();
    }
}
