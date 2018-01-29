package org.vs.util;

import org.json.simple.JSONObject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.HashMap;



public class OwnUtil {
    private static Client client;
    private static HashMap<Response,String> map = new HashMap<>();

    public static HashMap groupCastFilesystem(String[] ips, JSONObject filesystem){
        client = ClientBuilder.newClient();
        Response[] r = new Response[ips.length];
        for(int i = 0; i<ips.length; i++){
            r[i] = client.target("http://"+ips[i] +"/").request().post(Entity.json(filesystem));
            map.put(r[i],ips[i]);
        }
        return map;
    }


    /**
     * Sendet an alle Clients erneut das filesystem, wenn diese den Responsewert 503(Service Unavailable) geliefert haben
     * @param filesystem Das Aktuelle Dateisystem
     */
    public static void retryGroupCastFilesystem(HashMap<Response,String> map, JSONObject filesystem){
        client = ClientBuilder.newClient();
        String[] ips = new String[map.size()];
        int i = 0;
        for(HashMap.Entry<Response,String> entry : map.entrySet()){
            if(entry.getKey().getStatus() == 503){
                ips[i]= entry.getValue();
                i++;
            }
        }
        groupCastFilesystem(ips,filesystem);
    }
}
