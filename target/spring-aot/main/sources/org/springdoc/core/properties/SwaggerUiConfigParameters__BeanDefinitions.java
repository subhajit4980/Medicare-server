package org.springdoc.core.properties;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SwaggerUiConfigParameters}.
 */
public class SwaggerUiConfigParameters__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springdoc.core.properties.SwaggerUiConfigParameters'.
   */
  private static BeanInstanceSupplier<SwaggerUiConfigParameters> getSwaggerUiConfigParametersInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SwaggerUiConfigParameters>forConstructor(SwaggerUiConfigProperties.class)
            .withGenerator((registeredBean, args) -> new SwaggerUiConfigParameters(args.get(0)));
  }

  /**
   * Get the bean definition for 'swaggerUiConfigParameters'.
   */
  public static BeanDefinition getSwaggerUiConfigParametersBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SwaggerUiConfigParameters.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getSwaggerUiConfigParametersInstanceSupplier());
    return beanDefinition;
  }
}
