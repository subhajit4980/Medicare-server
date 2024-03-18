package com.subhajit.Medicare.Controllers.API.User.Cart;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CartController}.
 */
public class CartController__BeanDefinitions {
  /**
   * Get the bean definition for 'cartController'.
   */
  public static BeanDefinition getCartControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(CartController.class);
    InstanceSupplier<CartController> instanceSupplier = InstanceSupplier.using(CartController::new);
    instanceSupplier = instanceSupplier.andThen(CartController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
