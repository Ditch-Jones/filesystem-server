package org.vs.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.vs.Main;
import org.vs.model.FilesystemMessage;
import org.vs.util.OwnJsonUtil;
import org.vs.util.OwnUtil;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;


public class UpdateFilesystemService {
    private Client client;
    @POST
    @Consumes("application/json")
    public Response addUser(InputStream is) {
        try{
            JSONObject filesystem;
            client = ClientBuilder.newClient();
            //TODO SIZE == AnzIPs in der DB
            Response[] responses = new Response[10];
            //TODO SIZE == AnzIPs in der DB
            String[] ips = new String[10];
            JSONObject jo = OwnJsonUtil.readInputStream(is);
            FilesystemMessage fsm = OwnJsonUtil.jsonObjectToFSM(jo);
            filesystem = fsm.getFilesystem();
            Main.map.put(fsm.getOrigin(),fsm.getIp());


            //TODO noch nicht getestet bzw. muss noch ganz überarbeitet werden, ist nur ein erster Ansatz
            //HashMap map = OwnUtil.groupCastFilesystem(ips,filesystem);
            //OwnUtil.retryGroupCastFilesystem(map,filesystem);

            Response.ResponseBuilder rb  = Response.ok();
            return rb.build();
        }catch(IOException | ParseException e ){
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
