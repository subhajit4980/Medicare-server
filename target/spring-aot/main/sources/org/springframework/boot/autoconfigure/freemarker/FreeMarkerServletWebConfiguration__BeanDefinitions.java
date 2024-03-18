package org.springframework.boot.autoconfigure.freemarker;

import freemarker.template.Configuration;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * Bean definitions for {@link FreeMarkerServletWebConfiguration}.
 */
public class FreeMarkerServletWebConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.freemarker.FreeMarkerServletWebConfiguration'.
   */
  private static BeanInstanceSupplier<FreeMarkerServletWebConfiguration> getFreeMarkerServletWebConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<FreeMarkerServletWebConfiguration>forConstructor(FreeMarkerProperties.class)
            .withGenerator((registeredBean, args) -> new FreeMarkerServletWebConfiguration(args.get(0)));
  }

  /**
   * Get the bean definition for 'freeMarkerServletWebConfiguration'.
   */
  public static BeanDefinition getFreeMarkerServletWebConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FreeMarkerServletWebConfiguration.class);
    beanDefinition.setInstanceSupplier(getFreeMarkerServletWebConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'freeMarkerConfigurer'.
   */
  private static BeanInstanceSupplier<FreeMarkerConfigurer> getFreeMarkerConfigurerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<FreeMarkerConfigurer>forFactoryMethod(FreeMarkerServletWebConfiguration.class, "freeMarkerConfigurer")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(FreeMarkerServletWebConfiguration.class).freeMarkerConfigurer());
  }

  /**
   * Get the bean definition for 'freeMarkerConfigurer'.
   */
  public static BeanDefinition getFreeMarkerConfigurerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(FreeMarkerConfigurer.class);
    beanDefinition.setInstanceSupplier(getFreeMarkerConfigurerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'freeMarkerConfiguration'.
   */
  private static BeanInstanceSupplier<Configuration> getFreeMarkerConfigurationInstanceSupplier() {
    return BeanInstanceSupplier.<Configuration>forFactoryMethod(FreeMarkerServletWebConfiguration.class, "freeMarkerConfiguration", FreeMarkerConfig.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(FreeMarkerServletWebConfiguration.class).freeMarkerConfiguration(args.get(0)));
  }

  /**
   * Get the bean definition for 'freeMarkerConfiguration'.
   */
  public static BeanDefinition getFreeMarkerConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(Configuration.class);
    beanDefinition.setInstanceSupplier(getFreeMarkerConfigurationInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'freeMarkerViewResolver'.
   */
  private static BeanInstanceSupplier<FreeMarkerViewResolver> getFreeMarkerViewResolverInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<FreeMarkerViewResolver>forFactoryMethod(FreeMarkerServletWebConfiguration.class, "freeMarkerViewResolver")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(FreeMarkerServletWebConfiguration.class).freeMarkerViewResolver());
  }

  /**
   * Get the bean definition for 'freeMarkerViewResolver'.
   */
  public static BeanDefinition getFreeMarkerViewResolverBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(FreeMarkerViewResolver.class);
    beanDefinition.setInstanceSupplier(getFreeMarkerViewResolverInstanceSupplier());
    return beanDefinition;
  }
}
