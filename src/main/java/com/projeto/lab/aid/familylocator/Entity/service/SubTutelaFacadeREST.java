/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projeto.lab.aid.familylocator.Entity.service;

import com.projeto.lab.aid.familylocator.Entity.SubTutela;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Cams
 */
@Stateless
@Path("subtutela")
//@RestController
//@RequestMapping("/subtutela")
public class SubTutelaFacadeREST extends AbstractFacade<SubTutela> {

    @PersistenceContext(unitName = "Proj_FamilyLocator_UP")
    private EntityManager em;

    public SubTutelaFacadeREST() {
        super(SubTutela.class);
    }
 /*   @PostMapping()
    public ResponseEntity<Map<String, String>> crearUser(@RequestHeader(value="Accept") String acceptHeader,
            @RequestHeader(value="Authorization") String authorizationacceptHeader){
        Map<String, String> returnValue = new HashMap<>();
        returnValue.put("Accept", acceptHeader);
        returnValue.put("Authorization", authorizationacceptHeader);
    
        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }
*/
    @POST
    @Override
    @Consumes ({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void create(SubTutela entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes ({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
   // @PutMapping(path = "/{id}", produces = { "application/json" })
    public void edit(@PathParam("id") Integer id, SubTutela entity) {
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
    public SubTutela find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
     @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<SubTutela> findAll() {
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
    
    @GET
    @Path("listarUser")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<SubTutela> ListarUsers(){ 
        return super.listarTodos();
     }
    
    @GET
    @Path("search/{name}")
     @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<SubTutela> SearchString(String nc, @PathParam("name") String v){ 
        nc="name";
        return super.procurarString(nc, v);
     }
    
}
