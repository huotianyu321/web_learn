# SSM整合总结

## 注解总结

- @Value 注入配置文件的变量

- @AutoWired 注入bean

---

- @Bean // 方法上的注解，用于标记方法返回一个归spring管的bean。比如JdbcConfig类中的DataSource，MyBatisConfig类中的SqlSessionFactoryBean和MapperScannerConfigurer

- @Component, @Service, @Controller

- @RestController  = @Controller + @ResponseBody // 以restful风格开发

- @GetMapping = @RequestMapping(value="", method = RequestMethod.GET)  // 其他类似

---

- @ResponseBody // 标记controller返回响应体
- @RequestBody // 标记controller的方法接受请求体传参
- @ReqeustParam("name") // 用于给请求参数起别名
- @PathVariable // 路径变量，搭配url路径参数“/{name}”

---

- @Configuration // 配置类注解， 比如加在SpringConfig类和SpringMvcConfig类上
- @PropertySource // 指定属性配置文件
- @ComponentScan("包名") // 扫描bean， SpringMvcConfig扫描Controller， SpringConfig扫描其他的

- @Import({class, class}) // 在配置类中导入其他配置，比如在SpringConfig中导入JdbcConfig。（ 也可以在JdbcConfig上加@Configuration注解并在SpringConfig中扫描JdbcConfig所在的包）

---

- @EnableWebMvc // 加载SpringMvcConfig上
- @EnableTransactionManagement // 加载SpringConfig上，开启事务管理
- @Transactional //  加在类或方法上

---

- RestControllerAdivce // 加在全局异常处理类上

- ExceptionHandler // 加载异常处理方法上，要拦截哪些异常，如何处理等

  ```java
  @RestControllerAdvice
  public class ExceptionAdvice {
      @ExceptionHandler(value = AppException.class)
      public ApiResult<String> handleException(AppException e) {
          return new ApiResult<String>(e.getCode(), e.getMessage(), null);
      }
  }
  ```

---

- 单元测试
- @RunWith(SpringJUnit4ClassRunner.class)
- @ContextConfiguration(classes = SpringConfig.class)
- @Test  // 加在测试方法上

## 注意事项

- ServletConfig类继承AbstractAnnotationConfigDispatcherServletInitializer， 作为web应用的启动类，其中覆写三个方法，指定spring的根容器配置类，servelet容器的配置类，要管理的请求映射路径

- SpringMvcConfig继承WebMvcConfigurer类，可以添加过滤器（归servlet管的操作， 处理静态资源访问， 覆写addResourceHandlers方法）和拦截器（归spring mvc管的操作，覆写addInterceptors方法）

- 自定义Interceptor类继承HandlerInterceptor类，覆写preHandle、postHandle、afterCompletion三个方法

- 自定义Advice异常处理类@RestControllerAdvice，添加异常处理方法@ExceptionHandler

  

  