package com.subhajit.Medicare.Config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.web.cors.CorsConfiguration;

/**
 * Bean definitions for {@link CorsConfig}.
 */
public class CorsConfig__BeanDefinitions {
  /**
   * Get the bean definition for 'corsConfig'.
   */
  public static BeanDefinition getCorsConfigBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CorsConfig.class);
    beanDefinition.setTargetType(CorsConfig.class);
    ConfigurationClassUtils.initializeConfigurationClass(CorsConfig.class);
    beanDefinition.setInstanceSupplier(CorsConfig$$SpringCGLIB$$0::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'getCorsConfiguration'.
   */
  private static BeanInstanceSupplier<CorsConfiguration> getGetCorsConfigurationInstanceSupplier() {
    return BeanInstanceSupplier.<CorsConfiguration>forFactoryMethod(CorsConfig.class, "getCorsConfiguration", HttpServletRequest.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(CorsConfig.class).getCorsConfiguration(args.get(0)));
  }

  /**
   * Get the bean definition for 'getCorsConfiguration'.
   */
  public static BeanDefinition getGetCorsConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(CorsConfiguration.class);
    beanDefinition.setInstanceSupplier(getGetCorsConfigurationInstanceSupplier());
    return beanDefinition;
  }
}
