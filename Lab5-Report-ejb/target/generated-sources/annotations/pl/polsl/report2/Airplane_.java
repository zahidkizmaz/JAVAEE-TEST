package pl.polsl.report2;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pl.polsl.report2.Customer;

@Generated(value="EclipseLink-2.6.4.v20160829-rNA", date="2017-01-03T15:09:32")
@StaticMetamodel(Airplane.class)
public class Airplane_ { 

    public static volatile SingularAttribute<Airplane, Integer> passenger;
    public static volatile SingularAttribute<Airplane, Integer> id;
    public static volatile SingularAttribute<Airplane, String> airplaneName;
    public static volatile ListAttribute<Airplane, Customer> customer;

}