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
import ufpb.entity.Funcionario;

/**
 *
 * @author Izabelly
 */
public class FuncionarioTest {
    
    public FuncionarioTest() {
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
       Funcionario func = new Funcionario("Antonio Jose", "Rua da vila");
       
        
        
        DAOJpaController instance = new DAOJpaController();
        instance.create(func);
        
        assertEquals(instance.findEntities(Funcionario.class).size(), 1);
        
        assertEquals(func, instance.findObject(func.getCpf(), Funcionario.class));
        
        //alterar
        func.setNome("Nome alterado");
        instance.edit(func);
        
         assertEquals(instance.findEntities(Funcionario.class).size(), 1);
        
        assertEquals(func, instance.findObject(func.getCpf(), Conteudo.class));
        
        //get
       Funcionario result = (Funcionario) instance.findObject(func.getCpf(), Funcionario.class);
        assertEquals(result, func);
        
        //remover
        instance.destroy(func.getCpf(), Funcionario.class);
        assertEquals(instance.findEntities(Funcionario.class).size(),0);
        
         
        
    }
    
    
    
}
