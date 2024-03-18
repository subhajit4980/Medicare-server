package com.subhajit.Medicare.Controllers.API.User.Product;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link ProductUser}.
 */
public class ProductUser__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static ProductUser apply(RegisteredBean registeredBean, ProductUser instance) {
    instance.productRepository = AutowiredFieldValueResolver.forRequiredField("productRepository").resolve(registeredBean);
    instance.searchService = AutowiredFieldValueResolver.forRequiredField("searchService").resolve(registeredBean);
    instance.emailService = AutowiredFieldValueResolver.forRequiredField("emailService").resolve(registeredBean);
    return instance;
  }
}
