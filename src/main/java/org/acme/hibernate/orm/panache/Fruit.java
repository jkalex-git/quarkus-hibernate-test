package org.acme.hibernate.orm.panache;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import com.vladmihalcea.hibernate.type.array.ListArrayType;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;

@Entity
@Cacheable
@TypeDef(
        name = "int-array",
        typeClass = ListArrayType.class
)
public class Fruit extends PanacheEntity {

    @Column(length = 40, unique = true)
    public String name;

    @Column
    @Type(type = "int-array")
    List<Integer> codes;

    public Fruit() {
    }

    public Fruit(String name) {
        this.name = name;
    }
}
