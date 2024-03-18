package com.subhajit.Medicare.Config;

import com.subhajit.Medicare.Repository.UserRepository;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

/**
 * Bean definitions for {@link AppConfig}.
 */
public class AppConfig__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'appConfig'.
   */
  private static BeanInstanceSupplier<AppConfig> getAppConfigInstanceSupplier() {
    return BeanInstanceSupplier.<AppConfig>forConstructor(UserRepository.class)
            .withGenerator((registeredBean, args) -> new AppConfig$$SpringCGLIB$$0(args.get(0)));
  }

  /**
   * Get the bean definition for 'appConfig'.
   */
  public static BeanDefinition getAppConfigBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AppConfig.class);
    beanDefinition.setTargetType(AppConfig.class);
    ConfigurationClassUtils.initializeConfigurationClass(AppConfig.class);
    beanDefinition.setInstanceSupplier(getAppConfigInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'restTemplate'.
   */
  private static BeanInstanceSupplier<RestTemplate> getRestTemplateInstanceSupplier() {
    return BeanInstanceSupplier.<RestTemplate>forFactoryMethod(AppConfig.class, "restTemplate")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(AppConfig.class).restTemplate());
  }

  /**
   * Get the bean definition for 'restTemplate'.
   */
  public static BeanDefinition getRestTemplateBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(RestTemplate.class);
    beanDefinition.setInstanceSupplier(getRestTemplateInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'userDetailsService'.
   */
  private static BeanInstanceSupplier<UserDetailsService> getUserDetailsServiceInstanceSupplier() {
    return BeanInstanceSupplier.<UserDetailsService>forFactoryMethod(AppConfig.class, "userDetailsService")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(AppConfig.class).userDetailsService());
  }

  /**
   * Get the bean definition for 'userDetailsService'.
   */
  public static BeanDefinition getUserDetailsServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(UserDetailsService.class);
    beanDefinition.setInstanceSupplier(getUserDetailsServiceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'authenticationProvider'.
   */
  private static BeanInstanceSupplier<AuthenticationProvider> getAuthenticationProviderInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<AuthenticationProvider>forFactoryMethod(AppConfig.class, "authenticationProvider")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(AppConfig.class).authenticationProvider());
  }

  /**
   * Get the bean definition for 'authenticationProvider'.
   */
  public static BeanDefinition getAuthenticationProviderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(AuthenticationProvider.class);
    beanDefinition.setInstanceSupplier(getAuthenticationProviderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'passwordEncoder'.
   */
  private static BeanInstanceSupplier<PasswordEncoder> getPasswordEncoderInstanceSupplier() {
    return BeanInstanceSupplier.<PasswordEncoder>forFactoryMethod(AppConfig.class, "passwordEncoder")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(AppConfig.class).passwordEncoder());
  }

  /**
   * Get the bean definition for 'passwordEncoder'.
   */
  public static BeanDefinition getPasswordEncoderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(PasswordEncoder.class);
    beanDefinition.setInstanceSupplier(getPasswordEncoderInstanceSupplier());
    return beanDefinition;
  }
}
