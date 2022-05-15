package flashcardstuff;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

public class Study extends JPanel implements ActionListener {

    ArrayList<FlashCard> deck = new ArrayList<FlashCard>();
    int i = 0;
    public static JLabel q;
    public static JLabel a;
    public static JButton next;
    public static JButton prev;

    public Study() {
        this.setBackground(Color.white);
        this.setBounds(150, 0, 1200, 500);
        q = new JLabel("");
        q.setBounds(450, 10, 1000, 100);
        this.add(q);

        a = new JLabel("");
        a.setBounds(450, 160, 1000, 100);
        this.add(a);

        next = new JButton("Next");
        next.setBounds(1125, 400, 75, 25);
        next.addActionListener(this);
        this.add(next);

        prev = new JButton("Prev");
        prev.setBounds(0, 400, 75, 25);
        prev.addActionListener(this);
        this.add(prev);

        this.setLayout(null);
    }

    public void importCards(ArrayList<FlashCard> deck) {

        this.deck = deck;
        FlashCard f = deck.get(i);
        q.setText("Question: " + f.question);
        a.setText("Answer: " + f.answer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            // System.out.println("Working");

            i++;
            if (i == deck.size()) {
                i = 0;
                FlashCard f = deck.get(i);
                q.setText("Question: " + f.question);
                a.setText("Answer: " + f.answer);
            } else {
                FlashCard f = deck.get(i);
                q.setText("Question: " + f.question);
                a.setText("Answer: " + f.answer);
            }

        }

        else if (e.getSource() == prev) {
            i--;
            if (i == -1) {
                i = (deck.size() - 1);
                FlashCard f = deck.get(i);
                q.setText("Question: " + f.question);
                a.setText("Answer: " + f.answer);
            } else {
                FlashCard f = deck.get(i);
                q.setText("Question: " + f.question);
                a.setText("Answer: " + f.answer);
            }
        }

    }

}
