package flashcardstuff;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Color;
import java.util.*;

public class Trivia extends JPanel implements ActionListener {

    ArrayList<FlashCard> deck = new ArrayList<FlashCard>();
    int i = 0;
    public static JLabel q;
    public static JButton wrong1;
    public static JButton wrong2;
    public static JButton wrong3;
    public static JButton correct;
    public static JButton next;
    public static int correctans = 0;
    public static JLabel end;
    public static String character;
    Character1 fire;
    Character2 water;
    Character3 leaf;
    public static int exp = 0;

    public Trivia() {
        // this.setBackground(Color.white);
        this.setForeground(Color.decode("#BFB8EF"));
        this.setBounds(150, 0, 1200, 500);

        q = new JLabel("Question");
        q.setBounds(450, 10, 1000, 100);
        this.add(q);

        end = new JLabel("");
        end.setBounds(450, 150, 1000, 100);
        end.setVisible(false);
        this.add(end);

        wrong1 = new JButton("choice 1");
        wrong1.setBounds(450, 100, 490, 50);
        wrong1.addActionListener(this);
        this.add(wrong1);

        wrong2 = new JButton("choice 2");
        wrong2.setBounds(450, 150, 490, 50);
        wrong2.addActionListener(this);
        this.add(wrong2);

        wrong3 = new JButton("choice 3");
        wrong3.setBounds(450, 200, 490, 50);
        wrong3.addActionListener(this);
        this.add(wrong3);

        correct = new JButton("choice 4");
        correct.setBounds(450, 250, 490, 50);
        // correct.setBackground(Color.green);
        correct.addActionListener(this);
        this.add(correct);

        next = new JButton("next");
        next.setBounds(1125, 400, 75, 25);
        next.addActionListener(this);
        next.setVisible(false);
        this.add(next);

        this.setLayout(null);
    }

    public void importCharacter(Character1 fire) {
        this.fire = fire;
        character = "fire";
    }

    public void importCharacter(Character2 water) {
        this.water = water;
        character = "water";
    }

    public void importCharacter(Character3 leaf) {
        this.leaf = leaf;
        character = "leaf";
    }

    public void importCards(ArrayList<FlashCard> deck) {
        this.deck = deck;
        FlashCard f = deck.get(i);
        q.setText("Question: " + f.question);
        /*
         * ArrayList<FlashCard> temp = new ArrayList<FlashCard>();
         * temp = deck;
         * temp.remove(i);
         */

        String[] strArray = new String[deck.size() - 1];
        int k = 0;

        for (int m = 0; m < deck.size(); m++) {
            if (m != i) {
                FlashCard c = deck.get(m);
                strArray[k] = c.answer;
                k++;
            }
        }

        int arr[] = { 100, 150, 200, 250 };
        Random randNum = new Random();
        Set<Integer> set = new LinkedHashSet<Integer>();
        while (set.size() < 4) {
            set.add(randNum.nextInt(4));
        }
        Integer[] array = new Integer[set.size()];
        int j = 0;
        for (Integer i : set) {
            array[j++] = i;
        }

        Set<Integer> set2 = new LinkedHashSet<Integer>();
        while (set2.size() < deck.size()) {
            set2.add(randNum.nextInt(deck.size()));
        }
        Integer[] array2 = new Integer[set2.size()];
        j = 0;
        for (Integer i : set2) {
            array2[j++] = i;
        }

        correct.setBounds(450, arr[array[3]], 490, 50);
        correct.setText(f.answer);

        // f = temp.get(array2[0]);
        wrong1.setBounds(450, arr[array[0]], 490, 50);
        wrong1.setText(strArray[0]);

        // f = temp.get(array2[1]);
        wrong2.setBounds(450, arr[array[1]], 490, 50);
        wrong2.setText(strArray[1]);

        // f = temp.get(array2[2]);
        wrong3.setBounds(450, arr[array[2]], 490, 50);
        wrong3.setText(strArray[2]);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == correct) {
            correctans++;
            // correct.setBackground(Color.green);
            correct.setText("Correct");
            next.setVisible(true);
            wrong1.setVisible(false);
            wrong2.setVisible(false);
            wrong3.setVisible(false);
            exp += 50;
            // correct.setVisible(false);

        }

        else if (e.getSource() == wrong1) {
            // wrong1.setBackground(Color.red);
            wrong1.setText("Wrong answer");
            next.setVisible(true);
            // wrong1.setVisible(false);
            wrong2.setVisible(false);
            wrong3.setVisible(false);
            correct.setVisible(false);
        }

        else if (e.getSource() == wrong2) {
            // wrong2.setBackground(Color.red);
            wrong2.setText("Wrong answer");
            next.setVisible(true);
            wrong1.setVisible(false);
            // wrong2.setVisible(false);
            wrong3.setVisible(false);
            correct.setVisible(false);
        }

        else if (e.getSource() == wrong3) {
            // wrong3.setBackground(Color.red);
            wrong3.setText("Wrong answer");
            next.setVisible(true);
            wrong1.setVisible(false);
            wrong2.setVisible(false);
            // wrong3.setVisible(false);
            correct.setVisible(false);
        }

        else if (e.getSource() == next) {
            i++;
            if (i == deck.size()) {
                q.setVisible(false);
                next.setVisible(false);
                wrong1.setVisible(false);
                wrong2.setVisible(false);
                wrong3.setVisible(false);
                correct.setVisible(false);
                end.setText("Game over, you have answered " + correctans + " questions right");
                end.setVisible(true);
                if (character.equals("fire")) {
                    fire.addExperience(exp);
                } else if (character.equals("water")) {
                    water.addExperience(exp);
                } else if (character.equals("leaf")) {
                    leaf.addExperience(exp);
                }

            } else {
                next.setVisible(false);
                wrong1.setVisible(true);
                wrong2.setVisible(true);
                wrong3.setVisible(true);
                correct.setVisible(true);

                FlashCard f = deck.get(i);
                q.setText("Question: " + f.question);
                /*
                 * ArrayList<FlashCard> temp = new ArrayList<FlashCard>();
                 * temp = deck;
                 * temp.remove(i);
                 */
                String[] strArray = new String[deck.size() - 1];
                int k = 0;

                for (int m = 0; m < deck.size(); m++) {
                    if (m != i) {
                        FlashCard c = deck.get(m);
                        strArray[k] = c.answer;
                        k++;
                    }
                }

                int arr[] = { 100, 150, 200, 250 };
                Random randNum = new Random();
                Set<Integer> set = new LinkedHashSet<Integer>();
                while (set.size() < 4) {
                    set.add(randNum.nextInt(4));
                }
                Integer[] array = new Integer[set.size()];
                int j = 0;
                for (Integer i : set) {
                    array[j++] = i;
                }

                Set<Integer> set2 = new LinkedHashSet<Integer>();
                while (set2.size() < deck.size()) {
                    set2.add(randNum.nextInt(deck.size()));
                }
                Integer[] array2 = new Integer[set2.size()];
                j = 0;
                for (Integer i : set2) {
                    array2[j++] = i;
                }

                correct.setBounds(450, arr[array[3]], 490, 50);
                correct.setText(f.answer);

                // f = temp.get(array2[0]);
                wrong1.setBounds(450, arr[array[0]], 490, 50);
                wrong1.setText(strArray[0]);

                // f = temp.get(array2[1]);
                wrong2.setBounds(450, arr[array[1]], 490, 50);
                wrong2.setText(strArray[1]);

                // f = temp.get(array2[2]);
                wrong3.setBounds(450, arr[array[2]], 490, 50);
                wrong3.setText(strArray[2]);
            }

        }
    }

}
