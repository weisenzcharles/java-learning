package org.charles.springboot.mybatis.datasource.datasource;

//
//@Configuration
//@MapperScan(basePackages = "org.charles.learning.springmybatisdemo.mapper.post", sqlSessionTemplateRef = "postSqlSessionTemplate")
//public class PostDataSourceConfig {
//
//    @Bean(name = "postDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.post")
//    public DataSource postDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "postSqlSessionFactory")
//    public SqlSessionFactory postSqlSessionFactory(@Qualifier("postDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/post/*.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "postTransactionManager")
//    public DataSourceTransactionManager postTransactionManager(@Qualifier("postDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "postSqlSessionTemplate")
//    public SqlSessionTemplate postSqlSessionTemplate(@Qualifier("postSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//}