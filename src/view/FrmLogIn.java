package view;

import com.mmg.Admin;
import com.mmg.Application;
import com.mmg.Player;
import com.mmg.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;

public class FrmLogIn extends JFrame implements KeyListener{

    public static final int     WIDTH = 640;
    public static final int     HEIGHT = 320;
    public static final String  WINDOW_NAME = "Log In";

    // Components
    JPanel          panel               = new JPanel();
    JLabel          lbl_username        = new JLabel();
    JTextField      txt_username        = new JTextField();
    JLabel          lbl_password        = new JLabel();
    JTextField      txt_password        = new JTextField();

    JButton         btn_login           = new JButton();

    // Don't know if needed yet
    JButton         btn_new_account     = new JButton();

    JButton         btn_admin           = new JButton();

    // Constructor
    public FrmLogIn(){
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        addKeyListener(this);

        lbl_username    .setText("User name ");
        lbl_password    .setText("Password ");
        btn_login       .setText("Log In");
        btn_new_account .setText("Create Account");
        btn_admin       .setText("Log in as Admin");

        lbl_username    .setBounds(100,40,80,35);
        lbl_password    .setBounds(100,80,80,35);
        txt_username    .setBounds(200,40,300,35);
        txt_password    .setBounds(200,80,300,35);
        btn_login       .setBounds(200,140,145,35);
        btn_new_account .setBounds(355,140,145,35);
        btn_admin       .setBounds(200,160,145,35);

        panel.setLayout(null);
        panel.add(lbl_username,     "lbl_username");
        panel.add(lbl_password,     "lbl_password");
        panel.add(btn_login,        "btn_login");
        panel.add(btn_new_account,  "btn_new_account");
        panel.add(txt_username,     "txt_username");
        panel.add(txt_password,     "txt_password");
        panel.add(btn_admin,        "btn_admin");

        this.setSize(WIDTH,HEIGHT);
        this.setTitle(WINDOW_NAME);
        this.setContentPane(panel);

        // Add event to log in button
        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Log in for Player
                try{

                    // TODO: it currently allows users to log in several times
                    User u = Application.getInstance().searchUser(txt_username.getText());

                    FrmChooseGame frm_choose_game = new FrmChooseGame();
                    frm_choose_game.setLocationRelativeTo(null);
                    frm_choose_game.setVisible(true);

                    dispose();

                }catch(Exception e){

                }
           }
        });

        // Add event to new account button
        btn_new_account.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // TODO: createNewAccountMethod()
            }
        });

        // Log in as admin
        btn_admin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Log in for Admin
                try{
                    User u = Application.getInstance().searchAdmin(txt_username.getText());

                    FrmAdminView frm_admin = new FrmAdminView();
                    frm_admin.setLocationRelativeTo(null);
                    frm_admin.setVisible(true);

                    dispose();

                }catch(Exception e){

                }
            }
        });
    }



    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
