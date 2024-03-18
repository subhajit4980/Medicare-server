package com.subhajit.Medicare.Controllers.UI;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link Home}.
 */
public class Home__BeanDefinitions {
  /**
   * Get the bean definition for 'home'.
   */
  public static BeanDefinition getHomeBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(Home.class);
    InstanceSupplier<Home> instanceSupplier = InstanceSupplier.using(Home::new);
    instanceSupplier = instanceSupplier.andThen(Home__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
