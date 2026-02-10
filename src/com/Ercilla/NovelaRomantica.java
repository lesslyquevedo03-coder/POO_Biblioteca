package com.Ercilla;

import java.time.LocalDate;

public class NovelaRomantica extends Libro implements Prestable{

    private boolean finalFeliz;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    //Constructor
    public NovelaRomantica(String autor, String titulo, boolean finalFeliz){
        super(autor, titulo, Genero.NovelaRomantica);
        this.finalFeliz = finalFeliz;
    }

    @Override
    public String getDescripcion(){
        return "Final feliz " + (finalFeliz?"SI":"NO");
    }

    @Override
    public void prestar(LocalDate fechaPrestamo) {
        if (this.fechaPrestamo != null) {
            System.out.println("El libro " + titulo + " ya está prestado");
            return;
        }
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaPrestamo.plusDays(30);
    }
    @Override
    public void devolver(LocalDate fechaDevolucion){
        if (this.fechaDevolucion == null){
            System.out.println("El libro " + titulo + " ya está prestado");
            return;
        }
        System.out.println("Novela romantica devuelta el " + fechaDevolucion);
        this.fechaPrestamo = null;
        this.fechaDevolucion = null;
    }
}
