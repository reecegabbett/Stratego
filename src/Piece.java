

public abstract class Piece {
    int xCoord;
    int yCoord;
    int Power;
    int PlayerNum;
    int PieceID;
    char token;
    char gettoken(){
        return token;
    }


    static class Bomb extends Piece{
        Bomb(){
            token = 'B';
            Power = 11;
        }
    }

    static class Marshal extends Piece{
        Marshal(){
            token = 'M';
            Power = 10;
        }
    }

    static class General extends Piece{
        General(){
            token = 'G';
            Power = 9;
        }
    }

    static class Colonel extends Piece{
        Colonel(){
            token = 'C';
            Power = 8;
        }
    }

    static class Major extends Piece{
        Major(){
            token = 'm';
            Power = 7;
        }
    }
    static class Captain extends Piece{
        Captain(){
            token = 'c';
            Power = 6;
        }
    }
    static class Lieutenant extends Piece{
        Lieutenant(){
            token = 'L';
            Power = 5;
        }
    }
    static class Sergeant extends Piece{
        Sergeant(){
            token = 'S';
            Power = 4;
        }
    }
    static class Miner extends Piece{
        Miner(){
            token = '/';
            Power = 3;
        }
    }
    static class Scout extends Piece{
        Scout(){
            token = 's';
            Power = 2;
        }
    }
    static class Spy extends Piece{
        Spy(){
            token = '?';
            Power = 1;
        }

    }

    static class Flag extends Piece{
        Flag(){
            token = 'F';
            Power = 0;
        }
    }

    static class Water extends Piece{
        Water(){
            token = 'W';
            Power = 0;
            PlayerNum=0;
        }
    }




}
