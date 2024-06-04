package com.example;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Random;

public class FakerMetodos {
    private static Faker faker = new Faker();
    private static Random random = new Random();


    public static String generarNombreCompleto() {
        return  faker.name().fullName();
    }
    public static String generarArrayString(String cadenas[]){
        return cadenas[random.nextInt(cadenas.length)];
    }
    public static String cadenaAleatoria(int cantidad){
        int count = 0;
        String cadena = "";
        while (count < cantidad){
            cadena += faker.letterify("?");
            count++;
        }
        return cadena;
    }
    public static int numeroBetweenExcluyente(int inferior, int superior){
        return faker.number().numberBetween(inferior, superior);
    }
    public static double doubleRandomIncExc(int decimales, int inferior, int superior){
        return faker.number().randomDouble(decimales, inferior, superior);
    }
    public static String stringNumLongDeterminada(int longitud){
        return faker.number().digits(longitud);
    }
    public static String direccion(){
        return faker.address().fullAddress();
    }
    public static String ciudad(){
        return faker.address().cityName();
    }
    public static String pais(){
        return faker.address().country();
    }
    public static String telefonos(){
        return faker.phoneNumber().cellPhone();
    }
    public static LocalDate fechaAntiguedadBetween(int añosMaxima, int añosMinimos){
        return faker.date().birthday(añosMaxima, añosMinimos)
                .toInstant()
                .atZone(ZoneId.of("Europe/Madrid"))
                .toLocalDate();
    }
    public static String titulo(){
        return faker.book().title();
    }
    public static String genero(){
        return faker.book().genre();
    }
    public static LocalTime hora(int hMin, int hMax, int mMin, int mMax){
        return LocalTime.of(faker.number().numberBetween(hMin, hMax), faker.number().numberBetween(mMin, mMax));
    }
    public static String texto(){return faker.lorem().sentence();}
    public static String nombre(){
        return faker.name().firstName();
    }
    public static String apellidos(){
        return faker.name().lastName();
    }
    public static String email(){
        return faker.internet().emailAddress();
    }

    public static String dni(){
        return faker.number().digits(8)+ FakerMetodos.cadenaAleatoria(1).toUpperCase();
    }
}
