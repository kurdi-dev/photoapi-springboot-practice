package com.kurdidev.walid.photoapi.model;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table("PHOTOZ")
public class Photo {

    @Id
    private Integer id;

    @NotEmpty
    private String fileName;

    @JsonIgnore
    private byte[] data;

    private String contentType;
   

    public Photo() {
    }



    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
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

    public Photo id(Integer id) {
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
