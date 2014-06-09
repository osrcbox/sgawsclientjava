/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sga.ws.test;

import sga.ws.SgaWsPersonal;
import sga.ws.SgaWsAcademica;
import org.json.simple.JSONArray;
import sga.ws.SgaWs;

/**
 *
 * @author uti
 */
public class TestWs {
    public static void main(String[] a){
        SgaWs.setCredentials("poner_nombre_usuario", "poner_clave_usuario");
        
        JSONArray jec = SgaWsAcademica.sgaws_expediente_carrera("1104285604", 79);        
        System.out.println("JSONArray: " + jec);
        
        JSONArray jdp = SgaWsPersonal.sgaws_datos_estudiante("1104285604");
        System.out.println("JSONArray: " + jdp);
    }
}
