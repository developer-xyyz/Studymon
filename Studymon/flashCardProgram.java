import flashcardstuff.*;

import javax.swing.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class flashCardProgram implements ActionListener {

    static JButton fileImport;
    static JButton study;
    static JButton trivia;
    static ArrayList<FlashCard> deck = new ArrayList<FlashCard>();
    static JFrame frame;
    // static Study myStudy;
    static JLabel deckError;
    static Study s;
    static Trivia t;
    static JButton showChar;
    static CharDisp c;
    static String character;
    static Character1 fire;
    static Character2 water;
    static Character3 leaf;
    static JPanel createChar;
    static JButton fire1;
    static JButton water1;
    static JButton leaf1;
    static JButton save;

    public static void main(String[] args) {

        frame = new JFrame("Studymon");
        // frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setLayout(new FlowLayout());
        File charFile = new File("character.txt");
        try {
            Scanner scan = new Scanner(charFile);
            String[] arr;
            String line;

            line = scan.nextLine();
            arr = line.split(":");
            int exp = Integer.parseInt(arr[1]);
            if (arr[0].equals("fire")) {
                fire = new Character1("Charmander", exp);
                character = "fire";
            } else if (arr[0].equals("water")) {
                water = new Character2("Squirtle", exp);
                character = "water";
            } else if (arr[0].equals("leaf")) {
                leaf = new Character3("Bulbasaur", exp);
                character = "leaf";
            }

        } catch (FileNotFoundException e1) {
            createChar = new JPanel();
            createChar.setBounds(0, 0, 1920, 1200);
            createChar.setBackground(Color.gray);
            createChar.setLayout(null);

            JLabel createMessage = new JLabel();
            createMessage.setFont(new Font("Book Antiqua", Font.PLAIN, 30));
            createMessage.setBounds(600, 250, 600, 40);
            createChar.add(createMessage);

            fire1 = new JButton("Charmander");
            fire1.setBounds(525, 300, 100, 25);
            fire1.setForeground(Color.orange);
            fire1.addActionListener(new flashCardProgram());
            createChar.add(fire1);

            water1 = new JButton("Squirtle");
            water1.setBounds(660, 300, 100, 25);
            water1.setForeground(Color.blue);
            water1.addActionListener(new flashCardProgram());
            createChar.add(water1);

            leaf1 = new JButton("Bulbasaur");
            leaf1.setBounds(790, 300, 100, 25);
            leaf1.setForeground(Color.green);
            leaf1.addActionListener(new flashCardProgram());
            createChar.add(leaf1);

            ImageIcon imageIcon1 = new ImageIcon("pokemonbg.png");
            Image image1 = imageIcon1.getImage();
            Image newimg1 = image1.getScaledInstance(1450, 800, java.awt.Image.SCALE_SMOOTH);
            ImageIcon scaledimg1 = new ImageIcon(newimg1);

            ImageIcon fire2 = new ImageIcon("1.png");
            Image fire3 = fire2.getImage();
            Image newfire1 = fire3.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            ImageIcon scaledfire1 = new ImageIcon(newfire1);

            ImageIcon water2 = new ImageIcon("3.png");
            Image water3 = water2.getImage();
            Image newwater1 = water3.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            ImageIcon scaledwater1 = new ImageIcon(newwater1);

            ImageIcon grass2 = new ImageIcon("2.png");
            Image grass3 = grass2.getImage();
            Image newgrass1 = grass3.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            ImageIcon scaledgrass1 = new ImageIcon(newgrass1);

            JLabel fire = new JLabel(scaledfire1);
            JLabel water = new JLabel(scaledwater1);
            JLabel grass = new JLabel(scaledgrass1);
            createMessage = new JLabel(scaledimg1);

            createChar.add(fire);
            fire.setBounds(335, -10, 500, 500);
            createChar.add(water);
            water.setBounds(460, -10, 500, 500);
            createChar.add(grass);
            grass.setBounds(600, -10, 500, 500);

            createMessage.setBounds(-245, -180, 1920, 1200);
            createChar.add(createMessage);

            frame.add(createChar);

        }
        // createChar.setVisible(false);

        ImageIcon imageIcon = new ImageIcon("pokemon.jpg");
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(1450, 845, java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledimg = new ImageIcon(newimg);

        fileImport = new JButton("Import");
        fileImport.addActionListener(new flashCardProgram());
        fileImport.setBounds(10, 10, 100, 50);
        // frame.add(fileImport);
        save = new JButton("save");
        save.addActionListener(new flashCardProgram());
        save.setBounds(10, 100, 100, 50);

        study = new JButton("Study");
        study.addActionListener(new flashCardProgram());
        study.setBounds(880, 550, 200, 125);
        // frame.add(study);

        trivia = new JButton("Trivia");
        trivia.addActionListener(new flashCardProgram());
        trivia.setBounds(640, 550, 200, 125);
        // frame.add(trivia);

        showChar = new JButton("Show Character");
        showChar.addActionListener(new flashCardProgram());
        showChar.setBounds(400, 550, 200, 125);

        c = new CharDisp();
        c.setVisible(false);

        s = new Study();
        s.setVisible(false);

        t = new Trivia();
        t.setVisible(false);

        deckError = new JLabel("");
        deckError.setBounds(550, 675, 500, 50);
        deckError.setForeground(Color.red);
        deckError.setVisible(false);
        // frame.add(deckError);

        JLabel label = new JLabel(scaledimg);
        // label created with image
        label.add(trivia);// add button 1
        label.add(study);// add button 2
        label.add(fileImport);
        label.add(showChar);
        label.add(save);
        label.add(s);
        label.add(t);
        label.add(c);
        label.add(deckError);
        frame.add(label);
        frame.setSize(1920, 1200);

        // frame.add(s);
        // frame.add(t);
        // frame.setLayout(null);
        // frame.setResizable(false);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == fileImport) { // if the user chooses import button

            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) { // if the user chooses import button
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    Scanner scan = new Scanner(file);
                    String[] arr;
                    String line;

                    while (scan.hasNextLine()) {
                        line = scan.nextLine();
                        arr = line.split(":::");
                        FlashCard f = new FlashCard(arr[0], arr[1]);
                        deck.add(f);
                    }
                    deckError.setText("File Imported!");
                } catch (FileNotFoundException e1) {
                    System.out.println("Error opening the file");
                    e1.printStackTrace();
                }

            }

        }

        else if (e.getSource() == study) {

            if (deck.size() == 0) {
                deckError.setText("Error: Please import flashcards");
                deckError.setVisible(true);
            }

            else {
                deckError.setVisible(false);
                c.setVisible(false);
                t.setVisible(false);
                s.importCards(deck);
                s.setVisible(true);
            }

        }

        else if (e.getSource() == trivia) {
            /*
             * deckError.setText("Error: Function Not implemented yet");
             * deckError.setVisible(true);
             */

            if (deck.size() == 0) {
                deckError.setText("Error: Please import flashcards");
                deckError.setVisible(true);
            }

            else {
                if (character.equals("fire")) {
                    t.importCharacter(fire);
                } else if (character.equals("water")) {
                    t.importCharacter(water);
                } else if (character.equals("leaf")) {
                    t.importCharacter(leaf);
                }
                s.setVisible(false);
                c.setVisible(false);
                deckError.setVisible(false);
                t.importCards(deck);
                t.setVisible(true);
            }
        }

        else if (e.getSource() == showChar) {
            s.setVisible(false);
            t.setVisible(false);
            if (character.equals("fire")) {
                c.showCharacter(fire);
            } else if (character.equals("water")) {
                c.showCharacter(water);
            }

            else if (character.equals("leaf")) {
                c.showCharacter(leaf);
            }

            c.setVisible(true);

        }

        else if (e.getSource() == fire1) {
            fire = new Character1("Charmander", 0);
            character = "fire";
            createChar.setVisible(false);
        }

        else if (e.getSource() == water1) {
            water = new Character2("Squirtle", 0);
            character = "water";
            createChar.setVisible(false);
        }

        else if (e.getSource() == leaf1) {
            leaf = new Character3("Bulbasaur", 0);
            character = "leaf";
            createChar.setVisible(false);
        }

        else if (e.getSource() == save) {
            try {
                FileWriter myWriter = new FileWriter("character.txt");
                if (character.equals("fire"))
                    myWriter.write("fire:" + fire.exp);
                else if (character.equals("water"))
                    myWriter.write("water:" + water.exp);
                else if (character.equals("leaf"))
                    myWriter.write("leaf:" + leaf.exp);
                myWriter.close();

            } catch (IOException e2) {

                e2.printStackTrace();
            }
        }

    }
}
