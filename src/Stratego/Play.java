package Stratego;

import java.util.Scanner;

public class Play {
    public static void main(String[] args) {


        /*
        The Stratego.Play Class is simply a tester class that I used to
        test all of the functions from the rest of the classes.

        */ /*

        Implementing objects and placing pieces.
         */
        Board B = new Board();
        Player P1 = B.P1;
        Player P2 = B.P2;
        boolean tester = true;
        Scanner input = new Scanner(System.in);
        B.placePiece(P1.Scout1,0,0);
        B.placePiece(P1.Scout2,1,0);
        B.placePiece(P1.Bomb2,0,1);

        B.placePiece(P2.Spy,2,3);


        System.out.println(B.hasValidMove(P1));

        /*
        Movement Tester
         */

        B.PrintBoard();

        tester=true;
        while(tester){

            System.out.println("Enter current tile and future tile (2 3 4 5)= (2,3) -> (4,5) :");
            int xC = input.nextInt();
            int yC = input.nextInt();
            int xF = input.nextInt();
            int yF = input.nextInt();
            Piece p = B.PlayBoard[xC][yC].currentPiece;
            Tile t = B.PlayBoard[xF][yF];
            if(B.PlayBoard[xC][yC].occupied) {
                boolean succ =B.movePiece(p, t);

                B.PrintBoard();

            }
        }



    }
}
