/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas;

/**
 *
 * @author bryan
 */
import javax.swing.*;

public class Lamina_Botones extends JPanel {

    public Lamina_Botones(String titulo, String[] opciones) {

        setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        grupo = new ButtonGroup();

        for (int i = 0; i < opciones.length; i++) {
            JRadioButton bot = new JRadioButton(opciones[i]);
            
            bot.setActionCommand(opciones[i]);
            add(bot);
            grupo.add(bot);
            bot.setSelected(i == 0);
        }

    }

    public String dameSeleccion() {
       /* ButtonModel miBoton = grupo.getSelection();
        String s = miBoton.getActionCommand();

        return s;*/
       
       return grupo.getSelection().getActionCommand();
    }
    private ButtonGroup grupo;
}
