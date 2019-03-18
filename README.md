## Springboot-experiment

#### JPA实例  2019.03.11

###### JPA基本映射声明方法：

@Entity

- @Entity(javax.persistence.Entity)修饰声明实体类，springboot启动时，自动扫描全部实体类，不可重名

@Table

- Name：对应关系型数据库的数据表名，默认为实体类名，**当希望实体类名称与数据表名称不同，或名称与数据库关键字冲突时使用**

###### 基本属性的映射声明：

- @Id：(javax.persistence.Id)修饰属性变量声明为主键，也可修饰主键的getter方法。
- @GeneratedValue的strategy字段声明主键生成策略
- JPA提供四种主键生成器策略
- - GenerationType.IDENTITY：自增长主键，多数数据库支持此策略(MySQL, SQL Server, PostgreSQL)
  - GenerationType.SEQUENCE：序列(Oracle)
  - GenerationType.TABLE：不依赖于数据库的具体实现，通过创建序列表维护表的主键，便于移植。
  - GenerationType.Auto：默认值。由JPA服务商选择生成策略，无法对具体数据库进行优化

- @Column
  - Name：指定该列的名字，默认名称与@column修饰的属性名相同。
  - nullable：指定该列是否允许为空，布尔型，默认值为true。
  - Length：指定该列保存数据的最大长度，默认长度225
  - **Insertable**：指定该列是否包含在JPA生成的insert语句的列的列表中，默认为true
  - **Updatable**：指定该列数否包含在JPA生成的update语句的列的列表中，默认为true
  - Unique：指定该列是否具有唯一约束，默认为false
  - **columnDefinition**：生成列时使用的SQL片段。



###### 实体对象关联对象的实现方法，映射声明

- mappedBy出现在哪，哪端放弃维护
- 在many段维护关系，one端有一个集合？？？



1. 一对多    User  1—N   Address （由多的一方维护）

   ```java
   Address  多
   @ManyToOne
   private User user;
   
   User     一
   @OneToMany(mappedBy = "user")  （放弃维护）
   private List<Address> addresses;
   ```

2. 多对多   N—N   =>   Student 1—N  Elective  N—1 Course

   ```
   Course   一
   @OneToMany(mappedBy = "course")
   private List<Elective> electiveList;
   
   Student   一
   @OneToMany(mappedBy = "student")
   private List<Elective> electiveList;
   
   Elective   多
   @ManyToOne
   private Student student;
   @ManyToOne
   private Course course;
   ```



？？？

```
@Repository 声明组件
@Transactional   声明事物
@PersistenceContext  ？？？

@Autowired   注入组件
@RunWith(SpringRunner.class)  指定测试运行器
@SpringBootTest    声明为springboot测试类，可启动测试用Springboot
```
