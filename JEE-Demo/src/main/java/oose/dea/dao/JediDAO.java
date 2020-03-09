package oose.dea.dao;

import oose.dea.domain.Jedi;

import javax.annotation.Resource;
import javax.enterprise.inject.Default;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Dit is de default implementatie.
// Deze gebruikt een zogenaamde Database implementatie.
// In de webapp/WEB-INF/beans.xml heb ik aangegeven dat ik een Alternative implementatie wil gaan gebruiken.
@Default
public class JediDAO implements IJediDAO {

    @Resource(name = "jdbc/starwarsDB")
    DataSource dataSource;

    @Override
    public Jedi getJedi(int customerId) {
        if (customerId <= 0) {
            return null;
        }

        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM jedi WHERE customerId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Jedi jedi = new Jedi();
                jedi.setCustomerId(resultSet.getInt("customerId"));
                jedi.setName(resultSet.getString("name"));
                jedi.setDarkside(resultSet.getBoolean("darkside"));
                jedi.setRank(resultSet.getInt("rank"));

                return jedi;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
