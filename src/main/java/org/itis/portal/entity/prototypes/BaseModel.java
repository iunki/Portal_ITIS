package org.itis.portal.entity.prototypes;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    protected Integer id;

    public Integer getId() {
        return this.id;
    }

    public boolean isNew() {
        return this.id == null;
    }
}