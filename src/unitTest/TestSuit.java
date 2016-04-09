package unitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  FoodTest.class,
  NullFoodTest.class,
  CatagoryTest.class,
  MenuTest.class,
  AddressTest.class,
  ItemTest.class,
  OrderTest.class,
  NullOrderTest.class,
  AdminManagerTest.class,
  MenuManagerTest.class
})
public class TestSuit {   
} 