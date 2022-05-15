package flashcardstuff;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Color;
import java.util.*;

public class Character2 {

    public String name;
    public int exp;
    public int level;

    public Character2(String name, int exp) {
        this.name = name;
        this.exp = exp;
        setLevel();
    }

    public void setLevel() {
        level = exp / 95;
    }

    public void addExperience(int experience) {
        exp += experience;
        setLevel();
    }
}
