package top5v2;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.net.URL;
import java.io.IOException;
import javafx.embed.swing.JFXPanel;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Group;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JPanel;

public class Version2 extends javax.swing.JFrame {
List<JButton> panels;
private maps panel;

    /**
     * Creates new form Version2
     */
    public Version2() {
        initComponents();
        initPanels();
    }
public void initPanels() {
    
        panels = new ArrayList<>();
        panels.add(panel1);
        panels.add(panel2);
        panels.add(panel3);
        panels.add(panel4);
        panels.add(panel5);
        
        panel = new maps();
        
        panel.setBounds(880, 80, 500, 425); // sets bounds of the JFXPanel holding the browser
        panel.setEnabled(true);
        panel.setVisible(true);
        add(panel);
        setVisible(true);
        
        jTextArea1.setWrapStyleWord(true);
    }


    // Creates a map panel, which holds the code for a browser which opens an HTML file for the google maps api. 

    private class maps extends JPanel {
        
        private WebView browser;
        private JFXPanel jfxPanel;
        private WebEngine webEngine;
        
        public maps(){
            new JFXPanel(); // constructor calls for a JFXPanel, needed to set up libraries
            Platform.runLater(new Runnable(){ // needs to run in its own thread
                @Override
                public void run() {
                    initComponents();
                }
            });
        }
        
        public void setGoogleAddress(String address){
            Platform.runLater(new Runnable() { // Any method from JavaFX needs its own thread in order to run
                @Override
                public void run() {
                   if (webEngine != null){
                       webEngine.executeScript("setAddress(" + address + ")"); // Executes javascript function in newhtml.html          
                   }
                }
            });
        }
        
        private void initComponents(){
            jfxPanel = new JFXPanel();
            Scene scene = createScene();
            jfxPanel.setScene(scene);
            setLayout(new BorderLayout());
            add(jfxPanel, BorderLayout.CENTER);
        }
        
        private Scene createScene(){
            Group root = new Group();
            Scene scene = new Scene(root, 500, 500);
            
            browser = new WebView(); // creates a browser 
            
            browser.setMaxSize(500, 425); // sets browser size
            webEngine = browser.getEngine();
            webEngine.load(getClass().getResource("newhtml.html").toExternalForm());
            webEngine.setJavaScriptEnabled(true);
            
            ObservableList<Node> children = root.getChildren();
            children.add(browser);
            
            return (scene);
        }
    }
        
    public void setNewGoogle(String address){
        panel.setGoogleAddress(address);
    }
    
    public void addSettingsListener(ActionListener listener){
        jButton14.addActionListener(listener);
    }
    
    public void setPanel(int panel, String text) {
        panels.get(panel).setText(text);   
    }
    
    public void addButtonOneListener(ActionListener listener) {
        panel1.addActionListener(listener);
    }
    
    public void addButtonTwoListener(ActionListener listener) {
        panel2.addActionListener(listener);
    }
    
    public void addButtonThreeListener(ActionListener listener) {
        panel3.addActionListener(listener);
    }
    
    public void addButtonFourListener(ActionListener listener) {
        panel4.addActionListener(listener);
    }
    
    public void addButtonFiveListener(ActionListener listener) {
        panel5.addActionListener(listener);
    }
    
    public void addRestaurantButtonActionListener(ActionListener listener){
        jButton1.addActionListener(listener);
    }
    
    public void addShoppingButtonActionListener(ActionListener listener){
        jButton2.addActionListener(listener);
    }
    
    public void addBarsButtonActionListener(ActionListener listener){
        jButton3.addActionListener(listener);
    }
    
    public void addTheatresButtonActionListener(ActionListener listener){
        jButton4.addActionListener(listener);
    }
    
    public void addHotelsButtonActionListener(ActionListener listener){
        jButton5.addActionListener(listener);
    }
    
    public void addCoffeeButtonActionListener(ActionListener listener){
        jButton6.addActionListener(listener);
    }
    
    public void addDinnerButtonActionListener(ActionListener listener){
        jButton8.addActionListener(listener);
    }
    
