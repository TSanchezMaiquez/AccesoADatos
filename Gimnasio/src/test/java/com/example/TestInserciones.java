package com.example;

import com.example.model.Pista;
import com.example.model.Reserva;
import com.example.model.Socio;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

public class TestInserciones {

    @Test
    void name(){
        insertPista();
        insertarSocio();
        insertcionReserva();

    }
    @Test
    void insertcionReserva(){

        Random random = new Random();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        int count =1;

        List<Pista> pistas = session.createQuery("select a from Pista a", Pista.class).getResultList();
        List<Socio> socios = session.createQuery("select a from Socio a", Socio.class).getResultList();
        Map<String, String> reservas = new HashMap<>();

        while (count<=40){
            var pista = pistas.get(random.nextInt(pistas.size()));
            var socio = socios.get(random.nextInt(socios.size()));
            reservas.put(pista.getnPista()+socio.getDni(), "");
            if (reservas.size() == count){
                var reserva = new Reserva(socio.getDni(), pista.getnPista(),
                                        FakerMetodos.fechaAntiguedadBetween(0, 10),
                                        FakerMetodos.hora(9, 18, 0, 30));
                session.persist(reserva);
                count++;
            }
        }

        session.getTransaction().commit();
        session.close();
    }

    @Test
    void insertarSocio(){
        Random random = new Random();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String[] observacionesDeSocioEnGimnasio = {
                "Asiste regularmente a clases de fitness", "Interesado en programas de entrenamiento personalizado",
                "Uso frecuente de áreas de cardio", "Registro constante de progreso",
                "Participa en eventos y desafíos del gimnasio"
        };
        var socioO = new Socio(FakerMetodos.dni(),
                FakerMetodos.generarArrayString(observacionesDeSocioEnGimnasio),
                FakerMetodos.nombre(),
                FakerMetodos.apellidos(),
                FakerMetodos.direccion(),
                FakerMetodos.fechaAntiguedadBetween(0, 10), null);
        session.persist(socioO);
        List<Socio> socios = new ArrayList<>();
        socios.add(socioO);
        int count =0;
        while (count<40){
            int insercion = random.nextInt(2);
            String posibleSocio= null;
            if (insercion==1){
                posibleSocio = socios.get(random.nextInt(socios.size())).getDni();
            }
            var socio = new Socio(FakerMetodos.dni(),
                                FakerMetodos.generarArrayString(observacionesDeSocioEnGimnasio),
                                FakerMetodos.nombre(),
                                FakerMetodos.apellidos(),
                                FakerMetodos.direccion(),
                                FakerMetodos.fechaAntiguedadBetween(0, 10), posibleSocio);
            socios.add(socio);
            socio.getAmigos().add(socio);
            session.persist(socio);
            count++;
        }

        session.getTransaction().commit();
        session.close();

    }
    @Test
    void insertPista(){

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String[] estadosDePista = {"Disponible", "En mantenimiento", "Ocupada", "Reservada", "Fuera de servicio"};

        int count =0;
        while (count<40){
            var pista = new Pista(FakerMetodos.doubleRandomIncExc(2, 1000, 2500),
                                FakerMetodos.ciudad(),
                                FakerMetodos.generarArrayString(estadosDePista));

            session.persist(pista);
            count++;
        }

        session.getTransaction().commit();
        session.close();

    }

}
