package views;

import Entities.Employee;
import dao.EmployeeDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ListEmployee extends javax.swing.JFrame {
    ArrayList<Employee> emp = null;
    /**
     * Creates new form ListEmployee
     */
    public ListEmployee() {
        initComponents();
        this.list_data();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_employee = new javax.swing.JTable();
        txt_rut = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl_employee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "RUT", "Nombre", "Apellido", "Edad", "Cargo", "Sexo", "Extranjero"
            }
        ));
        jScrollPane1.setViewportView(tbl_employee);

        btn_search.setText("Buscar");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        btn_delete.setText("Eliminar");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_update.setText("Modificar");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_exit.setText("Salir");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txt_rut, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_search)
                        .addGap(29, 29, 29))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_exit)
                .addGap(18, 18, 18)
                .addComponent(btn_update)
                .addGap(26, 26, 26)
                .addComponent(btn_delete)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_rut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_delete)
                    .addComponent(btn_update)
                    .addComponent(btn_exit))
                .addGap(35, 35, 35))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    //  -----------------------
    //  BOTON BUSCAR
    //  -----------------------
    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        this.list_data();
    }//GEN-LAST:event_btn_searchActionPerformed

    
    //  -----------------------
    //  BOTON ELIMINAR
    //  -----------------------
    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        int row_index = tbl_employee.getSelectedRow();
        
        if (row_index != 1){
            JOptionPane.showMessageDialog(this, "No se ha podido eliminar");
            this.list_data();
        }
        Employee e = this.emp.get(row_index);
        EmployeeDAO dao = new EmployeeDAO();
        
        try {
            if(dao.deleteEmployee(e.getRut())){
                JOptionPane.showMessageDialog(this, "Eliminado Correctamente");
            }else{
                JOptionPane.showMessageDialog(this, "No se ha podido eliminar");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        this.list_data();
    }//GEN-LAST:event_btn_deleteActionPerformed
    
    //  -----------------------
    //  BOTON PARA MODIFICAR EMPLEADOS
    //  -----------------------
    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        try {
            int row_index = tbl_employee.getSelectedRow();
            Employee e = emp.get(row_index);
            
            UpdateEmployee update = new UpdateEmployee(e);
            update.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Selecciona un empleado");
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_exitActionPerformed
    
    //  -----------------------
    //  FUNCION PARA LISTAR EMPLEADOS
    //  -----------------------
    private void list_data(){
        EmployeeDAO dao = new  EmployeeDAO();
        
        try {            
            if(txt_rut.getText().isEmpty()){
                emp = dao.listEmployee();
            }else{
                emp = dao.searchEmployeeByRut(txt_rut.getText());
                if(emp.size() == 0){
                    JOptionPane.showMessageDialog(this, "No se ha encontrado el rut");
                }
            }
            
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("RUT");
            model.addColumn("Nombre");
            model.addColumn("Apellido");
            model.addColumn("Edad");
            model.addColumn("Cargo");
            model.addColumn("Sexo");
            model.addColumn("Extranjero");
            
            for (Employee emp1 : emp) {
                String[] row = new String[7];
                row[0] = emp1.getRut();
                row[1] = emp1.getName();
                row[2] = emp1.getLast_name();
                row[3] = String.valueOf(emp1.getAge());
                row[4] = emp1.getPosition();
                if(emp1.isSex()){
                    row[5] = "Hombre";
                }else{
                    row[5] = "Mujer";
                }
                if(emp1.isIs_foreign()){
                    row[6] = "Si";
                }else{
                    row[6] = "No";
                }
                model.addRow(row);
                
            }
            tbl_employee.setModel(model);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
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
            java.util.logging.Logger.getLogger(ListEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_update;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_employee;
    private javax.swing.JTextField txt_rut;
    // End of variables declaration//GEN-END:variables
}
