package top5v2;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MacAttack
 */
public class Settings extends javax.swing.JDialog {

    /**
     * Creates new form Settings
     */
    public Settings(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jTextField1.isEditable();
    }
    
    public void setBoxes(List<String> topics,String location) {
        choice1.setSelectedItem((String) topics.get(0));
        choice2.setSelectedItem((String) topics.get(1));
        choice3.setSelectedItem((String) topics.get(2));
        choice4.setSelectedItem((String) topics.get(3));
        choice5.setSelectedItem((String) topics.get(4));
        this.jTextField1.setText(location);
    }
    
    public String getString(){
        String string = choice1.getSelectedItem().toString() + "\n" + choice2.getSelectedItem().toString() + "\n" + choice3.getSelectedItem().toString() +"\n"
                        + choice4.getSelectedItem().toString() + "\n" +choice5.getSelectedItem().toString() +"\n" + jTextField1.getText();
        return string;
    }
    
    public List<String> returnSelection(){
        List<String> newSelection = new ArrayList<>();
        newSelection.add(choice1.getSelectedItem().toString());
        newSelection.add(choice2.getSelectedItem().toString());
        newSelection.add(choice3.getSelectedItem().toString());
        newSelection.add(choice4.getSelectedItem().toString());
        newSelection.add(choice5.getSelectedItem().toString());
        newSelection.add(jTextField1.getText());
        return newSelection;
    }
    
    public void addOKButtonListener(ActionListener AL) {
        OKButton.addActionListener(AL);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        choice1 = new javax.swing.JComboBox();
        choice2 = new javax.swing.JComboBox();
        choice3 = new javax.swing.JComboBox();
        choice4 = new javax.swing.JComboBox();
        choice5 = new javax.swing.JComboBox();
        OKButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(307, 344));
        setMinimumSize(new java.awt.Dimension(307, 344));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(40, 40, 40));
        jPanel1.setPreferredSize(new java.awt.Dimension(307, 344));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pick Your Top Five");

        choice1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "resturant", "breakfast", "lunch", "dinner", "hotel", "coffee", "shopping", "bar", "movies", "parks", "beauty and spas", "arts and crafts" }));

        choice2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "resturant", "breakfast", "lunch", "dinner", "hotel", "coffee", "shopping", "bar", "movies", "parks", "beauty and spas", "arts and crafts" }));

        choice3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "resturant", "breakfast", "lunch", "dinner", "hotel", "coffee", "shopping", "bar", "movies", "parks", "beauty and spas", "arts and crafts" }));

        choice4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "resturant", "breakfast", "lunch", "dinner", "hotel", "coffee", "shopping", "bar", "movies", "parks", "beauty and spas", "arts and crafts" }));

        choice5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "resturant", "breakfast", "lunch", "dinner", "hotel", "coffee", "shopping", "bar", "movies", "parks", "beauty and spas", "arts and crafts" }));

        OKButton.setText("OK");

        jTextField1.setText("jTextField1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter City:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(choice2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(choice3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(choice1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(choice4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(choice5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(119, 119, 119))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(choice2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(choice3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(choice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(choice4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(choice5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton OKButton;
    private javax.swing.JComboBox choice1;
    private javax.swing.JComboBox choice2;
    private javax.swing.JComboBox choice3;
    private javax.swing.JComboBox choice4;
    private javax.swing.JComboBox choice5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
