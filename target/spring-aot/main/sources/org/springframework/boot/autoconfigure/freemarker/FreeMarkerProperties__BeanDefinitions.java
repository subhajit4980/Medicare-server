package org.springframework.boot.autoconfigure.freemarker;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FreeMarkerProperties}.
 */
public class FreeMarkerProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'freeMarkerProperties'.
   */
  public static BeanDefinition getFreeMarkerPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FreeMarkerProperties.class);
    beanDefinition.setInstanceSupplier(FreeMarkerProperties::new);
    return beanDefinition;
  }
}
