/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sga.ws;

import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import static sga.ws.SgaWs.getJsonArray;

/**
 *
 * @author uti
 */
public class SgaWsPersonal {
    
    private static final String wsname = "wspersonal";
    
    public static JSONArray sgaws_datos_estudiante(String cedula) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("cedula", cedula);        
        return getJsonArray(wsname, "sgaws_datos_estudiante", params);
    }
    
}
