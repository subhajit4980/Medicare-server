package org.springframework.boot.autoconfigure.data.mongo;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link MongoRepositoriesAutoConfiguration}.
 */
public class MongoRepositoriesAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'mongoRepositoriesAutoConfiguration'.
   */
  public static BeanDefinition getMongoRepositoriesAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MongoRepositoriesAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(MongoRepositoriesAutoConfiguration::new);
    return beanDefinition;
  }
}
