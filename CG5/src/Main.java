import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main extends JFrame {

    private DrawUtils drawingPanel = new DrawUtils();

    static ArrayList<ArrayList<Integer>> lines = new ArrayList<>();
    static ArrayList<Integer> rectangle = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> polygon = new ArrayList<>();

    public Main(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int WIDTH = 900;
        int HEIGHT = 680;
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setLayout(null);

        drawingPanel.setBounds(0, 0, WIDTH, 560);
        add(drawingPanel);

        JButton drawLineButton = new JButton("Draw line");
        drawLineButton.setBounds(20, 580, 200, 40);
        drawLineButton.addActionListener(e -> {
            drawingPanel.drawLines(lines);
        });
        add(drawLineButton);

        JButton drawPolygonButton = new JButton("Draw polygon");
        drawPolygonButton.setBounds(240, 580, 200, 40);
        drawPolygonButton.addActionListener(e -> {
            drawingPanel.drawPolygon(polygon);
        });
        add(drawPolygonButton);

        JButton drawRectangleButton = new JButton("Draw rectangle");
        drawRectangleButton.setBounds(460, 580, 200, 40);
        drawRectangleButton.addActionListener(e -> {
            drawingPanel.drawRectangle(rectangle);
        });
        add(drawRectangleButton);

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(680, 580, 200, 40);
        clearButton.addActionListener(e -> {
            drawingPanel.drawLines(new ArrayList<>());
                    drawingPanel.drawRectangle(new ArrayList<>());
                            drawingPanel.drawPolygon(new ArrayList<>());
        });
        add(clearButton);
        setResizable(false);
    }


    public static void main(String[] args) throws IOException {
        File fin = new File("input.txt");
        Scanner scanner = new Scanner(fin);
        int n = Integer.parseInt(scanner.nextLine());

        for(int i=0;i<n;i++){
            lines.add(new ArrayList<>());
            String[] line = scanner.nextLine().split(" ");
            for(String num : line){
                lines.get(i).add(Integer.parseInt(num));
            }
        }

        rectangle = new ArrayList<>();
        String[] line = scanner.nextLine().split(" ");
        for(String num : line){
            rectangle.add(Integer.parseInt(num));
        }

        polygon.add(new ArrayList<>());
        polygon.get(0).addAll(Arrays.asList(-5, 2, 7, 6));
        polygon.add(new ArrayList<>());
        polygon.get(1).addAll(Arrays.asList(7, 6, 12, 3));
        polygon.add(new ArrayList<>());
        polygon.get(2).addAll(Arrays.asList(12, 3, -10, -8));
        polygon.add(new ArrayList<>());
        polygon.get(3).addAll(Arrays.asList(-10, -8, -5, 2));

        Main main = new Main();
        main.repaint();
    }
}
