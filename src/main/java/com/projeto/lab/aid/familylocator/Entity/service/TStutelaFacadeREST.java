/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.lab.aid.familylocator.Entity.service;

import com.projeto.lab.aid.familylocator.Entity.TStutela;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Cams
 */
@Stateless
@Path("tstutela")
public class TStutelaFacadeREST extends AbstractFacade<TStutela> {

    @PersistenceContext(unitName = "Proj_FamilyLocator_UP")
    private EntityManager em;

    public TStutelaFacadeREST() {
        super(TStutela.class);
    }

    @POST
    @Override
    @Consumes ({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void create(TStutela entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes ({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void edit(@PathParam("id") Integer id, TStutela entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
     @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public TStutela find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
     @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<TStutela> findAll() {
        return super.findAll();
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
