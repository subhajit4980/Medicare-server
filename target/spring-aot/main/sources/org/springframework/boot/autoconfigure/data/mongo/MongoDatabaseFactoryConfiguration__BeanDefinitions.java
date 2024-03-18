package org.springframework.boot.autoconfigure.data.mongo;

import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.mongo.MongoConnectionDetails;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.core.ResolvableType;
import org.springframework.data.mongodb.core.MongoDatabaseFactorySupport;

/**
 * Bean definitions for {@link MongoDatabaseFactoryConfiguration}.
 */
public class MongoDatabaseFactoryConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'mongoDatabaseFactoryConfiguration'.
   */
  public static BeanDefinition getMongoDatabaseFactoryConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MongoDatabaseFactoryConfiguration.class);
    beanDefinition.setInstanceSupplier(MongoDatabaseFactoryConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'mongoDatabaseFactory'.
   */
  private static BeanInstanceSupplier<MongoDatabaseFactorySupport> getMongoDatabaseFactoryInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MongoDatabaseFactorySupport>forFactoryMethod(MongoDatabaseFactoryConfiguration.class, "mongoDatabaseFactory", MongoClient.class, MongoProperties.class, MongoConnectionDetails.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(MongoDatabaseFactoryConfiguration.class).mongoDatabaseFactory(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'mongoDatabaseFactory'.
   */
  public static BeanDefinition getMongoDatabaseFactoryBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(ResolvableType.forClass(MongoDatabaseFactorySupport.class));
    beanDefinition.setInstanceSupplier(getMongoDatabaseFactoryInstanceSupplier());
    return beanDefinition;
  }
}
