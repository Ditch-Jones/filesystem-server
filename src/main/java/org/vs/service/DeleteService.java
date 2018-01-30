package org.vs.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.vs.Main;
import org.vs.model.DeleteMessage;
import org.vs.util.OwnJsonUtil;

import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

@Path("/delete")
public class DeleteService {
    private Client client;

    @POST
    @Consumes("application/json")
    public Response deleteFile(InputStream is){
        try{
            JSONObject jo = OwnJsonUtil.readInputStream(is);
            String jsonString = jo.toJSONString();

            DeleteMessage dlm = OwnJsonUtil.jsonObjectToDLM(jo);
            String ip = (String)Main.map.get(dlm.getDestination());
            System.out.println(ip);
            if(ip != null){
                ResponseBuilder rb = Response.ok(ip);
                client = ClientBuilder.newClient();
                //TODO URL noch an richtige Client-Adresse anpassen
                Response r = client.target("http://"+ip+"/rest/fileSystem/DeleteFile").request().post(Entity.json(jsonString));
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
