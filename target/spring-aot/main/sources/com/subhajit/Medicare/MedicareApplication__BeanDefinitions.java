package com.subhajit.Medicare;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;

/**
 * Bean definitions for {@link MedicareApplication}.
 */
public class MedicareApplication__BeanDefinitions {
  /**
   * Get the bean definition for 'medicareApplication'.
   */
  public static BeanDefinition getMedicareApplicationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MedicareApplication.class);
    beanDefinition.setTargetType(MedicareApplication.class);
    ConfigurationClassUtils.initializeConfigurationClass(MedicareApplication.class);
    beanDefinition.setInstanceSupplier(MedicareApplication$$SpringCGLIB$$0::new);
    return beanDefinition;
  }
}
