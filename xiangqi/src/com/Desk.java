package com;

import com.chess.Chess;

import java.util.Arrays;

public class Desk {
    //�ƶ�����
    public Chess[][]desk = new Chess[9][10];
    //��������˭��
    public boolean forBlack = false;
    //����һ�ºں�˫���Ľ��ĳ�ʼλ�� Ĭ���·��Ǻ�(�����еĵ�һ��λ���Ǻ췽˧��λ��)��
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
    //����FEN�ַ���
    public String generateFENString(){
        String FEN = "";
        return FEN;
    }
    //�������� ���罫�� ���� �Ƿ��Ѿ���Ϊ����
    public void analysis(){

    }
    //������һ������
    public Desk action(String beginPosition,String dstPosition){
        Desk nextDesk = new Desk();
        //��ȡָ�����������
        Chess chess = this.desk[beginPosition.charAt(0)-'a'][beginPosition.charAt(1)-'0'];
        if(chess==null){
            System.out.println("��λ��������");
            UtilsForChess.showDesk(this);
            return this;
        }
        else if(chess.isBlack!=forBlack){
            System.out.println("����Ȩ�ƶ���������");
            return this;
        }
        else{
            System.out.println("ѡ�е�����:"+chess.toString());
        }

        //����ִ�ж�Ӧ�Ĳ�
        chess.changePosition(dstPosition,this);

        //���ĵ�ǰ���
        //�޸ĸ�˭��һ�š�
        forBlack = !forBlack;
        System.out.println("֮�������:"+chess.toString());
        return this;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
