package view;

import com.mmg.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmChooseGame extends JFrame {

    public static final int     WIDTH       = 640;
    public static final int     HEIGHT      = 320;
    public static final String  WINDOW_NAME = "Select Game";

    // Components
    JPanel          panel               = new JPanel();
/*
    Labels not needed at this point
    JLabel          lbl_small           = new JLabel();
    JLabel          lbl_medium          = new JLabel();
    JLabel          lbl_big             = new JLabel();
    JLabel          lbl_specific_size   = new JLabel();
*/
    JRadioButton    rdb_small           = new JRadioButton();
    JRadioButton    rdb_medium          = new JRadioButton();
    JRadioButton    rdb_large           = new JRadioButton();
    JRadioButton    rdb_specific        = new JRadioButton();

    ButtonGroup     rdb_menu_size       = new ButtonGroup();

    // to set specific size
    JTextField      txt_specific_size   = new JTextField();

    JButton         btn_start_game      = new JButton();
    Game            game                = new Game();

    // Constructor
    public FrmChooseGame() {
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));


        rdb_small           .setText("Small");
        rdb_medium          .setText("Medium");
        rdb_large           .setText("Large");
        rdb_specific        .setText("Set size");
        btn_start_game      .setText("Start Game");

        rdb_small           .setBounds(100, 40, 80, 35);
        rdb_medium          .setBounds(100, 80, 80, 35);
        rdb_large           .setBounds(200, 40, 300, 35);
        rdb_specific        .setBounds(200, 80, 300, 35);
        txt_specific_size   .setBounds(200, 80, 300, 35);
        btn_start_game      .setBounds(200, 140, 145, 35);


        panel.setLayout(null);
        panel.add(rdb_small, "rdb_small");
        panel.add(rdb_medium, "rdb_medium");
        panel.add(rdb_large, "rdb_large");
        panel.add(rdb_specific, "rdb_specific");
        panel.add(txt_specific_size, "txt_specific_size");
        panel.add(btn_start_game, "btn_start_game");


        rdb_menu_size.add(rdb_small);
        rdb_menu_size.add(rdb_medium);
        rdb_menu_size.add(rdb_large);
        rdb_menu_size.add(rdb_specific);

        this.setSize(WIDTH, HEIGHT);
        this.setTitle(WINDOW_NAME);
        this.setContentPane(panel);

        // Add event to log in button
        btn_start_game.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(rdb_small.isSelected()){
                    game.startSelectedGame(3);
                }else if(rdb_medium.isSelected()){
                    game.startSelectedGame(6);
                }else if(rdb_large.isSelected()){
                    game.startSelectedGame(9);
                }else{
                    game.startSelectedGame(Integer.parseInt(txt_specific_size.getText()));
                }
                // TODO: startSelectedGame()
            }
        });

    }
}
