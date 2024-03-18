package org.springframework.boot.autoconfigure.mongo;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link MongoAutoConfiguration}.
 */
public class MongoAutoConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'mongoAutoConfiguration'.
   */
  public static BeanDefinition getMongoAutoConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MongoAutoConfiguration.class);
    beanDefinition.setInstanceSupplier(MongoAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'mongoConnectionDetails'.
   */
  private static BeanInstanceSupplier<PropertiesMongoConnectionDetails> getMongoConnectionDetailsInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<PropertiesMongoConnectionDetails>forFactoryMethod(MongoAutoConfiguration.class, "mongoConnectionDetails", MongoProperties.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(MongoAutoConfiguration.class).mongoConnectionDetails(args.get(0)));
  }

  /**
   * Get the bean definition for 'mongoConnectionDetails'.
   */
  public static BeanDefinition getMongoConnectionDetailsBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(PropertiesMongoConnectionDetails.class);
    beanDefinition.setInstanceSupplier(getMongoConnectionDetailsInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'mongo'.
   */
  private static BeanInstanceSupplier<MongoClient> getMongoInstanceSupplier() {
    return BeanInstanceSupplier.<MongoClient>forFactoryMethod(MongoAutoConfiguration.class, "mongo", ObjectProvider.class, MongoClientSettings.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(MongoAutoConfiguration.class).mongo(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'mongo'.
   */
  public static BeanDefinition getMongoBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(MongoClient.class);
    beanDefinition.setDestroyMethodNames("close");
    beanDefinition.setInstanceSupplier(getMongoInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link MongoAutoConfiguration.MongoClientSettingsConfiguration}.
   */
  public static class MongoClientSettingsConfiguration {
    /**
     * Get the bean definition for 'mongoClientSettingsConfiguration'.
     */
    public static BeanDefinition getMongoClientSettingsConfigurationBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition(MongoAutoConfiguration.MongoClientSettingsConfiguration.class);
      beanDefinition.setInstanceSupplier(MongoAutoConfiguration.MongoClientSettingsConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'mongoClientSettings'.
     */
    private static BeanInstanceSupplier<MongoClientSettings> getMongoClientSettingsInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<MongoClientSettings>forFactoryMethod(MongoAutoConfiguration.MongoClientSettingsConfiguration.class, "mongoClientSettings")
              .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(MongoAutoConfiguration.MongoClientSettingsConfiguration.class).mongoClientSettings());
    }

    /**
     * Get the bean definition for 'mongoClientSettings'.
     */
    public static BeanDefinition getMongoClientSettingsBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition();
      beanDefinition.setTargetType(MongoClientSettings.class);
      beanDefinition.setInstanceSupplier(getMongoClientSettingsInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'standardMongoSettingsCustomizer'.
     */
    private static BeanInstanceSupplier<StandardMongoClientSettingsBuilderCustomizer> getStandardMongoSettingsCustomizerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<StandardMongoClientSettingsBuilderCustomizer>forFactoryMethod(MongoAutoConfiguration.MongoClientSettingsConfiguration.class, "standardMongoSettingsCustomizer", MongoProperties.class, MongoConnectionDetails.class, ObjectProvider.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(MongoAutoConfiguration.MongoClientSettingsConfiguration.class).standardMongoSettingsCustomizer(args.get(0), args.get(1), args.get(2)));
    }

    /**
     * Get the bean definition for 'standardMongoSettingsCustomizer'.
     */
    public static BeanDefinition getStandardMongoSettingsCustomizerBeanDefinition() {
      RootBeanDefinition beanDefinition = new RootBeanDefinition();
      beanDefinition.setTargetType(StandardMongoClientSettingsBuilderCustomizer.class);
      beanDefinition.setInstanceSupplier(getStandardMongoSettingsCustomizerInstanceSupplier());
      return beanDefinition;
    }
  }
}
