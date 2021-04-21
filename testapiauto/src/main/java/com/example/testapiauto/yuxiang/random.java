package com.example.testapiauto.yuxiang;

import java.util.Random;

/**
 * TODO
 *
 * @author yuxiang
 * @version 1.0
 * @date 2021/4/19 9:44
 */
public class random {

     /**
      *
      * @param
      * @author 假斯文
      * @date 2021/4/19 10:35
      * @return  获取指定长度long类型的随机数
      */
        public static String getRandom(int len){
            Random r = new Random();
            int bitNum=1;
            for(int i=0;i<len;i++){
                bitNum=bitNum*10;
            }
            long num = Math.abs(r.nextLong() % (bitNum));
            String s = String.valueOf(num);
            for (int i = len - s.length(); i >0 ;i--) {
                s = "0" + s;
            }
            if(s.length()>len){
                s=s.substring(0,len);
            }
            return s;
        }


}
