
package pl.polsl.report2;

import java.util.List;
import javax.ejb.Local;


/**
 * Here we specify all the methods that will be used
 * @author Kizmaz Zahid - Hernandez Raul - Grande Alvaro
 * @version 1.0
 */
@Local
public interface Report3SesionBeanLocal {
    
    /**
     * This method looks for all the Airplane objects in the database.
     * @return List of all airplanes in the database.
     */
    public List<Airplane> findAll();
    
    /**
     * This method will be used for update the Airplane information in the database.
     * @param airplane The parameter a will be updated in the database.
     * @return The updated version of the Airplane object.
     */
    public Airplane update(Airplane airplane);
    
    /**
     * This method is used for deleting an Airplane object in the database.
     * @param airplane This parameter is the one that will be searched for an airplane
     * and if it is founded it will be deleted from the database.
     */
    public void delete(Airplane airplane);
    
    /**
     * This method add an Airplane to the database.
     * @param airplane This parameter is the one that will be added to the database.
     * @return The Airplane object added to the database.
     */
    public Airplane insert(Airplane airplane);
    
    /**
     * This method finds the Airplane by its id
     * @param id The unique number of the Airplane in the database.
     * @return The Airplane that matches the id of the parameter.
     */
    public Airplane find(Integer id);
    
    /**
     * This method looks for all the Customer objects in the database.
     * @return List of all Customers in the database.
     */
    public List<Customer> findAllCustomer();
    
    /**
     * This method finds the Customer by its id
     * @param id The unique number of the Customer in the database.
     * @return The Customer that matches the id of the parameter.
     */
    public Customer findC(Integer id);
    
    /**
     * This method add an Customer to the database.
     * @param customer This parameter is the one that will be added to the database.
     * @return The Customer object added to the database.
     */
    public Customer insert(Customer customer);
    
    /**
     * This method is used for deleting an Customer object in the database.
     * @param customer This parameter is the one that will be searched for an Customer
     * and if it is founded it will be deleted from the database.
     */
    public void deleteC(Customer customer);
    
    /**
     * This method will be used for update the Customer information in the database.
     * @param customer The parameter a will be updated in the database.
     * @return The updated version of the Customer object.
     */
    public Customer updateC(Customer customer);
}
