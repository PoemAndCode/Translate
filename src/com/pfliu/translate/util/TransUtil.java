package com.pfliu.translate.util;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.omg.IOP.Encoding;

import com.google.gson.Gson;
import com.pfliu.translate.baidu.TransApi;

/**  
 * 类名: TransUtil  
 * 作者： pfliu
 * 日期: 2019年4月3日
 * 时间：下午1:23:35                
 */
public class TransUtil{
    static ResourceBundle resource=ResourceBundle.getBundle("com.pfliu.translate.config");
    private static final String APP_ID = resource.getString("appid");
    private static final String SECURITY_KEY = resource.getString("securityKey");

    public static String getTransResult(String query, String from, String to) {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);

        String str = api.getTransResult(query, from, to);

        Gson gson = new Gson();
        Model model=gson.fromJson(str, Model.class);
        return model.getTrans_result().get(0).getDst();
    }
    public static void main(String[] args){
        System.out.println(getTransResult("query","auto","zh"));
    }
}
  
