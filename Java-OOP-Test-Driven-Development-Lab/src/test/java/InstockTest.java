import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.PortUnreachableException;

public class InstockTest {
    private Instock instock;
   @Before
    public void create(){
       instock=new Instock();
   }
   @Test
    public void testAddProduct(){
       Product product=new Product("Ice cream",3000,10);
       instock.add(product);
       Assert.assertEquals(1,instock.getCount());
   }
   @Test
    public void testContains(){
       Product product=new Product("Ice cream",2000,5);
       instock.add(product);
       Assert.assertTrue(instock.contains(product));
   }
   @Test
    public void testGetCount(){
       instock.add(new Product("Ice cream",5000,3));
       Assert.assertEquals(1,instock.getCount());
   }
   @Test
    public void testGetFind(){
       Product product = new Product("Ice cream",5000, 3);
       instock.add(product);
       Product product1 = instock.find(0);

       Assert.assertNotNull(product1);
   }
   @Test
    public void testChangeQuantity(){
       Product product = new Product("Ice cream",5000,3);
       instock.add(product);
       instock.changeQuantity("Ice cream",4);

   }

}
