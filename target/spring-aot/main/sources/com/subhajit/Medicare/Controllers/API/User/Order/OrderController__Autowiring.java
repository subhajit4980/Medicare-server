package com.subhajit.Medicare.Controllers.API.User.Order;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link OrderController}.
 */
public class OrderController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static OrderController apply(RegisteredBean registeredBean, OrderController instance) {
    instance.orderService = AutowiredFieldValueResolver.forRequiredField("orderService").resolve(registeredBean);
    return instance;
  }
}
