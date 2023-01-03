import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BounceBall {
  private static final int BALL_SIZE = 50;
  private static final int UPDATE_RATE = 10; 
  private JFrame frame;
  private BallPanel ballPanel;
  private Thread animator;
  private boolean running;
  private int x;
  private int y;
  private int dx;
  private int dy;

  public BounceBall() {
    ballPanel = new BallPanel();
    ballPanel.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
       start();
      }
    });
    frame = new JFrame("Bounce Ball");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(ballPanel);
    frame.pack();
    frame.setVisible(true);
  }
  public void start() {
    animator = new Thread(new BallRunnable());
    animator.start();
  }
  private class BallPanel extends JPanel {
    public BallPanel() {
      setPreferredSize(new Dimension(400, 400));
      setBackground(Color.WHITE);
    }
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.BLUE);
      g.fillOval(x, y, BALL_SIZE, BALL_SIZE);
    }
  }
private class BallRunnable implements Runnable {
  public void run() {
    running = true;
    x = 0;
    y = 0;
    dx = 5;
    dy = 5;
    while (running) {
      x += dx;
      y += dy;
      if (x < 0 || x > ballPanel.getWidth() - BALL_SIZE) {
        dx = -dx;
      }
      if (y < 0 || y > ballPanel.getHeight() - BALL_SIZE) {
        dy = -dy;
      }
      SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          ballPanel.repaint();
        }
      });
      try {
        Thread.sleep(UPDATE_RATE);
      } catch (InterruptedException e) {}
    }
  }
}
public static void main(String[] args) {
    new BounceBall();
  }
}
