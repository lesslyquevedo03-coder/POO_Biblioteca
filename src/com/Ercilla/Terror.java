package com.Ercilla;

import java.time.LocalDate;

public class Terror extends Libro implements Prestable{

    private int nivelMiedo;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    //Constructor (el constructor siempre se llama igual que la clase)
    public Terror (String autor, String titulo, int nivelMiedo){
        super(autor,titulo, Genero.Terror);
        this.nivelMiedo = nivelMiedo;
    }

    @Override
    public String getDescripcion(){
        return "Nivel de miedo: " + nivelMiedo;
    }

    @Override //Implementar una clase que ya está en algún sitio
    public void prestar (LocalDate fechaPrestamo){
        if (this.fechaPrestamo!= null){
            System.out.println("El libro ya está prestado");
            return;
        }
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaPrestamo.plusDays(15);
        System.out.println("Prestado el " + fechaPrestamo + "Devolver antes del " + fechaDevolucion);
    }

    @Override
    public void devolver(LocalDate fechaDevolucion){
        if (this.fechaDevolucion == null){
            System.out.println("El libro no está prestado");
            return;
        }
        System.out.println("Devuelto el " + fechaDevolucion);
        this.fechaPrestamo = null;
        this.fechaDevolucion = null;
    }
}
