package com.subhajit.Medicare.Controllers.API.Authentication;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link AuthController}.
 */
public class AuthController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static AuthController apply(RegisteredBean registeredBean, AuthController instance) {
    instance.authenticationManager = AutowiredFieldValueResolver.forRequiredField("authenticationManager").resolve(registeredBean);
    instance.userRepository = AutowiredFieldValueResolver.forRequiredField("userRepository").resolve(registeredBean);
    instance.roleRepository = AutowiredFieldValueResolver.forRequiredField("roleRepository").resolve(registeredBean);
    instance.encoder = AutowiredFieldValueResolver.forRequiredField("encoder").resolve(registeredBean);
    instance.authService = AutowiredFieldValueResolver.forRequiredField("authService").resolve(registeredBean);
    instance.logoutService = AutowiredFieldValueResolver.forRequiredField("logoutService").resolve(registeredBean);
    return instance;
  }
}
