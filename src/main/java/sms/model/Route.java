package sms.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Objects;

/**
 * Created by Andrey on 20.02.2016.
 */

@Data
@Entity
@Table(name = "sms_route", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private java.sql.Date date;

    private int priority;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_id"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "trade_point_id", foreignKey = @ForeignKey(name = "fk_trade_point_id"))
    private TradePoint tradePoint;

    @Column(name = "date_time")
    private java.util.Date dateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route instance = (Route) o;
        return Objects.equals(id, instance.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

