package modd;

import java.util.ArrayList;
// import java.util.*;
import java.util.List;

// import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;

public class Intr extends JFrame {
    /**
     *
     */
    private int[][] maze = {
            { 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 0, 0, 1, 0, 0, 1, 1 },
            { 1, 0, 1, 1, 0, 0, 1, 1 },
            { 1, 0, 0, 0, 0, 1, 0, 1 },
            { 1, 0, 1, 1, 1, 1, 0, 1 },
            { 1, 0, 1, 0, 0, 0, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 9, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1 }
    };

    public List<Integer> path = new ArrayList<>();

    public Intr() {
        setTitle("Maze SOlver");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dfs.search(maze, 1, 1, path);
        System.out.println(path);
    }

    @Override
    public void paint(Graphics g) {
        g.translate(300, 300);
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                Color color;
                switch (maze[i][j]) {
                    case 1:
                        color = Color.BLACK;
                        break;
                    case 9:
                        color = Color.RED;
                        break;
                    default:
                        color = Color.WHITE;
                        break;
                }
                g.setColor(color);
                g.fillRect(30 * j, 30 * i, 30, 30);
                g.setColor(Color.RED);
                g.drawRect(30 * j, 30 * i, 30, 30);
            }
        }
        for (int i = 0; i < path.size(); i += 2) {
            int x = path.get(i);
            int y = path.get(i + 1);
            g.setColor(Color.green);
            g.fillOval(30 * x, 30 * y, 20, 20);
        }
    }

    public static void main(String[] args) {
        Intr view = new Intr();
        view.setVisible(true);
    }
}
