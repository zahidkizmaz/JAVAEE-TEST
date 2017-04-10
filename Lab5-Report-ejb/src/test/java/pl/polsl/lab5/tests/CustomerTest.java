package pl.polsl.lab5.tests;

import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.polsl.report2.Customer;
import pl.polsl.report2.Report3SesionBeanLocal;

/**
 *
 * @author
 */
public class CustomerTest {

    private static Report3SesionBeanLocal customerBean;
    private static Properties properties = new Properties();

    static {
        properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.LocalInitialContextFactory");

        properties.setProperty("Lab5-PU.UserName", "lab");
        properties.setProperty("Lab5-PU.Password", "lab");
        properties.setProperty("Lab5-PU.JtaManaged", "true");
        properties.setProperty("Lab5-PU", "new://Resoruce?type=DataSource");
        properties.setProperty("Lab5-PU.JdbcDriver", "com.mysql.jdbc.Driver");
        properties.setProperty("Lab5-PU.JdbcUrl", "jdbc:mysql://localhost/lab?characterEncoding=utf8");
    }

    @BeforeClass
    public static void init() throws NamingException {
        customerBean = (Report3SesionBeanLocal) new InitialContext(properties).lookup("Report3SesionBeanLocal");
    }

    @Test
    public void testCreate() {
        Customer customer = new Customer();
        customer.setName("zahid");
        customer.setLastname("kizmaz");

        assertNull("Id should be null", customer.getId());
        customer = customerBean.insert(customer);
        assertNotNull("Id should not be null", customer.getId());
    }
    
    @Test
    public void testDelete(){
        Customer customer = new Customer();
        customer.setName("zahid");
        customer.setLastname("kizmaz");
        assertNull("Id should be null", customer.getId());
        customer = customerBean.insert(customer);
        assertNotNull("Id should not be null", customer.getId());
        customerBean.deleteC(customer);
        customer = customerBean.findC(customer.getId());
        assertNull("Id should be null", customer);
    }
    
    @Test
    public void testUpdate(){
        Customer customer = new Customer();
        customer.setName("zahid");
        customer.setLastname("kizmaz");

        customer = customerBean.insert(customer); 
        assertNotNull("Id should not be null", customer.getId());
        customer.setName("New name");
        customerBean.updateC(customer);
        assertEquals(customer.getName(),"New name"); 
    }
    
    @Test
    public void testRetrieve(){
        Customer customer = new Customer();
        customer.setName("zahid");
        customer.setLastname("kizmaz");
        customer = customerBean.insert(customer); 
        List<Customer> customers = customerBean.findAllCustomer();
        assertTrue(customers.size() > 0);
                
    }
    
}
