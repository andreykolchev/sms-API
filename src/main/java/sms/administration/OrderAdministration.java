package sms.administration;

/**
 * Created by user on 29.03.16.
 */
import org.lightadmin.api.config.AdministrationConfiguration;
import org.lightadmin.api.config.builder.EntityMetadataConfigurationUnitBuilder;
import org.lightadmin.api.config.unit.EntityMetadataConfigurationUnit;
import sms.model.Order;

public class OrderAdministration extends AdministrationConfiguration<Order> {

    @Override
    public EntityMetadataConfigurationUnit configuration(EntityMetadataConfigurationUnitBuilder configurationBuilder) {
        return configurationBuilder.nameField("description").singularName("Заказ").pluralName("Заказы").build();
    }

}