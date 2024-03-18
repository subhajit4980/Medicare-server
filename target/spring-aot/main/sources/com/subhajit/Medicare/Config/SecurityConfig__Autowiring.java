package com.subhajit.Medicare.Config;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link SecurityConfig}.
 */
public class SecurityConfig__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static SecurityConfig apply(RegisteredBean registeredBean, SecurityConfig instance) {
    instance.appConfig = AutowiredFieldValueResolver.forRequiredField("appConfig").resolve(registeredBean);
    instance.point = AutowiredFieldValueResolver.forRequiredField("point").resolve(registeredBean);
    instance.logoutHandler = AutowiredFieldValueResolver.forRequiredField("logoutHandler").resolve(registeredBean);
    instance.authTokenFilter = AutowiredFieldValueResolver.forRequiredField("authTokenFilter").resolve(registeredBean);
    return instance;
  }
}
