import java.awt.Color;
import java.util.*;

public abstract class Player {
    int PlayerID;
    Color PlayerColor;
    Vector<Piece> PieceList = new Vector<>(40);
    Piece Bomb1  = new Piece.Bomb();
    Piece Bomb2 = new Piece.Bomb();
    Piece Bomb3 = new Piece.Bomb();
    Piece Bomb4 = new Piece.Bomb();
    Piece Bomb5 = new Piece.Bomb();
    Piece Bomb6 = new Piece.Bomb();
    Piece Marshal = new Piece.Marshal();
    Piece General = new Piece.General();
    Piece Colonel1 = new Piece.Colonel();
    Piece Colonel2 = new Piece.Colonel();
    Piece Major1 = new Piece.Major();
    Piece Major2 = new Piece.Major();
    Piece Major3 = new Piece.Major();
    Piece Captain1  = new Piece.Captain();
    Piece Captain2 = new Piece.Captain();
    Piece Captain3 = new Piece.Captain();
    Piece Captain4 = new Piece.Captain();
    Piece Lieutenant1  = new Piece.Lieutenant();
    Piece Lieutenant2 = new Piece.Lieutenant();
    Piece Lieutenant3 = new Piece.Lieutenant();
    Piece Lieutenant4 = new Piece.Lieutenant();
    Piece Sergeant1  = new Piece.Sergeant();
    Piece Sergeant2 = new Piece.Sergeant();
    Piece Sergeant3 = new Piece.Sergeant();
    Piece Sergeant4 = new Piece.Sergeant();
    Piece Miner1  = new Piece.Miner();
    Piece Miner2 = new Piece.Miner();
    Piece Miner3 = new Piece.Miner();
    Piece Miner4 = new Piece.Miner();
    Piece Miner5 = new Piece.Miner();
    Piece Scout1 = new Piece.Scout();
    Piece Scout2 = new Piece.Scout();
    Piece Scout3 = new Piece.Scout();
    Piece Scout4 = new Piece.Scout();
    Piece Scout5 = new Piece.Scout();
    Piece Scout6 = new Piece.Scout();
    Piece Scout7 = new Piece.Scout();
    Piece Scout8 = new Piece.Scout();
    Piece Spy = new Piece.Spy();
    Piece Flag = new Piece.Flag();
    public Player(){
        PieceList.add(Bomb1);
        PieceList.add(Bomb2);
        PieceList.add(Bomb3);
        PieceList.add(Bomb4);
        PieceList.add(Bomb5);
        PieceList.add(Bomb6);
        PieceList.add(Marshal);
        PieceList.add(General);
        PieceList.add(Colonel1);
        PieceList.add(Colonel2);
        PieceList.add(Major1);
        PieceList.add(Major2);
        PieceList.add(Major3);
        PieceList.add(Captain1);
        PieceList.add(Captain2);
        PieceList.add(Captain3);
        PieceList.add(Captain4);
        PieceList.add(Lieutenant1);
        PieceList.add(Lieutenant2);
        PieceList.add(Lieutenant3);
        PieceList.add(Lieutenant4);
        PieceList.add(Sergeant1);
        PieceList.add(Sergeant2);
        PieceList.add(Sergeant3);
        PieceList.add(Sergeant4);
        PieceList.add(Miner1);
        PieceList.add(Miner2);
        PieceList.add(Miner3);
        PieceList.add(Miner4);
        PieceList.add(Miner5);
        PieceList.add(Scout1);
        PieceList.add(Scout2);
        PieceList.add(Scout3);
        PieceList.add(Scout3);
        PieceList.add(Scout4);
        PieceList.add(Scout5);
        PieceList.add(Scout6);
        PieceList.add(Scout7);
        PieceList.add(Scout8);
        PieceList.add(Flag);
    }






    static class Player1 extends Player {
        Player1(){
            super();
            PlayerID=1;
            PlayerColor = Color.RED;
            int j=0;
            for(Piece i : PieceList){
                i.PlayerNum=PlayerID;
                i.PieceID=j;
                j++;
            }


        }
    }

    static class Player2 extends Player {
        Player2() {
            super();
            PlayerID = 2;
            PlayerColor = Color.BLUE;
            int j=0;
            for(Piece i : PieceList){
                i.PlayerNum=PlayerID;
                i.PieceID=j;
                j++;
            }



        }
    }


}
