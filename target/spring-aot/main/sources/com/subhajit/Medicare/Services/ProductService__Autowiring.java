package com.subhajit.Medicare.Services;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ProductService}.
 */
public class ProductService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ProductService apply(RegisteredBean registeredBean, ProductService instance) {
    instance.productRepository = AutowiredFieldValueResolver.forRequiredField("productRepository").resolve(registeredBean);
    instance.offerTypeRepository = AutowiredFieldValueResolver.forRequiredField("offerTypeRepository").resolve(registeredBean);
    return instance;
  }
}
