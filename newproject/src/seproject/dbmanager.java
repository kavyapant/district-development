/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seproject;
import java.io.*;
import java.awt.*;
import java.util.*;
import jxl.NumberCell;
import javax.swing.table.*;
import javax.swing.*;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import java.io.File;
import javax.swing.JOptionPane;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class dbmanager extends javax.swing.JFrame {


    public dbmanager() {
        initComponents();   
         try{
                int i;
                File f=new File("C:\\Users\\MAHE\\Desktop\\SEPROJECT\\src\\seproject\\data.xls");
                Workbook wb= Workbook.getWorkbook(f);
                Sheet s=wb.getSheet(0);
                String b[]=new String[17];
                for(int x=0;x<17;x++){
                Cell c=s.getCell(x,0);
                b[x]=c.getContents();
                }
                Object d[][]=new Object[642][18];
                for(int x=1;x<643;x++){
                    for(int y=0;y<18;y++){
                        Cell c=s.getCell(y, x);
                        d[x-1][y]=c.getContents();
                    }
                }
                 DefaultTableModel model=new DefaultTableModel(d,b);
            table.setModel(model);
            rem.setVisible(false);
            table.setRowSelectionAllowed(false);
        table.setCellSelectionEnabled(true);
            wb.close();
         }
         catch(Exception e){
             
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        users = new javax.swing.JRadioButton();
        data = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        rem = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        txt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1750, 675));

        jLabel1.setText("MAnager");

        jButton1.setText("change password");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(users);
        users.setText("Users");
        users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersMouseClicked(evt);
            }
        });
        users.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersActionPerformed(evt);
            }
        });

        buttonGroup1.add(data);
        data.setSelected(true);
        data.setText("Data");
        data.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dataMouseClicked(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);

        rem.setText("Remove");
        rem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remActionPerformed(evt);
            }
        });

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(275, 275, 275)
                                .addComponent(jButton1)
                                .addGap(56, 56, 56)
                                .addComponent(jButton2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(268, 268, 268)
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rem))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(201, 201, 201)
                                    .addComponent(data)
                                    .addGap(128, 128, 128)
                                    .addComponent(users)
                                    .addGap(44, 44, 44)
                                    .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(edit))))
                        .addGap(0, 1142, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(rem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(users)
                    .addComponent(data)
                    .addComponent(edit)
                    .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new CHANGEPASSWORD(2,"dbm").setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        new homepage().setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void usersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersActionPerformed
   
    }//GEN-LAST:event_usersActionPerformed

    private void usersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersMouseClicked
       txt.setVisible(false);
        table.setCellSelectionEnabled(false);
        table.setRowSelectionAllowed(true);
        try{
                int i;
                File f=new File("C:\\Users\\MAHE\\Desktop\\SEPROJECT\\src\\seproject\\users.xls");
                Workbook wb= Workbook.getWorkbook(f);
                Sheet s=wb.getSheet(0);
                String b[]=new String[8];
                for(int x=0;x<8;x++){
                Cell c=s.getCell(x,0);
                b[x]=c.getContents();
                }
                Object d[][]=new Object[s.getRows()][8];
                for(int x=1;x<s.getRows();x++){
                    for(int y=0;y<8;y++){
                        Cell c=s.getCell(y, x);
                        d[x-1][y]=c.getContents();
                    }
                }
                 DefaultTableModel model=new DefaultTableModel(d,b);
            table.setModel(model);
            rem.setVisible(true);
            edit.setVisible(false);
            
            wb.close();
         }
         catch(Exception e){
             
         }
    }//GEN-LAST:event_usersMouseClicked

    private void dataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dataMouseClicked
        rem.setVisible(false);
        edit.setVisible(true);
        txt.setVisible(true);
        table.setRowSelectionAllowed(false);
        table.setCellSelectionEnabled(true);
        try{
                int i;
                File f=new File("C:\\Users\\MAHE\\Desktop\\SEPROJECT\\src\\seproject\\data.xls");
                Workbook wb= Workbook.getWorkbook(f);
                Sheet s=wb.getSheet(0);
                String b[]=new String[17];
                for(int x=0;x<17;x++){
                Cell c=s.getCell(x,0);
                b[x]=c.getContents();
                }
                Object d[][]=new Object[642][18];
                for(int x=1;x<643;x++){
                    for(int y=0;y<18;y++){
                        Cell c=s.getCell(y, x);
                        d[x-1][y]=c.getContents();
                    }
                }
                 DefaultTableModel model=new DefaultTableModel(d,b);
            table.setModel(model);
            wb.close();
         }
         catch(Exception e){
             
         }
    }//GEN-LAST:event_dataMouseClicked

    private void remActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remActionPerformed
        int r=table.getSelectedRow();
        if(r==0||r==1){
            JOptionPane.showMessageDialog(null,"Default users cannot be deleted");
        }
        else
        if(r!=-1){
             DefaultTableModel model=(DefaultTableModel)table.getModel();
             model.removeRow(r);
         try{
             File f=new File("C:\\Users\\MAHE\\Desktop\\SEPROJECT\\src\\seproject\\users.xls");
                Workbook wb= Workbook.getWorkbook(f);
                Sheet s=wb.getSheet(0);
                String p=(String)table.getValueAt(r,1);
                Cell q=s.findCell(p);
                int z=q.getRow();
              WritableWorkbook w=Workbook.createWorkbook(f,wb);
       WritableSheet ws=w.getSheet(0);
               ws.removeRow(z-1);
               w.write();
               w.close();
                wb.close();
         }
          catch(Exception e){
             
         }
        }
    }//GEN-LAST:event_remActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
     int r=table.getSelectedRow();
     int c=table.getSelectedColumn();
     if(c==0||c==1)
         JOptionPane.showMessageDialog(null,"Default Values Cannot Be Changed");
     else{
     if(r!=-1&&c!=-1){
     try{
         double st=Double.parseDouble(txt.getText());
         table.setValueAt((Double)st, r, c);
           File f=new File("C:\\Users\\MAHE\\Desktop\\SEPROJECT\\src\\seproject\\data.xls");
                Workbook wb= Workbook.getWorkbook(f);
                Sheet s=wb.getSheet(0);
                String p=(String)table.getValueAt(r, 0);
                     WritableWorkbook w=Workbook.createWorkbook(f,wb);
       WritableSheet ws=w.getSheet(0);
               Label l=new Label(c,r+1,txt.getText());
               ws.addCell(l);
               w.write();
               w.close();
                wb.close();
         
                
     }
     catch(NumberFormatException e){
         JOptionPane.showMessageDialog(null,"Enter valid value");         
     }
     catch(Exception e){
         
     }
     }
     }
    }//GEN-LAST:event_editActionPerformed

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
            java.util.logging.Logger.getLogger(dbmanager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dbmanager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dbmanager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dbmanager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dbmanager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton data;
    private javax.swing.JButton edit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton rem;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt;
    private javax.swing.JRadioButton users;
    // End of variables declaration//GEN-END:variables
}