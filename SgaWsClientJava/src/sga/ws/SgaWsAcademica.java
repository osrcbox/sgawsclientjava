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
public class SgaWsAcademica {
    
    private static final String wsname = "wsacademica";
    
    public static JSONArray sgaws_expediente_carrera(String cedula, int id_carrera) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("cedula", cedula);
        params.put("id_carrera", id_carrera);
        return getJsonArray(wsname, "sgaws_expediente_carrera", params);
    }
    
}
