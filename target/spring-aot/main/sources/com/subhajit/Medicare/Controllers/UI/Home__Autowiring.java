package com.subhajit.Medicare.Controllers.UI;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link Home}.
 */
public class Home__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static Home apply(RegisteredBean registeredBean, Home instance) {
    AutowiredFieldValueResolver.forRequiredField("myDataService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
