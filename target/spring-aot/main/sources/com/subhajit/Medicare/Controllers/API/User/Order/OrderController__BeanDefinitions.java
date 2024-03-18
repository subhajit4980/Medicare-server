package com.subhajit.Medicare.Controllers.API.User.Order;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link OrderController}.
 */
public class OrderController__BeanDefinitions {
  /**
   * Get the bean definition for 'orderController'.
   */
  public static BeanDefinition getOrderControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OrderController.class);
    InstanceSupplier<OrderController> instanceSupplier = InstanceSupplier.using(OrderController::new);
    instanceSupplier = instanceSupplier.andThen(OrderController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
