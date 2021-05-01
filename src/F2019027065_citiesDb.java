
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aslam Javed
 */
public class F2019027065_citiesDb extends javax.swing.JFrame {

    /**
     * Creates new form F2019027065_citiesDb
     */
    public F2019027065_citiesDb() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        citiesdbbox = new javax.swing.JComboBox<>();
        fetchbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fetchbtn.setText("Fetch");
        fetchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fetchbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(177, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fetchbtn)
                    .addComponent(citiesdbbox, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(116, 116, 116))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(citiesdbbox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(fetchbtn)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fetchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fetchbtnActionPerformed
                
        try {
            Connection conn;
            String dbURL="jdbc:postgresql://localhost:5432/postgres";
            String userName="postgres";
            String password="k@inatJava";  
            
            
            conn=DriverManager.getConnection(dbURL,userName,password);
            
            String query = "SELECT \n" +"  city_id,\n" +"  city_name\n" +"FROM \n" +"  public.city ;";

            Statement stmt;
            stmt = conn.createStatement();
            stmt.executeQuery(query);
            ResultSet rs = stmt.executeQuery(query);
            rs.next();

            while (rs.next()) {
                String city_name = rs.getString("city_name");
                citiesdbbox.addItem(city_name);
            }
            conn.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();

        }
     
    }//GEN-LAST:event_fetchbtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> citiesdbbox;
    private javax.swing.JButton fetchbtn;
    // End of variables declaration//GEN-END:variables
}
