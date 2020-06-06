/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm_proje;


import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author gacar
 */
public class sinemalar extends javax.swing.JFrame {
    int mousepX;
    int mousepY;
    String  fileName=null;
    byte[] person_image;
    public sinemalar() {
        this.person_image = null;
        initComponents();
        lastMovie();


      

        showDate();
        

        
        panel_ArananFilm.setVisible(false);

    }   
         //film göstermek için

    ArrayList<Film> oldMovies = new ArrayList<>();
    ArrayList<Film> newMovies = new ArrayList<>();
    ArrayList<Film> aksiyonFilmleri = new ArrayList<>();
    ArrayList<Film> ustPuan = new ArrayList<>();
    
    public ArrayList<Film> FilmList(){
        
        
                try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;user=sa;password=123;databaseName=sineDB;";

            Connection con = DriverManager.getConnection(url);
                String sql = "SELECT * FROM filmler WHERE FilmYil<'2000'";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            

            Film film;
            while(rs.next()){
                film = new Film(rs.getInt("Id"),rs.getString("filmAd"),rs.getString("filmKonu"),rs.getString("filmYonetmen"),rs.getString("FilmYil"),rs.getString("FilmTur"),rs.getString("filmPuan"),rs.getString("filmID"),rs.getBytes("FilmResimler"));
                oldMovies.add(film);
            }

              jTable_Display_Movies.setModel(new DefaultTableModel(null,new String[]{"Id","FilmAd","FilmYonetmen","FilmYil","FilmTur","FilmPuan","FilmID"}));
         

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
                return oldMovies;
    }

