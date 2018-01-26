package org.vs.model;

import org.json.simple.JSONObject;

public class FilesystemMessage {
    private String path;
    private String origin;
    private String ip;
    private JSONObject filesystem;


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public JSONObject getFilesystem() {
        return filesystem;
    }

    public void setFilesystem(JSONObject filesystem) {
        this.filesystem = filesystem;
    }


    @Override
    public String toString() {
        return "FilesystemMessage{" +
                "path='" + path + '\'' +
                ", origin='" + origin + '\'' +
                ", ip='" + ip + '\'' +
                ", filesystem=" + filesystem +
                '}';
    }
}
