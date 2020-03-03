package oose.dea.dao;

import oose.dea.domain.Lightsaber;

import javax.enterprise.inject.Default;

// Dit is de default implementatie.
// Deze gebruikt een zogenaamde Database implementatie.
// In de webapp/WEB-INF/beans.xml heb ik aangegeven dat ik een Alternative implementatie wil gaan gebruiken.
@Default
public class LightsaberDAO implements ILightsaberDAO {
    @Override
    public Lightsaber getLightsaber() {

        //ToDo: Get data from database
        Lightsaber lightsaber = new Lightsaber();
        lightsaber.setColor("red");
        lightsaber.setSides(2);

        return lightsaber;
    }
}
