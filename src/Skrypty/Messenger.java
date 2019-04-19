package Skrypty;

import java.awt.Color;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author Minty
 */
public class Messenger extends javax.swing.JFrame {
    String login, pass, friend, msgFriend, call;
    int mess = 0;
    Connection c = null;
    boolean nextSwith = false;
    
    DefaultListModel listModel = new DefaultListModel();
    DefaultListModel listChat = new DefaultListModel();
    
    public Messenger() {
        initComponents();
        setLocationRelativeTo(null);
        W_Text.setLineWrap(true);
        this.setTitle("Welcome to ...!");
        T_Info.setText("Welcome to ...!");
        
        //Centered L_Friends
        DefaultListCellRenderer renderer = (DefaultListCellRenderer)L_Friends.getCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        
        //Connecting to Database
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e){ //Here put your MySQL server settings
        }
            String serverName = ""; 
            String serverPort = ""; 
            String sid = "";
            String url = "jdbc:mysql://" + serverName + ":" + serverPort + "/" + sid + "?useUnicode=true&characterEncoding=utf-8";
            String username = "";
            String password = "";
        try{
            c = DriverManager.getConnection (url, username, password);
        } catch(Exception e){ 
            System.out.println("Nie połączono!"); 
        }
        

        Runnable fillMsgsec = new Runnable() {
            public void run() {
                fillMsg();
            }
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(fillMsgsec, 0, 150, TimeUnit.MILLISECONDS);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        W_Friends = new javax.swing.JFrame();
        TF_Friend = new javax.swing.JTextField();
        B_AddFriend = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        L_Friends = new javax.swing.JList<>();
        M_RightClick = new javax.swing.JPopupMenu();
        M_Delete = new javax.swing.JMenuItem();
        W_Chat = new javax.swing.JFrame();
        B_Send = new javax.swing.JButton();
        TF_Text = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        W_Text = new javax.swing.JTextArea();
        TF_Login = new javax.swing.JTextField();
        T_Pass = new java.awt.Label();
        T_Login = new java.awt.Label();
        T_Info = new java.awt.Label();
        B_Login = new javax.swing.JButton();
        B_Register = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        TF_Pass = new javax.swing.JPasswordField();

        W_Friends.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        W_Friends.setResizable(false);

        B_AddFriend.setText("+");
        B_AddFriend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_AddFriendActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Friends");

        L_Friends.setModel(listModel);
        L_Friends.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        L_Friends.setToolTipText("");
        L_Friends.setAutoscrolls(false);
        L_Friends.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        L_Friends.setPreferredSize(null);
        L_Friends.setValueIsAdjusting(true);
        L_Friends.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L_FriendsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                L_FriendsMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(L_Friends);

        javax.swing.GroupLayout W_FriendsLayout = new javax.swing.GroupLayout(W_Friends.getContentPane());
        W_Friends.getContentPane().setLayout(W_FriendsLayout);
        W_FriendsLayout.setHorizontalGroup(
            W_FriendsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(W_FriendsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(W_FriendsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, W_FriendsLayout.createSequentialGroup()
                        .addComponent(TF_Friend)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(B_AddFriend))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        W_FriendsLayout.setVerticalGroup(
            W_FriendsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(W_FriendsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(W_FriendsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_Friend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_AddFriend))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        M_Delete.setText("Delete");
        M_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                M_DeleteActionPerformed(evt);
            }
        });
        M_RightClick.add(M_Delete);

        B_Send.setText("Send");
        B_Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_SendActionPerformed(evt);
            }
        });

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        W_Text.setEditable(false);
        W_Text.setColumns(20);
        W_Text.setRows(5);
        W_Text.setWrapStyleWord(true);
        jScrollPane3.setViewportView(W_Text);

        javax.swing.GroupLayout W_ChatLayout = new javax.swing.GroupLayout(W_Chat.getContentPane());
        W_Chat.getContentPane().setLayout(W_ChatLayout);
        W_ChatLayout.setHorizontalGroup(
            W_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(W_ChatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(W_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(W_ChatLayout.createSequentialGroup()
                        .addComponent(TF_Text, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(B_Send)))
                .addContainerGap())
        );
        W_ChatLayout.setVerticalGroup(
            W_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, W_ChatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(W_ChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_Send))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TF_Login.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        T_Pass.setAlignment(java.awt.Label.CENTER);
        T_Pass.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        T_Pass.setText("Password");

        T_Login.setAlignment(java.awt.Label.CENTER);
        T_Login.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        T_Login.setText("Login");

        T_Info.setAlignment(java.awt.Label.CENTER);

        B_Login.setText("Login");
        B_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_LoginActionPerformed(evt);
            }
        });

        B_Register.setText("Register");
        B_Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_RegisterActionPerformed(evt);
            }
        });

        TF_Pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(T_Pass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(B_Register, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(T_Login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(B_Login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TF_Login)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(T_Info, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(jSeparator2)
                            .addComponent(TF_Pass))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(T_Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TF_Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(T_Pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TF_Pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(T_Info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(B_Login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(B_Register)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_LoginActionPerformed
        login = TF_Login.getText();
        pass = TF_Pass.getText();

        call = "SELECT * FROM USERS WHERE LOGIN = '" + login + "' AND PASS = '" + pass + "'";
        System.out.println(call);
        
        if(login.length() > 4 && pass.length() > 4){   
            Statement s = null;            
            try {  
                s = c.createStatement();
                ResultSet r;
                r=s.executeQuery(call);  
                r.next();
                if(login.equals(r.getObject(2).toString()) && pass.equals(r.getObject(3).toString())){
                    W_Friends.setSize(new Dimension(275, 565));
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    Point middle = new Point(screenSize.width / 2, screenSize.height / 2);
                    Point newLocation = new Point((2*middle.x - W_Friends.getWidth())-middle.x/30, (2*middle.y - W_Friends.getHeight())-middle.y/8); //I know 4:3 would have problems.
                    W_Friends.setLocation(newLocation);
                    W_Friends.setVisible(true);
                    this.setVisible(false);
                    fillFriends();
                    W_Friends.setTitle("Friends list");
                }
            } catch(SQLException e) {
                T_Info.setText("Wrong Login/Password!");
            }
        }else if(login.length() < 5){
            T_Info.setText("Login is too short!");
        }else if(pass.length() < 5){
            T_Info.setText("Password is too short!");
        }
    }//GEN-LAST:event_B_LoginActionPerformed

    private void B_RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_RegisterActionPerformed
        boolean registerSwitch = false;
        
        login = TF_Login.getText();
        pass = TF_Pass.getText();
        
        call = "SELECT * FROM USERS WHERE LOGIN = '" + login + "'";
        
        if(login.length() > 4 && pass.length() > 4){   
            Statement s = null;                     
            try {  
                s = c.createStatement();
                ResultSet r;
                r=s.executeQuery(call);  
                r.next();
                if(login.equals(r.getObject(2).toString())) T_Info.setText("Someone is using this login!");
            } catch(SQLException e) {
                registerSwitch = true;
            }
            
            if(registerSwitch == true){
                //Register
                try {
                    s = null;
                    call = "INSERT INTO USERS (LOGIN, PASS) VALUES ('" + login + "', '" + pass + "')";
                    s = c.createStatement();
                    s.executeUpdate(call);
                    s.close();
                    System.out.println(call);
                    T_Info.setText("Registered successfully!");
                } catch(SQLException e) {
                }  
            }
        }else if(login.length() < 5){
            T_Info.setText("Login is too short!");
        }else if(pass.length() < 5){
            T_Info.setText("Password is too short!");
        }
    }//GEN-LAST:event_B_RegisterActionPerformed

    private void B_AddFriendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_AddFriendActionPerformed
        boolean friendSwitch = false;
        Statement s = null;
        friend = TF_Friend.getText();
        
        //check "If there is friend"
        try {
            call = "SELECT * FROM USERS WHERE LOGIN='" + friend + "'";
            s = c.createStatement();
            ResultSet r;
            r=s.executeQuery(call);  
            r.next();
            if(friend.equals(r.getObject(2).toString())) friendSwitch = true; System.out.println("friendSwitch TRUE!");
        } catch(SQLException e) {
            System.out.println("There is no such friend in database! :(");
        }
        
        //check "Already friends?"
        try {
            call = "SELECT * FROM FRIENDS WHERE ID_USER1 = (SELECT ID FROM USERS WHERE LOGIN='" + login + "') AND ID_USER2 = (SELECT ID FROM USERS WHERE LOGIN='" + friend + "')";
            s = c.createStatement();
            ResultSet r;
            r=s.executeQuery(call);
            int i = 0;
            while(r.next()) i++;

            if(i>0){ 
                friendSwitch = false;
                System.out.println("friendSwitch FALSE!");
            }
            
            //add friend
            if(friendSwitch){
                try {
                    call = "INSERT INTO FRIENDS VALUES ((SELECT ID FROM USERS WHERE LOGIN='" + login + "'), (SELECT ID FROM USERS WHERE LOGIN='" + friend + "'))";        
                    s = c.createStatement();
                    s.executeUpdate(call);
                    s.close();
                    System.out.println(call);
                } catch(SQLException e) {
                }
                fillFriends();
            }
            
        } catch(SQLException e) {
        }
    }//GEN-LAST:event_B_AddFriendActionPerformed

    private void L_FriendsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L_FriendsMouseReleased
        //M_RightClick
        L_Friends = (JList)evt.getSource();
        int row = L_Friends.locationToIndex(evt.getPoint());
        L_Friends.setSelectedIndex(row);
        
        if(evt.isPopupTrigger()){
            M_RightClick.show(evt.getComponent(),evt.getX(),evt.getY());
        }
    }//GEN-LAST:event_L_FriendsMouseReleased

    private void M_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_M_DeleteActionPerformed
        Statement s = null;            
        try {  
            call = "DELETE FROM FRIENDS WHERE ID_USER1 = (SELECT ID FROM USERS WHERE LOGIN = '" + login +"') AND ID_USER2 = (SELECT ID FROM USERS WHERE LOGIN = '" + L_Friends.getSelectedValue() +"')";
            s = c.createStatement();
            s.executeUpdate(call);
            s.close();
            System.out.println(call); 
        } catch(SQLException e) {
        }
        fillFriends();
    }//GEN-LAST:event_M_DeleteActionPerformed

    private void L_FriendsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L_FriendsMousePressed
        //M_LeftClick
        if (evt.getClickCount() == 2 && evt.getButton() == MouseEvent.BUTTON1) {
            int index = L_Friends.locationToIndex(evt.getPoint());
            System.out.println("index: "+index);
            
            W_Chat.setSize(new Dimension(500, 400));
            W_Chat.setVisible(true);
            W_Chat.setLocationRelativeTo(null);
            msgFriend = L_Friends.getSelectedValue();
            W_Chat.setTitle("Rozmawiasz z " + msgFriend);
            mess = -5;
        }
    }//GEN-LAST:event_L_FriendsMousePressed

    private void B_SendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_SendActionPerformed
        Statement s;
        String msg = TF_Text.getText();
        try {
            call = "INSERT INTO `MSG` (`ID_USER1`, `ID_USER2`, `MESSAGE`, `DATE`) VALUES ((SELECT ID FROM USERS WHERE LOGIN='" + login + "'), (SELECT ID FROM USERS WHERE LOGIN='" + msgFriend + "'), '" + msg + "', CURRENT_TIMESTAMP)"; 
            s = c.createStatement();
            s.executeUpdate(call);
            s.close();
            System.out.println(call);
        } catch(SQLException e) {
        }
        TF_Text.setText("");
        mess = -5;
    }//GEN-LAST:event_B_SendActionPerformed

    void fillFriends(){ //Method fill L_Friends
        listModel.clear();
        call = "SELECT USERS.LOGIN FROM FRIENDS INNER JOIN USERS ON FRIENDS.ID_USER2=USERS.ID WHERE FRIENDS.ID_USER1 = (SELECT ID FROM USERS WHERE LOGIN = '" + login +"')";
        
        Statement s = null;            
        try {  
            s = c.createStatement();
            ResultSet r;
            r=s.executeQuery(call);  
            r.next();
            do {
                listModel.addElement(r.getObject(1).toString());
            }while(r.next());  
        } catch(SQLException e) {
        }
    }
    
    void fillMsg(){
        call = "SELECT USERS.LOGIN, MSG.DATE, MSG.MESSAGE FROM MSG INNER JOIN USERS ON USERS.ID = MSG.ID_USER1 WHERE (MSG.ID_USER1 = (SELECT ID FROM USERS WHERE LOGIN = '" + login +"') AND MSG.ID_USER2 = (SELECT ID FROM USERS WHERE LOGIN = '" + msgFriend +"')) OR (MSG.ID_USER1 = (SELECT ID FROM USERS WHERE LOGIN = '" + msgFriend +"') AND MSG.ID_USER2 = (SELECT ID FROM USERS WHERE LOGIN = '" + login +"')) ORDER BY MSG.DATE ASC";
        
        JScrollBar ver = jScrollPane3.getVerticalScrollBar();
        if(nextSwith) ver.setValue( ver.getMaximum() + 1); nextSwith = false;       
        
        Statement s = null;            
        try {  
            s = c.createStatement();
            ResultSet r;
            r=s.executeQuery(call);  
            r.next();
            r.last(); 
            if(mess < r.getRow()){
                r.first();
                W_Text.setText("");
                do {
                    W_Text.append(r.getObject(1).toString() + ", " + r.getObject(2).toString() + ": \n" + r.getObject(3).toString() + "\n \n");
                }while(r.next());
                r.last();
                mess = r.getRow();
                nextSwith = true;
            }
        } catch(SQLException e) {
        }
    }
    
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Messenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Messenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Messenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Messenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Messenger().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_AddFriend;
    private javax.swing.JButton B_Login;
    private javax.swing.JButton B_Register;
    private javax.swing.JButton B_Send;
    private javax.swing.JList<String> L_Friends;
    private javax.swing.JMenuItem M_Delete;
    private javax.swing.JPopupMenu M_RightClick;
    private javax.swing.JTextField TF_Friend;
    private javax.swing.JTextField TF_Login;
    private javax.swing.JPasswordField TF_Pass;
    private javax.swing.JTextField TF_Text;
    private java.awt.Label T_Info;
    private java.awt.Label T_Login;
    private java.awt.Label T_Pass;
    private javax.swing.JFrame W_Chat;
    private javax.swing.JFrame W_Friends;
    private javax.swing.JTextArea W_Text;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
