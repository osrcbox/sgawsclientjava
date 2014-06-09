/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sga.ws;

import java.io.IOException;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author uti
 */
public class SgaWs {
    
    private static String user = "";
    private static String pass = "";
    private static String baseUrl = "http://ws.unl.edu.ec/sgaws/";
    
    public static void setCredentials(String username, String password){
        SgaWs.user = username;
        SgaWs.pass = password;
    }
    
    public static void setBaseUrl(String baseUrl){
        SgaWs.baseUrl = baseUrl;
    }
    
    private static String getUrl(String ws, String method, Map<String, Object> params) {
        String url = baseUrl + ws + "/" + method;
        
        if(params != null && !params.isEmpty()){
            url += "?";
            boolean concatenar = false;
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                String k = entry.getKey();
                Object v = entry.getValue();                                                
                url += (concatenar ? "&":"") + k + "=" + v;
                
                if(concatenar == false){
                    concatenar = true;
                }                
            }
        }
        
        return url;
    }
    
    protected static JSONArray getJsonArray(String ws, String method, Map<String, Object> params) {
        JSONArray ojson = null;
        try {
            DefaultHttpClient Client = new DefaultHttpClient();
            Client.getCredentialsProvider().setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(user, pass));

            String url = getUrl(ws, method, params);           
            HttpGet httpGet = new HttpGet(url);            
            HttpResponse response = Client.execute(httpGet);
            String json = EntityUtils.toString(response.getEntity());
            
            try {
                String jsonf = json.replaceAll("<result>", "").replaceAll("</result>", "");                        
                ojson = (JSONArray) new JSONParser().parse(jsonf);
            } catch (ParseException e) {
                System.err.println(json);
                ojson = new JSONArray();
                ojson.add(0, "_error");
                ojson.add(1, "Error al intentar convertir a json");
            }
        } catch (IOException e) {
            e.printStackTrace();
            ojson = new JSONArray();
            ojson.add(0, "_error");
            ojson.add(1, "Error de conexión");
        }
        
        return ojson;        
    }                        
    
}
