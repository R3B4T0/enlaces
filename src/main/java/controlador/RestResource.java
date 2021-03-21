/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelo.Enlaces;
import modelo.enlacesCRUD;

/**
 * REST Web Service
 *
 * @author David Rebato
 */
@Path("rest")
public class RestResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestResource
     */
    public RestResource() {
    }

    /**
     * Retrieves representation of an instance of controlador.RestResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of RestResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
    
    @GET
    @Path("/enlace/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Enlaces getEnlaceJson(@PathParam("id") int id) {
        Enlaces miEnlace = enlacesCRUD.getEnlace(id);
        return miEnlace;
    }
    
    @GET
    @Path("/enlaces/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Enlaces> getEnlaces() {
        List<Enlaces> listaEnlaces = enlacesCRUD.getEnlaces();
        return listaEnlaces;
    }
    
    @PUT
    @Path("/enlace/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Enlaces updateEnlace(Enlaces enlace) {
        enlacesCRUD.actualizaEnlace(enlace);
        return enlace;
    }
    
    @POST
    @Path("/enlace/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Enlaces insertaEnlace(Enlaces enlace) {
        enlacesCRUD.insertaEnlace(enlace);
        return enlace;
    }
}
