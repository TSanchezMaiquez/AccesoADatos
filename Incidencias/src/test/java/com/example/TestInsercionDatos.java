package com.example;

import com.example.model.*;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TestInsercionDatos {
private List<Usuario> usuariosIncidencias = new ArrayList<>();
    @Test
    void name(){

        insercionUsuarios();
        insertarTelefonos();
        insercionResponsable();
        insercionTecnico();
        insercionLocalizacion();
        insercionIncidencias();
        insercionTarea();
        insercionParticipa();


    }
    @Test
    void insercionIncidencias(){
        Random random = new Random();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Localizacion> localizaciones = session.createQuery("select a from Localizacion a", Localizacion.class).getResultList();
        List<Responsable> responsables = session.createQuery("select a from Responsable a", Responsable.class).getResultList();
        int count =0;
        while (count<50){
            var usuario = usuariosIncidencias.remove(random.nextInt(usuariosIncidencias.size()));
            var responsable = responsables.get(random.nextInt(responsables.size()));
            var localizacion = localizaciones.get(random.nextInt(localizaciones.size()));
            var incidencia = new Incidencia(FakerMetodos.cadenaAleatoria(2).toUpperCase()+FakerMetodos.stringNumLongDeterminada(4),
                            FakerMetodos.fechaAntiguedadBetween(1, 20),
                            FakerMetodos.fechaAntiguedadBetween(0,19),
                            FakerMetodos.texto(),
                            responsable, usuario, localizacion);
            session.persist(incidencia);
            count++;
        }

        session.getTransaction().commit();
        session.close();

    }
    @Test
    void insercionLocalizacion(){
        List<Localizacion> localizaciones = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        var localizacionOrigen = new Localizacion(FakerMetodos.cadenaAleatoria(3).toUpperCase()+FakerMetodos.stringNumLongDeterminada(3),
                FakerMetodos.texto(),
                FakerMetodos.direccion(),
                null
        );
        localizaciones.add(localizacionOrigen);
        session.persist(localizacionOrigen);
        int count =0;
        String localizacionAAñadir = null;
        Random random = new Random();

        while (count<40){
            int opcion = random.nextInt(2);
            if (opcion !=0){
                localizacionAAñadir = localizaciones.get(random.nextInt(localizaciones.size())).getCodLocalizacion();
            }
            var localizacion = new Localizacion(FakerMetodos.cadenaAleatoria(3).toUpperCase()+FakerMetodos.stringNumLongDeterminada(3),
                                            FakerMetodos.texto(),
                                            FakerMetodos.direccion(),
                                            localizacionAAñadir
                                    );
            session.persist(localizacion);
            localizaciones.add(localizacion);
            count++;
        }

        session.getTransaction().commit();
        session.close();
    }
    @Test
    void insercionParticipa(){
        Random random = new Random();
        String[] roles = {
                "Técnico de Soporte de Aplicaciones","Analista de Incidencias","Ingeniero de Soporte Técnico",
                "Especialista en Diagnóstico de Problemas","Desarrollador de Parches y Soluciones Temporales",
                "Ingeniero de Calidad de Software","Coordinador de Equipos de Resolución de Incidencias",
                "Experto en Seguridad de Aplicaciones","Líder Técnico de Incidencias",
                "Consultor de Mejora Continua en Desarrollo de Software"
        };
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =1;

        List<Tecnico> tecnicos = session.createQuery("select a from Tecnico a", Tecnico.class).getResultList();
        List<Tarea> tareas = session.createQuery("select a from Tarea a", Tarea.class).getResultList();
        Map<String, String> tareasTecnicos = new HashMap<>();

        while (count<=100){
            var tecnico = tecnicos.get(random.nextInt(tecnicos.size()));
            var tarea = tareas.get(random.nextInt(tareas.size()));
            tareasTecnicos.put(tecnico.getCodUsuario()+tarea.getNumOrden(), "");
            if (tareasTecnicos.size() == count){

                var participa = new Participa(tarea.getNumOrden(),
                                            tecnico.getCodUsuario(),
                                            FakerMetodos.fechaAntiguedadBetween(0,20),
                                            FakerMetodos.generarArrayString(roles)
                                            );
                session.persist(participa);
                count++;
            }
        }

        session.getTransaction().commit();
        session.close();
    }
    @Test
    void insercionTarea(){
        Random random = new Random();
        String[] tareas = {
                "Análisis y diagnóstico de incidencias reportadas por usuarios o equipos de prueba","Colaboración estrecha con desarrolladores para comprender y solucionar problemas de código",
                "Priorización de incidencias según su impacto en la funcionalidad y el negocio","Documentación detallada de cada incidencia, incluyendo pasos para reproducir el problema",
                "Implementación de soluciones temporales o parches rápidos para incidencias críticas","Participación en reuniones de revisión de código para prevenir futuras incidencias similares",
                "Desarrollo y mantenimiento de scripts de automatización para tareas de diagnóstico","Gestión de la comunicación con usuarios y equipos internos durante el proceso de resolución",
                "Seguimiento y actualización regular del estado de las incidencias en sistemas de seguimiento","Participación en sesiones de mejora continua para optimizar los procesos de desarrollo"
        };
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Incidencia> incidencias = session.createQuery("select a from Incidencia a", Incidencia.class).getResultList();
        int count =0;
        while (count<50){
            var incidencia = incidencias.remove(random.nextInt(incidencias.size()));
            var tarea = new Tarea(FakerMetodos.generarArrayString(tareas), incidencia);
            session.persist(tarea);
            count++;
        }

        session.getTransaction().commit();
        session.close();
    }
    @Test
    void insercionTecnico(){
        String[] especializaciones = {
                "Análisis y resolución de errores en aplicaciones Java","Debugging avanzado para identificación rápida de problemas de código",
                "Especialista en gestión de incidencias críticas","Implementación de estrategias para la mejora continua del proceso de desarrollo",
                "Experto en optimización y rendimiento de aplicaciones Java","Desarrollo de scripts y herramientas para automatizar tareas de diagnóstico",
                "Colaboración activa con equipos de desarrollo en la implementación de soluciones","Conocimiento profundo de herramientas de monitorización y registro de eventos",
                "Especialización en la identificación y corrección de vulnerabilidades de seguridad","Certificación en metodologías ágiles y prácticas DevOps"
        };
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =0;
        while (count<50){
            var tecnico = new Tecnico(FakerMetodos.cadenaAleatoria(4).toUpperCase()+"-"+FakerMetodos.stringNumLongDeterminada(4),
                    FakerMetodos.stringNumLongDeterminada(6),
                    FakerMetodos.email(),
                    FakerMetodos.email(),
                    FakerMetodos.nombre(),
                    FakerMetodos.apellidos(),
                    FakerMetodos.fechaAntiguedadBetween(0,15),
                    FakerMetodos.fechaAntiguedadBetween(0, 30),
                    FakerMetodos.generarArrayString(especializaciones)
                    );

            session.persist(tecnico);
            count++;
        }

        session.getTransaction().commit();
        session.close();

    }
    @Test
    void insercionResponsable(){
        String[] cualificaciones = {
                "Experiencia en desarrollo Java","Conocimiento sólido de estructuras de datos",
                "Habilidad para depurar y resolver problemas","Experiencia con frameworks como Spring",
                "Conocimiento de bases de datos relacionales (por ejemplo, MySQL, PostgreSQL)",
                "Familiaridad con herramientas de control de versiones (por ejemplo, Git)", "Capacidad para analizar y entender el código de otros desarrolladores",
                "Habilidades de comunicación efectiva con el equipo", "Conocimiento de metodologías ágiles (por ejemplo, Scrum)",
                "Capacidad para gestionar y priorizar incidencias de manera eficiente"
        };
        String[] descripciones = {
                "Profesional orientado a la resolución eficiente de incidencias en aplicaciones Java",
                "Experto en identificación y corrección de problemas de código", "Capacidad para analizar y comprender rápidamente el funcionamiento de sistemas complejos",
                "Colaborador proactivo en la mejora continua del desarrollo y despliegue de software","Comunicador efectivo, tanto con desarrolladores como con equipos no técnicos",
                "Gestión eficiente de prioridades para abordar y resolver incidencias críticas", "Mantenimiento y mejora constante de la calidad del código y la arquitectura del software",
                "Experiencia en coordinación con equipos de desarrollo y operaciones (DevOps)", "Habilidad para trabajar bajo presión y cumplir con plazos ajustados",
                "Familiaridad con herramientas de monitoreo y diagnóstico de rendimiento"
        };
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =0;
        while (count<50){
            var responsable = new Responsable(FakerMetodos.cadenaAleatoria(4).toUpperCase()+"-"+FakerMetodos.stringNumLongDeterminada(4),
                    FakerMetodos.stringNumLongDeterminada(6),
                    FakerMetodos.email(),
                    FakerMetodos.email(),
                    FakerMetodos.nombre(),
                    FakerMetodos.apellidos(),
                    FakerMetodos.fechaAntiguedadBetween(0,15),
                    FakerMetodos.generarArrayString(cualificaciones),
                    FakerMetodos.generarArrayString(descripciones));

            session.persist(responsable);
            count++;
        }

        session.getTransaction().commit();
        session.close();
    }
    @Test
    void insertarTelefonos(){
        Random random = new Random();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Usuario> usuarios = session.createQuery("select a from Usuario a", Usuario.class).getResultList();
        int count =0;
        while (count<50){
            var usuario = usuarios.remove(random.nextInt(usuarios.size()));
            var telefono = new Telefono(FakerMetodos.cadenaAleatoria(2).toUpperCase()+FakerMetodos.stringNumLongDeterminada(3),
                    FakerMetodos.telefonos(), usuario);

            session.persist(telefono);
            count++;
        }

        session.getTransaction().commit();
        session.close();

    }
    @Test
    void insercionUsuarios(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Telefono> telefonos = session.createQuery("select a from Telefono a", Telefono.class).getResultList();
        int count =0;
        while (count<50){

            var usuario = new Usuario(FakerMetodos.cadenaAleatoria(4).toUpperCase()+"-"+FakerMetodos.stringNumLongDeterminada(4),
                    FakerMetodos.stringNumLongDeterminada(6),
                    FakerMetodos.email(),
                    FakerMetodos.email(),
                    FakerMetodos.nombre(),
                    FakerMetodos.apellidos(),
                    FakerMetodos.fechaAntiguedadBetween(0,15));
            usuariosIncidencias.add(usuario);
            session.persist(usuario);
            count++;
        }

        session.getTransaction().commit();
        session.close();
    }
}

