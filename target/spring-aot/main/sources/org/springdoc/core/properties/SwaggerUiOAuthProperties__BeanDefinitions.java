package org.springdoc.core.properties;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SwaggerUiOAuthProperties}.
 */
public class SwaggerUiOAuthProperties__BeanDefinitions {
  /**
   * Get the bean definition for 'swaggerUiOAuthProperties'.
   */
  public static BeanDefinition getSwaggerUiOAuthPropertiesBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SwaggerUiOAuthProperties.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(SwaggerUiOAuthProperties::new);
    return beanDefinition;
  }
}
