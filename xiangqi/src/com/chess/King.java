package com.chess;

import com.Desk;

import java.util.ArrayList;
import java.util.Iterator;

public class King extends Chess{

    ArrayList<String> allPosition = new ArrayList<>();
    {
        for (int i = 'd';i<='f';i++){
            for (int j='0';j<='2';j++){
                allPosition.add(new StringBuffer("").append((char)i).append((char)j).toString());
            }
            for (int j='7';j<='9';j++){
                allPosition.add(new StringBuffer("").append((char)i).append((char)j).toString());
            }
        }
    }
    @Override
    public boolean runByEndPosition(Desk desk, String endPosition) {
        boolean res = false;

        return res;
    }
    public King(){
        super();

    }
    public King(boolean isBlack,String name,String position){
        super(isBlack, name, position);
    }

    @Override
    public String[] generateProbablyGoList(Desk desk) {
       properNextPosition.clear();
       //老将的移动方法
       for (String s:allPosition
             ) {
            if(Math.abs(position.charAt(0)-s.charAt(0))+Math.abs(position.charAt(1)-s.charAt(1))==1){
                properNextPosition.add(s.toString());
            }
        }
       //避免误伤我方棋子
       deleteSomePoints(desk);
        return properNextPosition.toArray(new String[properNextPosition.size()]);
    }

}
