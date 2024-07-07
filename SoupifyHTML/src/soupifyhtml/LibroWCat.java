/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soupifyhtml;

import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;

/**
 *
 * @author bryan
 */
class LibroWCat {

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
