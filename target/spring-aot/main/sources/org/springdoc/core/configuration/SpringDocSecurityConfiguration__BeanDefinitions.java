package org.springdoc.core.configuration;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SpringDocSecurityConfiguration}.
 */
public class SpringDocSecurityConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'springDocSecurityConfiguration'.
   */
  public static BeanDefinition getSpringDocSecurityConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDocSecurityConfiguration.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(SpringDocSecurityConfiguration::new);
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link SpringDocSecurityConfiguration.SpringSecurityLoginEndpointConfiguration}.
   */
  public static class SpringSecurityLoginEndpointConfiguration {
    /**
     * Get the bean instance supplier for 'org.springdoc.core.configuration.SpringDocSecurityConfiguration$SpringSecurityLoginEndpointConfiguration'.
     */
    private static BeanInstanceSupplier<SpringDocSecurityConfiguration.SpringSecurityLoginEndpointConfiguration> getSpringSecurityLoginEndpointConfigurationInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<SpringDocSecurityConfiguration.SpringSecurityLoginEndpointConfiguration>forConstructor()
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocSecurityConfiguration.class).new SpringSecurityLoginEndpointConfiguration());
    }

    /**
     * Get the bean definition for 'springSecurityLoginEndpointConfiguration'.
     */
    public static BeanDefinition getSpringSecurityLoginEndpointConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDocSecurityConfiguration.SpringSecurityLoginEndpointConfiguration.class);
      beanDefinition.setLazyInit(false);
      beanDefinition.setInstanceSupplier(getSpringSecurityLoginEndpointConfigurationInstanceSupplier());
      return beanDefinition;
    }
  }
}
