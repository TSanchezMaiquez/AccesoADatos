package com.example;

import com.example.model.*;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TestEntitys {

    @Test
    void name(){
        insertarCocineros();
        insertarPinches();
        insertarTipoPlato();
        insertarPlato();
        insertarCocinados();
        insertarAlmacen();
        insertarEstante();
        insertarIngredientes();
        generarPlatosConIngredientes();

    }
    void generarPlatosConIngredientes(){
        Random random = new Random();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =1;

        List<Ingrediente> ingredientes = session.createQuery("select a from Ingrediente a", Ingrediente.class).getResultList();
        List<Plato> platos = session.createQuery("select a from Plato a", Plato.class).getResultList();
        Map<String, String> platosconIngredientes = new HashMap<>();

        while (count<40){
            var ingrediente = ingredientes.get(random.nextInt(ingredientes.size()));
            var plato = platos.get(random.nextInt(platos.size()));
            platosconIngredientes.put(ingrediente.getId()+""+plato.getCodPlato(), "");
            if (platosconIngredientes.size() == count) {
                ingrediente.getPlatos().add(plato);
                session.merge(ingrediente);
                count++;
            }
        }

        session.getTransaction().commit();
        session.close();
    }
    void insertarEstante(){
        Random random = new Random();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Almacen> almacenes = session.createQuery("select a from Almacen a", Almacen.class).getResultList();
        int count =0;
        while (count<40){
            var almacen = almacenes.remove(random.nextInt(almacenes.size()));
            var estante = new Estante(FakerMetodos.cadenaAleatoria(3),
                                      almacen,
                                      FakerMetodos.numeroBetweenExcluyente(8, 20));
            session.persist(estante);
            count++;
        }

        session.getTransaction().commit();
        session.close();
    }
    void insertarAlmacen(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =0;
        while (count<40) {
            var almacen = new Almacen(FakerMetodos.nombre(),
                    FakerMetodos.texto());
            count++;
            session.persist(almacen);
        }
        session.getTransaction().commit();
        session.close();
    }
    void insertarIngredientes(){
        Random random = new Random();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Estante> estantes = session.createQuery("select a from Estante a", Estante.class).getResultList();
        int count =0;
        while (count<40) {
            var estante = estantes.remove(random.nextInt(estantes.size()));
            var ingrediente = new Ingrediente(FakerMetodos.nombre(),
                    FakerMetodos.doubleRandomIncExc(2, 5, 50),
                    estante,
                    FakerMetodos.numeroBetweenExcluyente(1, 20));
            count++;
            session.persist(ingrediente);
        }
        session.getTransaction().commit();
        session.close();
    }
    void insertarTipoPlato(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =0;
        while (count<40) {

            var tipoPlato = new TipoPlato(FakerMetodos.texto());
            count++;
            session.persist(tipoPlato);
        }
        session.getTransaction().commit();
        session.close();
    }
    void insertarCocinados(){
        Random random = new Random();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =1;

    List<Cocinero> cocineros = session.createQuery("select a from Cocinero a", Cocinero.class).getResultList();
    List<Plato> platos = session.createQuery("select a from Plato a", Plato.class).getResultList();
    Map<String, String> cocinados = new HashMap<>();

    while (count<40){
        var cocinero = cocineros.get(random.nextInt(cocineros.size()));
        var plato = platos.remove(random.nextInt(platos.size()));
        cocinados.put(cocinero.getDni()+plato.getCodPlato(), "");
        if (cocinados.size() == count) {
            cocinero.getPlatos().add(plato);
            session.merge(cocinero);
            count++;
        }
    }

        session.getTransaction().commit();
        session.close();
    }
    void insertarPlato(){
        Random random = new Random();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<TipoPlato> tiposDePlatos = session.createQuery("select a from TipoPlato a", TipoPlato.class).getResultList();
        int count =0;
        while (count<40) {
            var tipoPlato = tiposDePlatos.get(random.nextInt(tiposDePlatos.size()));
            var plato = new Plato(FakerMetodos.nombre(),
                                  FakerMetodos.doubleRandomIncExc(2, 6, 18),
                                  tipoPlato);
            count++;
            session.persist(plato);
        }
        session.getTransaction().commit();
        session.close();
    }
    void insertarPinches(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =0;
        while (count<40) {

            var pinche = new Pinche(FakerMetodos.stringNumLongDeterminada(8) + FakerMetodos.cadenaAleatoria(1).toUpperCase(),
                    FakerMetodos.stringNumLongDeterminada(12),
                    FakerMetodos.nombre(),
                    FakerMetodos.apellidos(),
                    FakerMetodos.fechaAntiguedadBetween(20, 65)
            );
            count++;
            session.persist(pinche);
        }
        session.getTransaction().commit();
        session.close();
    }
    void insertarCocineros(){

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =0;
        while (count<40) {

            var cocinero = new Cocinero(FakerMetodos.stringNumLongDeterminada(8) + FakerMetodos.cadenaAleatoria(1).toUpperCase(),
                    FakerMetodos.stringNumLongDeterminada(12),
                    FakerMetodos.nombre(),
                    FakerMetodos.apellidos(),
                    FakerMetodos.fechaAntiguedadBetween(10, 15)
            );
            count++;
            session.persist(cocinero);
        }
        session.getTransaction().commit();
        session.close();

    }
}
