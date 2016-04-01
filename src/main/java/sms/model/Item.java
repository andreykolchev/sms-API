package sms.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Andrey on 20.02.2016.
 */
@Data
@Entity
@Table(name = "sms_item",uniqueConstraints = {
        @UniqueConstraint(columnNames = "id"),
        @UniqueConstraint(columnNames = "integration_id", name = "uk_item_integration_id")
})
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "integration_id")
    private String integrationId;

    private String description;

    @ManyToOne
    @JoinColumn(name="category_id", foreignKey = @ForeignKey(name = "fk_category_id"))
    private Category category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item instance = (Item) o;
        return Objects.equals(id, instance.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Item{");
        sb.append("id=").append(id);
        sb.append(", integrationId='").append(integrationId).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", category=").append(category.toString());
        sb.append('}');
        return sb.toString();
    }
}
