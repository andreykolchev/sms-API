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
@Table(name = "sms_trade_point", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id"),
        @UniqueConstraint(columnNames = "integration_id", name = "uk_trade_point_integration_id")
})
public class TradePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "integration_id")
    private String integrationId;

    private String description;

    private String contact;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String region;

    private String address;

    private Double latitude;

    private Double longitude;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradePoint instance = (TradePoint) o;
        return Objects.equals(id, instance.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
