package org.springdoc.core.configuration;

import java.util.Optional;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SpringDocUIConfiguration}.
 */
public class SpringDocUIConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springdoc.core.configuration.SpringDocUIConfiguration'.
   */
  private static BeanInstanceSupplier<SpringDocUIConfiguration> getSpringDocUIConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SpringDocUIConfiguration>forConstructor(Optional.class)
            .withGenerator((registeredBean, args) -> new SpringDocUIConfiguration(args.get(0)));
  }

  /**
   * Get the bean definition for 'springDocUIConfiguration'.
   */
  public static BeanDefinition getSpringDocUIConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDocUIConfiguration.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getSpringDocUIConfigurationInstanceSupplier());
    return beanDefinition;
  }
}
