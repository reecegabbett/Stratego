package Stratego;

public class Tile {

    public boolean occupied;
    public int xCoord;
    public int yCoord;
    public Piece currentPiece;


    public Tile(int x, int y){
        occupied=false;
        this.xCoord = x;
        this.yCoord = y;



    }

    public char getPiece(){

        if(currentPiece!=null){
            return currentPiece.gettoken();
        }
        else return ' ';
    }

    public Boolean placePiece(Piece p){
        this.currentPiece = p;
        this.occupied = true;
        p.xCoord=xCoord;
        p.yCoord=yCoord;
        return currentPiece!=null;

    }

    public Boolean takePiece(){
        this.currentPiece=null;
        this.occupied=false;
        return true;
    }


}
