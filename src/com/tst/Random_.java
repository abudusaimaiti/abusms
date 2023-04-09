package com.tst;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author 阿卜杜赛麦提
 * @version 1.0
 * @date 2023/4/2
 */
public class Random_ {
    String [] name={"张三","阿三","阿卜","啊热","李四","阿里","卡迪"};
    Set<Integer> ran=new HashSet<Integer>();
    public void setHashset(){
        for (int j = 0; j <= 5; j++) {
            System.out.println("第"+j+"轮抽奖~");
            while (true){
                Integer random =(int)( Math.floor (Math.random()*7));
                if (ran.size()==3){
                    break;
                }
                ran.add(random);
            }
//            抽奖
            for(Integer i:ran){
                System.out.println( name[i]);
            }
            ran.clear();
        }





    }


    public static void main(String[] args) {
       new Random_().setHashset();
    }
}
