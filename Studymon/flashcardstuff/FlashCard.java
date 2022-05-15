package flashcardstuff;

import javax.swing.*;
import java.util.Scanner;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.FlowLayout;

public class FlashCard {

    public String question;
    public String answer;

    public FlashCard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

}