package org.vs.util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.vs.model.DeleteMessage;
import org.vs.model.FilesystemMessage;
import org.vs.model.RenameMessage;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class OwnJsonUtil {

    public static FilesystemMessage jsonObjectToFSM(JSONObject jo){
        FilesystemMessage fsm = new FilesystemMessage();
        fsm.setPath((String) jo.get("path"));
        fsm.setIp((String) jo.get("ip"));
        fsm.setOrigin((String) jo.get("origin"));
        fsm.setFilesystem((JSONObject) jo.get("filesystem"));
        System.out.println("\nFilesystemMessage: "+ fsm.toString());
        return fsm;
    }

    public static RenameMessage jsonObjectToRNM(JSONObject jo){
        RenameMessage rnm = new RenameMessage();
        rnm.setDestination((String) jo.get("destination"));
        rnm.setFileName((String) jo.get("fileName"));
        rnm.setOrigin((String) jo.get("origin"));
        rnm.setPath((String) jo.get("path"));
        rnm.setNewFileName((String) jo.get("newFileName"));
        System.out.println("\nRenameMessage: "+ rnm.toString());
        return rnm;
    }

    public static DeleteMessage jsonObjectToDLM(JSONObject jo){
        DeleteMessage dlm = new DeleteMessage();
        dlm.setDestination((String) jo.get("destination"));
        dlm.setFileName((String) jo.get("fileName"));
        dlm.setOrigin((String) jo.get("origin"));
        dlm.setPath((String) jo.get("path"));
        return dlm;
    }

    public static JSONObject readInputStream(InputStream is) throws IOException, ParseException {
        JSONParser jp = new JSONParser();
        JSONObject jo = null;
        jo = (JSONObject) jp.parse(new InputStreamReader(is, "UTF-8"));

        return jo;
    }
}
