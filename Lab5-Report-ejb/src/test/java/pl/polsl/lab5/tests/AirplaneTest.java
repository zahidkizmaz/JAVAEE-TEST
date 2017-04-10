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
import pl.polsl.report2.Airplane;
import pl.polsl.report2.Report3SesionBeanLocal;

/**
 *
 * @author
 */
public class AirplaneTest {

    private static Report3SesionBeanLocal airplaneBean;
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
        airplaneBean = (Report3SesionBeanLocal) new InitialContext(properties).lookup("Report3SesionBeanLocal");
    }

    @Test
    public void testCreate() {
        Airplane airplane = new Airplane();
        airplane.setAirplaneName("kartal");
        airplane.setPassenger(77);

        assertNull("Id should be null", airplane.getId());
        airplane = airplaneBean.insert(airplane);
        assertNotNull("Id should not be null", airplane.getId());
    }
    
    @Test
    public void testDelete(){
        Airplane airplane = new Airplane();
        airplane.setAirplaneName("kartal");
        airplane.setPassenger(77);
        assertNull("Id should be null", airplane.getId());
        airplane = airplaneBean.insert(airplane);
        assertNotNull("Id should not be null", airplane.getId());
        airplaneBean.delete(airplane);
        airplane = airplaneBean.find(airplane.getId());
        assertNull("Id should be null", airplane);
    }
    
    @Test
    public void testUpdate(){
        Airplane airplane = new Airplane();
        airplane.setAirplaneName("kartal");
        airplane.setPassenger(77);

        airplane = airplaneBean.insert(airplane); 
        assertNotNull("Id should not be null", airplane.getId());
        airplane.setAirplaneName("New name");
        airplaneBean.update(airplane);
        assertEquals(airplane.getAirplaneName(),"New name"); 
    }
    
    @Test
    public void testRetrieve(){
        Airplane airplane = new Airplane();
        airplane.setAirplaneName("kartal");
        airplane.setPassenger(77);
        airplane = airplaneBean.insert(airplane); 
        List<Airplane> airplanes = airplaneBean.findAll();
        assertTrue(airplanes.size() > 0);
                
    }
    
}
