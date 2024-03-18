package org.springdoc.webmvc.ui;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link SwaggerWelcomeWebMvc}.
 */
public class SwaggerWelcomeWebMvc__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static SwaggerWelcomeWebMvc apply(RegisteredBean registeredBean,
      SwaggerWelcomeWebMvc instance) {
    AutowiredFieldValueResolver.forRequiredField("mvcServletPath").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
