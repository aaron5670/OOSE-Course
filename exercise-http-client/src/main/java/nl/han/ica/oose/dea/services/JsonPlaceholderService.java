package nl.han.ica.oose.dea.services;

import nl.han.ica.oose.dea.services.dtos.TodoDto;
import nl.han.ica.oose.dea.services.mappers.TodoMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Consumer;

public class JsonPlaceholderService {

    private TodoMapper todoMapper;

    public JsonPlaceholderService() {
        todoMapper = new TodoMapper();
    }

    public void getTodos() {
        var httpClient = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/todos")).build();

        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenAccept(response -> {
            //System.out.println(response.statusCode());
            //System.out.println(response.headers());
            System.out.println(response.body());
        });
    }

    public void getTodosWithCallback(Consumer<String> callback) {
        var httpClient = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/todos")).build();

        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenAccept(response -> {
            callback.accept(response.body());
        });
    }

    public void createNewTodoItemOnServer(Consumer<String> callback) {

    }

    private TodoDto createNewTodoItem(int id) {
        var todo = new TodoDto();
        todo.setId(id);
        todo.setCompleted(false);
        todo.setTitle("Finish the DEA Exercise");
        todo.setUserId(2);
        return todo;
    }
}
