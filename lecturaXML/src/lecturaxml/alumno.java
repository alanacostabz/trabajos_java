/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaxml;

import javax.xml.bind.annotation.*;

/**
 *
 * @author bryan
 */
@XmlRootElement(name = "Alumnos")
@XmlType(propOrder = {"nombres", "apellidos", "sexo", "fechaNacimiento"})
public class alumno {

    public String nombre;
    public String apellido;
    public String sexo;
    public String fechaNacimiento;

    public alumno() {
    }

    @XmlAttribute(name = "nombres")
    public String getNombre() {
        return nombre;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
