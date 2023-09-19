import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Frame implements ActionListener {
   
    private final int TIMEOUT = 5000; // 5 seconds

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JButton[] buttons = new JButton[9];
    JLabel label = new JLabel();
    JLabel label2 = new JLabel();
    boolean player1;
    Random rand = new Random();

    public Frame() {

        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.MAGENTA);

        label.setText("Tic Tac Toe");
        label.setBounds(0, 0, 200, 150);
        label.setFont(new java.awt.Font("Ink Free", Font.BOLD, 40));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setForeground(Color.WHITE);
        label.setBackground(Color.BLACK);
        label.setOpaque(true);

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setSize(100, 100);
            buttons[i].setFont(new java.awt.Font("Ink Free", Font.BOLD, 40));
            buttons[i].setBackground(Color.WHITE);
            buttons[i].setOpaque(true);
            panel2.add(buttons[i], BorderLayout.CENTER);
            buttons[i].addActionListener(this);
        }
        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);
        panel.setSize(800, 200);
        panel2.setLayout(new GridLayout(3, 3));
        panel2.setSize(800, 700);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(panel2);

        turn();

    }

    public void turn() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (rand.nextInt(2) == 0) {
            player1 = true;
            label.setText("X- Turn");
        } else {
            player1 = false;
            label.setText("O- Turn");
        }
    }

    public void check() {

        if (buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X")) {
            xWins(0, 1, 2);
        } else if (buttons[3].getText().equals("X") && buttons[4].getText().equals("X")
                && buttons[5].getText().equals("X")) {
            xWins(3, 4, 5);
        } else if (buttons[6].getText().equals("X") && buttons[7].getText().equals("X")
                && buttons[8].getText().equals("X")) {
            xWins(6, 7, 8);
        } else if (buttons[0].getText().equals("X") && buttons[3].getText().equals("X")
                && buttons[6].getText().equals("X")) {
            xWins(0, 3, 6);
        } else if (buttons[1].getText().equals("X") && buttons[4].getText().equals("X")
                && buttons[7].getText().equals("X")) {
            xWins(1, 4, 7);
        } else if (buttons[2].getText().equals("X") && buttons[5].getText().equals("X")
                && buttons[8].getText().equals("X")) {
            xWins(2, 5, 8);
        } else if (buttons[0].getText().equals("X") && buttons[4].getText().equals("X")
                && buttons[8].getText().equals("X")) {
            xWins(0, 4, 8);
        } else if (buttons[2].getText().equals("X") && buttons[4].getText().equals("X")
                && buttons[6].getText().equals("X")) {
            xWins(2, 4, 6);
        }

        if (buttons[0].getText().equals("O") && buttons[1].getText().equals("O") && buttons[2].getText().equals("O")) {
            oWins(0, 1, 2);
        } else if (buttons[3].getText().equals("O") && buttons[4].getText().equals("O")
                && buttons[5].getText().equals("O")) {
            oWins(0, 1, 2);

        } else if (buttons[6].getText().equals("O") && buttons[7].getText().equals("O")
                && buttons[8].getText().equals("O")) {
            oWins(3, 4, 5);

        } else if (buttons[0].getText().equals("O") && buttons[3].getText().equals("O")
                && buttons[6].getText().equals("O")) {
            oWins(0, 3, 6);
        } else if (buttons[1].getText().equals("O") && buttons[4].getText().equals("O")
                && buttons[7].getText().equals("O")) {
            oWins(1, 4, 7);

        } else if (buttons[2].getText().equals("O") && buttons[5].getText().equals("O")
                && buttons[8].getText().equals("O")) {
            oWins(2, 5, 8);
        } else if (buttons[0].getText().equals("O") && buttons[4].getText().equals("O")
                && buttons[8].getText().equals("O")) {
            oWins(0, 4, 8);
        } else if (buttons[2].getText().equals("O") && buttons[4].getText().equals("O")
                && buttons[6].getText().equals("O")) {
            oWins(2, 4, 6);
        }
        return;

    }

    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        label.setText("X wins");
        // frame.repaint();
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        label2.setBackground(Color.CYAN);
        label2.setBounds(350, 350, 700, 200);
        label2.setFont(new Font("Inkwell", Font.BOLD, 60));
        label2.setForeground(Color.WHITE);
        label2.setText("GAME OVER");
        panel3.add(label2, BorderLayout.CENTER);
    }

    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.RED);
        buttons[b].setBackground(Color.RED);
        buttons[c].setBackground(Color.RED);
        label.setText("O wins");
        // frame.repaint();
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        //label2.setBackground(Color.BLACK);
        label2.setBounds(350, 350, 700, 200);
        label2.setFont(new Font("Inkwell", Font.BOLD, 60));
        label2.setForeground(Color.WHITE);
        label2.setText("GAME OVER");
        panel3.add(label2, BorderLayout.SOUTH);

        frame.add(panel3, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        for (int i = 0; i < 9; i++) {

            if (e.getSource() == buttons[i]) {
                if (player1) {
                    buttons[i].setText("X");
                    buttons[i].setForeground(Color.ORANGE);
                    player1 = false;
                    check();

                } else {
                    buttons[i].setText("O");
                    buttons[i].setForeground(Color.RED);
                    player1 = true;
                    check();
                }
            }
        }
    }

    

}
