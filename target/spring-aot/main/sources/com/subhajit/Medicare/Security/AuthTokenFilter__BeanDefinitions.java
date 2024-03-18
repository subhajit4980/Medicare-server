package com.subhajit.Medicare.Security;

import com.subhajit.Medicare.Tokens.TokenRepository;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Bean definitions for {@link AuthTokenFilter}.
 */
public class AuthTokenFilter__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'authTokenFilter'.
   */
  private static BeanInstanceSupplier<AuthTokenFilter> getAuthTokenFilterInstanceSupplier() {
    return BeanInstanceSupplier.<AuthTokenFilter>forConstructor(JwtUtils.class, UserDetailsService.class, TokenRepository.class)
            .withGenerator((registeredBean, args) -> new AuthTokenFilter(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'authTokenFilter'.
   */
  public static BeanDefinition getAuthTokenFilterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AuthTokenFilter.class);
    beanDefinition.setInstanceSupplier(getAuthTokenFilterInstanceSupplier());
    return beanDefinition;
  }
}
