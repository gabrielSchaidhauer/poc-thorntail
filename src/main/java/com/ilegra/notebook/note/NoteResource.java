package com.ilegra.notebook.note;


import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("notes")
@RequestScoped
public class NoteResource {

    @Inject
    private NoteRepository repository;

    @Inject
    @ConfigurationValue("thorntail.test.chave")
    private String config;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(Note note) {
        return Response.status(Response.Status.CREATED).entity(repository.save(note)).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Note note) {
        return Response.status(Response.Status.CREATED).entity(repository.update(note)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.status(Response.Status.OK).entity(repository.findAll()).build();
    }

    @GET
    @Path("/{uuid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findOne(@PathParam("uuid") UUID uuid) {
        return Response.status(Response.Status.OK).entity(repository.findOne(uuid)).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(Note note) {
        repository.delete(note);
        return Response.status(Response.Status.OK).build();
    }
}
