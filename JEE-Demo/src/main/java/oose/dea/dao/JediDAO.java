package oose.dea.dao;

import oose.dea.domain.Jedi;
import javax.enterprise.inject.Default;

// Dit is de default implementatie.
// Deze gebruikt een zogenaamde Database implementatie.
// In de webapp/WEB-INF/beans.xml heb ik aangegeven dat ik een Alternative implementatie wil gaan gebruiken.
@Default
public class JediDAO implements IJediDAO {
    @Override
    public Jedi getJedi(int customerId) {
        if (customerId < 0) return null;


        //ToDo: Get data from database
        Jedi jedi = new Jedi();
        jedi.setCustomerId(customerId);
        jedi.setName("JediFromDB");
        jedi.setRank(4);
        jedi.setDarkside(false);

        return jedi;
    }
}
