/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaxml;

import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.*;


/**
 *
 * @author bryan
 */
@XmlRootElement(name="Alumnos")
@XmlType(propOrder={"nombres","apellidos","sexo","fechaNacimiento"})
public class Alumnos {
   public ArrayList<alumno> Alumnos = new ArrayList();

    public Alumnos() {
    }
    
    @XmlElementWrapper(name="Alumnos")
    @XmlElement(name="Alumno")
    public ArrayList<alumno> getAlumnos() {
        return Alumnos;
    }

    public void setAlumnos(ArrayList<alumno> alumnos) {
        this.Alumnos = alumnos;
    }
   
   
}
