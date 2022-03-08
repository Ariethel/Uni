package model;

import java.util.*;

import static java.util.Map.*;

/**
 * A small table of banking customers for testing.
 */

public class CustomerDAO {

    private Map<String, Customer> customers = new HashMap<String, Customer>()
    {
        {
            put("id001", new Customer("id001", "Harry", "Hacker", -3456.78));
            put("id002", new Customer("id002", "Codie", "Coder", 1234.56));
            put("id003", new Customer("id003", "Polly", "Programmer", 987654.32));
        }
    };

    /**
     * Finds the customer with the given ID.
     * Returns null if there is no match.
     */

    public Customer findCustomer(String id) {
        if (id != null) {
            return customers.get(id.toLowerCase());
        } else {
            return null;
        }
    }

}


