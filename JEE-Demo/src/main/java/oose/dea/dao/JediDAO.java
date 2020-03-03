package oose.dea.dao;

import oose.dea.domain.Jedi;

import javax.enterprise.inject.Default;

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
