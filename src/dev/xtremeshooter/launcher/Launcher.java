package dev.xtremeshooter.launcher;

import java.io.IOException;

import dev.xtremeshooter.frontend.FrontPage;
import dev.xtremeshooter.frontend.MainMenu;

public class Launcher {
      public static void main(String args[]) {
      Thread thread = new Thread() {
      public void run() {
    	  FrontPage frontPage = new FrontPage();
    	  try {
    		  sleep(1500);
              frontPage.Menu.setVisible(false);
              new MainMenu();
          } catch (InterruptedException ex) {
                ex.printStackTrace();
          }
     }
     };
     thread.start();
     }  
}