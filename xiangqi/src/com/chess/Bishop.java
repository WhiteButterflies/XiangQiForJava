package com.chess;

import com.Desk;

import java.util.ArrayList;

public class Bishop extends Chess{

    ArrayList<String> allPosition = new ArrayList<>();
    {
        allPosition.add("c9");allPosition.add("g9");allPosition.add("a7");allPosition.add("e7");allPosition.add("i7");
        allPosition.add("c5");allPosition.add("g5");
        allPosition.add("c0");allPosition.add("g0");allPosition.add("a2");allPosition.add("e2");allPosition.add("i2");
        allPosition.add("c4");allPosition.add("g4");
    }
    public Bishop(){super();}
    public Bishop(boolean isBlack,String name,String position){
        super(isBlack, name, position);
    }

    @Override
    public boolean runByEndPosition(Desk desk, String endPosition) {
        return false;
    }

    @Override
    public String[] generateProbablyGoList(Desk desk) {
        properNextPosition.clear();
        int middleX,middleY;
        //相的移动方法
        for (String s:allPosition
        ) {
            middleX = (position.charAt(0)+s.charAt(0))/2-'a';
            middleY = (position.charAt(1)+s.charAt(1))/2-'0';
            //避免遇到憋象腿的情况
            if ((Math.abs(position.charAt(0)-s.charAt(0))==2&&Math.abs(position.charAt(1)-s.charAt(1))==2)&&desk.desk[middleX][middleY]==null){
                properNextPosition.add(s.toString());
            }

        }
        //避免误伤我方棋子
        deleteSomePoints(desk);
        return properNextPosition.toArray(new String[properNextPosition.size()]);

    }
}
