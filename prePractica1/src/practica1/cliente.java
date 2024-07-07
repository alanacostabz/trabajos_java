package practica1;

import java.util.Date;
import javax.swing.JOptionPane;

//id
//        nombre
//apellido
//sexo
//fechanacimiento
//celular
//activo
public class cliente {
    public static int siguienteID = 0;
    public int id;
    public String nombre;
    public String apellidos;
    public String sexo;
    public Date fechaNacimiento;
    public String celular;
    public boolean activo;
    
    public cliente(){
        siguienteID +=1;
        this.id = siguienteID;
        this.nombre = "";
        this.apellidos = "";
        this.sexo = sexo = "";
        this.fechaNacimiento = new Date(2018,01,01);
        this.celular = "";
        this.activo = true;
    }

    public cliente(int id, String nombre, String apellidos, String sexo, Date fechanacimiento, String celular, boolean activo) {
        siguienteID +=1;
        this.id = siguienteID;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.fechaNacimiento = fechanacimiento;
        this.celular = celular;
        this.activo = activo;

    }

    public void mostrarDatos() {
        JOptionPane.showMessageDialog(null,
                "ID: " + id
                + "\nNombre: " + nombre
                + "\nApellidos: " + apellidos
                + "\nSexo: " + sexo
                + "\nFecha de nacimiento: " + fechaNacimiento
                + "\nCelular: " + celular
                + "\nStatus: " + activo);
    }
}
