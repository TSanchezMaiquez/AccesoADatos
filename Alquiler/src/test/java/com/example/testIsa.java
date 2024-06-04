package com.example;

import com.example.model.*;
import com.github.javafaker.Faker;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import java.util.*;

public class testIsa {

    @Test
    void name(){
    insertarTipoCoche();
    insertarCliente();
    insertarTelefonoClientes();
    insertarMarca();
    insertCoche();
    insertarAlquiler();
    insertarDesperfectosCoches();

    }
    void insertarDesperfectosCoches(){
        String[] desperfectos = { "Abolladuras en la carrocería", "Rasguños en la pintura","Rueda pinchada",
                "Interiores sucios o manchados", "Daños en el parachoques", "Rotura de espejos retrovisores",
                "Fumar en el interior","Desgaste excesivo en los neumáticos", "Perdida de llaves",
                "Olores desagradables en el habitáculo", "Desperfectos en la tapicería",
                "Daños en el sistema de audio o entretenimiento"
        };
        Random random = new Random();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
         List<Alquiler> alquilados = session.createQuery("select a from coches_alquilados a", Alquiler.class).getResultList();
        int count = alquilados.size();
        while (count>0){
            int desperfectosRandom = random.nextInt(2)+1;
            var alquilado = alquilados.remove(random.nextInt(alquilados.size()));

            for (int i = 0; i < desperfectosRandom; i++) {
                alquilado.getDesperfectos().add(FakerMetodos.generarArrayString(desperfectos));
            }
            session.merge(alquilado);
            count--;
        }

        session.getTransaction().commit();
        session.close();
    }
    void insertarAlquiler(){
        Random random = new Random();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =1;

        List<Coche> coches = session.createQuery("select a from Coche a", Coche.class).getResultList();
        List<Cliente> clientes = session.createQuery("select a from Cliente a", Cliente.class).getResultList();
        Map<String, String> cochesAlquilados = new HashMap<>();

        while (count<=40){
            var coche = coches.get(random.nextInt(coches.size()));
            var cliente = clientes.get(random.nextInt(clientes.size()));
            cochesAlquilados.put(coche.getMatricula()+cliente.getDni(), "");
            if (cochesAlquilados.size() == count){
                int ki= (int)FakerMetodos.doubleRandomIncExc(2, 0, 10000);
                var alquiler = new Alquiler(cliente.getDni(), coche.getMatricula(),
                        FakerMetodos.fechaAntiguedadBetween(10, 12),
                        FakerMetodos.fechaAntiguedadBetween(11, 13),
                        (double)ki,
                        FakerMetodos.doubleRandomIncExc(3, ki, ki+8000));
                session.persist(alquiler);
                count++;
            }
        }

        session.getTransaction().commit();
        session.close();
    }
    void insertCoche(){
        Random random = new Random();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Marca> marcas = session.createQuery("select a from Marca a", Marca.class).getResultList();
        List<TipoCoche> tipoCoches = session.createQuery("select a from TipoCoche a", TipoCoche.class).getResultList();
        int count =0;
        while (count<40){
            var marca = marcas.get(random.nextInt(marcas.size()));
            var tipoCoche = tipoCoches.get(random.nextInt(tipoCoches.size()));
            var coche = new Coche(FakerMetodos.stringNumLongDeterminada(4)+FakerMetodos.cadenaAleatoria(3).toUpperCase(),
                    FakerMetodos.texto(),
                    FakerMetodos.stringNumLongDeterminada(12),
                    FakerMetodos.doubleRandomIncExc(2, 0, 100000), marca, tipoCoche);
            session.persist(coche);
            count++;
        }

        session.getTransaction().commit();
        session.close();
    }
    void insertarMarca(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =0;
        while (count<40){
            var marca = new Marca(FakerMetodos.texto());
            session.persist(marca);
            count++;
        }

        session.getTransaction().commit();
        session.close();
    }
    void insertarTelefonoClientes(){
        Random random = new Random();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Cliente> clientes = session.createQuery("select a from Cliente a", Cliente.class).getResultList();
        int count =clientes.size();
        while (count>0){
            int telefonosRandom = random.nextInt(2)+1;
            var cliente = clientes.remove(random.nextInt(clientes.size()));
            Set<String> telefonos = new HashSet<>();
            for (int i = 0; i < telefonosRandom; i++) {
                telefonos.add(FakerMetodos.telefonos());
            }
            cliente.setTelefono(telefonos);
            session.merge(cliente);
            count--;
        }

        session.getTransaction().commit();
        session.close();
    }
    void insertarCliente(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =0;
        while (count<40){
            var cliente = new Cliente(FakerMetodos.stringNumLongDeterminada(8)+FakerMetodos.cadenaAleatoria(1).toUpperCase(),
                    FakerMetodos.nombre(),
                    FakerMetodos.apellidos(),
                    FakerMetodos.direccion(),
                    FakerMetodos.email(),
                    FakerMetodos.fechaAntiguedadBetween(10, 15));
            session.persist(cliente);
            count++;
        }

        session.getTransaction().commit();
        session.close();
    }
    void insertarTipoCoche(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =0;
        while (count<40){
            var tipoCoche = new TipoCoche(FakerMetodos.texto());
            session.persist(tipoCoche);
            count++;
        }

        session.getTransaction().commit();
        session.close();
    }

    void insertData(){

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        var cliente = new Cliente(FakerMetodos.stringNumLongDeterminada(8)+FakerMetodos.cadenaAleatoria(1).toUpperCase(),
                                    FakerMetodos.nombre(),
                                    FakerMetodos.apellidos(),
                                    FakerMetodos.direccion(),
                                    FakerMetodos.email(),
                                    FakerMetodos.fechaAntiguedadBetween(10, 15));

        cliente.getTelefono().add("123123123");

        var marca = new Marca(FakerMetodos.texto());
        int ki= (int)FakerMetodos.doubleRandomIncExc(2, 0, 10000);


        var tipoCoche = new TipoCoche(FakerMetodos.texto());
        var coche = new Coche(FakerMetodos.stringNumLongDeterminada(4)+FakerMetodos.cadenaAleatoria(3).toUpperCase(),
                FakerMetodos.texto(),
                FakerMetodos.stringNumLongDeterminada(12),
                FakerMetodos.doubleRandomIncExc(2, 0, 100000), marca, tipoCoche);

        var alquiler = new Alquiler(cliente.getDni(), coche.getMatricula(),
                FakerMetodos.fechaAntiguedadBetween(10, 12),
                FakerMetodos.fechaAntiguedadBetween(11, 13),
                (double)ki,
                FakerMetodos.doubleRandomIncExc(3, ki, ki+8000));

        alquiler.getDesperfectos().add("arañazo puerta");
        alquiler.getDesperfectos().add("asiento conductor manchado");

        session.persist(tipoCoche);
        session.persist(marca);
        session.persist(coche);
        session.persist(cliente);
        session.persist(alquiler);
        session.getTransaction().commit();
        session.close();

    }
}
