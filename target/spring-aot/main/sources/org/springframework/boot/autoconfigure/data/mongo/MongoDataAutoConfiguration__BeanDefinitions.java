package org.springframework.boot.autoconfigure.data.mongo;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link MongoDataAutoConfiguration}.
 */
public class MongoDataAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'mongoDataAutoConfiguration'.
   */
  public static BeanDefinition getMongoDataAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MongoDataAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(MongoDataAutoConfiguration::new);
    return beanDefinition;
  }
}
