package org.vs.service;


import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.vs.Main;
import org.vs.model.RenameMessage;
import org.vs.util.OwnJsonUtil;

import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;


@Path("/rename")
public class RenameService {
    private Client client;

    @POST
    @Consumes("application/json")
    public Response renameFile(InputStream is){
        try{
            JSONObject jo = OwnJsonUtil.readInputStream(is);
            String jsonString = jo.toJSONString();

            RenameMessage rnm = OwnJsonUtil.jsonObjectToRNM(jo);
            String ip = (String) Main.map.get(rnm.getOrigin());

            if(ip != null){
                ResponseBuilder rb = Response.ok(ip);
                client = ClientBuilder.newClient();
                //TODO URL noch an richtige Client-Adresse anpassen
                Response r = client.target("http://"+ip+"/myapp/rename").request().post(Entity.json(jsonString));
                return rb.build();
            }else{
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
