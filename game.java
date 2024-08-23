import java.util.Scanner;

public class TicTacToe {
    private static char[] board = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        System.out.println("Welcome to Tic-Tac-Toe!");
        printBoard();

        while (true) {
            int move = getMove();
            board[move] = currentPlayer;
            printBoard();

            if (checkWinner()) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            } else if (isBoardFull()) {
                System.out.println("It's a tie!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    private static void printBoard() {
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("--+---+--");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("--+---+--");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    private static int getMove() {
        Scanner scanner = new Scanner(System.in);
        int move;

        while (true) {
            System.out.print("Player " + currentPlayer + ", enter your move (1-9): ");
            move = scanner.nextInt() - 1;

            if (move >= 0 && move < 9 && board[move] == ' ') {
                break;
            } else {
                System.out.println("This spot is invalid or already taken. Try again.");
            }
        }

        return move;
    }

    private static boolean checkWinner() {
        int[][] winConditions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, 
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, 
            {0, 4, 8}, {2, 4, 6}             
        };

        for (int[] condition : winConditions) {
            if (board[condition[0]] == currentPlayer &&
                board[condition[0]] == board[condition[1]] &&
                board[condition[1]] == board[condition[2]]) {
                return true;
            }
        }
        return false;
    }

    private static boolean isBoardFull() {
        for (char spot : board) {
            if (spot == ' ') {
                return false;
            }
        }
        return true;
    }
}