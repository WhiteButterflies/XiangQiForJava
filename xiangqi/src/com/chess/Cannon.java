package com.chess;

import com.Desk;

import java.util.ArrayList;

public class Cannon extends Chess {
    ArrayList<String> allPosition = new ArrayList<>();

    public Cannon() {

    }

    public Cannon(boolean isBlack, String name, String position) {
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
            //避免把自己算进去
            if(x==position.charAt(0)){

                continue;
            }
            if(desk.desk[x-'a'][position.charAt(1)-'0']==null){
                properNextPosition.add(""+(char)(x)+(position.charAt(1)));
            }else{
               //开始寻找第一个可以打得子
                for (int x1 = x;x1<='i';x1++){
                    if(x1==x){

                        continue;
                    }
                    //如果遇到了可以攻打的棋子
                    if(desk.desk[x1-'a'][position.charAt(1)-'0']!=null){
                        properNextPosition.add(""+(char)(x1)+(position.charAt(1)));
                        break;
                    }
                }
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
                //开始寻找第一个可以打得子
                for (int x1 = x;x1>='a';x1--){
                    if(x1==x){

                        continue;
                    }
                    if(desk.desk[x1-'a'][position.charAt(1)-'0']!=null){
                        properNextPosition.add(""+(char)(x1)+(position.charAt(1)));
                        break;
                    }
                }
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
                //开始寻找第一个可以打得子
                for (int y1 = y;y1<='9';y1++){
                    if(y1==y){

                        continue;
                    }
                    if(desk.desk[position.charAt(0)-'a'][y1-'0']!=null){
                        properNextPosition.add(""+position.charAt(0)+(char)(y1));
                        break;
                    }
                }
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
                //开始寻找第一个可以打得子
                for (int y1 = y;y1>='0';y1--){
                    if(y1==y){

                        continue;
                    }
                    if(desk.desk[position.charAt(0)-'a'][y1-'0']!=null){
                        properNextPosition.add(""+position.charAt(0)+(char)(y1));
                        break;
                    }
                }
                break;
            }
        }

        deleteSomePoints(desk);
        return properNextPosition.toArray(new String[properNextPosition.size()]);
    }
}
