/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newproject.regression;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import matrix.Matrix;
import matrix.NoSquareException;

/**
 *
 * @author MAHE
 */
public class aaaa extends javax.swing.JFrame {

    /**
     * Creates new form aaaa
     */
    public aaaa() {
        initComponents();
        String a[]={"Net irrigated area(Hectares)",
"Density Population(persons per sq.km.)",
"Percentage SC Population",
"Percentage ST Population",
"Percentage Urban Population",
"Education level",
"Overall Literacy",
"Female Literacy",
"Sex ratio",
"Total Number of Schools",
"infant",
"Life expectancy at    Birth", 
"Number of Villages",
 "Persons"           
    };    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ind = new javax.swing.JComboBox<>();
        dep = new java.awt.List();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ind.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Net irrigated area(Hectares)", "Density Population(persons per sq.km.)", "Percentage SC Population", "Percentage ST Population", "Percentage Urban Population", "Education level", "Overall Literacy", "Female Literacy", "Sex ratio", "Total Number of Schools", "infant", "Life expectancy at    Birth ", "Number of Villages", " " }));
        ind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indActionPerformed(evt);
            }
        });

        dep.setMultipleMode(true);

        jButton1.setText("Calculate regression");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(ind, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jButton1)))
                .addGap(52, 52, 52)
                .addComponent(dep, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(ind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(dep, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(171, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void indActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indActionPerformed
String  s=(String)ind.getSelectedItem();
ArrayList<String> arr=new ArrayList<>(644);
dep.clear();
if(s.equals("Net irrigated area(Hectares)")){
   arr.add("Percentage SC Population");
arr.add("Percentage ST Population");
arr.add("Sex ratio");
arr.add("Total Number of Schools");
arr.add("Number of Villages");
arr.add("Persons"); 
}
else if(s.equals("Density Population(persons per sq.km.)")){
    arr.add("Percentage Urban Population");
    arr.add("Overall Literacy");
     arr.add("Female Literacy");
     arr.add("Sex ratio");
}
else if(s.equals("Percentage SC Population")){
    arr.add("Net irrigated area(Hectares)");
    arr.add("Percentage ST Population");
}
else if(s.equals("Percentage ST Population")){
     arr.add("Net irrigated area(Hectares)");
    arr.add("Percentage SC Population");
    arr.add("Total Number of Schools");
arr.add("Number of Villages");
}
else if(s.equals("Percentage Urban Population")){
    arr.add("Density Population(persons per sq.km.)");
     arr.add("Overall Literacy");
     arr.add("Female Literacy");
     arr.add("Sex ratio");
     arr.add("infant");
     arr.add("Number of Villages");
}
else if(s.equals("Education level")){
     arr.add("Net irrigated area(Hectares)");
     arr.add("Overall Literacy");
     arr.add("Female Literacy");
     arr.add("Total Number of Schools");
      arr.add("infant");
     arr.add("Number of Villages");
}
else if(s.equals("Overall Literacy")){
    arr.add("Density Population(persons per sq.km.)");
     arr.add("Percentage Urban Population");
      arr.add("Education level");
      arr.add("Female Literacy");
      arr.add("infant");
     arr.add("Number of Villages");
}
else if(s.equals("Sex ratio")){
     arr.add("Density Population(persons per sq.km.)");
     arr.add("Percentage Urban Population");
     arr.add("Life expectancy at    Birth");
}
else if(s.equals("infant")){
    arr.add("Percentage Urban Population");
     arr.add("Life expectancy at    Birth");
     arr.add("Overall Literacy");
}
for(int i=0;i<arr.size();i++){
    dep.add(arr.get(i));
   // arr.r
}
    }//GEN-LAST:event_indActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

int r=0,c=0;
newproject2 ob=new newproject2(644,dep.getSelectedItems().length,644,1);
ob.setInputFile("C:\\Users\\MAHE\\Desktop\\SEPROJECT\\src\\seproject\\data.xls");
        try {
            ob.read();
        } catch (IOException ex) {
            Logger.getLogger(aaaa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger(aaaa.class.getName()).log(Level.SEVERE, null, ex);
        }
        String a[]=dep.getSelectedItems();
        for(int i=0;i<a.length;i++){
           ob.addd(a[i]);
        }
        ob.addd2((String)ind.getSelectedItem());
        for(int i=0;i<ob.arr.size();i++)
            {
                     
              if(ob.arr.get(i)!=-9999.0)
              {
                     
                ob.a[r][c]=ob.arr.get(i);
                r++;
              }
              else
              { c++;
                  r=0;
              }
             
            }
        int r2=0;int c2=0;
            
            for(int i=0;i<ob.arr2.size();i++)
            {
              if(ob.arr2.get(i)!=-9999.0)
              {
                ob.a2[r2][c2]=ob.arr2.get(i);
                r2++;
                
              }
              else
              {
                  c2++;
              }
             
            }
            Matrix X=new Matrix(ob.a);
            Matrix Y=new Matrix(ob.a2);
        MultiLinear obj=new MultiLinear(X,Y);
        Matrix beta = null;
        try {
            beta=obj.calculate();
        } catch (NoSquareException ex) {
            Logger.getLogger(aaaa.class.getName()).log(Level.SEVERE, null, ex);
        }
         double o[][]=new double[beta.getNrows()][beta.getNcols()];
          
         
          o=beta.getValues();
           double a1[]=new double[beta.getNrows()];
             
           int k=0;
            for(int i=0;i<beta.getNrows();i++)
            {
                    a1[k++]=o[i][0];
            
            }
            String a2="beta0:"+String.valueOf(a1[0])+"\n";
            for(int q=1;q<a1.length;q++){
               a2=a2+"beta"+q+":"+a1[q]+"\n";
            }
            JOptionPane.showMessageDialog(null,a2);
    }//GEN-LAST:event_jButton1ActionPerformed
    
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
            java.util.logging.Logger.getLogger(aaaa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(aaaa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(aaaa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(aaaa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new aaaa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.List dep;
    private javax.swing.JComboBox<String> ind;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
