package oose.dea.dao;

import oose.dea.domain.Lightsaber;

import javax.enterprise.inject.Alternative;

//Dit is een alternative implementatie.
//In webapp/WEB-INF/beans.xml heb ik aangegeven om deze implementatie te gebruiken in StarWars.java
@Alternative
public class LightsaberExcelDAO implements ILightsaberDAO {
    @Override
    public Lightsaber getLightsaber() {

        //ToDo: Get data from Excel
        Lightsaber lightsaber = new Lightsaber();
        lightsaber.setColor("blue");
        lightsaber.setSides(4);

        return lightsaber;
    }
}
