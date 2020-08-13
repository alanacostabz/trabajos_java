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

    private int id;
    private String nombre;
    private String apellidos;
    private String sexo;
    private Date fechanacimiento;
    private int celular;
    private boolean activo;

    public cliente(int id, String nombre, String apellidos, String sexo, Date fechanacimiento, int celular, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.fechanacimiento = fechanacimiento;
        this.celular = celular;
        this.activo = activo;

    }

    public void mostrarDatos() {
        JOptionPane.showMessageDialog(null,
                "ID: " + id
                + "\nNombre: " + nombre
                + "\nApellidos: " + apellidos
                + "\nSexo: " + sexo
                + "\nFecha de nacimiento: " + fechanacimiento
                + "\nCelular: " + celular
                + "\nStatus: " + activo);
    }
}
