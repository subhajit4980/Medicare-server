package org.springframework.boot.autoconfigure.data.mongo;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.mongo.MongoConnectionDetails;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

/**
 * Bean definitions for {@link MongoDatabaseFactoryDependentConfiguration}.
 */
public class MongoDatabaseFactoryDependentConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'mongoDatabaseFactoryDependentConfiguration'.
   */
  public static BeanDefinition getMongoDatabaseFactoryDependentConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MongoDatabaseFactoryDependentConfiguration.class);
    beanDefinition.setInstanceSupplier(MongoDatabaseFactoryDependentConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'mongoTemplate'.
   */
  private static BeanInstanceSupplier<MongoTemplate> getMongoTemplateInstanceSupplier() {
    return BeanInstanceSupplier.<MongoTemplate>forFactoryMethod(MongoDatabaseFactoryDependentConfiguration.class, "mongoTemplate", MongoDatabaseFactory.class, MongoConverter.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(MongoDatabaseFactoryDependentConfiguration.class).mongoTemplate(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'mongoTemplate'.
   */
  public static BeanDefinition getMongoTemplateBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(MongoTemplate.class);
    beanDefinition.setInstanceSupplier(getMongoTemplateInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'mappingMongoConverter'.
   */
  private static BeanInstanceSupplier<MappingMongoConverter> getMappingMongoConverterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<MappingMongoConverter>forFactoryMethod(MongoDatabaseFactoryDependentConfiguration.class, "mappingMongoConverter", MongoDatabaseFactory.class, MongoMappingContext.class, MongoCustomConversions.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(MongoDatabaseFactoryDependentConfiguration.class).mappingMongoConverter(args.get(0), args.get(1), args.get(2)));
  }

  /**
   * Get the bean definition for 'mappingMongoConverter'.
   */
  public static BeanDefinition getMappingMongoConverterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(MappingMongoConverter.class);
    beanDefinition.setInstanceSupplier(getMappingMongoConverterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'gridFsTemplate'.
   */
  private static BeanInstanceSupplier<GridFsTemplate> getGridFsTemplateInstanceSupplier() {
    return BeanInstanceSupplier.<GridFsTemplate>forFactoryMethod(MongoDatabaseFactoryDependentConfiguration.class, "gridFsTemplate", MongoProperties.class, MongoDatabaseFactory.class, MongoTemplate.class, MongoConnectionDetails.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(MongoDatabaseFactoryDependentConfiguration.class).gridFsTemplate(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'gridFsTemplate'.
   */
  public static BeanDefinition getGridFsTemplateBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(GridFsTemplate.class);
    beanDefinition.setInstanceSupplier(getGridFsTemplateInstanceSupplier());
    return beanDefinition;
  }
}
