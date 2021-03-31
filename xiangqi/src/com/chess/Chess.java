package com.chess;

import com.Desk;
import sun.security.krb5.internal.crypto.Des;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Chess {
    public String name="";
    //�Ƿ��Ǻ��� Ĭ���Ǻ���
    public boolean isBlack = false;
    //�Ƿ�������trueΪ����
    public boolean isDead = false;
    public ArrayList<String> properNextPosition = new ArrayList<>();
    //�������ڵ�λ������ (a1)
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
    //���ɸ��������п��ܵ���ŵ�
    public abstract String[] generateProbablyGoList(Desk desk);
    //�ı��������� ��ָ��λ�ý�����һ�� true ����˲�����
    public boolean changePosition(String position, Desk desk){
        boolean bool = false;//���������Դ�ΪĿ��
        generateProbablyGoList(desk);
        for (String s:properNextPosition
        ) {
            //�������λ�����ڿ��ܵ�λ�ã����ǻ�û�ж����ܵ�λ�����Ƿ��ез����� �������ҷ�����
            if(s.equals(position)){
                bool = true;
                System.out.println("Ŀ��λ�ÿ����ƶ����������ӻ������ƶ�");
                desk.desk[position.charAt(0)-'a'][position.charAt(1)-'0']=this;
                desk.desk[this.position.charAt(0)-'a'][this.position.charAt(1)-'0']=null;
                this.position = position;
                return bool;
            }
        }
        return bool;
    }
        //����Ե��ҷ����ӣ�ȥ��Խ��㡢
    public void deleteSomePoints(Desk desk){

        String s;
        for (Iterator<String> iterator = properNextPosition.iterator(); iterator.hasNext();){
            s=iterator.next();
            //��Խ��Ŀ���λ�ý����ų�
            if(s.charAt(0)<'a'||s.charAt(0)>'i'||s.charAt(1)<'0'||s.charAt(1)>'9'){
                iterator.remove();
                continue;
            }

            //����Ե���������
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
