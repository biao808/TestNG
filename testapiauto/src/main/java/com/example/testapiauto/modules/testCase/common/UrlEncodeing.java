package com.example.testapiauto.modules.testCase.common;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class UrlEncodeing {


    /***
    * @author 假斯文
    * @date 2021/3/25 14:07
    * @param
    * @return
    ***/
    public static String GetRealUrl(String str){
        try {
            int index = str.indexOf("?");
            if (index < 0) return str;
            String query = str.substring(0,index);
            String params =str.substring(index + 1);
            Map map = GetArgs(params);
            String encodeParams = TransMapToString(map);
            return query + "?" +encodeParams;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return "";
    }


    /***
    * @author 假斯文
    * @date 2021/3/25 14:07
    * @param
    * @return 将url参数转换为map
    ***/
    public static Map GetArgs(String params)throws Exception {
        Map map = new HashMap();
        String[] pairs =params.split("&");
        for (int i = 0; i <pairs.length; i++){
            int pos = pairs[i].indexOf("=");
            if (pos == -1)continue;
            String argname = pairs[i].substring(0,pos);
            String value = pairs[i].substring(pos+1);
            value =URLEncoder.encode(value,"utf-8");
            map.put(argname,value);
        }
        return map;
    }



    /***
    * @author 假斯文
    * @date 2021/3/25 14:08
    * @param
    * @return 将map转换为指定String类型
    ***/
    public static String TransMapToString(Map map){
        java.util.Map.Entry entry;
        StringBuffer sb = new StringBuffer();
        for (Iterator iterator = map.entrySet().iterator();iterator.hasNext();){
            entry = (java.util.Map.Entry) iterator.next();
            sb.append(entry.getKey().toString()).append("=").append(null == entry.getValue()? "":
                    entry.getValue().toString()).append(iterator.hasNext()? "&" : "");
        }
        return sb.toString();
    }

    /***
    * @author 假斯文
    * @date 2021/3/25 14:08
    * @param
    * @return 将String类型按一定规则转换为Map
    ***/
    public static Map TransStringToMap(String mapString){
        Map map = new HashMap();
        java.util.StringTokenizer items;
        for (StringTokenizer entrys = new StringTokenizer(mapString,"&");entrys.hasMoreTokens();
             map.put(items.nextToken(),items.hasMoreTokens()? ((Object)(items.nextToken())) : null))
            items = new StringTokenizer(entrys.nextToken(),"=");
        return map;
    }
}