    public void addLunchButtonActionListener(ActionListener listener){
        jButton9.addActionListener(listener);
    }
    
    public void addBreakfastButtonActionListener(ActionListener listener){
        jButton10.addActionListener(listener);
    }
    
    public void addParkButtonActionListener(ActionListener listener){
        jButton11.addActionListener(listener);
    }
    
    public void addArtsButtonActionListener(ActionListener listener){
        jButton12.addActionListener(listener);
    }
    
    public void addSpaButtonActionListener(ActionListener listener){
        jButton13.addActionListener(listener);
    }
    
    public void addLinkButtonListener(ActionListener AL){
        jButton7.addActionListener(AL);
    }
    
    public void setName(String name){
        jLabel6.setText(name);
    }
    
    public void setWebsite(String website){
        jButton7.setText(website);
    }
    
    public void setPhone(String phone){
        jLabel14.setText(phone);
    }
    
    public void setRatings(ArrayList<URL> ratings){
        ImageIcon[] images = new ImageIcon[5];
        Image image = null;
        int count = 0;
        for (URL url: ratings){
            try {
                image = ImageIO.read(url);
            } catch (IOException e){
                e.printStackTrace();
            }
            ImageIcon icon = new ImageIcon(image);
            images[count] = icon;
            count++;
        }
        jLabel7.setIcon(images[0]);
        jLabel8.setIcon(images[1]);
        jLabel9.setIcon(images[2]);
        jLabel10.setIcon(images[3]);
        jLabel11.setIcon(images[4]);
    }
    
    public void setCategory(String category){
        if (category.compareTo("Coffee") == 0 || category.compareTo("Shopping") == 0
                || category.compareTo("Dinner") == 0 || category.compareTo("Lunch") == 0
                || category.compareTo("Breakfast") == 0 || category.compareTo("Arts & Crafts") == 0)
                
            jLabel1.setText(category + " Spots");
        else
            jLabel1.setText(category);
    }
    
    public void resetCategory() {
        jLabel1.setText("");
    }
    
    public void setReviewCount(Long reviewCount){
        jLabel16.setText(Long.toString(reviewCount));
    }
    
    public void setReview(String review){
        jTextArea1.setLineWrap(true);
        jTextArea1.setText(review);
    }
    
    public void setRating(URL rating){
        Image image = null;
        try {
            image = ImageIO.read(rating);
        } catch (IOException e){
            e.printStackTrace();
        }
        ImageIcon icon = new ImageIcon(image);
        jLabel5.setIcon(icon);
    }
    
    public void setImage(URL url){
        Image image = null;
        try {
            image = ImageIO.read(url);
        } catch (IOException e){
            e.printStackTrace();
        }
        ImageIcon icon = new ImageIcon(image);
        
        jLabel12.setIcon(icon);
    }
    
