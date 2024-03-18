package com.subhajit.Medicare.Controllers;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link TestController}.
 */
public class TestController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static TestController apply(RegisteredBean registeredBean, TestController instance) {
    instance.userRepository = AutowiredFieldValueResolver.forRequiredField("userRepository").resolve(registeredBean);
    return instance;
  }
}
