package org.springdoc.webmvc.core.configuration;

import java.util.List;
import java.util.Optional;
import org.springdoc.core.customizers.SpringDocCustomizers;
import org.springdoc.core.discoverer.SpringDocParameterNameDiscoverer;
import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springdoc.core.providers.SpringDocProviders;
import org.springdoc.core.providers.SpringWebProvider;
import org.springdoc.core.service.AbstractRequestService;
import org.springdoc.core.service.GenericParameterService;
import org.springdoc.core.service.GenericResponseService;
import org.springdoc.core.service.OperationService;
import org.springdoc.core.service.RequestBodyService;
import org.springdoc.core.utils.PropertyResolverUtils;
import org.springdoc.webmvc.api.OpenApiWebMvcResource;
import org.springdoc.webmvc.core.providers.RouterFunctionWebMvcProvider;
import org.springdoc.webmvc.core.service.RequestService;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SpringDocWebMvcConfiguration}.
 */
public class SpringDocWebMvcConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'springDocWebMvcConfiguration'.
   */
  public static BeanDefinition getSpringDocWebMvcConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDocWebMvcConfiguration.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(SpringDocWebMvcConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'openApiResource'.
   */
  private static BeanInstanceSupplier<OpenApiWebMvcResource> getOpenApiResourceInstanceSupplier() {
    return BeanInstanceSupplier.<OpenApiWebMvcResource>forFactoryMethod(SpringDocWebMvcConfiguration.class, "openApiResource", ObjectFactory.class, AbstractRequestService.class, GenericResponseService.class, OperationService.class, SpringDocConfigProperties.class, SpringDocProviders.class, SpringDocCustomizers.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocWebMvcConfiguration.class).openApiResource(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5), args.get(6)));
  }

  /**
   * Get the bean definition for 'openApiResource'.
   */
  public static BeanDefinition getOpenApiResourceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(OpenApiWebMvcResource.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getOpenApiResourceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'requestBuilder'.
   */
  private static BeanInstanceSupplier<RequestService> getRequestBuilderInstanceSupplier() {
    return BeanInstanceSupplier.<RequestService>forFactoryMethod(SpringDocWebMvcConfiguration.class, "requestBuilder", GenericParameterService.class, RequestBodyService.class, OperationService.class, Optional.class, SpringDocParameterNameDiscoverer.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocWebMvcConfiguration.class).requestBuilder(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4)));
  }

  /**
   * Get the bean definition for 'requestBuilder'.
   */
  public static BeanDefinition getRequestBuilderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(RequestService.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getRequestBuilderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'springWebProvider'.
   */
  private static BeanInstanceSupplier<SpringWebProvider> getSpringWebProviderInstanceSupplier() {
    return BeanInstanceSupplier.<SpringWebProvider>forFactoryMethod(SpringDocWebMvcConfiguration.class, "springWebProvider")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(SpringDocWebMvcConfiguration.class).springWebProvider());
  }

  /**
   * Get the bean definition for 'springWebProvider'.
   */
  public static BeanDefinition getSpringWebProviderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(SpringWebProvider.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getSpringWebProviderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'responseBuilder'.
   */
  private static BeanInstanceSupplier<GenericResponseService> getResponseBuilderInstanceSupplier() {
    return BeanInstanceSupplier.<GenericResponseService>forFactoryMethod(SpringDocWebMvcConfiguration.class, "responseBuilder", OperationService.class, List.class, SpringDocConfigProperties.class, PropertyResolverUtils.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocWebMvcConfiguration.class).responseBuilder(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'responseBuilder'.
   */
  public static BeanDefinition getResponseBuilderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(GenericResponseService.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getResponseBuilderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link SpringDocWebMvcConfiguration.SpringDocWebMvcRouterConfiguration}.
   */
  public static class SpringDocWebMvcRouterConfiguration {
    /**
     * Get the bean definition for 'springDocWebMvcRouterConfiguration'.
     */
    public static BeanDefinition getSpringDocWebMvcRouterConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDocWebMvcConfiguration.SpringDocWebMvcRouterConfiguration.class);
      beanDefinition.setInstanceSupplier(SpringDocWebMvcConfiguration.SpringDocWebMvcRouterConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'routerFunctionProvider'.
     */
    private static BeanInstanceSupplier<RouterFunctionWebMvcProvider> getRouterFunctionProviderInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<RouterFunctionWebMvcProvider>forFactoryMethod(SpringDocWebMvcConfiguration.SpringDocWebMvcRouterConfiguration.class, "routerFunctionProvider")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(SpringDocWebMvcConfiguration.SpringDocWebMvcRouterConfiguration.class).routerFunctionProvider());
    }

    /**
     * Get the bean definition for 'routerFunctionProvider'.
     */
    public static BeanDefinition getRouterFunctionProviderBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition();
      beanDefinition.setTargetType(RouterFunctionWebMvcProvider.class);
      beanDefinition.setLazyInit(false);
      beanDefinition.setInstanceSupplier(getRouterFunctionProviderInstanceSupplier());
      return beanDefinition;
    }
  }
}
