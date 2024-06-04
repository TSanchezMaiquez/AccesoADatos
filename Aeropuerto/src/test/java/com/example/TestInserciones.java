package com.example;

import com.example.model.*;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TestInserciones {

    @Test
    void name(){

    crearPilotos();
    generarPropietarios();
    generarMecanicos();
    generarTipos();
    generarPilota();
    generarHangar();
    generarAvion();
    generarCompra();
    generarMantiene();
    generarCualifica();

    }
    void generarCualifica(){
        Random random = new Random();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =1;

        List<Mecanico> mecanicos = session.createQuery("select a from Mecanico a", Mecanico.class).getResultList();
        List<Tipo> tipos = session.createQuery("select a from Tipo a", Tipo.class).getResultList();
        Map<String, String> cualifica = new HashMap<>();

        while (count<=40){
            var mecanico = mecanicos.get(random.nextInt(mecanicos.size()));
            var tipo = tipos.get(random.nextInt(tipos.size()));
            cualifica.put(mecanico.getNss()+tipo.getModelo(), "");
            if (cualifica.size() == count){
                mecanico.getTipos().add(tipo);
                session.merge(mecanico);
                count++;
            }
        }

        session.getTransaction().commit();
        session.close();
    }
    void generarMantiene(){
        Random random = new Random();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =1;

        List<Mecanico> mecanicos = session.createQuery("select a from Mecanico a", Mecanico.class).getResultList();
        List<Avion> aviones = session.createQuery("select a from Avion a", Avion.class).getResultList();
        Map<String, String> proAviones = new HashMap<>();

        while (count<=40){
            var mecanico = mecanicos.get(random.nextInt(mecanicos.size()));
            var avion = aviones.get(random.nextInt(aviones.size()));
            proAviones.put(mecanico.getNss()+avion.getnRegistro(), "");
            if (proAviones.size() == count){
                var mantiene = new Mantiene(mecanico.getNss(),
                                            avion.getnRegistro(),
                                            FakerMetodos.stringNumLongDeterminada(2),
                                            FakerMetodos.fechaAntiguedadBetween(15,20),
                                            FakerMetodos.numeroBetweenExcluyente(0,5));
                session.persist(mantiene);
                count++;
            }

        }

        session.getTransaction().commit();
        session.close();
    }
    void generarHangar(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =0;
        while (count<40){
            var hangar = new Hangar(FakerMetodos.cadenaAleatoria(3)+FakerMetodos.stringNumLongDeterminada(3),
                                    FakerMetodos.numeroBetweenExcluyente(10000, 20000),
                                    FakerMetodos.ciudad());

            session.merge(hangar);
            count++;
        }

        session.getTransaction().commit();
        session.close();
    }
    void generarAvion(){
        Random random = new Random();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Tipo> tipos = session.createQuery("select a from Tipo a", Tipo.class).getResultList();
        List<Hangar> hangares = session.createQuery("select a from Hangar a", Hangar.class).getResultList();
        int count =0;
        while (count<40){
            var tipo =  tipos.get(random.nextInt(tipos.size()));
            var hangar =  hangares.get(random.nextInt(hangares.size()));
            var avion = new Avion(FakerMetodos.cadenaAleatoria(3)+FakerMetodos.stringNumLongDeterminada(3),
                                    FakerMetodos.stringNumLongDeterminada(5),
                                    FakerMetodos.fechaAntiguedadBetween(10,25),
                                    FakerMetodos.fechaAntiguedadBetween(15,30),
                                    FakerMetodos.fechaAntiguedadBetween(15,20),
                                    tipo,
                                    hangar);

            session.merge(avion);
            count++;
        }
        session.getTransaction().commit();
        session.close();
    }
    void generarPilota(){
        Random random = new Random();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =1;

        List<Piloto> pilotos = session.createQuery("select a from Piloto a", Piloto.class).getResultList();
        List<Tipo> tipos = session.createQuery("select a from Tipo a", Tipo.class).getResultList();
        Map<String, String> pilota = new HashMap<>();

        while (count<40){
            var piloto = pilotos.get(random.nextInt(pilotos.size()));
            var tipo = tipos.remove(random.nextInt(tipos.size()));
            pilota.put(piloto.getNss()+tipo.getModelo(), "");
            if (pilota.size() == count) {
                piloto.getTipos().add(tipo);
                session.merge(piloto);
                count++;
            }
        }

        session.getTransaction().commit();
        session.close();
    }
    void generarCompra(){
        Random random = new Random();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =1;

        List<Propietario> propietarios = session.createQuery("select a from Propietario a", Propietario.class).getResultList();
        List<Avion> aviones = session.createQuery("select a from Avion a", Avion.class).getResultList();
        Map<String, String> proAviones = new HashMap<>();

        while (count<=40){
            var propietario = propietarios.get(random.nextInt(propietarios.size()));
            var avion = aviones.get(random.nextInt(aviones.size()));
            proAviones.put(propietario.getNss()+avion.getnRegistro(), "");
            if (proAviones.size() == count){
                var compra = new Compra(propietario.getNss(), avion.getnRegistro(), FakerMetodos.fechaAntiguedadBetween(10, 15));
                session.persist(compra);
                count++;
            }

        }

        session.getTransaction().commit();
        session.close();
    }
    void crearPilotos(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =0;
        while (count<50){
            var piloto = new Piloto(FakerMetodos.stringNumLongDeterminada(12),
                    FakerMetodos.generarNombreCompleto(),
                    FakerMetodos.direccion(),
                    FakerMetodos.cadenaAleatoria(3).toUpperCase()+"-"+FakerMetodos.stringNumLongDeterminada(6));
            session.persist(piloto);
            count++;
        }

        session.getTransaction().commit();
        session.close();
    }
    void generarPropietarios(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =0;
        while (count<50){

            var propietario = new Propietario(FakerMetodos.stringNumLongDeterminada(12),
                    FakerMetodos.generarNombreCompleto(),
                    FakerMetodos.direccion(),
                    FakerMetodos.telefonos());
            session.persist(propietario);
            count++;
        }

        session.getTransaction().commit();
        session.close();
    }
    void generarMecanicos(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =0;
        while (count<50){
            String turnos [] = {"mañana", "tarde", "noche"};

            var mecanico = new Mecanico(FakerMetodos.stringNumLongDeterminada(12),
                    FakerMetodos.generarNombreCompleto(),
                    FakerMetodos.direccion(),
                    FakerMetodos.generarArrayString(turnos),
                    FakerMetodos.doubleRandomIncExc(2, 1500, 3000)
                    );
            session.persist(mecanico);
            count++;
        }

        session.getTransaction().commit();
        session.close();
    }
    void generarTipos(){

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =0;
        while (count<50){

            var tipo = new Tipo(FakerMetodos.cadenaAleatoria(3)+"-"+FakerMetodos.stringNumLongDeterminada(4),
                                FakerMetodos.doubleRandomIncExc(2, 10000, 20000),
                                FakerMetodos.numeroBetweenExcluyente(20000, 40000)
            );
            session.persist(tipo);
            count++;
        }

        session.getTransaction().commit();
        session.close();
    }
    void insertData2(){

        Session session = HibernateUtil.getSessionFactory().openSession();

        var piloto = new Piloto("123P", "pil1", "dic1", "lic1");
        var prop = new Propietario("123Pr", "pil1", "dic1", "123456789");
        var tipo = new Tipo("mod1", 2000.4, 10000);
        var hangar = new Hangar("cod1", 10000, "españa");


        session.beginTransaction();

        session.persist(hangar);
        var avion = new Avion("reg1", "1233", LocalDate.of(2000, 10, 12), LocalDate.of(1996, 1, 12), LocalDate.of(1992, 1, 12), tipo, hangar);
        var compra = new Compra(prop.getNss(), avion.getnRegistro(), LocalDate.of(1999, 1, 12));

        session.persist(tipo);
        var mecanico = new Mecanico("123M", "mec1", "dic1", "tarde", 1200.5);
        mecanico.getTipos().add(tipo);
        var mantiene = new Mantiene(mecanico.getNss(), avion.getnRegistro(), "12", LocalDate.of(2022, 2, 12), 2);
        piloto.getTipos().add(tipo);
        session.persist(piloto);
        session.persist(mecanico);
        session.persist(prop);
        session.persist(avion);
        session.persist(compra);
        session.persist(mantiene);

        session.getTransaction().commit();

    }
}
