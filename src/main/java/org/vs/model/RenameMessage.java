package org.vs.model;



public class RenameMessage {
    private String path;
    private String destination;
    private String origin;
    private String fileName;
    private String newFileName;

    public RenameMessage(String path, String destination, String origin, String fileName, String newFileName) {
        this.path = path;
        this.destination = destination;
        this.origin = origin;
        this.fileName = fileName;
        this.newFileName = newFileName;
    }

    public RenameMessage() {
    }

    public String getPath() {
        return path;
    }

    public String getDestination() {
        return destination;
    }

    public String getOrigin() {
        return origin;
    }

    public String getFileName() {
        return fileName;
    }

    public String getNewFileName() {
        return newFileName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    @Override
    public String toString() {
        return "RenameMessage{" +
                "path='" + path + '\'' +
                ", destination='" + destination + '\'' +
                ", origin='" + origin + '\'' +
                ", fileName='" + fileName + '\'' +
                ", newFileName='" + newFileName + '\'' +
                '}';
    }
}
