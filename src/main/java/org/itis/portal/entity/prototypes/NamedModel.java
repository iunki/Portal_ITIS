package org.itis.portal.entity.prototypes;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class NamedModel extends BaseModel {

    @Column(name = "name", unique = false, nullable = true, length = 30)
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
