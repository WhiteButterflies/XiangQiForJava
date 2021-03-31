package com;

import com.chess.Chess;

import java.util.Arrays;

public class Desk {
    //制定棋盘
    public Chess[][]desk = new Chess[9][10];
    //这个局面该谁走
    public boolean forBlack = false;
    //设置一下黑红双方的将的初始位置 默认下方是红(数组中的第一个位置是红方帅的位置)。
    public String[] kings = new String[2];
    {
        kings[0]="e0";
        kings[1]="e9";
    }

    public Desk(){

    }
    public Desk(String FEN){

    }
    public Desk(String command,String a){

    }
    //生成FEN字符串
    public String generateFENString(){
        String FEN = "";
        return FEN;
    }
    //分析局面 比如将军 吃子 是否已经成为死局
    public void analysis(){

    }
    //进行下一步动作
    public Desk action(String beginPosition,String dstPosition){
        Desk nextDesk = new Desk();
        //提取指定坐标的棋子
        Chess chess = this.desk[beginPosition.charAt(0)-'a'][beginPosition.charAt(1)-'0'];
        if(chess==null){
            System.out.println("此位置无棋子");
            UtilsForChess.showDesk(this);
            return this;
        }
        else if(chess.isBlack!=forBlack){
            System.out.println("你无权移动敌人棋子");
            return this;
        }
        else{
            System.out.println("选中的棋子:"+chess.toString());
        }

        //棋子执行对应的步
        chess.changePosition(dstPosition,this);

        //更改当前棋局
        //修改该谁下一着。
        forBlack = !forBlack;
        System.out.println("之后的棋子:"+chess.toString());
        return this;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
