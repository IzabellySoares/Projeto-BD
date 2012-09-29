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
import ufpb.entity.Revista;

/**
 *
 * @author Izabelly
 */
public class RevistaTest {
    
    public RevistaTest() {
       
        
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
        Revista rev = new Revista("10,00","Hoje em dia"," Adulto", "1290");
        
        
        DAOJpaController instance = new DAOJpaController();
        instance.create(rev);
        
        assertEquals(instance.findEntities(Revista.class).size(), 1);
        
        assertEquals(rev, instance.findObject(rev.getCodigoDeBarras(), Revista.class));
        
        //alterar
       
        rev.setNome("Revista Social");
        instance.edit(rev);
        
         assertEquals(instance.findEntities(Revista.class).size(), 1);
        
        assertEquals(rev, instance.findObject(rev.getCodigoDeBarras(), Revista.class));
        
        //get
       Revista result = (Revista) instance.findObject(rev.getCodigoDeBarras(), Revista.class);
        assertEquals(result, rev);
        
        //remover
        instance.destroy(rev.getCodigoDeBarras(), Revista.class);
        assertEquals(instance.findEntities(Revista.class).size(),0);
        
        
        
    }
    
    
}
