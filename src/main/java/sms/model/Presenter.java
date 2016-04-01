package sms.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Created by Andrey on 20.02.2016.
 */
@Data
@Entity
@Table(name = "sms_presenter", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Presenter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id", foreignKey = @ForeignKey(name = "fk_item_id"))
    private Item item;

    @NotNull
    private int priority;

    @Column(name = "image")
    private String image;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Presenter instance = (Presenter) o;
        return Objects.equals(id, instance.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
