package com;

import com.chess.*;

import java.util.Locale;

public class UtilsForChess {
    public static String action(String FEN,String action){
        String resFEN = "";
        return resFEN;
    }
    //伪图形化显示某个瞬间棋盘的情况
    public static void showDesk(Desk desk){
        for(int j=9;j>=0;j--){
            for (int i = 0;i<=8;i++){
                if(desk.desk[i][j]!=null) {
                    System.out.print(String.format("%-16s",desk.desk[i][j].name));
                }
                else{
                    System.out.print(String.format("%-16s",""));
                }
            }
            System.out.println();
        }
    }
    //自动读取ICCS 实现下棋操作
    public static void autoReadICCS(String iccs,Desk desk){
        iccs  = iccs.toLowerCase(Locale.ROOT);
        String s1,s2;
        for (int i=0;i<iccs.length();i+=4){
            s1 = ""+(char)iccs.charAt(i)+iccs.charAt(i+1);
            s2 = ""+iccs.charAt(i+2)+iccs.charAt(i+3);
            System.out.println(i/8+1+"   "+s1+s2);
            desk.action(s1,s2);
        }
    }
    //恢复棋盘初始布局
    public static void setDesk(Desk desk){
        desk.desk = new Chess[9][10];
        desk.desk[0][0] = new Rook(false,"Che-red","a0");
        desk.desk[1][0] = new Knight(false,"Ma-red","b0");
        desk.desk[2][0] = new Bishop(false,"Xiang-red","c0");
        desk.desk[3][0] = new Advisor(false,"Shi-red","d0");
        desk.desk[4][0] = new King(false,"Shuai-red","e0");
        desk.desk[5][0] = new Advisor(false,"Shi-red","f0");
        desk.desk[6][0] = new Bishop(false,"Xiang-red","g0");
        desk.desk[7][0] = new Knight(false,"Ma-red","h0");
        desk.desk[8][0] = new Rook(false,"Che-red","i0");

        desk.desk[1][2] = new Cannon(false,"Pao-red","b2");
        desk.desk[7][2] = new Cannon(false,"Pao-red","h2");

        desk.desk[0][3] = new Pawn(false,"Bing-Red","a3");
        desk.desk[2][3] = new Pawn(false,"Bing-Red","c3");
        desk.desk[4][3] = new Pawn(false,"Bing-Red","e3");
        desk.desk[6][3] = new Pawn(false,"Bing-Red","g3");
        desk.desk[8][3] = new Pawn(false,"Bing-Red","i3");

        desk.desk[0][9] = new Rook(true,"Che-black","a9");
        desk.desk[1][9] = new Knight(true,"Ma-black","b9");
        desk.desk[2][9] = new Bishop(true,"Xiang-black","c9");
        desk.desk[3][9] = new Advisor(true,"Shi-black","d9");
        desk.desk[4][9] = new King(true,"Shuai-black","e9");
        desk.desk[5][9] = new Advisor(true,"Shi-black","f9");
        desk.desk[6][9] = new Bishop(true,"Xiang-black","g9");
        desk.desk[7][9] = new Knight(true,"Ma-black","h9");
        desk.desk[8][9] = new Rook(true,"Che-black","i9");

        desk.desk[1][7] = new Cannon(true,"Pao-black","b7");
        desk.desk[7][7] = new Cannon(true,"Pao-black","h7");

        desk.desk[0][6] = new Pawn(true,"Bing-black","a6");
        desk.desk[2][6] = new Pawn(true,"Bing-black","c6");
        desk.desk[4][6] = new Pawn(true,"Bing-black","e6");
        desk.desk[6][6] = new Pawn(true,"Bing-black","g6");
        desk.desk[8][6] = new Pawn(true,"Bing-black","i6");
    }

}
