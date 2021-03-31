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
        //ͨ�������ȡ�ĸ������ϵĵ�
        for(x = position.charAt(0);x<='i';x++){
            //������Լ����ȥ
            if(x==position.charAt(0)){

                continue;
            }
            if(desk.desk[x-'a'][position.charAt(1)-'0']==null){
                properNextPosition.add(""+(char)(x)+(position.charAt(1)));
            }else{
               //��ʼѰ�ҵ�һ�����Դ����
                for (int x1 = x;x1<='i';x1++){
                    if(x1==x){

                        continue;
                    }
                    //��������˿��Թ��������
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
                //��ʼѰ�ҵ�һ�����Դ����
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
                //��ʼѰ�ҵ�һ�����Դ����
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
                //��ʼѰ�ҵ�һ�����Դ����
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
