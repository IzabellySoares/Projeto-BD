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
import ufpb.entity.Materia;

/**
 *
 * @author Izabelly
 */
public class MateriaTest {
    
    public MateriaTest() {
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
        Materia mat = new Materia("Comportamento social","A sociedade e seu dia a dia","2");
        
        
        DAOJpaController instance = new DAOJpaController();
        instance.create(mat);
        
        assertEquals(instance.findEntities(Materia.class).size(), 1);
        
        assertEquals(mat, instance.findObject(mat.getId(), Materia.class));
        
        //alterar
        mat.setTema("A sociedade atual");
        instance.edit(mat);
        
         assertEquals(instance.findEntities(Materia.class).size(), 1);
        
        assertEquals(mat, instance.findObject(mat.getId(), Materia.class));
        
        //get
        Materia result = (Materia) instance.findObject(mat.getId(), Materia.class);
        assertEquals(result, mat);
        
        //remover
        instance.destroy(mat.getId(), Materia.class);
        assertEquals(instance.findEntities(Materia.class).size(),0);
        
         
        
    }
    
    
    
}
