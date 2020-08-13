package leerxml;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LeeXML extends javax.swing.JFrame {

    private DefaultTableModel dtm;
    private DefaultTableModel dtmMaterias;
    private String[] mirenglon;
    private boolean primeraVez;
    private boolean primeraVezMaterias;

    public LeeXML() {
        initComponents();
        dtm = (DefaultTableModel) tablaAlumnos.getModel();
        dtmMaterias = (DefaultTableModel) tablaMaterias.getModel();
        primeraVez = false;
        primeraVezMaterias = false;
        leeXMLInternet();
    }

    private void agregarenglones(String renglon[]) {
        dtm.addRow(renglon);
    }

    private void agregaColumnas(String nombreColumna) {
        dtm.addColumn(nombreColumna);
    }

    private void agregaDatos(NodeList otroListado) {
        // Sin elemento materias:  
        mirenglon = new String[otroListado.getLength() - 1];
        // mirenglon = new String[otroListado.getLength()];

        int contador = -1;
        for (int j = 0; j < otroListado.getLength(); j++) {
            if (j % 2 == 1) {
                contador += 1;
                if (!otroListado.item(j).getNodeName().equalsIgnoreCase("materias")) {
                    String nombreNodo = otroListado.item(j).getNodeName();
                    String textoNodo = otroListado.item(j).getTextContent();
                    System.out.println(nombreNodo + ": " + textoNodo);

                    if (primeraVez == false) {
                        agregaColumnas(nombreNodo);
                    }

                    mirenglon[contador] = textoNodo;
                } else {
                    informacionMaterias(otroListado.item(j));
                }
            }
        }
        primeraVez = true;
        agregarenglones(mirenglon);
    }

    private void informacionMaterias(Node nodoMaterias) {
        String[] renglonMaterias;
        

        System.out.println("\nCurrent Element :" + nodoMaterias.getNodeName());
        if (nodoMaterias.getNodeType() == Node.ELEMENT_NODE) {
            NodeList listadoMaterias = nodoMaterias.getChildNodes();
            for (int i = 0; i < listadoMaterias.getLength(); i++) {
                if (i % 2 == 1) {
                    Node unaMateria = listadoMaterias.item(i);
                    NodeList nodosMaterias = unaMateria.getChildNodes();
                    
                    renglonMaterias = new String[nodosMaterias.getLength()];
                    int contador = -1;
                    
                    for (int j = 0; j < nodosMaterias.getLength(); j++) {
                        if (j % 2 == 1) {
                            contador++;
                            String nombreNodo = nodosMaterias.item(j).getNodeName();
                            String textoNodo = nodosMaterias.item(j).getTextContent();
                            System.out.println("****" + nombreNodo + ": " + textoNodo);

                            System.out.println("primeraVezMaterias = " + primeraVezMaterias);
                            if (primeraVezMaterias == false) {
                                dtmMaterias.addColumn(nombreNodo);
                            }
                            
                            renglonMaterias[contador] = textoNodo;
                        }
                    }
                    
                    primeraVezMaterias = true;
                    dtmMaterias.addRow(renglonMaterias);
                }
                
            }
            // renglonMaterias
        }
    }

    private void leeXMLInternet() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            // File archivo = new File("C:\\PVeI 2018\\AlumnosPequeno.xml");
            // File archivo = new File("C:\\PVeI 2018\\AlumnosPequeno.xml");
            // File archivo = new File("C:\\PVeI 2018\\Musica.xml");
            File archivo = new File("AlumnosMaterias.xml");

            Document doc = dBuilder.parse(archivo);

            // boolean primeraVez =false;
            // String[] mirenglon;
            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Elemento raíz o principal: "
                    + doc.getDocumentElement().getNodeName());

            // NodeList listadoNodos = doc.getElementsByTagName("hijo");
            NodeList listadoNodos = doc.getDocumentElement().getChildNodes();
            System.out.println("----------------------------");

            System.out.println("Elementos listadoNodos: "
                    + listadoNodos.getLength());

            for (int i = 0; i < listadoNodos.getLength(); i++) {
                if (i % 2 == 1) {
                    Node nodoHijo = listadoNodos.item(i);

                    System.out.println("\nCurrent Element :" + nodoHijo.getNodeName());
                    if (nodoHijo.getNodeType() == Node.ELEMENT_NODE) {
                        NodeList otroListado = nodoHijo.getChildNodes();

                        agregaDatos(otroListado);

                        System.out.println("\n");
                        // Element eElement = (Element) nodoHijo;
                        // System.out.println("Nombres : " + eElement.getAttribute("id"));
//                            System.out.println("Nombres : " + eElement.getElementsByTagName("nombres").item(0).getTextContent());
//                            System.out.println("Apellidos : " + eElement.getElementsByTagName("apellidos").item(0).getTextContent());
//                            System.out.println("Sexo : " + eElement.getElementsByTagName("sexo").item(0).getTextContent());
//                            System.out.println("FechaNacimiento : " + eElement.getElementsByTagName("fechaNacimiento").item(0).getTextContent());
//                            System.out.println("Materias : " + eElement.getElementsByTagName("materias").item(0).getTextContent());

                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Excepción: " + ex.toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMaterias = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaAlumnos);

        tablaMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaMaterias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LeeXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LeeXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LeeXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeeXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LeeXML().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaAlumnos;
    private javax.swing.JTable tablaMaterias;
    // End of variables declaration//GEN-END:variables
}
