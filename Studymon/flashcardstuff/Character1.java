package flashcardstuff;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Color;
import java.util.*;

public class Character1 {

    public String name;
    public int exp;
    public int level;
    public static JLabel info;

    public Character1(String name, int exp) {
        this.name = name;
        this.exp = exp;
        setLevel();
    }

    public void setLevel() {
        level = exp / 100;
    }

    public void addExperience(int experience) {
        exp += experience;
        setLevel();
    }

}
