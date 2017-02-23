/**
 * Created by kysft on 2/22/17.
 */

import java.util.*;


public class TestTicTacToe {
    //**first, build a board; then function run to check make a new record and check if there was a winner or not;
    // last, if there was a winner,run again;if not, keep run the step two;

        char position[]=new char[9];
        char player;
        int count;
        char mark;

    public char getMark() {
        if (player == 'A') {
            return 'X';
        }else {
            return 'O';
        }
    }

    public static void main(String[] args) {

        String startrunInput;
        do {
            System.out.println("\n\nWelcome!The 'TicTacToe' is started!");
            System.out.println("This is a game for two player!");
            System.out.println("Sample as below,");
            System.out.println("And you need type the no. of the position!");
            System.out.println("\n\t\t 1 | 2 | 3 ");
            System.out.println("\t\t __ __ __");
            System.out.println("\n\t\t 4 | 5 | 6 ");
            System.out.println("\t\t __ __ __");
            System.out.println("\n\t\t 7 | 8 | 9 ");
            System.out.println("\n\n" + "This is the start line of new Game!");

            TestTicTacToe TTT = new TestTicTacToe();
            TTT.newBoard();
            TTT.gameRun();
            System.out.println("Do you wanna play again? 'y' or 'n' ");

            Scanner stInput = new Scanner(System.in);
            startrunInput = stInput.nextLine();
        } while (startrunInput.equals('y') || startrunInput.equals('Y'));
    }

    public void newBoard() {
        char positionNew[] = {'_','_','_','_','_','_','_','_','_'};
        count = 0;
        player = 'A'; //don't use "" for string

        for (int i = 0; i < 9; i++) {
            position[i] = positionNew[i];
        }
        updateBoard();
    }

     public void updateBoard() {
        System.out.println("\n\n");
        System.out.println("\n\t\t " +position[0]+ " | " +position[1]+ " | " +position[2]+ " ");
        System.out.println("\t\t __ __ __");
        System.out.println("\n\t\t " +position[3]+ " | " +position[4]+ " | " +position[5]+ " ");
        System.out.println("\t\t __ __ __");
        System.out.println("\n\t\t " +position[6]+ " | " +position[7]+ " | " +position[8]+ " ");
        System.out.println("\n\n");
    }

    public void gameRun() {
        int positionTaken;
        char notTaken;
        //System.out.println("Player " + getPlayer() + " go first , pls choose a position from (1 to 9) !");

        //start loop
        do {

            System.out.println("Player " + getPlayer() + " , pls choose a position from (1 to 9) available !");

            boolean newpositionTaken = true;
            while(newpositionTaken) {
                String looprunInput;
                Scanner rrInput = new Scanner(System.in);
                looprunInput = rrInput.nextLine();

                int newInput = Integer.parseInt(looprunInput) - 1;

                newpositionTaken = newpositionCheck(newInput);

                if (newpositionTaken=false) {

                }else {
                    position[newInput] = getMark();
                }

            }
        System.out.println("Nice try! Next player, pls be ready!");
        updateBoard();
        nextPlayer();
        } while (winnerCheck() == ' ');
        //end loop
    }

    public boolean newpositionCheck(int newInput) {
        if (position[newInput] == 'X' || position[newInput] == 'O') {
            System.out.println("The position is taken, pls choose another one!");
            return true;
        }else {
            return false;
        }
    }
    public char nextPlayer() {
       if (player == 'A') {
           return player = 'B';
       }else {
           return player = 'A';
       }
    }
    public char getPlayer() {
        return player;
    }

    public char winnerCheck() {
        char winner = ' ';
        if (position[0] == 'X' && position[1] == 'X' && position[2] == 'X') {
            winner = 'A';
        }
        if (position[3] == 'X' && position[4] == 'X' && position[5] == 'X') {
            winner = 'A';
        }
        if (position[6] == 'X' && position[7] == 'X' && position[8] == 'X') {
            winner = 'A';
        }
        if (position[0] == 'X' && position[3] == 'X' && position[6] == 'X') {
            winner = 'A';
        }
        if (position[1] == 'X' && position[4] == 'X' && position[7] == 'X') {
            winner = 'A';
        }
        if (position[2] == 'X' && position[5] == 'X' && position[8] == 'X') {
            winner = 'A';
        }
        if (position[0] == 'X' && position[4] == 'X' && position[8] == 'X') {
            winner = 'A';
        }
        if (position[2] == 'X' && position[4] == 'X' && position[6] == 'X') {
            winner = 'A';
        }


        if (position[0] == 'O' && position[1] == 'O' && position[2] == '0') {
            winner = 'B';
        }
        if (position[3] == 'O' && position[4] == 'O' && position[5] == '0') {
            winner = 'B';
        }
        if (position[6] == 'O' && position[7] == 'O' && position[8] == '0') {
            winner = 'B';
        }
        if (position[0] == 'O' && position[3] == 'O' && position[6] == '0') {
            winner = 'B';
        }
        if (position[1] == 'O' && position[4] == 'O' && position[7] == '0') {
            winner = 'B';
        }
        if (position[2] == 'O' && position[5] == 'O' && position[8] == '0') {
            winner = 'B';
        }
        if (position[0] == 'O' && position[4] == 'O' && position[8] == '0') {
            winner = 'B';
        }
        if (position[2] == 'O' && position[4] == 'O' && position[6] == '0') {
            winner = 'B';
        }

        if (winner == 'A') {
            System.out.println("Player A is the Winner!");
        }else if (winner == 'B') {
            System.out.println("Player B is the Winner!");
        }
        return winner;
    }
}
