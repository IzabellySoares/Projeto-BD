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
import ufpb.entity.Texto;

/**
 *
 * @author Izabelly
 */
public class TextoTest {
        public TextoTest() {
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
       Texto tex = new Texto();
        
        
        
        DAOJpaController instance = new DAOJpaController();
        instance.create(tex);
        
        assertEquals(instance.findEntities(Texto.class).size(), 1);
        
        assertEquals(tex, instance.findObject(tex.getId(), Texto.class));
        
        //alterar
        tex.setIdioma("Portugues");
        instance.edit(tex);
        
         assertEquals(instance.findEntities(Texto.class).size(), 1);
        
        assertEquals(tex, instance.findObject(tex.getId(), Texto.class));
        
        //get
        Texto result = (Texto) instance.findObject(tex.getId(), Texto.class);
        assertEquals(result, tex);
        
        //remover
        instance.destroy(tex.getId(), Texto.class);
        assertEquals(instance.findEntities(Texto.class).size(),0);
        
         
        
    }
    
}
