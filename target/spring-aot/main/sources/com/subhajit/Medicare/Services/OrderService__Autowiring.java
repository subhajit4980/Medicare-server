package com.subhajit.Medicare.Services;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link OrderService}.
 */
public class OrderService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static OrderService apply(RegisteredBean registeredBean, OrderService instance) {
    instance.productRepository = AutowiredFieldValueResolver.forRequiredField("productRepository").resolve(registeredBean);
    instance.userRepository = AutowiredFieldValueResolver.forRequiredField("userRepository").resolve(registeredBean);
    instance.orderRepository = AutowiredFieldValueResolver.forRequiredField("orderRepository").resolve(registeredBean);
    instance.addressRepository = AutowiredFieldValueResolver.forRequiredField("addressRepository").resolve(registeredBean);
    return instance;
  }
}
