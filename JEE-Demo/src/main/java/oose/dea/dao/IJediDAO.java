package oose.dea.dao;

import oose.dea.domain.Jedi;

public interface IJediDAO {
    /**
     * Returns specified Jedi based on customerId
     * @param customerId the customer Id
     * @return Jedi in Database, null if not found
     */
    Jedi getJedi(int customerId);
}
