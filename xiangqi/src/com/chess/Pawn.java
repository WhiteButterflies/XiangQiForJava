package com.chess;

import com.Desk;

import java.util.ArrayList;

public class Pawn extends Chess{
    ArrayList<String> allPosition = new ArrayList<>();
    public Pawn(){

    }
    public Pawn(boolean isBlack,String name,String position){
        super(isBlack, name, position);
    }

    @Override
    public boolean runByEndPosition(Desk desk, String endPosition) {
        return false;
    }

    @Override
    public String[] generateProbablyGoList(Desk desk) {
        //兵的运行方法
        //判断兵是越河 不判断是否越过棋盘
        int distance = position.charAt(1)-desk.kings[!this.isBlack ?0:1].charAt(1);
        if(Math.abs(distance)>4){
            properNextPosition.add(new StringBuffer("").append(position.charAt(0)).append(
                    (char)(position.charAt(1)+distance/Math.abs(distance))).toString()
            );
            properNextPosition.add(new StringBuffer("").append((char)(position.charAt(0)+1)).append(
                    position.charAt(1)).toString()
            );
            properNextPosition.add(new StringBuffer("").append((char)(position.charAt(0)-1)).append(
                    position.charAt(1)).toString()
            );
        }else{
            properNextPosition.add(new StringBuffer("").append(position.charAt(0)).append(
                    (char)(position.charAt(1)+distance/Math.abs(distance))).toString()
            );
        }
        deleteSomePoints(desk);
        return properNextPosition.toArray(new String[properNextPosition.size()]);
    }
}
