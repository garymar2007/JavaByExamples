package org.gary.problemSolving;

import java.util.Scanner;

public class RockPaperScissorGame {

    private static final int ROCK = 1;
    private static final int PAPER = 2;
    private static final int SCISSOR = 3;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        boolean isContinue = true;
        int[] result = {0,0};
        while(isContinue) {
            playGame(sc, result);
            System.out.println("Do you want to quit the game:[Y/n]");
            String ans = sc.nextLine();
            isContinue = ans.equalsIgnoreCase("Y") ? false : true;
        }
        String who = adjudicateWinner(result);

        System.out.println("The result of this game is : " +
                ((who.equalsIgnoreCase("draw")) ? " DRAW" : who + " is the winner"));
    }

    static int getInputFromPlayer(Scanner sc,int player) {
        System.out.println("It is Player " + player + "'s turn.  Please type [1: rock, 2: paper, 3: scissor]");
        int choice = Integer.parseInt(sc.nextLine());

        return choice;
    }

    static boolean validateInput(int input) {
        return input > 0  && input < 4;
    }

    static void playGame(Scanner sc, int[] result) {
        int player1 = getInputFromPlayer(sc, 1);

        while(!validateInput(player1)) {
            player1 = getInputFromPlayer(sc,1);
        }

        int player2 = getInputFromPlayer(sc,2);

        while(!validateInput(player2)) {
            player2 = getInputFromPlayer(sc,2);
        }

        if(player1 == ROCK) {
            if(player2 == PAPER) {
                result[1] += 1;
            } else if (player2 == SCISSOR) {
                result[0] += 1;
            }
        } else if (player1 == PAPER) {
            if(player2 == ROCK) {
                result[0] += 1;
            } else if (player2 == SCISSOR) {
                result[1] += 1;
            }
        }else {
            if(player2 == ROCK) {
                result[1] += 1;
            } else if (player2 == PAPER) {
                result[0] += 1;
            }
        }
    }

    /**
     * Player 1: 3 wins, 2 lose, 0 draw
     * Player 2: 2 wins, 3 lose, 0 draw
     * @param result
     * @return
     */
    static String adjudicateWinner(int[] result) {
        return result[0] > result[1] ? "Player 1" : result[0] < result[1] ? "Player 2" : "Draw";
    }
}
