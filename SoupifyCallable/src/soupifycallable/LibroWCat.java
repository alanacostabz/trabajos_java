/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soupifycallable;

/**
 *
 * @author bryan
 */
public class LibroWCat {
    
        String titulo;
        String autor;
        String editorial;
        String isbn;
        String oclc;
        String notas;
        String descripcion;

        public LibroWCat(String titulo, String autor, String editorial, String isbn, String oclc, String notas, String descripcion) {
            this.titulo = titulo;
            this.autor = autor;
            this.editorial = editorial;
            this.isbn = isbn;
            this.oclc = oclc;
            this.notas = notas;
            this.descripcion = descripcion;
        }
}

