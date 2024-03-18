package org.springdoc.webmvc.ui;

import java.util.Optional;
import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springdoc.core.properties.SwaggerUiOAuthProperties;
import org.springdoc.core.providers.ObjectMapperProvider;
import org.springdoc.core.providers.SpringWebProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SwaggerConfig}.
 */
public class SwaggerConfig__BeanDefinitions {
  /**
   * Get the bean definition for 'swaggerConfig'.
   */
  public static BeanDefinition getSwaggerConfigBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SwaggerConfig.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(SwaggerConfig::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'swaggerWelcome'.
   */
  private static BeanInstanceSupplier<SwaggerWelcomeWebMvc> getSwaggerWelcomeInstanceSupplier() {
    return BeanInstanceSupplier.<SwaggerWelcomeWebMvc>forFactoryMethod(SwaggerConfig.class, "swaggerWelcome", SwaggerUiConfigProperties.class, SpringDocConfigProperties.class, SwaggerUiConfigParameters.class, SpringWebProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SwaggerConfig.class).swaggerWelcome(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'swaggerWelcome'.
   */
  public static BeanDefinition getSwaggerWelcomeBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(SwaggerWelcomeWebMvc.class);
    beanDefinition.setLazyInit(false);
    InstanceSupplier<SwaggerWelcomeWebMvc> instanceSupplier = getSwaggerWelcomeInstanceSupplier();
    instanceSupplier = instanceSupplier.andThen(SwaggerWelcomeWebMvc__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'swaggerConfigResource'.
   */
  private static BeanInstanceSupplier<SwaggerConfigResource> getSwaggerConfigResourceInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SwaggerConfigResource>forFactoryMethod(SwaggerConfig.class, "swaggerConfigResource", SwaggerWelcomeCommon.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SwaggerConfig.class).swaggerConfigResource(args.get(0)));
  }

  /**
   * Get the bean definition for 'swaggerConfigResource'.
   */
  public static BeanDefinition getSwaggerConfigResourceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(SwaggerConfigResource.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getSwaggerConfigResourceInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'indexPageTransformer'.
   */
  private static BeanInstanceSupplier<SwaggerIndexTransformer> getIndexPageTransformerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SwaggerIndexTransformer>forFactoryMethod(SwaggerConfig.class, "indexPageTransformer", SwaggerUiConfigProperties.class, SwaggerUiOAuthProperties.class, SwaggerUiConfigParameters.class, SwaggerWelcomeCommon.class, ObjectMapperProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SwaggerConfig.class).indexPageTransformer(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4)));
  }

  /**
   * Get the bean definition for 'indexPageTransformer'.
   */
  public static BeanDefinition getIndexPageTransformerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(SwaggerIndexTransformer.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getIndexPageTransformerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'swaggerWebMvcConfigurer'.
   */
  private static BeanInstanceSupplier<SwaggerWebMvcConfigurer> getSwaggerWebMvcConfigurerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SwaggerWebMvcConfigurer>forFactoryMethod(SwaggerConfig.class, "swaggerWebMvcConfigurer", SwaggerUiConfigParameters.class, SwaggerIndexTransformer.class, Optional.class, SwaggerResourceResolver.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SwaggerConfig.class).swaggerWebMvcConfigurer(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'swaggerWebMvcConfigurer'.
   */
  public static BeanDefinition getSwaggerWebMvcConfigurerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(SwaggerWebMvcConfigurer.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getSwaggerWebMvcConfigurerInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'swaggerResourceResolver'.
   */
  private static BeanInstanceSupplier<SwaggerResourceResolver> getSwaggerResourceResolverInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<SwaggerResourceResolver>forFactoryMethod(SwaggerConfig.class, "swaggerResourceResolver", SwaggerUiConfigProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SwaggerConfig.class).swaggerResourceResolver(args.get(0)));
  }

  /**
   * Get the bean definition for 'swaggerResourceResolver'.
   */
  public static BeanDefinition getSwaggerResourceResolverBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(SwaggerResourceResolver.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getSwaggerResourceResolverInstanceSupplier());
    return beanDefinition;
  }
}
