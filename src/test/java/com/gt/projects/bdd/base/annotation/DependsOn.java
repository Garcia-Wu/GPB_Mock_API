package com.gt.projects.bdd.base.annotation;

import com.gt.projects.bdd.base.utils.GherkinUtils;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class DependsOn {
    
    public static final String DEPENDS_ON_ANNOTATION_PATTERN = "@DependsOn(\\([\"']([^'\"]*+)[\"']\\)){0,1}";
    
    private String value;
    
    public static DependsOn getInstance(String tag){
    
        if(StringUtils.isBlank(tag)) return null;
        
        try{
            Pattern pattern = Pattern.compile(DEPENDS_ON_ANNOTATION_PATTERN);
            Matcher matcher = pattern.matcher(tag);
    
            if(matcher.matches()) {
                DependsOn dependsOn = new DependsOn();
                if(matcher.groupCount() > 0) {
                    dependsOn.setValue(matcher.group(2));
                }
                return dependsOn;
            }
        } catch(Exception ex){}
        
        return null;
    }
    
    public static DependsOn getInstance(Collection<String> tags){
    
        String tag = GherkinUtils.findPatternFromTags(tags, DEPENDS_ON_ANNOTATION_PATTERN);
        return getInstance(tag);
    }
}
