package org.vs.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.vs.Main;
import org.vs.model.FilesystemMessage;
import org.vs.util.OwnJsonUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;




@Path("/addUser")
public class UserService {
    @POST
    @Consumes("application/json")
    public Response addUser(InputStream is) {
        try{
            JSONObject jo = OwnJsonUtil.readInputStream(is);
            FilesystemMessage fsm = OwnJsonUtil.jsonObjectToFSM(jo);
            //Eigentlicher Aufruf der dieses JSONObject in der DB speichert
            Main.map.put(fsm.getOrigin(),fsm.getIp());
            ResponseBuilder rb  = Response.ok();
            return rb.build();
        }catch(IOException | ParseException e){
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }


}
