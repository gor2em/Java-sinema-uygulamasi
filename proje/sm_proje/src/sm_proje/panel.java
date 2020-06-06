/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm_proje;

import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.table.*;

/**
 *
 * @author gacar
 */
public class panel extends javax.swing.JFrame {
    int mousepX;
    int mousepY;

    //resim ekleme
    String  fileName=null;
    byte[] person_image =null;
    
 
    
    public panel() {
        initComponents();
        
       
        
        
                getRandom();
              for(int i = 1920;i<=2020;i++){
          cmb_filmYil.addItem(i+"\n");
          g_filmYil.addItem(i+"\n");
      }
        show_user();
    }

     //film göstermek için
    public ArrayList<Film> FilmList(){
        ArrayList<Film> filmsList = new ArrayList<>();
                try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;user=sa;password=123;databaseName=sineDB;";

            Connection con = DriverManager.getConnection(url);
            String sql = "SELECT * FROM filmler";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            Film film;
            while(rs.next()){
                film = new Film(rs.getInt("id"),rs.getString("filmAd"),rs.getString("filmKonu"),rs.getString("filmYonetmen"),rs.getString("FilmYil"),rs.getString("FilmTur"),rs.getString("filmPuan"),rs.getString("filmID"),rs.getBytes("FilmResimler"));
                filmsList.add(film);
            }


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
                return filmsList;
    }
    void getRandom(){
                Random rnd = new Random();
        int n =rnd.nextInt(1000000)+1;
        String val=String.valueOf(n);
        txt_filmID.setText(val);
        txt_filmID.setEnabled(false);    
    }
    public void show_user(){
        ArrayList<Film> list = FilmList();
        DefaultTableModel model = (DefaultTableModel)jTable_Display_Movies.getModel();
        Object[] row = new Object[8];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getId();
            row[1]=list.get(i).getFilmAdi();
            row[2]=list.get(i).getFilmKonu();
            row[3]=list.get(i).getFilmYonetmen();
            row[4]=list.get(i).getFilmYil();
            row[5]=list.get(i).getFilmTur();
            row[6]=list.get(i).getFilmPuan();
            row[7]=list.get(i).getFilmID();
            //row[8]=list.get(i).getImage();
//            row[8]=list.get(i).getDate();
            model.addRow(row);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ana_panel = new javax.swing.JPanel();
        lbl_exit = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbl_sinego1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_image = new javax.swing.JLabel();
        btn_sinemalar = new javax.swing.JButton();
        sag_alt_panel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        txt_FilmAdi = new javax.swing.JTextField();
        lbl_sineoto1 = new javax.swing.JLabel();
        filmEkle = new javax.swing.JButton();
        lbl_sineoto2 = new javax.swing.JLabel();
        txt_filmID = new javax.swing.JTextField();
        lbl_sineoto3 = new javax.swing.JLabel();
        lbl_sineoto4 = new javax.swing.JLabel();
        lbl_sineoto5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_FilmKonu = new javax.swing.JTextArea();
        cmb_FilmPuan = new javax.swing.JComboBox<>();
        cmb_FilmTur = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txt_FilmYonetmen1 = new javax.swing.JTextField();
        lbl_sineoto13 = new javax.swing.JLabel();
        lbl_sineoto20 = new javax.swing.JLabel();
        cmb_filmYil = new javax.swing.JComboBox<>();
        btn_resimSEC = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        s_filmID = new javax.swing.JTextField();
        lbl_sineoto6 = new javax.swing.JLabel();
        filmSil = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        g_txtFilmID = new javax.swing.JTextField();
        lbl_sineoto7 = new javax.swing.JLabel();
        filmGuncelle = new javax.swing.JButton();
        g_FilmAdi = new javax.swing.JTextField();
        lbl_sineoto8 = new javax.swing.JLabel();
        g_FilmYonetmen = new javax.swing.JTextField();
        lbl_sineoto9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        g_FilmKonu = new javax.swing.JTextArea();
        lbl_sineoto10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmb_FilmTur1 = new javax.swing.JComboBox<>();
        cmb_FilmPuan1 = new javax.swing.JComboBox<>();
        lbl_sineoto11 = new javax.swing.JLabel();
        lbl_sineoto12 = new javax.swing.JLabel();
        lbl_sineoto14 = new javax.swing.JLabel();
        g_filmYil = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Display_Movies = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(134, 194, 50));
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

