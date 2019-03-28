package com.gt.projects.bdd.base.enums;

public enum DataFormat {
    
    DEICMAL_PLACE_2("^[0-9]*\\.[0-9]{2}$"),
    EMAIL("^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$"),
    URL("^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$"),
    IP_ADDRESS("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
    
    
    private String regex;
    
    DataFormat(String regex){
        this.regex = regex;
    }
    
    public String getRegex(){
        return regex;
    }
}
