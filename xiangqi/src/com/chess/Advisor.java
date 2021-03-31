package com.chess;

import com.Desk;

import java.util.ArrayList;

public class Advisor extends Chess{
    ArrayList<String> allPosition = new ArrayList<>();
    {
        allPosition.add("d9");allPosition.add("f9");allPosition.add("e8");allPosition.add("d7"); allPosition.add("f7");
        allPosition.add("d2");allPosition.add("f2");allPosition.add("e1");allPosition.add("d0"); allPosition.add("f0");
    }
    public Advisor(){
        super();
    }
    public Advisor(boolean isBlack,String name,String position){
        super(isBlack, name, position);
    }

    @Override
    public boolean runByEndPosition(Desk desk, String endPosition) {
        return false;
    }

    @Override
    public String[] generateProbablyGoList(Desk desk) {
        properNextPosition.clear();
        //士的移动方法
        for (String s:allPosition
        ) {
            if(Math.abs(position.charAt(0)-s.charAt(0))==1&&Math.abs(position.charAt(1)-s.charAt(1))==1){
                properNextPosition.add(s.toString());
            }
        }
        //避免误伤我方棋子
        deleteSomePoints(desk);
        return properNextPosition.toArray(new String[properNextPosition.size()]);
    }

}
