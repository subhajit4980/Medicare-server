package com.subhajit.Medicare.Controllers.API.User.Cart;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link CartController}.
 */
public class CartController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static CartController apply(RegisteredBean registeredBean, CartController instance) {
    instance.cartRepository = AutowiredFieldValueResolver.forRequiredField("cartRepository").resolve(registeredBean);
    instance.cartService = AutowiredFieldValueResolver.forRequiredField("cartService").resolve(registeredBean);
    return instance;
  }
}
