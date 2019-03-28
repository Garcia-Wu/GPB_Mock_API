package com.gt.projects.bdd.base.annotation;

import com.gt.projects.bdd.base.utils.GherkinUtils;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class Const {
    
    public static final String CONST_ANNOTATION_PATTERN = "@[Cc]onst(\\(action=['\"]([^'\"]*+)['\"]\\)){0,1}";
    
    private String action;
    
    public static Const getInstance(String tag){
        
        if(StringUtils.isBlank(tag)) return null;
    
        try {
            Pattern pattern = Pattern.compile(CONST_ANNOTATION_PATTERN);
            Matcher matcher = pattern.matcher(tag);
            if(matcher.matches()) {
        
                Const aConst = new Const();
                if(matcher.groupCount() > 0) {
                    aConst.setAction(matcher.group(2));
                }
                return aConst;
            }
        } catch(Exception ex){}
        
        return null;
    }
    
    
    public static Const getInstance(Collection<String> tags){
        
        String tag = GherkinUtils.findPatternFromTags(tags, CONST_ANNOTATION_PATTERN);
        return getInstance(tag);
    }
}
