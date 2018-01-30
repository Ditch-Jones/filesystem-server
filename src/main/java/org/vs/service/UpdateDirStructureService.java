package org.vs.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.vs.util.OwnJsonUtil;
import org.vs.util.OwnUtil;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

//@Path("/update")
public class UpdateDirStructureService {

    @POST
    @Consumes("application/json")
    public Response update(InputStream is){
        try {
            JSONObject jo = OwnJsonUtil.readInputStream(is);
            //TODO IP-Array aus DB
            String[] ips = {"168.134.2.144","111.123.144.2"};

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
