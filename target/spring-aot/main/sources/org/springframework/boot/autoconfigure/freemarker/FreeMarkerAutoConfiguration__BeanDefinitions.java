package org.springframework.boot.autoconfigure.freemarker;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;

/**
 * Bean definitions for {@link FreeMarkerAutoConfiguration}.
 */
public class FreeMarkerAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration'.
   */
  private static BeanInstanceSupplier<FreeMarkerAutoConfiguration> getFreeMarkerAutoConfigurationInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<FreeMarkerAutoConfiguration>forConstructor(ApplicationContext.class, FreeMarkerProperties.class)
            .withGenerator((registeredBean, args) -> new FreeMarkerAutoConfiguration(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'freeMarkerAutoConfiguration'.
   */
  public static BeanDefinition getFreeMarkerAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(FreeMarkerAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(getFreeMarkerAutoConfigurationInstanceSupplier());
    return beanDefinition;
  }
}
