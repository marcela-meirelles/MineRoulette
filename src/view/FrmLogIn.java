package view;

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
    JPanel panel                = new JPanel();
    JLabel lbl_username         = new JLabel();
    JTextField txt_username     = new JTextField();
    JLabel lbl_password         = new JLabel();
    JTextField txt_password     = new JTextField();

    JButton btn_login           = new JButton();

    // Don't know if needed yet
    JButton btn_new_account     = new JButton();

    // Constructor
    public FrmLogIn(){
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        addKeyListener(this);

        lbl_username    .setText("User name ");
        lbl_password    .setText("Password ");
        btn_login       .setText("Log In");
        btn_new_account .setText("Create Account");

        lbl_username    .setBounds(100,40,80,35);
        lbl_password    .setBounds(100,80,80,35);
        txt_username    .setBounds(200,40,300,35);
        txt_password    .setBounds(200,80,300,35);
        btn_login       .setBounds(200,140,145,35);
        btn_new_account .setBounds(355,140,145,35);

        panel.setLayout(null);
        panel.add(lbl_username,     "lbl_username");
        panel.add(lbl_password,     "lbl_password");
        panel.add(btn_login,        "btn_login");
        panel.add(btn_new_account,  "btn_new_account");
        panel.add(txt_username,     "txt_username");
        panel.add(txt_password,     "txt_password");

        this.setSize(WIDTH,HEIGHT);
        this.setTitle(WINDOW_NAME);
        this.setContentPane(panel);

        // Add event to log in button
        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // TODO: logInMethod()
            }
        });

        // Add event to new account button
        btn_new_account.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // TODO: createNewAccountMethod()
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
