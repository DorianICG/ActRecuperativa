package com.mycompany.principal;

/**
 *
 *VICENTE HERRERA
 *DORIAN CANALES
 * 
 */
public class Principal {

    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante();
        estudiante.createStudent(new Estudiante("pepe",1,5,4));
        estudiante.createStudent(new Estudiante("pepito",2,4,4));
        estudiante.createStudent(new Estudiante("lupe",3,3,3));
        estudiante.createStudent(new Estudiante("lupito",1,6,5));
        estudiante.createStudent(new Estudiante("lulu",2,5,5));
        estudiante.createStudent(new Estudiante("lulita",3,1,1));
        estudiante.options();
    }
}
