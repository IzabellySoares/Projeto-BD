/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ufpb.Testes;

import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import ufpb.Dao.DAOJpaController;
import static org.junit.Assert.*;
import ufpb.entity.Conteudo;
import ufpb.entity.Edicao;
import ufpb.entity.Editora;

/**
 *
 * @author Izabelly
 */
public class ConteudoTest {
    
    public ConteudoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    /**
     * Test of create method, of class DAOJpaController.
     */
    @Test
    public void testCreate() throws Exception {        
        Conteudo cont = new Conteudo(9,"O dia","Relata a vida das pessoas","Livre");
        
        
        
        DAOJpaController instance = new DAOJpaController();
        instance.create(cont);
        
        assertEquals(instance.findEntities(Conteudo.class).size(), 1);
        
        assertEquals(cont, instance.findObject(cont.getId(), Conteudo.class));
        
        //alterar
        cont.setDescricao("Descriçao alterada");
        instance.edit(cont);
        
         assertEquals(instance.findEntities(Conteudo.class).size(), 1);
        
        assertEquals(cont, instance.findObject(cont.getId(), Conteudo.class));
        
        //get
        Conteudo result = (Conteudo) instance.findObject(cont.getId(), Conteudo.class);
        assertEquals(result, cont);
        
        //remover
        instance.destroy(cont.getId(), Conteudo.class);
        assertEquals(instance.findEntities(Conteudo.class).size(),0);
        
         
        
    }
    
    
}
