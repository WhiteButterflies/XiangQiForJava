package com.chess;

import com.Desk;
import sun.security.krb5.internal.crypto.Des;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Chess {
    public String name="";
    //是否是黑旗 默认是红旗
    public boolean isBlack = false;
    //是否死亡。true为死亡
    public boolean isDead = false;
    public ArrayList<String> properNextPosition = new ArrayList<>();
    //棋子所在的位置坐标 (a1)
    public String position = "";

    public Chess(){

    }
    public Chess(boolean isBlack,String name,String position){
        this.isBlack = isBlack;
        this.name = name;
        this.position = position;
    }

    //
    public abstract boolean runByEndPosition(Desk desk, String endPosition);
    //生成该棋子所有可能的落脚点
    public abstract String[] generateProbablyGoList(Desk desk);
    //改变棋子坐标 据指定位置进行下一着 true 代表此步可走
    public boolean changePosition(String position, Desk desk){
        boolean bool = false;//代表不允许以此为目标
        generateProbablyGoList(desk);
        for (String s:properNextPosition
        ) {
            //如果发现位置属于可能的位置，但是还没判定可能的位置上是否有敌方棋子 或者是我方棋子
            if(s.equals(position)){
                bool = true;
                System.out.println("目标位置可以移动，即将吃子或者是移动");
                desk.desk[position.charAt(0)-'a'][position.charAt(1)-'0']=this;
                desk.desk[this.position.charAt(0)-'a'][this.position.charAt(1)-'0']=null;
                this.position = position;
                return bool;
            }
        }
        return bool;
    }
        //避免吃到我方棋子，去掉越界点、
    public void deleteSomePoints(Desk desk){

        String s;
        for (Iterator<String> iterator = properNextPosition.iterator(); iterator.hasNext();){
            s=iterator.next();
            //对越界的可能位置进行排除
            if(s.charAt(0)<'a'||s.charAt(0)>'i'||s.charAt(1)<'0'||s.charAt(1)>'9'){
                iterator.remove();
                continue;
            }

            //避免吃到己方棋子
            if(desk.desk[s.charAt(0)-'a'][s.charAt(1)-'0']!=null&&desk.desk[s.charAt(0)-'a'][s.charAt(1)-'0'].isBlack==isBlack){
                iterator.remove();
            }else{

            }

        }

    }

    @Override
    public String toString() {
        return "Chess{" +
                "name='" + name + '\'' +
                ", isBlack=" + isBlack +
                ", isDead=" + isDead +
                ", properNextPosition=" + properNextPosition +
                ", position='" + position + '\'' +
                '}';
    }
}