    public void show_old_movies(){
        ArrayList<Film> list = FilmList();
        DefaultTableModel model = (DefaultTableModel)jTable_Display_Movies.getModel();
        Object[] row = new Object[7];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getId();
            row[1]=list.get(i).getFilmAdi();
//            row[2]=list.get(i).getFilmKonu();
            row[2]=list.get(i).getFilmYonetmen();
            row[3]=list.get(i).getFilmYil();
            row[4]=list.get(i).getFilmTur();
            row[5]=list.get(i).getFilmPuan();
            row[6]=list.get(i).getFilmID();
//            row[8]=list.get(i).getImage();

            model.addRow(row);

        }
                          
    }
            public ArrayList<Film> newFilms(){
                try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;user=sa;password=123;databaseName=sineDB;";

            Connection con = DriverManager.getConnection(url);
            String sql = "SELECT * FROM filmler WHERE FilmYil>='2000'";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            

            Film film;
            while(rs.next()){
                film = new Film(rs.getInt("Id"),rs.getString("filmAd"),rs.getString("filmKonu"),rs.getString("filmYonetmen"),rs.getString("FilmYil"),rs.getString("FilmTur"),rs.getString("filmPuan"),rs.getString("filmID"),rs.getBytes("FilmResimler"));
                newMovies.add(film);
            }

              jTable_Display_Movies.setModel(new DefaultTableModel(null,new String[]{"Id","FilmAd","FilmYonetmen","FilmYil","FilmTur","FilmPuan","FilmID"}));
         

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
                return newMovies;
    }
        public void show_new_movies(){

        ArrayList<Film> list = newFilms();
        DefaultTableModel model = (DefaultTableModel)jTable_Display_Movies.getModel();
        Object[] row = new Object[7];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getId();
            row[1]=list.get(i).getFilmAdi();
//            row[2]=list.get(i).getFilmKonu();
            row[2]=list.get(i).getFilmYonetmen();
            row[3]=list.get(i).getFilmYil();
            row[4]=list.get(i).getFilmTur();
            row[5]=list.get(i).getFilmPuan();
            row[6]=list.get(i).getFilmID();
//            row[8]=list.get(i).getImage();

            model.addRow(row);

        }
                                  
    }
       public ArrayList<Film> aksiyonGoster(){
                try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;user=sa;password=123;databaseName=sineDB;";

            Connection con = DriverManager.getConnection(url);
            String sql = "SELECT * FROM filmler WHERE FilmTur='Aksiyon'";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            

            Film film;
            while(rs.next()){
                film = new Film(rs.getInt("Id"),rs.getString("filmAd"),rs.getString("filmKonu"),rs.getString("filmYonetmen"),rs.getString("FilmYil"),rs.getString("FilmTur"),rs.getString("filmPuan"),rs.getString("filmID"),rs.getBytes("FilmResimler"));
                aksiyonFilmleri.add(film);
            }

              jTable_Display_Movies.setModel(new DefaultTableModel(null,new String[]{"Id","FilmAd","FilmYonetmen","FilmYil","FilmTur","FilmPuan","FilmID"}));
         

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
                return aksiyonFilmleri;
    }
                            public void show_aksiyon_filmleri(){

        ArrayList<Film> list = aksiyonGoster();
        DefaultTableModel model = (DefaultTableModel)jTable_Display_Movies.getModel();
        Object[] row = new Object[7];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getId();
            row[1]=list.get(i).getFilmAdi();
//            row[2]=list.get(i).getFilmKonu();
            row[2]=list.get(i).getFilmYonetmen();
            row[3]=list.get(i).getFilmYil();
            row[4]=list.get(i).getFilmTur();
            row[5]=list.get(i).getFilmPuan();
            row[6]=list.get(i).getFilmID();
//            row[8]=list.get(i).getImage();

            model.addRow(row);

        }
                                  
    }
                            
                            
                                   public ArrayList<Film> puanGoster(){
                try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;user=sa;password=123;databaseName=sineDB;";

            Connection con = DriverManager.getConnection(url);
            String sql = "SELECT * FROM filmler WHERE FilmPuan>='6'";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            

            Film film;
            while(rs.next()){
                film = new Film(rs.getInt("Id"),rs.getString("filmAd"),rs.getString("filmKonu"),rs.getString("filmYonetmen"),rs.getString("FilmYil"),rs.getString("FilmTur"),rs.getString("filmPuan"),rs.getString("filmID"),rs.getBytes("FilmResimler"));
                ustPuan.add(film);
            }

              jTable_Display_Movies.setModel(new DefaultTableModel(null,new String[]{"Id","FilmAd","FilmYonetmen","FilmYil","FilmTur","FilmPuan","FilmID"}));
         

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
                return ustPuan;
    }
                            public void show_6UstuPuan(){

        ArrayList<Film> list = puanGoster();
        DefaultTableModel model = (DefaultTableModel)jTable_Display_Movies.getModel();
        Object[] row = new Object[7];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getId();
            row[1]=list.get(i).getFilmAdi();
//            row[2]=list.get(i).getFilmKonu();
            row[2]=list.get(i).getFilmYonetmen();
            row[3]=list.get(i).getFilmYil();
            row[4]=list.get(i).getFilmTur();
            row[5]=list.get(i).getFilmPuan();
            row[6]=list.get(i).getFilmID();
//            row[8]=list.get(i).getImage();

            model.addRow(row);

        }
                                  
    }
                    
    void showDate(){
        Date d = new Date();
        SimpleDateFormat s= new SimpleDateFormat("dd-MM-yyyy");
        lbl_tarih.setText("Tarih: "+s.format(d));
    }

 
    void lastMovie(){
                 try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;user=sa;password=123;databaseName=sineDB;";

            Connection con = DriverManager.getConnection(url);
            String sql = "SELECT TOP 1 * FROM filmler ORDER BY Id DESC";
            PreparedStatement pst = con.prepareStatement(sql);
//            pst.setString(1, txt_FilmAra.getText());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){

            String setAd=rs.getString("FilmAd");
            s_filmAdi.setText("Film Adı: "+setAd);
                
             String setYonetmen=rs.getString("FilmYonetmen");
             s_FilmYonetmen.setText("Film Yönetmen: "+setYonetmen);          
             
            
             byte[] img  = rs.getBytes("FilmResimler");
             ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lbl_image1.getWidth(),lbl_image1.getHeight(),Image.SCALE_SMOOTH));
             lbl_image1.setIcon(imageIcon);   
             person_image=img;
                             
            }
            


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ana_panel = new javax.swing.JPanel();
        alt_panel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbl_image1 = new javax.swing.JLabel();
        s_filmAdi = new javax.swing.JLabel();
        s_FilmYonetmen = new javax.swing.JLabel();
        panel_ArananFilm = new javax.swing.JPanel();
        lbl_image2 = new javax.swing.JLabel();
        lbl_filmAdi = new javax.swing.JLabel();
        lbl_FilmYonetmen = new javax.swing.JLabel();
        sonEklenenF12 = new javax.swing.JLabel();
        txt_FilmAra = new javax.swing.JTextField();
        sonEklenenF2 = new javax.swing.JLabel();
        cmb_filmSorgu = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Display_Movies = new javax.swing.JTable();
        ust_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_sinego = new javax.swing.JLabel();
        lbl_exit = new javax.swing.JLabel();
        lbl_tarih = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(34, 38, 41));
        setUndecorated(true);
        setResizable(false);

        ana_panel.setBackground(new java.awt.Color(34, 38, 41));
        ana_panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                ana_panelMouseDragged(evt);
            }
        });
        ana_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ana_panelMousePressed(evt);
            }
        });

        alt_panel.setBackground(new java.awt.Color(34, 38, 41));

        jPanel1.setBackground(new java.awt.Color(53, 58, 62));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(71, 75, 79), 1, true));

        lbl_image1.setBackground(new java.awt.Color(255, 102, 102));
        lbl_image1.setForeground(new java.awt.Color(197, 198, 199));
        lbl_image1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_image1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(134, 194, 50), 3));

        s_filmAdi.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        s_filmAdi.setForeground(new java.awt.Color(255, 255, 255));
        s_filmAdi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        s_filmAdi.setText("Film Adı");

        s_FilmYonetmen.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        s_FilmYonetmen.setForeground(new java.awt.Color(197, 198, 199));
        s_FilmYonetmen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        s_FilmYonetmen.setText("Yönetmen");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(s_FilmYonetmen, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
            .addComponent(s_filmAdi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(lbl_image1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_image1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(s_filmAdi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(s_FilmYonetmen)
                .addContainerGap())
        );

        panel_ArananFilm.setBackground(new java.awt.Color(53, 58, 62));
        panel_ArananFilm.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(71, 75, 79), 1, true));

        lbl_image2.setBackground(new java.awt.Color(255, 102, 102));
        lbl_image2.setForeground(new java.awt.Color(197, 198, 199));
        lbl_image2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_image2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        lbl_filmAdi.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lbl_filmAdi.setForeground(new java.awt.Color(255, 255, 255));
        lbl_filmAdi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_filmAdi.setText("Film Adı");

        lbl_FilmYonetmen.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lbl_FilmYonetmen.setForeground(new java.awt.Color(197, 198, 199));
        lbl_FilmYonetmen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_FilmYonetmen.setText("Yönetmen");

        javax.swing.GroupLayout panel_ArananFilmLayout = new javax.swing.GroupLayout(panel_ArananFilm);
        panel_ArananFilm.setLayout(panel_ArananFilmLayout);
        panel_ArananFilmLayout.setHorizontalGroup(
            panel_ArananFilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_FilmYonetmen, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
            .addComponent(lbl_filmAdi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_ArananFilmLayout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(lbl_image2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_ArananFilmLayout.setVerticalGroup(
            panel_ArananFilmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ArananFilmLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_image2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_filmAdi)
                .addGap(12, 12, 12)
                .addComponent(lbl_FilmYonetmen)
                .addContainerGap())
        );

        sonEklenenF12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        sonEklenenF12.setForeground(new java.awt.Color(197, 198, 199));
        sonEklenenF12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sonEklenenF12.setText("Film Ara(ID)");

        txt_FilmAra.setBackground(new java.awt.Color(34, 38, 41));
        txt_FilmAra.setForeground(new java.awt.Color(197, 198, 199));
        txt_FilmAra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_FilmAraKeyReleased(evt);
            }
        });

        sonEklenenF2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        sonEklenenF2.setForeground(new java.awt.Color(197, 198, 199));
        sonEklenenF2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sonEklenenF2.setText("En son eklenen film");

        cmb_filmSorgu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seçim Yapınız...", "2000 öncesi filmler", "2000 sonrası filmler", "Aksiyon filmleri", "Puanı 6 dan yüksek filmler" }));
        cmb_filmSorgu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_filmSorguActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(34, 38, 41));

        jTable_Display_Movies.setBackground(new java.awt.Color(34, 38, 41));
        jTable_Display_Movies.setForeground(new java.awt.Color(197, 198, 199));
        jTable_Display_Movies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Film Adı", "FilmYonetmen", "Yapım Yılı", "Film Tur", "Film Puan", "FilmID"
            }
        ));
        jTable_Display_Movies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Display_MoviesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_Display_Movies);

        javax.swing.GroupLayout alt_panelLayout = new javax.swing.GroupLayout(alt_panel);
        alt_panel.setLayout(alt_panelLayout);
        alt_panelLayout.setHorizontalGroup(
            alt_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alt_panelLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(alt_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, alt_panelLayout.createSequentialGroup()
                        .addGroup(alt_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmb_filmSorgu, javax.swing.GroupLayout.Alignment.LEADING, 0, 345, Short.MAX_VALUE)
                            .addComponent(sonEklenenF2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(132, 132, 132)
                        .addGroup(alt_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel_ArananFilm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sonEklenenF12, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_FilmAra, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(85, 85, 85))
        );
        alt_panelLayout.setVerticalGroup(
            alt_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alt_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(alt_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sonEklenenF2, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addGroup(alt_panelLayout.createSequentialGroup()
                        .addComponent(sonEklenenF12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_FilmAra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(alt_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_ArananFilm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(cmb_filmSorgu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        ust_panel.setBackground(new java.awt.Color(71, 75, 79));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(197, 198, 199));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sinemalar");

        lbl_sinego.setFont(new java.awt.Font("Bebas Neue Bold", 1, 48)); // NOI18N
        lbl_sinego.setForeground(new java.awt.Color(69, 162, 158));
        lbl_sinego.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_sinego.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N

        lbl_exit.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        lbl_exit.setForeground(new java.awt.Color(197, 198, 199));
        lbl_exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_exit.setText("X");
        lbl_exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_exit.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        lbl_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_exitMouseClicked(evt);
            }
        });

        lbl_tarih.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lbl_tarih.setForeground(new java.awt.Color(197, 198, 199));
        lbl_tarih.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_tarih.setText("Tarih:");

        javax.swing.GroupLayout ust_panelLayout = new javax.swing.GroupLayout(ust_panel);
        ust_panel.setLayout(ust_panelLayout);
        ust_panelLayout.setHorizontalGroup(
            ust_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ust_panelLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lbl_sinego)
                .addGap(18, 18, 18)
                .addGroup(ust_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lbl_tarih))
                .addGap(656, 656, 656)
                .addComponent(lbl_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ust_panelLayout.setVerticalGroup(
            ust_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_sinego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ust_panelLayout.createSequentialGroup()
                .addComponent(lbl_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(ust_panelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_tarih)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ana_panelLayout = new javax.swing.GroupLayout(ana_panel);
        ana_panel.setLayout(ana_panelLayout);
        ana_panelLayout.setHorizontalGroup(
            ana_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ust_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ana_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(alt_panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ana_panelLayout.setVerticalGroup(
            ana_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ana_panelLayout.createSequentialGroup()
                .addComponent(ust_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 576, Short.MAX_VALUE))
            .addGroup(ana_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ana_panelLayout.createSequentialGroup()
                    .addGap(102, 102, 102)
                    .addComponent(alt_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ana_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ana_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lbl_exitMouseClicked

    private void ana_panelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ana_panelMousePressed
        mousepX = evt.getX();
        mousepY = evt.getY();
    }//GEN-LAST:event_ana_panelMousePressed

    private void ana_panelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ana_panelMouseDragged
                    int kordinatX = evt.getXOnScreen();
        int kordinatY = evt.getYOnScreen();
        this.setLocation(kordinatX-mousepX,kordinatY-mousepY);
        //System.out.println(kordinatX+","+kordinatY);
    }//GEN-LAST:event_ana_panelMouseDragged

    private void txt_FilmAraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_FilmAraKeyReleased
       
       if(txt_FilmAra.getText().trim().isEmpty()){
            panel_ArananFilm.setVisible(false);
        }else{
            panel_ArananFilm.setVisible(true);
       
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;user=sa;password=123;databaseName=sineDB;";

            Connection con = DriverManager.getConnection(url);
            String sql = "SELECT * FROM filmler WHERE Id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, txt_FilmAra.getText());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){

            String setAd=rs.getString("FilmAd");
            lbl_filmAdi.setText("Film Adı: "+setAd);
                
             String setYonetmen=rs.getString("FilmYonetmen");
             lbl_FilmYonetmen.setText("Film Yönetmen: "+setYonetmen);          
             
            
             byte[] img  = rs.getBytes("FilmResimler");
             ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lbl_image2.getWidth(),lbl_image2.getHeight(),Image.SCALE_SMOOTH));
             lbl_image2.setIcon(imageIcon);   
             person_image=img;
                             
            }
            else{
                panel_ArananFilm.setVisible(false);
                JOptionPane.showMessageDialog(null,"aradığınız ID de film bulunamadı!");    
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
         }
    }//GEN-LAST:event_txt_FilmAraKeyReleased
    void temizle(){
//        DefaultTableModel dm = (DefaultTableModel)jTable_Display_Movies.getModel();
//        dm.getDataVector().removeAllElements();
//        dm.fireTableDataChanged();

              jTable_Display_Movies.setModel(new DefaultTableModel(null,new String[]{"Id","FilmAd","FilmYonetmen","FilmTur","FilmYil","FilmPuan","FilmID"}));
         
    }
    private void cmb_filmSorguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_filmSorguActionPerformed
        
        if(cmb_filmSorgu.getSelectedIndex()==1){           
           show_old_movies();
        }
        else if(cmb_filmSorgu.getSelectedIndex()==2){
            show_new_movies();
        }
        else if(cmb_filmSorgu.getSelectedIndex()==3){
             show_aksiyon_filmleri();
        }
        else{
            show_6UstuPuan();
        }

    }//GEN-LAST:event_cmb_filmSorguActionPerformed

    private void jTable_Display_MoviesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Display_MoviesMouseClicked

        //        byte[] img = (FilmList().get(2).getImage());
        //        ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lbl_image.getWidth(),lbl_image.getHeight(),Image.SCALE_SMOOTH));
        //        lbl_resimGoster.setIcon(imageIcon);
    }//GEN-LAST:event_jTable_Display_MoviesMouseClicked

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
            java.util.logging.Logger.getLogger(sinemalar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sinemalar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sinemalar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sinemalar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sinemalar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel alt_panel;
    private javax.swing.JPanel ana_panel;
    private javax.swing.JComboBox<String> cmb_filmSorgu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_Display_Movies;
    private javax.swing.JLabel lbl_FilmYonetmen;
    private javax.swing.JLabel lbl_exit;
    private javax.swing.JLabel lbl_filmAdi;
    private javax.swing.JLabel lbl_image1;
    private javax.swing.JLabel lbl_image2;
    private javax.swing.JLabel lbl_sinego;
    private javax.swing.JLabel lbl_tarih;
    private javax.swing.JPanel panel_ArananFilm;
    private javax.swing.JLabel s_FilmYonetmen;
    private javax.swing.JLabel s_filmAdi;
    private javax.swing.JLabel sonEklenenF12;
    private javax.swing.JLabel sonEklenenF2;
    private javax.swing.JTextField txt_FilmAra;
    private javax.swing.JPanel ust_panel;
    // End of variables declaration//GEN-END:variables
}
