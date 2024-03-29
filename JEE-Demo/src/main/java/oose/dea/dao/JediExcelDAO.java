package oose.dea.dao;

import oose.dea.domain.Jedi;
import javax.enterprise.inject.Alternative;

//Dit is een alternative implementatie.
//In webapp/WEB-INF/beans.xml heb ik aangegeven om deze implementatie te gebruiken in StarWars.java
@Alternative
public class JediExcelDAO implements IJediDAO {
    @Override
    public Jedi getJedi(int customerId) {
        if (customerId < 0) return null;


        //ToDo: Get data from Excel
        Jedi jedi = new Jedi();
        jedi.setCustomerId(customerId);
        jedi.setName("JediFromExcel");
        jedi.setRank(3);
        jedi.setDarkside(false);

        return jedi;
    }
}
