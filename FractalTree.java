/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author shraddhapatel
 */
public class FractalTree extends JPanel {
    
    private final int MAX_DEPTH = 9;  // controls how many levels deep the recursion goes

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Starting point: bottom center of the panel
        int startX = getWidth() / 2;
        int startY = getHeight() - 50;
        drawTree(g, startX, startY, -90, MAX_DEPTH);  // -90 degrees so it grows upward
    }

    /**
     * Recursively draws a fractal tree.
     * @param g The graphics object to draw on.
     * @param x1 The starting x-coordinate of the branch.
     * @param y1 The starting y-coordinate of the branch.
     * @param angle The angle of the branch in degrees.
     * @param depth The current recursion depth.
     */
    private void drawTree(Graphics g, int x1, int y1, double angle, int depth) {
        // 1. Base Case: stop recursion when depth == 0
        if (depth == 0) return;

        // 2. Calculate the length of the current branch
        // Branch length decreases with depth
        int branchLength = depth * 10;

        // 3. Calculate the end coordinates (x2, y2)
        double angleRad = Math.toRadians(angle);
        int x2 = x1 + (int) (Math.cos(angleRad) * branchLength);
        int y2 = y1 + (int) (Math.sin(angleRad) * branchLength);

        // 4. Draw the current branch
        g.drawLine(x1, y1, x2, y2);

        // Optional: color by depth (for visual variety)
        g.setColor(new Color(0, 100 + depth * 10, 0)); // darker green as depth increases

        // 5. Recursive calls for left and right branches
        drawTree(g, x2, y2, angle - 20, depth - 1);  // Left branch
        drawTree(g, x2, y2, angle + 20, depth - 1);  // Right branch
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Recursive Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.add(new FractalTree());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
