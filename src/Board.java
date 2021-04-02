import java.util.*;

public class Board {


    public Tile[][] PlayBoard; //The 2D Tile Array used to represent the board
    Player.Player1 P1 = new Player.Player1(); //Implementing Player 1 Object
    Player.Player2 P2 = new Player.Player2(); //Implementing Player 2 Object
    Vector<Piece> onCollection1 = new Vector<>();  //Implementing vector for Player 1 pieces CURRENTLY on board
    Vector<Piece> offCollection1 = new Vector<>(); //Implementing vector for Player 1 pieces NOT CURRENTLY on board
    Vector<Piece> onCollection2 = new Vector<>(); //Implementing vector for Player 2 pieces CURRENTLY on board
    Vector<Piece> offCollection2 = new Vector<>(); //Implementing vector for Player 2 pieces NOT CURRENTLY on board

    //Board Constructor
    public Board(){
        //Adding Player's Pieces to the offCollections in the Board
        offCollection1.addAll(P1.PieceList);
        offCollection2.addAll(P2.PieceList);

        //Making the Board's 2D Tile array
        PlayBoard = new Tile[10][10];
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                PlayBoard[i][j]= new Tile(i,j);
            }
        }

        //Water Tiles
        Piece w = new Piece.Water();
        placePiece(w,2,4);
        placePiece(w,2,5);
        placePiece(w,3,4);
        placePiece(w,3,5);
        placePiece(w,6,4);
        placePiece(w,6,5);
        placePiece(w,7,4);
        placePiece(w,7,5);

    }

    public void PrintBoard(){
        //Temporary tester for Board
        System.out.println("  |_0_|_1_|_2_|_3_|_4_|_5_|_6_|_7_|_8_|_9_|");
        for(int i=0; i<10; i++) {
            System.out.println(i +" | " + PlayBoard[0][i].getPiece() + " | " + PlayBoard[1][i].getPiece() + " | " + PlayBoard[2][i].getPiece() + " | " + PlayBoard[3][i].getPiece() + " | " + PlayBoard[4][i].getPiece() + " | " + PlayBoard[5][i].getPiece() + " | " + PlayBoard[6][i].getPiece() + " | " + PlayBoard[7][i].getPiece() + " | " + PlayBoard[8][i].getPiece() + " | " + PlayBoard[9][i].getPiece()+ " | ");
            System.out.println("  |___|___|___|___|___|___|___|___|___|___|");

        }
    }

    //Movement method
    public boolean movePiece(Piece p, Tile t){



        //YOOOOOO YOU GOTTA MAKE SURE TO NOT ENTER COMBAT IF PLAYERID=0 and THE PLAYERID RESSETS WHEN YOU DIP
        int xC,yC, xF, yF;
        xC= p.xCoord;
        yC=p.yCoord;

        xF=t.xCoord;
        yF=t.yCoord;

        Vector<Tile> validMovements= validMovement(p);

        for(Tile i : validMovements){
            if(t==i){
                if(!t.occupied) {
                    Piece temp = PlayBoard[xC][yC].currentPiece;
                    temp.xCoord = xC;
                    temp.yCoord = yC;
                    //remove piece from current tile
                    PlayBoard[xC][yC].occupied=false;
                    PlayBoard[xC][yC].takePiece();
                    //place temp piece into requested tile
                    PlayBoard[xF][yF].placePiece(temp);
                    return true;
                }
                //if defending is not same player and not water tile
                else if(t.currentPiece.PlayerNum!=p.PlayerNum && t.currentPiece.PlayerNum!=0){
                    boolean result = action(p,t.currentPiece);
                    return result;
                }
                else{
                    return false;
                }
            }
        }
        return false;


    }



    public boolean swapPiece(Piece p){
        int j=0;
        boolean success=false;
        if(p.PlayerNum==1){
            for(Piece i : offCollection1){
                if(i==p){

                    offCollection1.remove(j);
                    onCollection1.add(p);
                    success=true;
                    break;
                }
                j++;
            }
            j=0;
            if(!success) {
                for (Piece i : onCollection1) {
                    if (i == p) {

                        onCollection1.remove(j);
                        offCollection1.add(p);
                        break;
                    }
                    j++;
                }
            }
        }
        else{
            for(Piece i : offCollection2){
                if(i==p){

                    offCollection2.remove(j);
                    onCollection2.add(p);
                    success=true;
                    break;
                }
                j++;
            }
            j=0;
            if(!success) {
                for (Piece i : onCollection2) {
                    if (i == p) {
                        onCollection2.remove(j);
                        offCollection2.add(p);
                        break;
                    }
                    j++;
                }
            }
        }
        return true;
    }


    public boolean placePiece(Piece p,int x, int y){
        swapPiece(p);

        if(PlayBoard[x][y]!=null){
            PlayBoard[x][y].placePiece(p);

            return true;
        }
        return false;
    }

    public boolean action(Piece p1, Piece p2){
        if(p1.Power>p2.Power || ((p1.Power==3)&&(p2.Power==11)) || (p1.Power==1)&&(p2.Power==10) ){
            PlayBoard[p2.xCoord][p2.yCoord].takePiece();
            swapPiece(p2);
            PlayBoard[p1.xCoord][p1.yCoord].takePiece();
            PlayBoard[p2.xCoord][p2.yCoord].placePiece(p1);

            PlayBoard[p1.xCoord][p1.yCoord].occupied=false;

        }
        else if(p1.Power < p2.Power){
            PlayBoard[p1.xCoord][p1.yCoord].takePiece();
            swapPiece(p1);
            PlayBoard[p1.xCoord][p1.yCoord].occupied=false;

        }
        else{
            swapPiece(p1);
            swapPiece(p2);
            PlayBoard[p2.xCoord][p2.yCoord].takePiece();
            PlayBoard[p1.xCoord][p1.yCoord].takePiece();
            PlayBoard[p1.xCoord][p1.yCoord].occupied=false;
            PlayBoard[p2.xCoord][p2.yCoord].occupied=false;


        }
        return true;
    }

    public Vector<Tile> validMovement(Piece p){
        Vector<Tile> validMovements= new Vector<>();

        if(p.Power==0 || p.Power==11){
            return validMovements;
        }


        if(!(p.Power==2)){
            int x = p.xCoord;
            int y = p.yCoord;
            if(x>0){
                validMovements.add(PlayBoard[x-1][y]);
            }
            if(x<9){
                validMovements.add(PlayBoard[x+1][y]);
            }
            if(y>0){
                validMovements.add(PlayBoard[x][y-1]);
            }
            if(y<9){
                validMovements.add(PlayBoard[x][y+1]);
            }


        }
        else{
            int x = p.xCoord;
            int y = p.yCoord;
            boolean loop;
            int z;

            //left
            loop = true;
            z=x;
            while(loop){
                z--;
                if(z>=0) {
                    if(!PlayBoard[z][y].occupied){
                        validMovements.add(PlayBoard[z][y]);
                    }
                    else{
                        validMovements.add(PlayBoard[z][y]);
                        loop=false;
                    }
                }
                else{loop=false;}

            }

            //right
            loop = true;
            z=x;
            while(loop){
                z++;
                if(z<=9) {
                    if(!PlayBoard[z][y].occupied){
                        validMovements.add(PlayBoard[z][y]);
                    }
                    else{
                        validMovements.add(PlayBoard[z][y]);
                        loop=false;
                    }
                }
                else{loop=false;}

            }

            //down
            loop = true;
            z=y;
            while(loop){
                z++;
                if(z<=9) {
                    if(!PlayBoard[x][z].occupied){
                        validMovements.add(PlayBoard[x][z]);
                    }
                    else{
                        validMovements.add(PlayBoard[x][z]);
                        loop=false;
                    }
                }
                else{loop=false;}

            }

            //up
            loop = true;
            z=y;
            while(loop){
                z--;
                if(z>=0) {
                    if(!PlayBoard[x][z].occupied){
                        validMovements.add(PlayBoard[x][z]);
                    }
                    else{
                        validMovements.add(PlayBoard[x][z]);
                        loop=false;
                    }
                }
                else{loop=false;}

            }



            return  validMovements;


        }

        return validMovements;
    }

}
