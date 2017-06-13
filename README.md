# ssm项目

> SpringBoot版本为1.5.2.RELEASE。
>
> Gradle版本为3.4.1。
>
> 集成了mybatis-spring-boot-starter能力，集成了HikariCp数据库连接池。
>
> 使用到了lombok插件，故在IDEA中开发需要开启注解能力。
>
> 
> 需手动修改application.yml文件中的spring.database.url和username,password
> 



项目实现了零代码配置。

Application.yml文件如下：

mybatis配置信息

```yaml
mybatis:
    type-aliases-package: com.avcdata.model 	// Mybatis别名目录
    mapper-locations: classpath:mapper/*.xml	// mapper.xml文件目录
    configuration:
      call-setters-on-nulls: true				// 若map中字段为空，依然保留key，value为null
```

通用Mapper配置

```Yaml
mapper:
    #通用Mapper目录
    mappers:
        - com.avcdata.util.MyMapper
    not-empty: false
    identity: MYSQL
```

Spring:datasource

```yaml
spring:
  datasource:
    url:  jdbc:mysql://localhost:3308/jdbc_db?useUnicode=true&characterEncoding=utf-8&useSSL=false
    type: com.zaxxer.hikari.HikariDataSource
    driver-class-name: com.mysql.cj.jdbc.Driver
    hikari:
      username: root
      password: new.1234
      max-lifetime: 1765000
      maximum-pool-size: 15
      minimum-idle: 2
      connection-timeout: 1765000
logging:
  # 日志打印级别配置
  config: classpath:logback-local.xml
```

UserService

在最近一条SQL之前，写如下代码，则可开启分页。

```java
// pageSize为每一页数量，pageNum为当前页
PageHelper.startPage(pageInfoParam.getPageSize(), pageInfoParam.getCurrentPage());
```

通用Mapper使用方式：

> 自己的Mapper继承MyMapper
>
> 即可直接curd

```java
        userMapper.selectAll();
        userMapper.insert(new User());
        userMapper.delete(new User());
        userMapper.updateByPrimaryKey(new User());
        return userMapper.selectAll();
```

Mybatis使用

一个Dao层的Mapper对应mapper文件夹中的xml。

namespace则为java的mapper。

其中id对应mapper的函数名。parameterType对应一个Bean，可用别名，resultType对应返回参数。

```Xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.avcdata.dao.UserMapper">

    <select id="query" parameterType="java.lang.String"
            resultType="user">
        SELECT
            username ,
            password
        FROM user
    </select>
</mapper>
```

一个Java的mapper文件

```java
package com.avcdata.dao;

import com.avcdata.model.User;
import com.avcdata.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *
 * Created by huangcheng on 2017/3/24.
 */
//继承了通用MyMapper，则可以根据Bean实现简单的增删改查
@Mapper
public interface UserMapper extends MyMapper<User> {
    List<User> query(String s);
}
```

