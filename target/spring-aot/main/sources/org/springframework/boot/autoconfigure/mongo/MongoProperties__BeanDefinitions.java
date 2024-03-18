package org.springframework.boot.autoconfigure.mongo;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link MongoProperties}.
 */
public class MongoProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'mongoProperties'.
   */
  public static BeanDefinition getMongoPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MongoProperties.class);
    beanDefinition.setInstanceSupplier(MongoProperties::new);
    return beanDefinition;
  }
}