    public void setImage(ImageIcon image){
        jLabel12.setIcon(image);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        panel1 = new javax.swing.JButton();
        panel2 = new javax.swing.JButton();
        panel3 = new javax.swing.JButton();
        panel4 = new javax.swing.JButton();
        panel5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 23, 1300, 750));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1350, 750));

        panel1.setBackground(new java.awt.Color(40, 40, 40));
        panel1.setFont(new java.awt.Font("Menlo", 1, 24)); // NOI18N
        panel1.setForeground(new java.awt.Color(100, 100, 100));
        panel1.setText("number1");
        panel1.setBorderPainted(false);
        panel1.setFocusPainted(false);
        panel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        panel1.setIconTextGap(20);

        panel2.setBackground(new java.awt.Color(40, 40, 40));
        panel2.setFont(new java.awt.Font("Menlo", 1, 24)); // NOI18N
        panel2.setForeground(new java.awt.Color(100, 100, 100));
        panel2.setText("number1");
        panel2.setBorderPainted(false);
        panel2.setFocusPainted(false);
        panel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        panel2.setIconTextGap(20);
        panel2.setMaximumSize(new java.awt.Dimension(300, 62));

        panel3.setBackground(new java.awt.Color(40, 40, 40));
        panel3.setFont(new java.awt.Font("Menlo", 1, 24)); // NOI18N
        panel3.setForeground(new java.awt.Color(100, 100, 100));
        panel3.setText("number1");
        panel3.setBorderPainted(false);
        panel3.setFocusPainted(false);
        panel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        panel3.setIconTextGap(20);

        panel4.setBackground(new java.awt.Color(40, 40, 40));
        panel4.setFont(new java.awt.Font("Menlo", 1, 24)); // NOI18N
        panel4.setForeground(new java.awt.Color(100, 100, 100));
        panel4.setText("number1");
        panel4.setBorderPainted(false);
        panel4.setFocusPainted(false);
        panel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        panel4.setIconTextGap(20);
        panel4.setMaximumSize(new java.awt.Dimension(300, 62));

        panel5.setBackground(new java.awt.Color(40, 40, 40));
        panel5.setFont(new java.awt.Font("Menlo", 1, 24)); // NOI18N
        panel5.setForeground(new java.awt.Color(100, 100, 100));
        panel5.setText("number1");
        panel5.setAutoscrolls(true);
        panel5.setBorderPainted(false);
        panel5.setFocusPainted(false);
        panel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        panel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        panel5.setIconTextGap(20);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Top Five");

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/top5v2/pictures/restaurant.png"))); // NOI18N
        jButton1.setText("Restaurants");
        jButton1.setToolTipText("");
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMaximumSize(new java.awt.Dimension(200, 110));
        jButton1.setMinimumSize(new java.awt.Dimension(200, 110));
        jButton1.setPreferredSize(new java.awt.Dimension(200, 110));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Luminari", 3, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(200, 200, 200));
        jLabel3.setText("Categories");

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/top5v2/pictures/retail.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setFocusPainted(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setLabel("Shopping");
        jButton2.setMaximumSize(new java.awt.Dimension(200, 110));
        jButton2.setMinimumSize(new java.awt.Dimension(200, 110));
        jButton2.setPreferredSize(new java.awt.Dimension(200, 110));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/top5v2/pictures/bar.png"))); // NOI18N
        jButton3.setText("Bars");
        jButton3.setBorderPainted(false);
        jButton3.setFocusPainted(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setMaximumSize(new java.awt.Dimension(200, 110));
        jButton3.setMinimumSize(new java.awt.Dimension(200, 110));
        jButton3.setPreferredSize(new java.awt.Dimension(200, 110));

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/top5v2/pictures/movieTheatre.png"))); // NOI18N
        jButton4.setText("Theatres");
        jButton4.setBorderPainted(false);
        jButton4.setFocusPainted(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setMaximumSize(new java.awt.Dimension(200, 110));
        jButton4.setMinimumSize(new java.awt.Dimension(200, 110));
        jButton4.setPreferredSize(new java.awt.Dimension(200, 110));

        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/top5v2/pictures/hotel.png"))); // NOI18N
        jButton5.setText("Hotels");
        jButton5.setBorderPainted(false);
        jButton5.setFocusPainted(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setMaximumSize(new java.awt.Dimension(200, 110));
        jButton5.setMinimumSize(new java.awt.Dimension(200, 110));
        jButton5.setPreferredSize(new java.awt.Dimension(200, 110));

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/top5v2/pictures/coffee.png"))); // NOI18N
        jButton6.setText("Coffee");
        jButton6.setBorderPainted(false);
        jButton6.setFocusPainted(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setMaximumSize(new java.awt.Dimension(200, 110));
        jButton6.setMinimumSize(new java.awt.Dimension(200, 110));
        jButton6.setPreferredSize(new java.awt.Dimension(200, 110));

        jPanel2.setBackground(new java.awt.Color(200, 200, 200));
        jPanel2.setPreferredSize(new java.awt.Dimension(1350, 5));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1350, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Website :");

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 102, 255));
        jButton7.setText("jButton7");
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setFocusPainted(false);
        jButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jButton7.setPreferredSize(new java.awt.Dimension(100, 22));

        jLabel5.setPreferredSize(new java.awt.Dimension(166, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("jLabel6");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));

        jLabel12.setToolTipText("");
        jLabel12.setAutoscrolls(true);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Phone #:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("jLabel14");

        jButton8.setBackground(new java.awt.Color(0, 0, 0));
        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/top5v2/pictures/Dinner.png"))); // NOI18N
        jButton8.setText("Dinner");
        jButton8.setBorderPainted(false);
        jButton8.setFocusPainted(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setMaximumSize(new java.awt.Dimension(200, 110));
        jButton8.setMinimumSize(new java.awt.Dimension(200, 110));
        jButton8.setPreferredSize(new java.awt.Dimension(200, 110));

        jButton9.setBackground(new java.awt.Color(0, 0, 0));
        jButton9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/top5v2/pictures/lunch.png"))); // NOI18N
        jButton9.setText("Lunch");
        jButton9.setBorderPainted(false);
        jButton9.setFocusPainted(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setMaximumSize(new java.awt.Dimension(200, 110));
        jButton9.setMinimumSize(new java.awt.Dimension(200, 110));
        jButton9.setPreferredSize(new java.awt.Dimension(200, 110));

        jButton10.setBackground(new java.awt.Color(0, 0, 0));
        jButton10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/top5v2/pictures/breakfast.png"))); // NOI18N
        jButton10.setText("Breakfast");
        jButton10.setBorderPainted(false);
        jButton10.setFocusPainted(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setMaximumSize(new java.awt.Dimension(200, 110));
        jButton10.setMinimumSize(new java.awt.Dimension(200, 110));
        jButton10.setPreferredSize(new java.awt.Dimension(200, 110));

        jButton11.setBackground(new java.awt.Color(0, 0, 0));
        jButton11.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/top5v2/pictures/park.png"))); // NOI18N
        jButton11.setText("Parks");
        jButton11.setBorderPainted(false);
        jButton11.setFocusPainted(false);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setMaximumSize(new java.awt.Dimension(200, 110));
        jButton11.setMinimumSize(new java.awt.Dimension(200, 110));
        jButton11.setPreferredSize(new java.awt.Dimension(200, 110));

        jButton12.setBackground(new java.awt.Color(0, 0, 0));
        jButton12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/top5v2/pictures/art.png"))); // NOI18N
        jButton12.setText("Arts & Crafts");
        jButton12.setBorderPainted(false);
        jButton12.setFocusPainted(false);
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setMaximumSize(new java.awt.Dimension(200, 110));
        jButton12.setMinimumSize(new java.awt.Dimension(200, 110));
        jButton12.setPreferredSize(new java.awt.Dimension(200, 110));

        jButton13.setBackground(new java.awt.Color(0, 0, 0));
        jButton13.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/top5v2/pictures/spa.png"))); // NOI18N
        jButton13.setText("Beauty & Spas");
        jButton13.setBorderPainted(false);
        jButton13.setFocusPainted(false);
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton13.setMaximumSize(new java.awt.Dimension(200, 110));
        jButton13.setMinimumSize(new java.awt.Dimension(200, 110));
        jButton13.setPreferredSize(new java.awt.Dimension(200, 110));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("# of Reviews :");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("jLabel16");

        jPanel5.setPreferredSize(new java.awt.Dimension(5, 450));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jTextArea1.setMaximumSize(new java.awt.Dimension(160, 90));
        jScrollPane1.setViewportView(jTextArea1);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Review Excerpt:");

        jButton14.setBackground(new java.awt.Color(0, 0, 0));
        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/top5v2/pictures/settingGear.png"))); // NOI18N
        jButton14.setBorderPainted(false);
        jButton14.setFocusPainted(false);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/top5v2/pictures/yelplogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(panel5, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(6, 6, 6)
                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(panel5, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)))))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1420, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton panel1;
    private javax.swing.JButton panel2;
    private javax.swing.JButton panel3;
    private javax.swing.JButton panel4;
    private javax.swing.JButton panel5;
    // End of variables declaration//GEN-END:variables
}
