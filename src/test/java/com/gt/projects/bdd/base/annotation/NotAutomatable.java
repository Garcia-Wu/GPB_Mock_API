package com.gt.projects.bdd.base.annotation;

import com.gt.projects.bdd.base.utils.GherkinUtils;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class NotAutomatable {
    
    public static final String NOT_AUTOMATABLE_ANNOTATION_PATTERN = "@NotAutomatable";
    
    private String value;
    
    public static NotAutomatable getInstance(String tag){
    
        if(StringUtils.isBlank(tag)) return null;
        
        try{
            Pattern pattern = Pattern.compile(NOT_AUTOMATABLE_ANNOTATION_PATTERN);
            Matcher matcher = pattern.matcher(tag);
    
            if(matcher.matches()) {
                NotAutomatable notAutomatable = new NotAutomatable();
                return notAutomatable;
            }
        } catch(Exception ex){}
        
        return null;
    }
    
    public static NotAutomatable getInstance(Collection<String> tags){
    
        String tag = GherkinUtils.findPatternFromTags(tags, NOT_AUTOMATABLE_ANNOTATION_PATTERN);
        return getInstance(tag);
    }
}
