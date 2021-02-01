
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JPanel;
import java.util.*;
import java.awt.*;


public class Maze extends JPanel{
    
    int size;
    Box[][] boxes;
    Stack<Box> stacks;
    ArrayList<Box> stuff;
    int ba;
    int bb;
    
    public Maze() {
        
        size = 20;
        boxes = new Box[size][size];
        stuff = new ArrayList<>();
        stacks = new Stack<>();
        ba = 0;
        bb = 0;
        fill();
        
        
    }
    
    public void fill() {
        boolean t = true;
        boolean f = false;
        boolean[][] visits = new boolean[size][size];
        for(int i = 0; i < visits.length; i++) {
            for(int j = 0; j < visits[i].length; j++) {
                visits[i][j] = true;
            }
        }     
        int a = (int)(Math.random() * size);
        int b = (int)(Math.random() * size);
        Box box = new Box(a,b);
        
        while(0==0) {
            
            int cnt = 0;
            //nswe
                visits[box.x][box.y] = false;
                if(box.x < size-1 && visits[box.x+1][box.y]) {
                    stuff.add(new Box(box.x+1,box.y,t,t,f,t));
                    cnt++;
                }
                if(box.x > 0 && visits[box.x-1][box.y]) {
                    stuff.add(new Box(box.x-1,box.y,t,t,t,f));
                    cnt++;
                }
                if(box.y < size-1 && visits[box.x][box.y+1]) {
                    stuff.add(new Box(box.x,box.y+1,f,t,t,t));
                    cnt++;
                }
                if(box.y > 0 && visits[box.x][box.y-1]) {
                    stuff.add(new Box(box.x,box.y-1,t,f,t,t));
                    cnt++;
                }
                
                int g = (int)(Math.random()*cnt);
                
                
                if(cnt == 0) {
                    
                    boxes[box.x][box.y] = box;
                    try{
                        box = stacks.pop();
                    }
                    catch(Exception ex){
                        break;
                    }
                    
                }
                else{
                    Box bx = stuff.get(g);
                    if(bx.x > box.x) {
                        
                        box.east=f;
                    }
                    if(bx.x < box.x) {
                        box.west=f;
                    }
                    if(bx.y > box.y) {
                        box.south=f;
                    }
                    if(bx.y < box.y) {
                        box.north=f;
                    }
                    
                    stacks.push(box);
                    
                    box = stuff.get(g);
                    stuff.clear();
                    Color c = new Color (0,0,0);
                }
                
                
        }
        
    }
    public void paint(Graphics window) {
        int width = getWidth()/size;
        int height = getHeight()/size;
        
        for(Box[] b :boxes) {
            for(Box c : b) {
                int a = c.x*width;
                int t = c.y*height;
                if(c.north) {
                    window.drawLine(a, t, a+width, t);
                }
                if(c.south) {
                    window.drawLine(a, t+height, a+width, t+height );
                }
                if(c.west) {
                    window.drawLine(a, t, a, t+height );
                }
                
                if(c.east) {
                    window.drawLine(a+width, t, a+width,t+height);
                    
                }
            }
        }
    }
    
    
    
    
}
