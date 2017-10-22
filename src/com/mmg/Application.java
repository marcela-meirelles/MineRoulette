package com.mmg;

import java.util.ArrayList;

public class Application {

    private ArrayList<User> user_list = new ArrayList<User>();
    private ArrayList<Game> game_list = new ArrayList<Game>();

    // Singleton STARTS
    // not sure if I must use singleton since it can be played by multiple users at the same time
    private static Application e = null;

    private Application(){
        user_list = new ArrayList();
        game_list = new ArrayList();
    }

    public static Application getInstance(){
        if(e == null){
            e = new Application();
        }
        return e;
    }
    // Singleton ENDS

    // Users methods
    public void addUser(User u){
        user_list.add(u);
    }

    public ArrayList<User> getUserList(){
        return (ArrayList<User>)user_list.clone();
    }

    public User searchUser(String username){
        for (User u : user_list){
            if(username == u.getUsername()){
                return u;
            }
        }
        return null;
    }

    // Game methods
    public void newGame(Game g){
        game_list.add(g);
    }

    public ArrayList<Game> getGamesList(){
        return (ArrayList<Game>)game_list.clone();
    }

}
