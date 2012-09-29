/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ufpb.Testes;

/**
 *
 * @author Izabelly
 */
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
public class EditoraTest {
    
    public EditoraTest() {
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
        Editora edit = new Editora(12847,"Rua nova","Editora XXX");
  
        
        DAOJpaController instance = new DAOJpaController();
        instance.create(edit);
        
        assertEquals(instance.findEntities(Editora.class).size(), 1);
        
        assertEquals(edit, instance.findObject(edit.getCnpj(), Editora.class));
        
        //alterar
        edit.setNome("XXX");
        instance.edit(edit);
        
         assertEquals(instance.findEntities(Editora.class).size(), 1);
        
        assertEquals(edit, instance.findObject(edit.getCnpj(), Editora.class));
        
        //get
        Editora result = (Editora) instance.findObject(edit.getCnpj(), Editora.class);
        assertEquals(result, edit);
        
        //remover
        instance.destroy(edit.getCnpj(), Editora.class);
        assertEquals(instance.findEntities(Editora.class).size(),0);
        
         
        
    }
    
}