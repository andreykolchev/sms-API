package sms.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Andrey on 20.02.2016.
 */
@Data
@Entity
@Table(name = "sms_order_row", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class OrderRow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", foreignKey = @ForeignKey(name = "fk_order_id"))
    private Order order;

    @ManyToOne
    @JoinColumn(name = "item_id", foreignKey = @ForeignKey(name = "fk_item_id"))
    private Item item;

    private double price;

    private double quantity;

    private double sum;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRow instance = (OrderRow) o;
        return Objects.equals(id, instance.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OrderRow{");
        sb.append("id=").append(id);
        sb.append(", order=").append(order.toString());
        sb.append(", item=").append(item.toString());
        sb.append(", price=").append(price);
        sb.append(", quantity=").append(quantity);
        sb.append(", sum=").append(sum);
        sb.append('}');
        return sb.toString();
    }
}
