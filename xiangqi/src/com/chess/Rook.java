package com.chess;

import com.Desk;

import java.util.ArrayList;

public class Rook extends Chess{
    ArrayList<String> allPosition = new ArrayList<>();

    public Rook(){

    }
    public Rook(boolean isBlack,String name,String position){
        super(isBlack, name, position);

    }
    @Override
    public boolean runByEndPosition(Desk desk, String endPosition) {
        return false;
    }


    @Override
    public String[] generateProbablyGoList(Desk desk) {
        properNextPosition.clear();
        int x,y;
        //通过坐标获取四个方向上的点
        for(x = position.charAt(0);x<='i';x++){
            if(x==position.charAt(0)){

                continue;
            }
            if(desk.desk[x-'a'][position.charAt(1)-'0']==null){
                properNextPosition.add(""+(char)(x)+(position.charAt(1)));
            }else{
                properNextPosition.add(""+(char)(x)+(position.charAt(1)));
                break;
            }
        }
        for(x = position.charAt(0);x>='a';x--){
            if(x==position.charAt(0)){

                continue;
            }
            if(desk.desk[x-'a'][position.charAt(1)-'0']==null){
                properNextPosition.add(""+(char)(x)+(position.charAt(1)));
            }else{
                properNextPosition.add(""+(char)(x)+(position.charAt(1)));
                break;
            }
        }
        for (y = position.charAt(1);y<='9';y++){
            if(y==position.charAt(1)){

                continue;
            }
            if(desk.desk[position.charAt(0)-'a'][y-'0']==null){
                properNextPosition.add(""+position.charAt(0)+(char)(y));
            }else{
                properNextPosition.add(""+position.charAt(0)+(char)(y));
                break;
            }
        }
        for (y = position.charAt(1);y>='0';y--){
            if(y == position.charAt(1)){

                continue;
            }
            if(desk.desk[position.charAt(0)-'a'][y-'0']==null){
                properNextPosition.add(""+position.charAt(0)+(char)(y));
            }else{
                properNextPosition.add(""+position.charAt(0)+(char)(y));
                break;
            }
        }
        deleteSomePoints(desk);
        return properNextPosition.toArray(new String[properNextPosition.size()]);
    }

}
