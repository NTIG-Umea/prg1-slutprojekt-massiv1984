import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.util.Objects;

public class Slutprojekt extends Canvas implements Runnable{

    private boolean running = false;
    private Thread thread;
    int x = 100;
    int y = 100;
    String mode = "None";
    String color = "Black";
    String[] colorchoice = { "Black", "Red", "Blue", "Green", "Yellow", "Orange", "Magenta", "Pink", "Cyan", "Grey", "Dark Grey", "White" };
    public Slutprojekt() {
        setSize(600,400);
        JFrame frame = new JFrame("Press C for different colors");
        frame.add(this);
        this.setBackground(Color.white);
        this.addKeyListener(new MyKeyListener());
        this.addMouseMotionListener(new MyMouseMotionListener());
        this.addMouseListener(new MyMouseListener());
        requestFocus();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        // Rita ut den nya bilden
        draw(g);

        g.dispose();
        bs.show();
    }

    public void draw(Graphics g) {
        //g.clearRect(0,0,getWidth(),getHeight());
        if (Objects.equals(mode, "Black")) {
            g.setColor(Color.BLACK);
            g.fillOval(x,y,10,10);
        }
        if (Objects.equals(mode, "Erase")) {
            g.setColor(Color.WHITE);
            g.fillOval(x,y,40,40);
        }
        if (Objects.equals(mode, "Red")) {
            g.setColor(Color.RED);
            g.fillOval(x,y,10,10);
        }
        if (Objects.equals(mode, "Blue")) {
            g.setColor(Color.BLUE);
            g.fillOval(x,y,10,10);
        }
        if (Objects.equals(mode, "Green")) {
            g.setColor(Color.GREEN);
            g.fillOval(x,y,10,10);
        }
        if (Objects.equals(mode, "Yellow")) {
            g.setColor(Color.YELLOW);
            g.fillOval(x,y,10,10);
        }
        if (Objects.equals(mode, "Orange")) {
            g.setColor(Color.ORANGE);
            g.fillOval(x,y,10,10);
        }
        if (Objects.equals(mode, "Pink")) {
            g.setColor(Color.PINK);
            g.fillOval(x,y,10,10);
        }
        if (Objects.equals(mode, "Cyan")) {
            g.setColor(Color.CYAN);
            g.fillOval(x,y,10,10);
        }
        if (Objects.equals(mode, "Grey")) {
            g.setColor(Color.GRAY);
            g.fillOval(x,y,10,10);
        }
        if (Objects.equals(mode, "Dark Grey")) {
            g.setColor(Color.DARK_GRAY);
            g.fillOval(x,y,10,10);
        }
        if (Objects.equals(mode, "Magenta")) {
            g.setColor(Color.MAGENTA);
            g.fillOval(x,y,10,10);
        }
        if (Objects.equals(mode, "White")) {
            g.setColor(Color.white);
            g.fillOval(x,y,10,10);
        }
    }

    private void update() {
    }

    public static void main(String[] args) {
        Slutprojekt minGrafik = new Slutprojekt();
        minGrafik.start();
    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        double ns = 1000000000.0 / 1000000.0;
        double delta = 0;
        long lastTime = System.nanoTime();

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while(delta >= 1) {
                // Uppdatera koordinaterna
                update();
                // Rita ut bilden med updaterad data
                render();
                delta--;
            }
        }
        stop();
    }

    public class MyMouseMotionListener implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            x = getMousePosition().x;
            y = getMousePosition().y;

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            x = getMousePosition().x;
            y = getMousePosition().y;

        }
    }

    public class MyMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == 1) {
                mode = color;
            }
            if (e.getButton() == 3) {
                mode = "Erase";
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            mode = "None";
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    public class MyKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            char ch = e.getKeyChar();

            if (ch == 'c' ) {
                color = (String) JOptionPane.showInputDialog(null, "Color", "Choose color", JOptionPane.QUESTION_MESSAGE, null, colorchoice, colorchoice[0]);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}
