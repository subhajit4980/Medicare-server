package com.subhajit.Medicare.Services;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link Cart_Service}.
 */
public class Cart_Service__BeanDefinitions {
  /**
   * Get the bean definition for 'cart_Service'.
   */
  public static BeanDefinition getCartServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(Cart_Service.class);
    InstanceSupplier<Cart_Service> instanceSupplier = InstanceSupplier.using(Cart_Service::new);
    instanceSupplier = instanceSupplier.andThen(Cart_Service__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
