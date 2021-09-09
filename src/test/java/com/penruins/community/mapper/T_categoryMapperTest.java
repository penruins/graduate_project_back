package com.penruins.community.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.penruins.community.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class MapperTest {
  /**
   * 报错没有影响
   *
   * 也可以在mapper上添加@Repository
   */
  @Autowired
  private CategoryMapper categoryMapper;
  @Autowired
  private ArticleMapper articleMapper;
  @Autowired
  private UserMapper userMapper;
  @Autowired
  private WaterMapper waterMapper;
  @Autowired
  private ElectricityMapper electricityMapper;
  @Autowired
  private GasMapper gasMapper;
  @Autowired
  private FinanceMapper financeMapper;
  @Autowired
  private HousingFundMapper housingFundMapper;
  @Autowired
  private UserService userService;


  @Test
  void test() {
    categoryMapper.selectList(null).forEach(System.out::println);
  }

  @Test
  void testArticleMapper() {
    articleMapper.selectList(null).forEach(System.out::println);
  }
  @Test
  void testUserMapper() {
    userMapper.selectList(null).forEach(System.out::println);
  }
  @Test
  void testWaterElectricityGas() {
    waterMapper.selectList(null).forEach(System.out::println);
    electricityMapper.selectList(null).forEach(System.out::println);
    gasMapper.selectList(null).forEach(System.out::println);
    financeMapper.selectList(null).forEach(System.out::println);
    housingFundMapper.selectList(null).forEach(System.out::println);
    financeMapper.selectFinanceListPage(new Page<>(1,10)).getRecords().forEach(System.out::println);
    financeMapper.selectFinanceListViewPage(new Page<>(1,10)).getRecords().forEach(System.out::println);
  }
  @Test
  void testView() {
    waterMapper.selectWaterListViewPage(new Page<>(1,10)).getRecords().forEach(System.out::println);
    electricityMapper.selectElectricityListViewPage(new Page<>(1,10)).getRecords().forEach(System.out::println);
    gasMapper.selectGasListViewPage(new Page<>(1,10)).getRecords().forEach(System.out::println);
    housingFundMapper.selectHousingFundListViewPage(new Page<>(1,10)).getRecords().forEach(System.out::println);
    financeMapper.selectFinanceListViewPage(new Page<>(1,10)).getRecords().forEach(System.out::println);
  }

  @Test
  void testUserExists() {
    System.out.println(userService.isExists("刘翔"));
    System.out.println(userService.isExists("贾明辉"));
  }
}