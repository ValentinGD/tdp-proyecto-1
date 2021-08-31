package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
		@SuppressWarnings("unused")
		Student yo= new Student(124266, "Gonzalez Dupouy", "Valentín", "valenelpala@hotmail.com", "https://github.com/ValentinGD", "/images/MiFoto.png");
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	SimplePresentationScreen screen = new SimplePresentationScreen(yo); 
            	screen.setVisible(true);
            }
        });
    }
}