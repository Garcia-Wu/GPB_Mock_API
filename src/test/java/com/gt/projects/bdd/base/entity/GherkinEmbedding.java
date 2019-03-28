package com.gt.projects.bdd.base.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by giotto.chow on 2/12/2018.
 */
@Data
@Entity
@ToString(exclude = "gherkinStep")
@EqualsAndHashCode(exclude = "gherkinStep")
public class GherkinEmbedding implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private Integer id;
    
    @Lob
    private byte[] data;

    @Column(length = 2000)
    private String mimeType;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH })
    @JoinColumn(name = "step_id")
    private GherkinStep gherkinStep;
    
    public static GherkinEmbedding newInstance(String mimeType, byte[] data){
        GherkinEmbedding embedding = new GherkinEmbedding();
        embedding.setData(data);
        embedding.setMimeType(mimeType);
        return embedding;
    }
}

