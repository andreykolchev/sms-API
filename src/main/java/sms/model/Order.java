package sms.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * Created by user on 18.02.16.
 */
@Data
@Entity
@Table(name = "sms_order",
       uniqueConstraints = {@UniqueConstraint(columnNames = "id"),
                            @UniqueConstraint(columnNames = "integration_id", name = "uk_order_integration_id")
})
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="integration_id")
    private String integrationId;

    @Column(name="date_time")
    private java.util.Date dateTime;

    private String description;

    @ManyToOne
    @JoinColumn(name = "firm_id", foreignKey = @ForeignKey(name = "fk_firm_id"))
    private Firm firm;

    @ManyToOne
    @JoinColumn(name="route_id", foreignKey = @ForeignKey(name = "fk_route_id"))
    private Route route;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<OrderRow> rows;

    private double sum;

    @Column(name = "shipping_date")
    private java.sql.Date shippingDate;

    @Column(name = "payment_date")
    private java.sql.Date paymentDate;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order instance = (Order) o;
        return Objects.equals(id, instance.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Order{");
        sb.append("id=").append(id);
        sb.append(", integrationId='").append(integrationId).append('\'');
        sb.append(", dateTime=").append(dateTime);
        sb.append(", description='").append(description).append('\'');
        sb.append(", firm=").append(firm.toString());
        sb.append(", route=").append(route.toString());
        sb.append(", sum=").append(sum);
        sb.append(", shippingDate=").append(shippingDate);
        sb.append(", paymentDate=").append(paymentDate);
        sb.append('}');
        return sb.toString();
    }
}
