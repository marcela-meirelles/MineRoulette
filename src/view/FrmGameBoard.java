package view;

import com.mmg.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmGameBoard extends JFrame {

    public static final int     WIDTH     = 840;
    public static final int     HEIGHT    = 620;
    public static final String  WINDOW_NAME  = "BLOW UP!!";

    // TODO: Set labels lbl_user1 and lbl_user2 with the following messages, according to what's needed
    private String waiting_for_player   = "Waiting for Player ";
    private String ready_player         = "Ready Player ";

    private User    u1;
    private User    u2;
    private Game    game;
    private Timer   timer;

    private JTable  table       =   new JTable();

    // Components
    JPanel          panel       =   new JPanel();
    JScrollPane     board_panel =   new JScrollPane();

    // board_panel will contain the actual board where the game is played

    JLabel lbl_user1        = new JLabel();
    JLabel lbl_user2        = new JLabel();
    JLabel lbl_bet_user1    = new JLabel();
    JLabel lbl_bet_user2    = new JLabel();
    JLabel lbl_timer        = new JLabel();
    JLabel lbl_bet_pool     = new JLabel();
    JLabel lbl_turn         = new JLabel();

    JButton btn_withdraw    = new JButton();
    JLabel  lbl_withdraw    = new JLabel();

    // Constructor
    public FrmGameBoard(){
        setFocusable(true);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));


        lbl_user1       .setText("Name 1");//u1.getUsername());
        lbl_user2       .setText("Name 2");//u2.getUsername());

        // TODO: set up observer pattern to get listeners for when bets are set, and a move is made

        // These items will be set once the observer pattern is ready
        lbl_bet_user1   .setText("100"); //u1.getLastBet());
        lbl_bet_user2   .setText("100"); //u2.getLastBet());
        /*
        lbl_timer       .setText(timer.getState());
        lbl_bet_pool    .setText(game.getBetPool());
        lbl_turn        .setText(game.getTurn());
        */
        btn_withdraw    .setText("WITHDRAW");
        btn_withdraw    .setBackground(Color.RED);
        btn_withdraw    .setForeground(Color.WHITE);
        lbl_withdraw    .setText("Withdraw will cause losing the game");
        lbl_withdraw    .setForeground(Color.RED);


        lbl_user1       .setBounds(100,40,80,35);
        lbl_bet_user1   .setBounds(100,80,80,35);
        lbl_user2       .setBounds(100,400,300,35);
        lbl_bet_user2   .setBounds(100,360,300,35);
        lbl_timer       .setBounds(200,140,145,35);
        lbl_bet_pool    .setBounds(355,140,145,35);
        lbl_turn        .setBounds(355,140,145,35);
        btn_withdraw    .setBounds(100,200,145,35);
        lbl_withdraw    .setBounds(100,240,145,35);


        panel.setLayout(null);
        panel.add(lbl_user1,        "lbl_user1");
        panel.add(lbl_user2,        "lbl_user2");
        panel.add(lbl_bet_user1,    "lbl_bet_user1");
        panel.add(lbl_bet_user2,    "lbl_bet_user2");
        panel.add(lbl_timer,        "lbl_timer");
        panel.add(lbl_bet_pool,     "lbl_bet_pool");
        panel.add(lbl_turn,         "lbl_turn");
        panel.add(btn_withdraw,     "btn_withdraw");
        panel.add(lbl_withdraw,     "lbl_withdraw");



        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));

        // board_panel will contain the actual board where the game is played
        panel       .add(board_panel, "board_panel");
        board_panel .setViewportView(table);
        board_panel .setBounds(300,50,450,450);

        this.setSize(WIDTH,HEIGHT);
        this.setTitle(WINDOW_NAME);
        this.setContentPane(panel);

        // Add event to withdraw button - will withdraw the user from the game, causing losing the game
        btn_withdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // TODO: withdrawMethod()
            }
        });


    }

}
