package com.subhajit.Medicare.Controllers.API.Admin.Product;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ProductAdmin}.
 */
public class ProductAdmin__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ProductAdmin apply(RegisteredBean registeredBean, ProductAdmin instance) {
    instance.productService = AutowiredFieldValueResolver.forRequiredField("productService").resolve(registeredBean);
    return instance;
  }
}
