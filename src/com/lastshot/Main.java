package com.lastshot;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        String title = "Game of Life by Conway";
        Conway game = new Conway();
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(game.grid);
        frame.pack();
        frame.setVisible(true);
        game.mainloop();
    }
}
