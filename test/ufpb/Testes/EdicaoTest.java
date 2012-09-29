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
public class EdicaoTest {

    /**
     *
     * @author Izabelly
     */
    public EdicaoTest() {
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
        Edicao edic = new Edicao(7, "122", "332");



        DAOJpaController instance = new DAOJpaController();
        instance.create(edic);

        assertEquals(instance.findEntities(Edicao.class).size(), 1);

        assertEquals(edic, instance.findObject(edic.getId(), Edicao.class));

        //alterar
        edic.setNumero("Numero da edicao alterado");
        instance.edit(edic);

        assertEquals(instance.findEntities(Edicao.class).size(), 1);

        assertEquals(edic, instance.findObject(edic.getId(), Edicao.class));

        //get
        Edicao res = (Edicao) instance.findObject(edic.getId(), Edicao.class);
        assertEquals(res, edic);

        //remover
        instance.destroy(edic.getId(), Edicao.class);
        assertEquals(instance.findEntities(Edicao.class).size(), 0);



    }
}
