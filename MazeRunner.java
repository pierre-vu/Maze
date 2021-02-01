import javax.swing.JFrame;
import java.awt.Component;
import java.io.FileNotFoundException;

public class MazeRunner extends JFrame{

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public static void main(String[] args) throws FileNotFoundException {
        new MazeRunner(); 
        
    }
      

    public MazeRunner() throws FileNotFoundException {
        super("Maze");

        setSize(WIDTH, HEIGHT);

        
        
        
        Maze graph = new Maze(); 
        
        
        ((Component) graph).setFocusable(true);

        getContentPane().add(graph);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}




