package com.gt.projects.bdd.base.api.entity;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by giotto.chow on 2/12/2018.
 */
@Data
public class TestApiReq {
    
    @JsonDeserialize(using = UrlDeserializer.class)
    private TestApiUrl url;
    private List<TestApiParam> header = new ArrayList<>();
    private String method;
    
    private TestApiBody body;
    
    @Data
    public static class TestApiBody{
        private String mode;
        private List<TestApiParam> unlencoded = new ArrayList<>();
        private String raw;
    }
}

class UrlDeserializer extends JsonDeserializer<TestApiUrl>{
    
    @Override
    public TestApiUrl deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        TestApiUrl result = new TestApiUrl();
        if(jsonParser.getCurrentToken() == JsonToken.VALUE_STRING){
            result.setRaw(jsonParser.getText());
        } else {
            result = deserializationContext.readValue(jsonParser, TestApiUrl.class);
        }
        return result;
    }
}