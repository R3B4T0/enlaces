/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author David Rebato
 */
public class enlacesCRUD {
    public static List<Enlaces> getEnlaces() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_enlaces_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM enlaces";
        Query q = manager.createNativeQuery(sql, Enlaces.class); //método para consultas en SQL
        List<Enlaces> enlacesBD =  q.getResultList();
        
        return enlacesBD;
    }
    
    public static void insertaEnlace(Enlaces enlace) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_enlaces_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(enlace);
        manager.getTransaction().commit();
    }
    
    public static List<Enlaces> getEnlacesPaginado(int offset, int tamanio_pagina) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_enlaces_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT * FROM Enlaces";
        Query q = manager.createNativeQuery(sql, Enlaces.class); //método para consultas en SQL
        q.setFirstResult(offset);
        q.setMaxResults(tamanio_pagina);
        List<Enlaces> enlacesBD = q.getResultList();
        
        return enlacesBD;        
    }
    
    public static int destroyEnlace(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_enlaces_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "DELETE from Enlaces e WHERE e.id = " + id;
        Query q = manager.createQuery(sql);
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate(); //para las consultas de modif. datos se usa el método executeUpdate
        manager.getTransaction().commit();
        return filasAfectadas;  
    }
    
    public static Enlaces getEnlace(int id) {  //devuelve un objeto de clase Productos
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_enlaces_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT e FROM Enlaces e WHERE e.id=" + id;
        Query q = manager.createQuery(sql, Enlaces.class); //método para consultas en SQL
        Enlaces miEnlace = (Enlaces) q.getSingleResult(); //para un único registro
        manager.close();
        return  miEnlace;
    }
       
    public static int actualizaEnlace(Enlaces miEnlace) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_enlaces_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "UPDATE Enlaces e SET e.nombre = :nombre, e.link = :link, e.tipo = :tipo WHERE e.id = :id";
        Query q = manager.createQuery(sql, Enlaces.class);
        q.setParameter("id", miEnlace.getId());
        q.setParameter("nombre", miEnlace.getNombre());
        q.setParameter("tipo", miEnlace.getTipo());
        q.setParameter("link", miEnlace.getLink());
        manager.getTransaction().begin();
        int filasAfectadas = q.executeUpdate();
        manager.getTransaction().commit();
        manager.close();
        
        return filasAfectadas;      
    }
}
