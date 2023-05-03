/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.principal;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Estudiante
 */
public class Estudiante {
    private Hashtable<Integer,Estudiante>estudiantes= new Hashtable<>();
    private String nombre;
    private int edad,cantComidas, cantVerduras;

    public Estudiante() {
    }

    public Estudiante(String nombre, int edad, int cantComidas, int cantVerduras) {
        this.nombre = nombre;
        this.edad = edad;
        this.cantComidas = cantComidas;
        this.cantVerduras = cantVerduras;
    }

    public Hashtable<Integer,Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getCantComidas() {
        return cantComidas;
    }

    public int getCantVerduras() {
        return cantVerduras;
    }

    public void setEstudiantes(Hashtable<Integer,Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCantComidas(int cantComidas) {
        this.cantComidas = cantComidas;
    }

    public void setCantVerduras(int cantVerduras) {
        this.cantVerduras = cantVerduras;
    }

    
    public void options(){
        int option;
        Scanner scan = new Scanner(System.in);
        do{
            do{
                System.out.println("""
                                   JOIN A OPTION TO STUDENT:
                                   
                                   1.- CREATE
                                   2.- PRINT
                                   0.- BACK
                                   
                                   """);
                option = scan.nextInt();
                if(option<0|option>2)
                {
                    System.out.println("""
                                       
                                       OPCIÓN INGRESADA NO VÁLIDA
                                       
                                       """);
                }
            }while(option<0|option>2);
            switch(option){
                    case 1 -> createStudent();
                    case 2 -> printStudents();  
                    case 3 -> printGeneral();
                    case 0 -> System.out.print("\n\n\t------FIN-------");
                
                    default -> {
                }
            }
            System.out.print("""
                             
                             DESEA HACER ALGO MÁS?
                             1.- SI
                             0.- NO
                             
                            """);
            option = scan.nextInt();          
        }while(option!=0);
    }

    public void createStudent(){
        Scanner scan = new Scanner(System.in);
        String newName;
        int newEdad, newComidas = 0, newVerduras = 0;
        int newID = estudiantes.size()+1;
        System.out.print("Ingrese el nombre del estudiante: ");
        newName = scan.next();
        System.out.print("Ingrese la edad del estudiante: ");
        newEdad = scan.nextInt();
        if(newEdad<15 | newEdad>30){
            System.out.print("HA INGRESADO UNA EDAD NO VALIDA");
        }else{
            System.out.print("Cuanta comida consume al dia?  ");
            newComidas = scan.nextInt();
            System.out.print("Cuanta contienen verduras?  ");
            newVerduras = scan.nextInt();
            if(newVerduras > newComidas){
                System.out.print("NO PUEDE TENER CANTIDADES DE COMIDAS CON VERDURAS QUE SUPERE A LAS CANTIDADES DE COMIDA\n");
            }else{
                estudiantes.put(newID, new Estudiante(newName, newEdad, newComidas, newVerduras));
            }
        }
        
        
    }

    public boolean checkCreate(int idFound){
        for(Map.Entry estudiante : estudiantes.entrySet()){
            if(estudiante.getKey()==(Object)idFound){
                return true;
            }
        }
        return false;
    }
     
    public void printGeneral(){
        double promMejor=0, promPeor=0, promComida,catPeor=-1,catMejor=-1;
        for(int i=0; i<3;i++){
            promComida = checkProm(i)/contProm(i);
            if(promMejor<promComida){
                promMejor = promComida;
                catMejor = i;
            }
            if(promPeor>promComida){
                promMejor = promComida;
                catMejor = i;
            }
        }
        System.out.print("La PEOR categoria de estudiantes es la de ");
        if(catPeor==0){
            System.out.print("15 y 20 anyos \n");
        }else if (catPeor==1){
            System.out.print("21 y 25 anyos \n");
        }else if (catPeor==2){
            System.out.print("26 y 30 anyos \n");
        }
        System.out.print("La MEJOR categoria de estudiantes es la de ");
        if(catMejor==0){
            System.out.print("15 y 20 anyos \n");
        }else if (catMejor==1){
            System.out.print("21 y 25 anyos \n");
        }else if (catMejor==2){
            System.out.print("26 y 30 anyos \n");
        }
        promComida=0;
        for(int i=0; i<3;i++){
            if(i==0){
                promComida += checkProm(15,20);
            }else if (i==1){
                promComida += checkProm(21,25);
            }else{
                promComida += checkProm(26,30);
            }
            promComida += checkProm(i);
        }
        promComida= promComida/estudiantes.size();
        if(promComida>2){
            System.out.println("Alimentación está balanceada");
        }else{
            System.out.println("Alimentación está desbalanceada");
        }
    }
    
    public double checkProm(int i){
        int promedio=0;
        for(Integer id: estudiantes.keySet()){
                Estudiante estudiante = estudiantes.get(id);
                if(i==0&&(estudiante.edad>=15&&estudiante.edad<=20)){
                    promedio+=estudiante.cantComidas;
                }else if(i==1&&(estudiante.edad>=21&&estudiante.edad<=25)){
                    promedio+=estudiante.cantComidas;
                }else if(i==2&&(estudiante.edad>=26&&estudiante.edad<=30)){
                    promedio+=estudiante.cantComidas;
                }
        }
        return promedio;
    }
    
    public int checkProm(int min, int max){
        int promedio=0;
        for(Integer id: estudiantes.keySet()){
                Estudiante estudiante = estudiantes.get(id);
                if(estudiante.edad>=min&&estudiante.edad<=max){
                    promedio+=estudiante.cantVerduras;
                }
        }
        return promedio;
    }
    public int contProm(int i){
        int contador=0;
        for(Integer id: estudiantes.keySet()){
                Estudiante estudiante = estudiantes.get(id);
                if(i==0&&(estudiante.edad>=15|estudiante.edad<=20)){
                    contador++;
                }else if(i==1&&(estudiante.edad>=21|estudiante.edad<=25)){
                    contador++;
                }else if(i==2&&(estudiante.edad>=26|estudiante.edad<=30)){
                    contador++;
                }
        }
        return contador;
    }
    
    public void printStudents(){
        
        for(Integer id: estudiantes.keySet()){
            Estudiante estudiante = estudiantes.get(id);
            System.out.println("""
                               ---------------------------------------
                               ID ESTUDIANTE :"""+ id+"\n"
                              +"ESTUDIANTE :"+estudiante.nombre+"\n"
                              +"EDAD :"+estudiante.edad+"\n"
                              +"COMIDAS :"+estudiante.cantComidas+"\n"
                              +"COMIDAS CON VERDURAS :"+estudiante.cantVerduras+"\n"+
                               "---------------------------------------\n");
        }
    }
    
}
