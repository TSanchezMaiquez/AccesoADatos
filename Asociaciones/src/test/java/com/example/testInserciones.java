package com.example;

import com.example.model.*;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class testInserciones {

    @Test
    void name(){

        insertarAsociacion();
        insertarPersona();
        insertarAsalariado();
        insertarSocio();
        insertarProyecto();
        insertarApoyo();
        insertarRol();
        insertarParticipa();
        insertaObjetivo();
        insetarObjetivosProyecto();

    }
    void insetarObjetivosProyecto(){
        Random random = new Random();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =1;

        List<Proyecto> proyectos = session.createQuery("select a from Proyecto a", Proyecto.class).getResultList();
        List<Objetivo> objetivos = session.createQuery("select a from Objetivo a", Objetivo.class).getResultList();
        Map<String, String> objetivosProyecto = new HashMap<>();

        while (count<40){
            var proyecto = proyectos.get(random.nextInt(proyectos.size()));
            var objetivo = objetivos.remove(random.nextInt(objetivos.size()));
            objetivosProyecto.put(proyecto.getId()+""+objetivo.getId(), "");
            if (objetivosProyecto.size() == count) {
                proyecto.getObjetivos().add(objetivo);
                session.merge(proyecto);
                count++;
            }
        }
            session.getTransaction().commit();
            session.close();
    }
    void insertaObjetivo(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =0;
        while (count<40){
            var objetivo = new Objetivo(FakerMetodos.texto());
            session.persist(objetivo);
            count++;
        }

        session.getTransaction().commit();
        session.close();
    }
    void insertarParticipa(){
        Random random = new Random();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =1;

        List<Asalariado> asalariados = session.createQuery("select a from Asalariado a", Asalariado.class).getResultList();
        List<Proyecto> proyectos = session.createQuery("select a from Proyecto a", Proyecto.class).getResultList();
        List<Rol> roles = session.createQuery("select a from Rol a", Rol.class).getResultList();
        Map<String, String> asalariadosProyectos = new HashMap<>();

        while (count<=40){
            var asalariado = asalariados.get(random.nextInt(asalariados.size()));
            var proyecto = proyectos.get(random.nextInt(proyectos.size()));
            var rol = roles.get(random.nextInt(roles.size()));
            asalariadosProyectos.put(asalariado.getNumAfil()+""+proyecto.getId(), "");
            if (asalariadosProyectos.size() == count){
                var participa = new Participa(asalariado.getNumAfil(),
                        proyecto.getId(),
                        FakerMetodos.fechaAntiguedadBetween(1, 5),
                        FakerMetodos.fechaAntiguedadBetween(0, 4),
                        rol);
                session.persist(participa);
                count++;
            }
        }

        session.getTransaction().commit();
        session.close();
    }
    void insertarRol(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =0;
        while (count<40){
            var rol = new Rol(FakerMetodos.texto());

            session.persist(rol);
            count++;
        }

        session.getTransaction().commit();
        session.close();
    }
    void insertarApoyo(){
        Random random = new Random();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =1;

        List<Socio> socios = session.createQuery("select a from Socio a", Socio.class).getResultList();
        List<Proyecto> proyectos = session.createQuery("select a from Proyecto a", Proyecto.class).getResultList();
        Map<String, String> sociosProyectos = new HashMap<>();

        while (count<=40){
            var socio = socios.get(random.nextInt(socios.size()));
            var proyecto = proyectos.get(random.nextInt(proyectos.size()));
            sociosProyectos.put(socio.getNumAfil()+""+proyecto.getId(), "");
            if (sociosProyectos.size() == count){
                var apoyo = new Apoya(socio.getNumAfil(),
                                    proyecto.getId(),
                                    FakerMetodos.fechaAntiguedadBetween(0, 5),
                                    FakerMetodos.doubleRandomIncExc(2, 20, 500));
                session.persist(apoyo);
                count++;
            }
        }

        session.getTransaction().commit();
        session.close();
    }
    void insertarProyecto(){
        Random random = new Random();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =0;
        List<Asociacion> asociaciones = session.createQuery("select a from Asociacion a", Asociacion.class).getResultList();
        while (count<40){
            var asociacion = asociaciones.get(random.nextInt(asociaciones.size()));
            var proyecto = new Proyecto(FakerMetodos.pais(),
                                        FakerMetodos.doubleRandomIncExc(2, 0, 1000),
                                        FakerMetodos.ciudad(),
                                        FakerMetodos.fechaAntiguedadBetween(0,5),
                                        FakerMetodos.numeroBetweenExcluyente(1,10),
                                        asociacion);

            session.persist(proyecto);
            count++;
        }

        session.getTransaction().commit();
        session.close();
    }
    void insertarSocio(){
        Random random = new Random();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =0;
        List<Asociacion> asociaciones = session.createQuery("select a from Asociacion a", Asociacion.class).getResultList();
        while (count<40){
            var asociacion = asociaciones.get(random.nextInt(asociaciones.size()));
            var socio = new Socio(FakerMetodos.stringNumLongDeterminada(8),
                    FakerMetodos.nombre(),
                    FakerMetodos.apellidos(),
                    FakerMetodos.direccion(),
                    asociacion,
                    FakerMetodos.fechaAntiguedadBetween(0, 5),
                    FakerMetodos.doubleRandomIncExc(2, 10, 450));

            session.persist(socio);
            count++;
        }

        session.getTransaction().commit();
        session.close();
    }
    void insertarAsalariado(){
        Random random = new Random();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =0;
        List<Asociacion> asociaciones = session.createQuery("select a from Asociacion a", Asociacion.class).getResultList();
        while (count<40){
            var asociacion = asociaciones.get(random.nextInt(asociaciones.size()));
            var asalariado = new Asalariado(FakerMetodos.stringNumLongDeterminada(8),
                    FakerMetodos.nombre(),
                    FakerMetodos.apellidos(),
                    FakerMetodos.direccion(),
                    asociacion,
                    FakerMetodos.stringNumLongDeterminada(12),
                    FakerMetodos.doubleRandomIncExc(2, 1200,2800),
                    FakerMetodos.texto(),
                    "ES"+FakerMetodos.stringNumLongDeterminada(12),
                    FakerMetodos.doubleRandomIncExc(2, 10, 450));

            session.persist(asalariado);
            count++;
        }

        session.getTransaction().commit();
        session.close();
    }
    void insertarPersona(){
        Random random = new Random();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =0;
        List<Asociacion> asociaciones = session.createQuery("select a from Asociacion a", Asociacion.class).getResultList();
        while (count<40){
            var asociacion = asociaciones.get(random.nextInt(asociaciones.size()));
            var persona = new Persona(FakerMetodos.stringNumLongDeterminada(8),
                                    FakerMetodos.nombre(),
                                    FakerMetodos.apellidos(),
                                    FakerMetodos.direccion(),
                                    asociacion);

            session.persist(persona);
            count++;
        }

        session.getTransaction().commit();
        session.close();
    }
    void insertarAsociacion(){

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =0;
        while (count<40){
        var asociacion = new Asociacion(FakerMetodos.direccion(),
                                        FakerMetodos.stringNumLongDeterminada(9),
                                        FakerMetodos.texto(),
                                        FakerMetodos.texto(),
                                        FakerMetodos.texto());

        session.persist(asociacion);
        count++;
    }

        session.getTransaction().commit();
        session.close();

    }
}
