package tictactoe;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(); // PW: Pewarisan - `Game` adalah kelas yang memanfaatkan komponen pewarisan tidak langsung (contoh: `Board` mewarisi `AbstractBoard`) untuk menjalankan logika permainan.
        game.start(); // PO: Polimorfisme - Memanggil metode `start()` pada objek `Game`, yang di dalamnya memanfaatkan implementasi polimorfik dari `AbstractBoard` melalui objek `Board`.
    }
}
