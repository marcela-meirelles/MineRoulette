package com.mmg;

import java.util.ArrayList;

public class Application {

    private ArrayList<Player>   user_list   = new ArrayList<Player>();
    private ArrayList<Admin>    admin_list  = new ArrayList<Admin>();
    private ArrayList<Game>     game_list   = new ArrayList<Game>();

    // Singleton STARTS
    // not sure if I must use singleton since it can be played by multiple users at the same time
    private static Application e = null;

    private Application(){
        user_list   = new ArrayList();
        admin_list  = new ArrayList();
        game_list   = new ArrayList();

        // Load Dummy Data
        loadData();
    }

    public static Application getInstance(){
        if(e == null){
            e = new Application();
        }
        return e;
    }
    // Singleton ENDS

    // Dummy Data
    public void loadData(){
        user_list   .add(new Player("player1",  "12345", "Player1 12345", 1000.23F));
        user_list   .add(new Player("player2",  "12345", "Player2 12345", 1000.23F));
        admin_list  .add(new Admin( "admin",    "admin", "Admin Admin"));
    }
    // Ends Dummy Data

    // Player methods
    public void addUser(Player p){
        user_list.add(p);
    }

    public ArrayList<Player> getUserList(){
        return (ArrayList<Player>)user_list.clone();
    }

    public Player searchUser(String username){
        for (Player u : user_list){
            if(username == u.getUsername()){ //maybe should use equals()
                return u;
            }
        }
        return null;
    }

    // Admin methods
    public void addAdmin(Admin a){
        admin_list.add(a);
    }

    public ArrayList<Admin> getAdminList(){
        return (ArrayList<Admin>)admin_list.clone();
    }

    public Admin searchAdmin(String username){
        for (Admin u : admin_list){
            if(username == u.getUsername()){ //maybe should use equals()
                return u;
            }
        }
        return null;
    }

    // AnyUser Methods
    public User searchAnyUser(String username){
        User u = null;
        try{
            u = searchAdmin(username);
        }catch(Exception e){}
        try{
            u = searchUser(username);
        }catch(Exception e){}
        return u;
    }

    // Game methods
    public void newGame(Game g){
        game_list.add(g);
    }

    public ArrayList<Game> getGamesList(){
        return (ArrayList<Game>)game_list.clone();
    }

}
