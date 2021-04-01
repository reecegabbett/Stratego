import java.util.Scanner;

public class Play {
    public static void main(String[] args) {


        /*
        The Play Class is simply a tester class that I used to
        test all of the functions from the rest of the classes.

        */ /*

        Implementing objects and placing pieces.
         */

        Board B = new Board();
        Player P1 = B.P1;
        Player P2 = B.P2;
        boolean tester = true;
        Scanner input = new Scanner(System.in);
        B.placePiece(P1,P1.Miner1,1,1);
        B.placePiece(P1,P1.Scout1,2,1);
        B.placePiece(P2,P2.Bomb1,2,3);

        /*
        Movement Tester
         */
        B.PrintBoard();
        System.out.println("Enter controlled piece :");
        String PieceSelector = input.next();
        Piece PlayingPiece=P1.Marshal;
        while(tester){
            if(PieceSelector.equals("m")){
                PlayingPiece=P1.Miner1;
                tester=false;
            }
            if(PieceSelector.equals("s")){
                PlayingPiece=P1.Scout1;
                tester=false;
            }

        }
        tester=true;
        while(tester){

            System.out.print("\n~");
            String letter = input.next();
            System.out.printf("\n");
            if(letter.equals("u")){
                int x= PlayingPiece.xCoord;
                int y =PlayingPiece.yCoord;
                if(y>=1) {
                    B.movePiece(PlayingPiece, B.PlayBoard[x][y - 1]);
                }
            }
            if(letter.equals("d")){
                int x= PlayingPiece.xCoord;
                int y =PlayingPiece.yCoord;
                if(y<=8) {
                    B.movePiece(PlayingPiece, B.PlayBoard[x][y + 1]);
                }
            }
            if(letter.equals("l")){
                int x= PlayingPiece.xCoord;
                int y =PlayingPiece.yCoord;
                if(x>=1) {
                    B.movePiece(PlayingPiece, B.PlayBoard[x - 1][y]);
                }
            }
            if(letter.equals("r")){
                int x= PlayingPiece.xCoord;
                int y =PlayingPiece.yCoord;
                if(x<=8) {
                    B.movePiece(PlayingPiece, B.PlayBoard[x + 1][y]);
                }
            }
            if(letter.equals("x")){
                tester=false;
            }
            B.PrintBoard();
            System.out.println(PlayingPiece.xCoord);
            System.out.println(PlayingPiece.yCoord);

        }



    }
}
