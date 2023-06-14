package com.ugb.urban_shop;

public class DataClass {

    private String dataNom;
    private String dataPrec;
    private String dataDescr;
    private String dataImage;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDataNom() {
        return dataNom;
    }

    public String getDataPrec() {
        return dataPrec;
    }

    public String getDataDescr() {
        return dataDescr;
    }

    public String getDataImage() {
        return dataImage;
    }

    public DataClass(String dataNom, String dataPrec, String dataDescr, String dataImage) {
        this.dataNom = dataNom;
        this.dataPrec = dataPrec;
        this.dataDescr = dataDescr;
        this.dataImage = dataImage;
    }

    public DataClass(){

    }
}
