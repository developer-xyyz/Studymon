package flashcardstuff;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Color;
import java.util.*;

public class CharDisp extends JPanel {

    Character1 fire;
    Character2 water;
    Character3 leaf;
    public static JLabel info;

    public CharDisp() {
        this.setForeground(Color.decode("#BFB8EF"));
        this.setBounds(150, 0, 1200, 500);

        info = new JLabel("");
        info.setBounds(60, 250, 1000, 25);

        this.add(info);
        this.setLayout(null);
    }

    public void showCharacter(Character1 fire) {
        this.fire = fire;
        info.setText("Name: " + fire.name + " || Level: " + fire.level + " || Exp: " + fire.exp);
		JLabel objectLabel = new JLabel();
		objectLabel.setBounds(400,50,400,400);
		ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource("Charmander.png"));
		objectLabel.setIcon(objectIcon);		
		this.add(objectLabel);
    }

    public void showCharacter(Character2 water) {
        this.water = water;
		JLabel objectLabel2 = new JLabel();
		objectLabel2.setBounds(400,50,400,400);
		ImageIcon objectIcon2 = new ImageIcon(getClass().getClassLoader().getResource("Squirtle.png"));
		objectLabel2.setIcon(objectIcon2);		
		this.add(objectLabel2);
        info.setText("Name: " + water.name + " || Level: " + water.level + " || Exp: " + water.exp);
    }

    public void showCharacter(Character3 leaf) {
        this.leaf = leaf;
		JLabel objectLabel3 = new JLabel();
		objectLabel3.setBounds(400,50,400,400);
		ImageIcon objectIcon3 = new ImageIcon(getClass().getClassLoader().getResource("Bulbasaur.png"));
		objectLabel3.setIcon(objectIcon3);		
		this.add(objectLabel3);
        info.setText("Name: " + leaf.name + " || Level: " + leaf.level + " || Exp: " + leaf.exp);
    }

}
