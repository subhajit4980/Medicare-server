package com.subhajit.Medicare.Services;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link Cart_Service}.
 */
public class Cart_Service__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static Cart_Service apply(RegisteredBean registeredBean, Cart_Service instance) {
    instance.cartRepository = AutowiredFieldValueResolver.forRequiredField("cartRepository").resolve(registeredBean);
    instance.productRepository = AutowiredFieldValueResolver.forRequiredField("productRepository").resolve(registeredBean);
    return instance;
  }
}
