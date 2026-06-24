package com.lectures.rest;

import com.lectures.entity.Todo;
import com.lectures.service.TodoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;

@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TodoRest {

    @Inject
    TodoService todoService;

    @Path("{id}")
    @GET
    public Todo getTodo(@PathParam("id") Long id) {
        // api/v1/todo/{id}
        return todoService.findTodoById(id);
    }

    @Path("list")
    @GET
    public List<Todo> getTodos() {
        // api/v1/todo/list
        return todoService.getTodos();
    }

    @Path("new")
    @POST
    public Response createTodo(Todo todo) {
        // api/v1/todo/new
        var created = todoService.createTodo(todo);
        var uri = UriBuilder.fromResource(TodoRest.class).path(created.getId().toString()).build();
        return Response.created(uri).build();
    }

    @Path("update")
    @PUT
    public Response updateTodo(Todo todo) {
        // api/v1/todo/update
        todoService.updateTodo(todo);
        return Response.ok(todo).build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteTodo(@PathParam("id") Long id) {
        // api/v1/todo/{id}
        todoService.deleteTodo(id);
        return Response.noContent().build();
    }

    @Path("status")
    @POST
    public Response markAsComplete(@QueryParam("id") Long id) {
        Todo todo = todoService.findTodoById(id);
        todo.setIsCompleted(true);
        todoService.updateTodo(todo);

        return Response.ok(todo).build();
    }
}
