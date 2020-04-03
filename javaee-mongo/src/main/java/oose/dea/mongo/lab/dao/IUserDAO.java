package oose.dea.mongo.lab.dao;

import org.bson.Document;

import java.util.List;

public interface IUserDAO {

    List<Document> getUsers();

    void addUser();

    void updateUser();

    void deleteUser();
}
