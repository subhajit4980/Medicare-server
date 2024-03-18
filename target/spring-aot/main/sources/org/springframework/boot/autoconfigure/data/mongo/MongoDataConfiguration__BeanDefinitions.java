package org.springframework.boot.autoconfigure.data.mongo;

import com.subhajit.Medicare.Models.Address;
import com.subhajit.Medicare.Models.DTO.Cart;
import com.subhajit.Medicare.Models.DTO.OfferType;
import com.subhajit.Medicare.Models.DTO.Order;
import com.subhajit.Medicare.Models.DTO.Product;
import com.subhajit.Medicare.Models.DTO.User;
import com.subhajit.Medicare.Models.Role;
import com.subhajit.Medicare.Tokens.Token;
import java.lang.Class;
import java.util.List;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.data.domain.ManagedTypes;
import org.springframework.data.mongodb.MongoManagedTypes;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

/**
 * Bean definitions for {@link MongoDataConfiguration}.
 */
public class MongoDataConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'mongoDataConfiguration'.
   */
  public static BeanDefinition getMongoDataConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MongoDataConfiguration.class);
    beanDefinition.setInstanceSupplier(MongoDataConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance for 'mongoManagedTypes'.
   */
  private static InstanceSupplier<MongoManagedTypes> mongoManagedTypesInstance() {
    return (registeredBean ->  {
      List<Class<?>> types = List.of(Product.class, Token.class, Order.class, Address.class, Role.class, Cart.class, OfferType.class, User.class);
      ManagedTypes managedTypes = ManagedTypes.fromIterable(types);
      return MongoManagedTypes.from(managedTypes);
    } );
  }

  /**
   * Get the bean definition for 'mongoManagedTypes'.
   */
  public static BeanDefinition getMongoManagedTypesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MongoDataConfiguration.class);
    beanDefinition.setTargetType(MongoManagedTypes.class);
    beanDefinition.setInstanceSupplier(MongoDataConfiguration__BeanDefinitions.mongoManagedTypesInstance());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'mongoMappingContext'.
   */
  private static BeanInstanceSupplier<MongoMappingContext> getMongoMappingContextInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MongoMappingContext>forFactoryMethod(MongoDataConfiguration.class, "mongoMappingContext", MongoProperties.class, MongoCustomConversions.class, MongoManagedTypes.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(MongoDataConfiguration.class).mongoMappingContext(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'mongoMappingContext'.
   */
  public static BeanDefinition getMongoMappingContextBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(MongoMappingContext.class);
    beanDefinition.setInstanceSupplier(getMongoMappingContextInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'mongoCustomConversions'.
   */
  private static BeanInstanceSupplier<MongoCustomConversions> getMongoCustomConversionsInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MongoCustomConversions>forFactoryMethod(MongoDataConfiguration.class, "mongoCustomConversions")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(MongoDataConfiguration.class).mongoCustomConversions());
  }

  /**
   * Get the bean definition for 'mongoCustomConversions'.
   */
  public static BeanDefinition getMongoCustomConversionsBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(MongoCustomConversions.class);
    beanDefinition.setInstanceSupplier(getMongoCustomConversionsInstanceSupplier());
    return beanDefinition;
  }
}