        jPanel1.setBackground(new java.awt.Color(34, 38, 41));
        jPanel1.setPreferredSize(new java.awt.Dimension(211, 226));

        lbl_sinego1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        lbl_sinego1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_sinego1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_sinego1.setText("Admin Panel");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N

        lbl_image.setBackground(new java.awt.Color(153, 0, 204));
        lbl_image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btn_sinemalar.setBackground(new java.awt.Color(134, 194, 50));
        btn_sinemalar.setForeground(new java.awt.Color(34, 38, 41));
        btn_sinemalar.setText("Sinemalara git!");
        btn_sinemalar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sinemalarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
            .addComponent(lbl_sinego1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_sinemalar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(lbl_sinego1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addComponent(lbl_image, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_sinemalar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sag_alt_panel.setBackground(new java.awt.Color(71, 75, 79));

        jTabbedPane1.setBackground(new java.awt.Color(134, 194, 50));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(71, 75, 79));

        txt_FilmAdi.setBackground(new java.awt.Color(34, 38, 41));
        txt_FilmAdi.setForeground(new java.awt.Color(197, 198, 199));

        lbl_sineoto1.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbl_sineoto1.setForeground(new java.awt.Color(197, 198, 199));
        lbl_sineoto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_sineoto1.setText("Film Adı");

        filmEkle.setBackground(new java.awt.Color(134, 194, 50));
        filmEkle.setForeground(new java.awt.Color(34, 38, 41));
        filmEkle.setText("Film Ekle");
        filmEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filmEkleActionPerformed(evt);
            }
        });

        lbl_sineoto2.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbl_sineoto2.setForeground(new java.awt.Color(197, 198, 199));
        lbl_sineoto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_sineoto2.setText("Film Konu");

        txt_filmID.setBackground(new java.awt.Color(34, 38, 41));
        txt_filmID.setForeground(new java.awt.Color(197, 198, 199));
        txt_filmID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_filmIDActionPerformed(evt);
            }
        });

        lbl_sineoto3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbl_sineoto3.setForeground(new java.awt.Color(197, 198, 199));
        lbl_sineoto3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_sineoto3.setText("Film Yönetmen");

        lbl_sineoto4.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbl_sineoto4.setForeground(new java.awt.Color(197, 198, 199));
        lbl_sineoto4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_sineoto4.setText("Film Tür");

        lbl_sineoto5.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbl_sineoto5.setForeground(new java.awt.Color(197, 198, 199));
        lbl_sineoto5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_sineoto5.setText("Film Puan");

        txt_FilmKonu.setBackground(new java.awt.Color(34, 38, 41));
        txt_FilmKonu.setColumns(20);
        txt_FilmKonu.setForeground(new java.awt.Color(197, 198, 199));
        txt_FilmKonu.setRows(5);
        jScrollPane1.setViewportView(txt_FilmKonu);

        cmb_FilmPuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        cmb_FilmPuan.setSelectedIndex(4);
        cmb_FilmPuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_FilmPuanActionPerformed(evt);
            }
        });

        cmb_FilmTur.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aksiyon", "Animasyon", "Belgesel", "Bilimkurgu", "Drama", "Fantastik, Macera", "Gerilim, Korku", "Komedi", "Romantik", "Suç", "Tarih", " " }));
        cmb_FilmTur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_FilmTurActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        txt_FilmYonetmen1.setBackground(new java.awt.Color(34, 38, 41));
        txt_FilmYonetmen1.setForeground(new java.awt.Color(197, 198, 199));

        lbl_sineoto13.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbl_sineoto13.setForeground(new java.awt.Color(197, 198, 199));
        lbl_sineoto13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_sineoto13.setText("Film ID");

        lbl_sineoto20.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbl_sineoto20.setForeground(new java.awt.Color(197, 198, 199));
        lbl_sineoto20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_sineoto20.setText("Film Yıl");

        cmb_filmYil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_filmYilActionPerformed(evt);
            }
        });

        btn_resimSEC.setText("Resim Ekle");
        btn_resimSEC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resimSECActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filmEkle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_resimSEC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cmb_filmYil, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_FilmYonetmen1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_sineoto1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_FilmAdi, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_sineoto2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_sineoto3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
                                .addComponent(lbl_sineoto20)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_filmID, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_sineoto13)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cmb_FilmTur, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lbl_sineoto4))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(lbl_sineoto5)
                                                .addComponent(cmb_FilmPuan, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbl_sineoto1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_FilmAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addComponent(lbl_sineoto2)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_sineoto3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_FilmYonetmen1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_sineoto20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmb_filmYil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_sineoto5)
                    .addComponent(lbl_sineoto4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb_FilmPuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_FilmTur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lbl_sineoto13)
                .addGap(5, 5, 5)
                .addComponent(txt_filmID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_resimSEC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(filmEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Film Ekle", jPanel3);

        jPanel4.setBackground(new java.awt.Color(71, 75, 79));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        s_filmID.setBackground(new java.awt.Color(34, 38, 41));
        s_filmID.setForeground(new java.awt.Color(197, 198, 199));

        lbl_sineoto6.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbl_sineoto6.setForeground(new java.awt.Color(197, 198, 199));
        lbl_sineoto6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_sineoto6.setText("Silinecek Film ID");

        filmSil.setBackground(new java.awt.Color(207, 0, 22));
        filmSil.setForeground(new java.awt.Color(197, 198, 199));
        filmSil.setText("Film Sil");
        filmSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filmSilActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(s_filmID)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbl_sineoto6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 313, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addComponent(filmSil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lbl_sineoto6))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(s_filmID, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(filmSil, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(350, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Film Sil", jPanel4);

        jPanel5.setBackground(new java.awt.Color(71, 75, 79));

        g_txtFilmID.setBackground(new java.awt.Color(34, 38, 41));
        g_txtFilmID.setForeground(new java.awt.Color(197, 198, 199));

        lbl_sineoto7.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbl_sineoto7.setForeground(new java.awt.Color(255, 255, 255));
        lbl_sineoto7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_sineoto7.setText("Güncellenecek Film ID");

        filmGuncelle.setBackground(new java.awt.Color(134, 194, 50));
        filmGuncelle.setForeground(new java.awt.Color(34, 38, 41));
        filmGuncelle.setText("Film Güncelle");
        filmGuncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filmGuncelleActionPerformed(evt);
            }
        });

        g_FilmAdi.setBackground(new java.awt.Color(34, 38, 41));
        g_FilmAdi.setForeground(new java.awt.Color(197, 198, 199));

        lbl_sineoto8.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbl_sineoto8.setForeground(new java.awt.Color(197, 198, 199));
        lbl_sineoto8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_sineoto8.setText("Film Adı");

        g_FilmYonetmen.setBackground(new java.awt.Color(34, 38, 41));
        g_FilmYonetmen.setForeground(new java.awt.Color(197, 198, 199));

        lbl_sineoto9.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbl_sineoto9.setForeground(new java.awt.Color(197, 198, 199));
        lbl_sineoto9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_sineoto9.setText("Film Yönetmen");

        g_FilmKonu.setBackground(new java.awt.Color(34, 38, 41));
        g_FilmKonu.setColumns(20);
        g_FilmKonu.setForeground(new java.awt.Color(197, 198, 199));
        g_FilmKonu.setRows(5);
        jScrollPane3.setViewportView(g_FilmKonu);

        lbl_sineoto10.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbl_sineoto10.setForeground(new java.awt.Color(197, 198, 199));
        lbl_sineoto10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_sineoto10.setText("Film Konu");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N

        cmb_FilmTur1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aksiyon", "Drama", "Komedi", "Bilimkurgu", "Macera-Fantastik" }));
        cmb_FilmTur1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_FilmTur1ActionPerformed(evt);
            }
        });

        cmb_FilmPuan1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
        cmb_FilmPuan1.setSelectedIndex(4);
        cmb_FilmPuan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_FilmPuan1ActionPerformed(evt);
            }
        });

        lbl_sineoto11.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbl_sineoto11.setForeground(new java.awt.Color(197, 198, 199));
        lbl_sineoto11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_sineoto11.setText("Film Puan");

        lbl_sineoto12.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbl_sineoto12.setForeground(new java.awt.Color(197, 198, 199));
        lbl_sineoto12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_sineoto12.setText("Film Tür");

        lbl_sineoto14.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        lbl_sineoto14.setForeground(new java.awt.Color(197, 198, 199));
        lbl_sineoto14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_sineoto14.setText("Film Yılı");

        g_filmYil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g_filmYilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filmGuncelle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(g_FilmAdi, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_sineoto10, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_sineoto8, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_sineoto9, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
                            .addComponent(lbl_sineoto14))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lbl_sineoto7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(g_txtFilmID)
                                    .addComponent(g_FilmYonetmen)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_sineoto12)
                                            .addComponent(cmb_FilmTur1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lbl_sineoto11, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmb_FilmPuan1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(g_filmYil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(101, 101, 101)))
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lbl_sineoto7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(g_txtFilmID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(lbl_sineoto8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(g_FilmAdi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lbl_sineoto10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_sineoto9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(g_FilmYonetmen, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_sineoto14)
                .addGap(13, 13, 13)
                .addComponent(g_filmYil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lbl_sineoto12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmb_FilmTur1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lbl_sineoto11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmb_FilmPuan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(filmGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Film Güncelle", jPanel5);

        jScrollPane2.setBackground(new java.awt.Color(34, 38, 41));

        jTable_Display_Movies.setBackground(new java.awt.Color(34, 38, 41));
        jTable_Display_Movies.setForeground(new java.awt.Color(197, 198, 199));
        jTable_Display_Movies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Film Adı", "Film Konu", "Film Yönetmen", "Yapım Yılı", "Film Tur", "Film Puan", "FilmID", "Vizyon Tarihi"
            }
        ));
        jTable_Display_Movies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Display_MoviesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_Display_Movies);
        if (jTable_Display_Movies.getColumnModel().getColumnCount() > 0) {
            jTable_Display_Movies.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable_Display_Movies.getColumnModel().getColumn(4).setResizable(false);
            jTable_Display_Movies.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Filmleri Göster", jPanel2);

        javax.swing.GroupLayout sag_alt_panelLayout = new javax.swing.GroupLayout(sag_alt_panel);
        sag_alt_panel.setLayout(sag_alt_panelLayout);
        sag_alt_panelLayout.setHorizontalGroup(
            sag_alt_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sag_alt_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(504, 504, 504))
        );
        sag_alt_panelLayout.setVerticalGroup(
            sag_alt_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sag_alt_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ana_panelLayout = new javax.swing.GroupLayout(ana_panel);
        ana_panel.setLayout(ana_panelLayout);
        ana_panelLayout.setHorizontalGroup(
            ana_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ana_panelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sag_alt_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ana_panelLayout.setVerticalGroup(
            ana_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ana_panelLayout.createSequentialGroup()
                .addComponent(lbl_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(sag_alt_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ana_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ana_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void lbl_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lbl_exitMouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked

    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jTable_Display_MoviesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Display_MoviesMouseClicked

//        byte[] img = (FilmList().get(2).getImage());
//        ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(lbl_image.getWidth(),lbl_image.getHeight(),Image.SCALE_SMOOTH));
//        lbl_resimGoster.setIcon(imageIcon);

    }//GEN-LAST:event_jTable_Display_MoviesMouseClicked

    private void g_filmYilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g_filmYilActionPerformed

    }//GEN-LAST:event_g_filmYilActionPerformed

    private void cmb_FilmPuan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_FilmPuan1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_FilmPuan1ActionPerformed

    private void cmb_FilmTur1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_FilmTur1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_FilmTur1ActionPerformed

    private void filmGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filmGuncelleActionPerformed
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;user=sa;password=123;databaseName=sineDB;";

            Connection con = DriverManager.getConnection(url);
            //int row = jTable_Display_Movies.getSelectedRow();
            //String value=(jTable_Display_Movies.getModel().getValueAt(row,0).toString());
            String sql = "UPDATE filmler SET FilmAd=?,FilmKonu=?,FilmYonetmen=?,FilmYil=?,FilmTur=?,FilmPuan=? WHERE filmID="+g_txtFilmID.getText();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1,g_FilmAdi.getText());
            pst.setString(2,g_FilmKonu.getText());
            pst.setString(3,g_FilmYonetmen.getText());

            String fYil,fTur,fPuan;

            fYil=g_filmYil.getSelectedItem().toString();
            pst.setString(4, fYil);

            fTur=cmb_FilmTur1.getSelectedItem().toString();
            pst.setString(5,fTur);

            fPuan=cmb_FilmPuan1.getSelectedItem().toString();
            pst.setString(6,fPuan);

            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)jTable_Display_Movies.getModel();
            model.setRowCount(0);
            show_user();

            JOptionPane.showMessageDialog(null,"Film Güncellendi!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_filmGuncelleActionPerformed

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked

    }//GEN-LAST:event_jPanel4MouseClicked

    private void filmSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filmSilActionPerformed

        int opt = JOptionPane.showConfirmDialog(null,"Silmek istediğinize emin misiniz?","Silme İşlemi",JOptionPane.YES_NO_OPTION);
        if(opt==0){

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433;user=sa;password=123;databaseName=sineDB;";

                Connection con = DriverManager.getConnection(url);
                //int row = jTable_Display_Movies.getSelectedRow();
                //String value=(jTable_Display_Movies.getModel().getValueAt(row,0).toString());
                String sql = "DELETE FROM  filmler WHERE filmID="+s_filmID.getText();
                PreparedStatement pst = con.prepareStatement(sql);

                pst.executeUpdate();
                DefaultTableModel model = (DefaultTableModel)jTable_Display_Movies.getModel();
                model.setRowCount(0);
                show_user();

                JOptionPane.showMessageDialog(null,"Film Silindi!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_filmSilActionPerformed

    private void btn_resimSECActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resimSECActionPerformed
        //resim ekleme butonu -- file chooser

        JFileChooser chooser  = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        fileName= f.getAbsolutePath();
        ImageIcon imageIcon;
        imageIcon= new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance
        (lbl_image.getWidth(),lbl_image.getHeight(),Image.SCALE_SMOOTH));
        lbl_image.setIcon(imageIcon);
        try{
            File image = new File(fileName);
            FileInputStream FIS = new FileInputStream(image);
            ByteArrayOutputStream BOS = new ByteArrayOutputStream();
            byte[] buf = new  byte [1024];
            for(int readNum;(readNum=FIS.read(buf))!=-1;){
                BOS.write(buf,0,readNum);

            }
            person_image=BOS.toByteArray();

        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }

    }//GEN-LAST:event_btn_resimSECActionPerformed

    private void cmb_filmYilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_filmYilActionPerformed

    }//GEN-LAST:event_cmb_filmYilActionPerformed

    private void cmb_FilmTurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_FilmTurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_FilmTurActionPerformed

    private void cmb_FilmPuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_FilmPuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_FilmPuanActionPerformed

    private void txt_filmIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_filmIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_filmIDActionPerformed

    //film ekleniyor...
    private void filmEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filmEkleActionPerformed
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;user=sa;password=123;databaseName=sineDB;";

            Connection con = DriverManager.getConnection(url);
            String sql = "INSERT INTO filmler(FilmAd,FilmKonu,FilmYonetmen,FilmYil,FilmTur,FilmPuan,filmID,FilmResimler) values(?,?,?,?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,txt_FilmAdi.getText());
            pst.setString(2,txt_FilmKonu.getText());
            pst.setString(3,txt_FilmYonetmen1.getText());

            String fYil,fTur,fPuan;
            fYil=cmb_filmYil.getSelectedItem().toString();
            pst.setString(4,fYil);

            fTur=cmb_FilmTur.getSelectedItem().toString();
            pst.setString(5,fTur);

            fPuan=cmb_FilmPuan.getSelectedItem().toString();
            pst.setString(6,fPuan);

            pst.setString(7, txt_filmID.getText());

            pst.setBytes(8, person_image);
            
//            SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
//            String date = sdf.format(jDateChooser1.getDate());
//            pst.setString(9, date);   

            pst.executeUpdate();
            
            DefaultTableModel model = (DefaultTableModel)jTable_Display_Movies.getModel();
            model.setRowCount(0);
            show_user();

            JOptionPane.showMessageDialog(null,"Film Eklendi!");
            getRandom();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_filmEkleActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
       txt_FilmAdi.setText("");
       txt_FilmKonu.setText("");
       txt_FilmYonetmen1.setText("");
       
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btn_sinemalarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sinemalarActionPerformed
       sinemalar snr = new sinemalar();
       this.setVisible(false);
       snr.setVisible(true);
    }//GEN-LAST:event_btn_sinemalarActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ana_panel;
    private javax.swing.JButton btn_resimSEC;
    private javax.swing.JButton btn_sinemalar;
    private javax.swing.JComboBox<String> cmb_FilmPuan;
    private javax.swing.JComboBox<String> cmb_FilmPuan1;
    private javax.swing.JComboBox<String> cmb_FilmTur;
    private javax.swing.JComboBox<String> cmb_FilmTur1;
    private javax.swing.JComboBox<String> cmb_filmYil;
    private javax.swing.JButton filmEkle;
    private javax.swing.JButton filmGuncelle;
    private javax.swing.JButton filmSil;
    private javax.swing.JTextField g_FilmAdi;
    private javax.swing.JTextArea g_FilmKonu;
    private javax.swing.JTextField g_FilmYonetmen;
    private javax.swing.JComboBox<String> g_filmYil;
    private javax.swing.JTextField g_txtFilmID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable_Display_Movies;
    private javax.swing.JLabel lbl_exit;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_sinego1;
    private javax.swing.JLabel lbl_sineoto1;
    private javax.swing.JLabel lbl_sineoto10;
    private javax.swing.JLabel lbl_sineoto11;
    private javax.swing.JLabel lbl_sineoto12;
    private javax.swing.JLabel lbl_sineoto13;
    private javax.swing.JLabel lbl_sineoto14;
    private javax.swing.JLabel lbl_sineoto2;
    private javax.swing.JLabel lbl_sineoto20;
    private javax.swing.JLabel lbl_sineoto3;
    private javax.swing.JLabel lbl_sineoto4;
    private javax.swing.JLabel lbl_sineoto5;
    private javax.swing.JLabel lbl_sineoto6;
    private javax.swing.JLabel lbl_sineoto7;
    private javax.swing.JLabel lbl_sineoto8;
    private javax.swing.JLabel lbl_sineoto9;
    private javax.swing.JTextField s_filmID;
    private javax.swing.JPanel sag_alt_panel;
    private javax.swing.JTextField txt_FilmAdi;
    private javax.swing.JTextArea txt_FilmKonu;
    private javax.swing.JTextField txt_FilmYonetmen1;
    private javax.swing.JTextField txt_filmID;
    // End of variables declaration//GEN-END:variables
}
