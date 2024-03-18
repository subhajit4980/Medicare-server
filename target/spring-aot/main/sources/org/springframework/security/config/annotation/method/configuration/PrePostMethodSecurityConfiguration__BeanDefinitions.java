package org.springframework.security.config.annotation.method.configuration;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;

/**
 * Bean definitions for {@link PrePostMethodSecurityConfiguration}.
 */
public class PrePostMethodSecurityConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'prePostMethodSecurityConfiguration'.
   */
  public static BeanDefinition getPrePostMethodSecurityConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PrePostMethodSecurityConfiguration.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(PrePostMethodSecurityConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'preFilterAuthorizationMethodInterceptor'.
   */
  private static BeanInstanceSupplier<MethodInterceptor> getPreFilterAuthorizationMethodInterceptorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MethodInterceptor>forFactoryMethod(PrePostMethodSecurityConfiguration.class, "preFilterAuthorizationMethodInterceptor", ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ApplicationContext.class)
            .withGenerator((registeredBean, args) -> PrePostMethodSecurityConfiguration.preFilterAuthorizationMethodInterceptor(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'preFilterAuthorizationMethodInterceptor'.
   */
  public static BeanDefinition getPreFilterAuthorizationMethodInterceptorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PrePostMethodSecurityConfiguration.class);
    beanDefinition.setTargetType(MethodInterceptor.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(getPreFilterAuthorizationMethodInterceptorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'preAuthorizeAuthorizationMethodInterceptor'.
   */
  private static BeanInstanceSupplier<MethodInterceptor> getPreAuthorizeAuthorizationMethodInterceptorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MethodInterceptor>forFactoryMethod(PrePostMethodSecurityConfiguration.class, "preAuthorizeAuthorizationMethodInterceptor", ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ApplicationContext.class)
            .withGenerator((registeredBean, args) -> PrePostMethodSecurityConfiguration.preAuthorizeAuthorizationMethodInterceptor(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5)));
  }

  /**
   * Get the bean definition for 'preAuthorizeAuthorizationMethodInterceptor'.
   */
  public static BeanDefinition getPreAuthorizeAuthorizationMethodInterceptorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PrePostMethodSecurityConfiguration.class);
    beanDefinition.setTargetType(MethodInterceptor.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(getPreAuthorizeAuthorizationMethodInterceptorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'postAuthorizeAuthorizationMethodInterceptor'.
   */
  private static BeanInstanceSupplier<MethodInterceptor> getPostAuthorizeAuthorizationMethodInterceptorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MethodInterceptor>forFactoryMethod(PrePostMethodSecurityConfiguration.class, "postAuthorizeAuthorizationMethodInterceptor", ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ApplicationContext.class)
            .withGenerator((registeredBean, args) -> PrePostMethodSecurityConfiguration.postAuthorizeAuthorizationMethodInterceptor(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5)));
  }

  /**
   * Get the bean definition for 'postAuthorizeAuthorizationMethodInterceptor'.
   */
  public static BeanDefinition getPostAuthorizeAuthorizationMethodInterceptorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PrePostMethodSecurityConfiguration.class);
    beanDefinition.setTargetType(MethodInterceptor.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(getPostAuthorizeAuthorizationMethodInterceptorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'postFilterAuthorizationMethodInterceptor'.
   */
  private static BeanInstanceSupplier<MethodInterceptor> getPostFilterAuthorizationMethodInterceptorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MethodInterceptor>forFactoryMethod(PrePostMethodSecurityConfiguration.class, "postFilterAuthorizationMethodInterceptor", ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ApplicationContext.class)
            .withGenerator((registeredBean, args) -> PrePostMethodSecurityConfiguration.postFilterAuthorizationMethodInterceptor(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'postFilterAuthorizationMethodInterceptor'.
   */
  public static BeanDefinition getPostFilterAuthorizationMethodInterceptorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PrePostMethodSecurityConfiguration.class);
    beanDefinition.setTargetType(MethodInterceptor.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(getPostFilterAuthorizationMethodInterceptorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'preFilterAuthorizationAdvisor'.
   */
  private static BeanInstanceSupplier<MethodInterceptor> getPreFilterAuthorizationAdvisorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MethodInterceptor>forFactoryMethod(PrePostMethodSecurityConfiguration.class, "preFilterAuthorizationMethodInterceptor", ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ApplicationContext.class)
            .withGenerator((registeredBean, args) -> PrePostMethodSecurityConfiguration.preFilterAuthorizationMethodInterceptor(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'preFilterAuthorizationAdvisor'.
   */
  public static BeanDefinition getPreFilterAuthorizationAdvisorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PrePostMethodSecurityConfiguration.class);
    beanDefinition.setTargetType(Advisor.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(getPreFilterAuthorizationAdvisorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'preAuthorizeAuthorizationAdvisor'.
   */
  private static BeanInstanceSupplier<MethodInterceptor> getPreAuthorizeAuthorizationAdvisorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MethodInterceptor>forFactoryMethod(PrePostMethodSecurityConfiguration.class, "preAuthorizeAuthorizationMethodInterceptor", ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ApplicationContext.class)
            .withGenerator((registeredBean, args) -> PrePostMethodSecurityConfiguration.preAuthorizeAuthorizationMethodInterceptor(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5)));
  }

  /**
   * Get the bean definition for 'preAuthorizeAuthorizationAdvisor'.
   */
  public static BeanDefinition getPreAuthorizeAuthorizationAdvisorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PrePostMethodSecurityConfiguration.class);
    beanDefinition.setTargetType(Advisor.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(getPreAuthorizeAuthorizationAdvisorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'postFilterAuthorizationAdvisor'.
   */
  private static BeanInstanceSupplier<MethodInterceptor> getPostFilterAuthorizationAdvisorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MethodInterceptor>forFactoryMethod(PrePostMethodSecurityConfiguration.class, "postFilterAuthorizationMethodInterceptor", ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ApplicationContext.class)
            .withGenerator((registeredBean, args) -> PrePostMethodSecurityConfiguration.postFilterAuthorizationMethodInterceptor(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'postFilterAuthorizationAdvisor'.
   */
  public static BeanDefinition getPostFilterAuthorizationAdvisorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PrePostMethodSecurityConfiguration.class);
    beanDefinition.setTargetType(Advisor.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(getPostFilterAuthorizationAdvisorInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'postAuthorizeAuthorizationAdvisor'.
   */
  private static BeanInstanceSupplier<MethodInterceptor> getPostAuthorizeAuthorizationAdvisorInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MethodInterceptor>forFactoryMethod(PrePostMethodSecurityConfiguration.class, "postAuthorizeAuthorizationMethodInterceptor", ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ApplicationContext.class)
            .withGenerator((registeredBean, args) -> PrePostMethodSecurityConfiguration.postAuthorizeAuthorizationMethodInterceptor(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5)));
  }

  /**
   * Get the bean definition for 'postAuthorizeAuthorizationAdvisor'.
   */
  public static BeanDefinition getPostAuthorizeAuthorizationAdvisorBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PrePostMethodSecurityConfiguration.class);
    beanDefinition.setTargetType(Advisor.class);
    beanDefinition.setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
    beanDefinition.setInstanceSupplier(getPostAuthorizeAuthorizationAdvisorInstanceSupplier());
    return beanDefinition;
  }
}
