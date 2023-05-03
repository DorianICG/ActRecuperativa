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
    private int categoria,cantComidas, cantVerduras;

    public Estudiante() {
    }

    public Estudiante(String nombre, int categoria, int cantComidas, int cantVerduras) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantComidas = cantComidas;
        this.cantVerduras = cantVerduras;
    }

    public Hashtable<Integer,Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCategoria() {
        return categoria;
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

    public void setEdad(int categoria) {
        this.categoria = categoria;
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
                                   
                                   1.- PRINT BUENA ALIMENTACION
                                   2.- PRINT ALIMENTACION BALANCEADA
                                   0.- BACK
                                   
                                   """);
                option = scan.nextInt();
                if(option<0|option>3)
                {
                    System.out.println("""
                                       
                                       OPCIÓN INGRESADA NO VÁLIDA
                                       
                                       """);
                }
            }while(option<0|option>3);
            switch(option){
                    case 1 -> printGeneral("LA MEJOR Y PEOR CATEGORIA SON:");  
                    case 2 -> printGeneral();
                    case 3 -> printCategory();
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

    public void createStudent(Estudiante nuevoEstudiante){
        int newID = estudiantes.size()+1;
        estudiantes.put(newID, nuevoEstudiante);
            
    }
        
    public void printGeneral(){
        double promComida;
        
        for(int i=0; i<3;i++){
            promComida=0;
            switch (i) {
                case 0 -> promComida += prom(i+1);
                case 1 -> promComida += prom(i+1);
                default -> promComida += prom(i+1);
            }
            promComida /= contador(i);
            if(promComida>2){
                System.out.println("Alimentación está balanceada de: "+promComida);
            }else{
                System.out.println("Alimentación está desbalanceada de: "+promComida);
            }
        }
    }
        
    
     
    public void printGeneral(String mensaje){
        double promMejor=0, promPeor=0, promComida;
        int catPeor=-1,catMejor=-1;
        System.out.print(mensaje+"\n");
        for(int i=0; i<3;i++){
            promComida = prom(i+1,0)/contador(i);
            if(promMejor<promComida||catMejor==-1){
                promMejor = promComida;
                catMejor = i;
            }
            if(promPeor>promComida||catPeor==-1){
                promPeor = promComida;
                catPeor = i;
            }
        }
        System.out.print("La PEOR categoria de estudiantes es la de ");
        switch (catPeor) {
            case 0 -> System.out.print("15 y 20 anyos ");
            case 1 -> System.out.print("21 y 25 anyos ");
            case 2 -> System.out.print("26 y 30 anyos ");
            default -> {
            }
        }
        System.out.print("con un promedio de: "+promPeor+"\n\n");
        System.out.print("La MEJOR categoria de estudiantes es la de ");
        switch (catMejor) {
            case 0 -> System.out.print("15 y 20 anyos ");
            case 1 -> System.out.print("21 y 25 anyos ");
            case 2 -> System.out.print("26 y 30 anyos ");
            default -> {
            }
        }
        System.out.print("con un promedio de: "+promMejor+"\n");
        
    }
    
    public double prom(int categoriaB, int i){
        int promedio=0;
        for(Integer id: estudiantes.keySet()){
                Estudiante estudiante = estudiantes.get(id);
                if(categoriaB==estudiante.categoria){
                    promedio+=estudiante.cantComidas;
                }
        }
        return promedio;
    }
    
    public int prom(int categoriaB){
        int promedio=0;
        for(Integer id: estudiantes.keySet()){
                Estudiante estudiante = estudiantes.get(id);
                if(categoriaB==estudiante.categoria){
                    promedio+=estudiante.cantVerduras;
                }
        }
        return promedio;
    }
    public int contador(int i){
        int contador=0;
        for(Integer id: estudiantes.keySet()){
                Estudiante estudiante = estudiantes.get(id);
            switch (estudiante.categoria) {
                case 0 -> contador++;
                case 1 -> contador++;
                case 2 -> contador++;
                default -> {
                }
            }
        }
        return contador;
    }
    
    public void printCategory(){
        
        for(Integer id: estudiantes.keySet()){
            Estudiante estudiante = estudiantes.get(id);
            System.out.println("""
                               ---------------------------------------
                               ID ESTUDIANTE :"""+ id+"\n"
                              +"ESTUDIANTE :"+estudiante.nombre+"\n"
                              +"CATEGORIA :"+estudiante.categoria+"\n"
                              +"COMIDAS :"+estudiante.cantComidas+"\n"
                              +"COMIDAS CON VERDURAS :"+estudiante.cantVerduras+"\n"+
                               "---------------------------------------\n");
        }
    }
    
}
