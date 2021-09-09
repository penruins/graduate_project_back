package com.penruins.community.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;

public class Generator {
  public static void main(String[] args) {
    AutoGenerator autoGenerator = new AutoGenerator();
    DataSourceConfig dataSourceConfig = new DataSourceConfig();
    dataSourceConfig.setDbType(DbType.MYSQL);
    dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/community?useUnicode=true&characterEncoding=UTF-8");
    dataSourceConfig.setUsername("root");
    dataSourceConfig.setPassword("mzrfviwhninayh");
    dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
    autoGenerator.setDataSource(dataSourceConfig);

    GlobalConfig globalConfig = new GlobalConfig();
    globalConfig.setOutputDir(System.getProperty("user.dir") + "/src/main/java");
    globalConfig.setOpen(false);
    globalConfig.setAuthor("penruins");
    autoGenerator.setGlobalConfig(globalConfig);

    PackageConfig packageConfig = new PackageConfig();
    packageConfig.setParent("com.penruins.community");
    packageConfig.setController("controller");
    packageConfig.setService("service");
    packageConfig.setServiceImpl("service.impl");
    packageConfig.setMapper("mapper");
    packageConfig.setEntity("entity");
    autoGenerator.setPackageInfo(packageConfig);

    StrategyConfig strategyConfig = new StrategyConfig();
    strategyConfig.setEntityLombokModel(true);
    autoGenerator.setStrategy(strategyConfig);

    autoGenerator.execute();
  }
}
