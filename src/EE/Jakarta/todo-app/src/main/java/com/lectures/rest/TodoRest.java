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
        return todoService.findTodoById(id);
    }

    @Path("list")
    @GET
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }

    @Path("new")
    @POST
    public Response createTodo(Todo todo) {
        //api/v1/todo/new
        var created = todoService.createTodo(todo);
        var uri = UriBuilder.fromResource(TodoRest.class).path("todo").path(created.getId().toString()).build();
        return Response.created(uri).build();
    }

    @Path("update")
    @PUT
    public Response updateTodo(Todo todo) {
        todoService.updateTodo(todo);
        return Response.ok(todo).build();
    }
}
