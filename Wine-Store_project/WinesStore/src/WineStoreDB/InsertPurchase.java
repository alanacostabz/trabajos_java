/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WineStoreDB;

import static WineStoreDB.DeleteWinesID.RET_OK;
import static WineStoreDB.InsertRefVineyards.RET_CANCEL;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author bryan
 */
public class InsertPurchase extends javax.swing.JDialog {

    /**
     * Creates new form InsertCoffeesDialog
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;
    private final Database db;
    private final HashMap ht1;
    double totalwine;

    public InsertPurchase(java.awt.Frame parent, Database db) {
        super(parent, true);
        initComponents();
        this.db = db;
        ht1 = new HashMap<String, Integer>();
        total.setText("0.00");
        java.util.Date date = new java.util.Date();
        jfecha.setDate(date);

        // Construir el combo con el ID y Nombre de proveedor
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
        total.setText("");

        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        idcostumer = new javax.swing.JTextField();
        idwine = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        total = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jfecha = new com.toedter.calendar.JDateChooser();
        jnombres = new javax.swing.JTextField();
        fly = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar Venta");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Agregar venta");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ID Cliente:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("ID Vino:");
        jLabel3.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Fecha de compra:");

        cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Cantidad :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Precio Total:");

        idcostumer.setToolTipText("");
        idcostumer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idcostumerActionPerformed(evt);
            }
        });
        idcostumer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idcostumerKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idcostumerKeyTyped(evt);
            }
        });

        idwine.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                idwineKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idwineKeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        total.setDisplayedMnemonic('0');
        total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        total.setForeground(new java.awt.Color(0, 0, 204));
        total.setText("0.00");

        jnombres.setEditable(false);
        jnombres.setBackground(new java.awt.Color(255, 255, 255));
        jnombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnombresActionPerformed(evt);
            }
        });

        fly.setEditable(false);
        fly.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(139, 139, 139))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(216, 216, 216)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(idcostumer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jnombres, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(idwine, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(fly, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(80, 80, 80)
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(97, 97, 97)
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(2, 2, 2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(idcostumer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jnombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(idwine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fly, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idcostumerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idcostumerActionPerformed

    }//GEN-LAST:event_idcostumerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String idc = idcostumer.getText();
        String idw = idwine.getText();
        String c = cantidad.getText();
        if (idc.isEmpty() || idw.isEmpty() || c.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Todos los compos tienen que llenarse.");
        } else {
            String f = "";
            String dia = "";
            String mes = "";
            String year = "";
            String s = "";
            //  java.util.Date r = jfecha.getDate();

            try {
                if (validacionDatosC(idc) == 0) {
                    JOptionPane.showMessageDialog(this, "El id " + idc + " de clientes no se encuentra en la base de datos.");
                } else if (validacionDatosW(idw) == 0) {
                    JOptionPane.showMessageDialog(this, "El id " + idw + " de vinos no se encuentra en la base de datos.");
                } else {
                    if (jfecha.getDate() == null) {
                        JOptionPane.showMessageDialog(this, "Seleccione la fecha de compra.");
                    } else {
                        int input = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro de añadir la venta? ", "Agregar venta", 0);
                        if (input == 0) {
                            dia = Integer.toString(jfecha.getCalendar().get(Calendar.DAY_OF_MONTH));
                            year = Integer.toString(jfecha.getCalendar().get(Calendar.YEAR));
                            mes = Integer.toString(jfecha.getCalendar().get(Calendar.MONTH) + 1);
                            f = year + "-" + mes + "-" + dia;
                            StringBuilder sql
                                    = new StringBuilder("INSERT INTO winestore.purchases (costumer_id, wine_store_id,Date_of_purchase,amount_of_bottles,amount_of_purchase) VALUES (\'");
                            sql.append(idc);
                            sql.append("\','");
                            sql.append(idw);
                            sql.append("\','");
                            sql.append(f);
                            sql.append("\','");
                            sql.append(c);
                            sql.append("\','");
                            sql.append(totalwine);
                            sql.append("\')");
                            try {
                                db.update(sql.toString());
                            } catch (SQLException ex) {
                                Logger.getLogger(InsertPurchase.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            JOptionPane.showMessageDialog(this, "El la venta ha sido añadida exitosamente.");
                            doClose(returnStatus);
                        }
                    }
                    }
                }catch (SQLException ex) {
                Logger.getLogger(InsertPurchase.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadKeyReleased
        String idw = idwine.getText();
        String valor = cantidad.getText();
        String preciow = "";

        if (!idw.equals("")) {
            try {
                if (validacionDatosW(idw) != 0) {
                    System.out.println("");
                    int aux = Integer.parseInt(idw);

                    final String sql = String.format("select price from winestore.wine_store where wine_store_id = %s", idw);

                    try {
                        ResultSet rs = db.query(sql);
                        while (rs.next()) {
                            int id = rs.getInt(1);
                            preciow = rs.getString(1);
                            ht1.put(preciow, id);
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                    double p;
                    char c = evt.getKeyChar();
                    if (!valor.isEmpty()) {
                        p = Double.parseDouble(preciow);
                        double can = Double.parseDouble(valor);
                        totalwine = can * p;
                        String aggh = Double.toString(totalwine);
                        total.setText(aggh);
                    } else {

                        total.setText("0.00");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El vino con id=" + idw + " no existe en la base de datos.");
                    total.setText("0.00");
                }
            } catch (SQLException ex) {
                Logger.getLogger(InsertPurchase.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_cantidadKeyReleased

    private void idwineKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idwineKeyReleased
        String idw = idwine.getText();
        String valor = cantidad.getText();
        String preciow = "";
        String name;
        fly.setText("");
        if (!idw.equals("")) {
            try {
                if (validacionDatosW(idw) != 0) {
                    System.out.println("");
                    int aux = Integer.parseInt(idw);
                    final String sql1 = String.format("SELECT wine_store_id,wine_name FROM winestore.wine_store where wine_store_id=" + idw);
                    try {
                        ResultSet rs = db.query(sql1);
                        while (rs.next()) {
                            //comboRegion.addItem("NULL");
                            int id1 = rs.getInt(1);
                            name = rs.getString(2);
                            fly.setText(name);
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }

                    final String sql = String.format("select price from winestore.wine_store where wine_store_id = %s", idw);

                    try {
                        ResultSet rs = db.query(sql);
                        while (rs.next()) {
                            int id = rs.getInt(1);
                            preciow = rs.getString(1);
                            ht1.put(preciow, id);
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                    double p;
                    char c = evt.getKeyChar();
                    if (!valor.isEmpty()) {
                        p = Double.parseDouble(preciow);
                        double can = Double.parseDouble(valor);
                        totalwine = can * p;
                        String aggh = Double.toString(totalwine);
                        total.setText(aggh);
                    } else {

                        total.setText("0.00");
                    }
                } else {
                    // JOptionPane.showMessageDialog(this, "El vino con id="+idw+" no existe en la base de datos.");
                    fly.setText("El ID no existente.");
                    total.setText("0.00");
                }
            } catch (SQLException ex) {
                Logger.getLogger(InsertPurchase.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_idwineKeyReleased

    private void idcostumerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idcostumerKeyReleased

        String idc = idcostumer.getText().toString();

        String n = "Cliente";
        jnombres.setText("");
        if (!idc.equals("")) {
            try {
                if (validacionDatosC(idc) != 0) {
                    final String sql1 = String.format("SELECT customer_id, apellido, nombre FROM winestore.customer where customer_id=" + idc);
                    try {

                        ht1.clear();
                        ResultSet rs = db.query(sql1);

                        while (rs.next()) {
                            //comboRegion.addItem("NULL");
                            jnombres.setText("");
                            int id1 = rs.getInt(1);

                            String apellido = rs.getString(2);
                            String name = rs.getString(3);
                            n = apellido + " " + name;
                            jnombres.setText(n);

                        }
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }

                } else {
                    jnombres.setText("Cliente no encontrado.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(InsertPurchase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_idcostumerKeyReleased

    private void idcostumerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idcostumerKeyTyped
        // TODO add your handling code here:
        int limit = 7;
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && c != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo se pueden ingresar números.");
        }
        if (idcostumer.getText().length() == limit) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_idcostumerKeyTyped

    private void idwineKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idwineKeyTyped
        // TODO add your handling code here:
        int limit = 7;
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && c != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo se pueden ingresar números.");
        }
        if (idwine.getText().length() == limit) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_idwineKeyTyped

    private void cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadKeyTyped
        // TODO add your handling code here:
        int limit = 5;
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && c != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Solo se pueden ingresar números.");
        }
        if (cantidad.getText().length() == limit) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_cantidadKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        doClose(returnStatus);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jnombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jnombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jnombresActionPerformed

    /**
     * @param args the command line arguments
     */
    public int validacionDatosC(String vd) throws SQLException {
        StringBuilder sql1 = new StringBuilder("select customer_id  from winestore.customer");
        int x = 0;
        try {
            ResultSet rs = db.query(sql1.toString());
            while (rs.next()) {

                String name = rs.getString(1);
                if (name.equalsIgnoreCase(vd)) {
                    x++;
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return x;
    }

    public int validacionDatosW(String vd) throws SQLException {
        StringBuilder sql1 = new StringBuilder("select wine_store_id from winestore.wine_store");
        int x = 0;
        try {
            ResultSet rs = db.query(sql1.toString());
            while (rs.next()) {

                String name = rs.getString(1);

                if (name.equalsIgnoreCase(vd)) {
                    x++;
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return x;
    }

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }
    private int returnStatus = RET_CANCEL;

    public int getReturnStatus() {
        return returnStatus;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cantidad;
    private javax.swing.JTextField fly;
    private javax.swing.JTextField idcostumer;
    private javax.swing.JTextField idwine;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JDateChooser jfecha;
    private javax.swing.JTextField jnombres;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}