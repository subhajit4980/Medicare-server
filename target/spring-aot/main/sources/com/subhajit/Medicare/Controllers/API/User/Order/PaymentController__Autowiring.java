package com.subhajit.Medicare.Controllers.API.User.Order;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link PaymentController}.
 */
public class PaymentController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static PaymentController apply(RegisteredBean registeredBean, PaymentController instance) {
    instance.productRepository = AutowiredFieldValueResolver.forRequiredField("productRepository").resolve(registeredBean);
    instance.userRepository = AutowiredFieldValueResolver.forRequiredField("userRepository").resolve(registeredBean);
    instance.orderRepository = AutowiredFieldValueResolver.forRequiredField("orderRepository").resolve(registeredBean);
    instance.cartRepository = AutowiredFieldValueResolver.forRequiredField("cartRepository").resolve(registeredBean);
    return instance;
  }
}
