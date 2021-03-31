package com.chess;

import com.Desk;

import java.util.ArrayList;
import java.util.Iterator;

public class Knight extends Chess{


    public Knight(){

    }
    public Knight(boolean isBlack,String name,String position){
        super(isBlack, name, position);
    }
    @Override
    public boolean runByEndPosition(Desk desk, String endPosition) {
        return false;
    }

    @Override
    public String[] generateProbablyGoList(Desk desk) {
        properNextPosition.clear();
        properNextPosition.add(new StringBuffer("").append((char)(position.charAt(0)+2)).append((char)(position.charAt(1)+1)).toString());
        properNextPosition.add(new StringBuffer("").append((char)(position.charAt(0)+2)).append((char)(position.charAt(1)-1)).toString());
        properNextPosition.add(new StringBuffer("").append((char)(position.charAt(0)-2)).append((char)(position.charAt(1)+1)).toString());
        properNextPosition.add(new StringBuffer("").append((char)(position.charAt(0)-2)).append((char)(position.charAt(1)-1)).toString());
        properNextPosition.add(new StringBuffer("").append((char)(position.charAt(0)+1)).append((char)(position.charAt(1)+2)).toString());
        properNextPosition.add(new StringBuffer("").append((char)(position.charAt(0)+1)).append((char)(position.charAt(1)-2)).toString());
        properNextPosition.add(new StringBuffer("").append((char)(position.charAt(0)-1)).append((char)(position.charAt(1)+2)).toString());
        properNextPosition.add(new StringBuffer("").append((char)(position.charAt(0)-1)).append((char)(position.charAt(1)-2)).toString());



        //删除一些对马来说特殊的点（蹩马腿）
        String s;
        //目标点与之间的距离
        int distanceX,distanceY;
        int absDistanceY,absDistanceX;
        for (Iterator<String> iterator = properNextPosition.iterator();iterator.hasNext();){
            s = iterator.next();
            //对越界的可能位置进行排除
            if(s.charAt(0)<'a'||s.charAt(0)>'i'||s.charAt(1)<'0'||s.charAt(1)>'9'){
                iterator.remove();
                continue;
            }
            //蹩马腿具体的删除
            distanceX = s.charAt(0)-position.charAt(0);
            distanceY = s.charAt(1)-position.charAt(1);
            absDistanceX = Math.abs(distanceX);
            absDistanceY = Math.abs(distanceY);
            if(absDistanceX==2&&absDistanceY==1){
                if(desk.desk[position.charAt(0)+distanceX/absDistanceX-'a'][position.charAt(1)-'0']!=null){
                    iterator.remove();
                }
            }else if(absDistanceX==1&&absDistanceY==2){
                if(desk.desk[position.charAt(0)-'a'][position.charAt(1)+distanceY/absDistanceY-'0']!=null){
                    iterator.remove();
                }
            }

        }
        deleteSomePoints(desk);

        return properNextPosition.toArray(new String[properNextPosition.size()]);

    }
}
