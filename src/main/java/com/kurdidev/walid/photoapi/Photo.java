package com.kurdidev.walid.photoapi;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class Photo {
    private String id;

    @NotEmpty
    private String fileName;

    @JsonIgnore
    private byte[] data;

    private String contentType;

   

    public Photo() {
    }

    public Photo(String id, String fileName, byte[] data, String contentType) {
        this.id = id;
        this.fileName = fileName;
        this.data = data;
        this.contentType = contentType;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Photo id(String id) {
        setId(id);
        return this;
    }

    public Photo fileName(String fileName) {
        setFileName(fileName);
        return this;
    }

    public Photo data(byte[] data) {
        setData(data);
        return this;
    }

    public Photo contentType(String contentType) {
        setContentType(contentType);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", fileName='" + getFileName() + "'" +
            ", data='" + getData() + "'" +
            ", contentType='" + getContentType() + "'" +
            "}";
    }
    
    
}
