import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Stopwatch {
  private static final int REFRESH_RATE = 100;
  private JLabel timeLabel;
  private JButton startButton;
  private JButton stopButton;
  private JButton lapButton;
  private JFrame frame;
  private StopwatchThread stopwatchThread;

  public Stopwatch() {
    timeLabel = new JLabel("00:00:00", JLabel.CENTER);
    startButton = new JButton("Start");
    stopButton = new JButton("Stop");
    lapButton = new JButton("Lap");
    stopButton.setEnabled(false);
    lapButton.setEnabled(false);
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(startButton);
    buttonPanel.add(stopButton);
    buttonPanel.add(lapButton);
    frame = new JFrame("Stopwatch");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    frame.add(timeLabel, BorderLayout.CENTER);
    frame.add(buttonPanel, BorderLayout.SOUTH);
    frame.setSize(new Dimension(300, 100));
    frame.setVisible(true);
    startButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         startStopwatch();
      }
    });
    stopButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        stopStopwatch();
      }
    });
    lapButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        lap();
      }
    });
  }
  private void startStopwatch() {
    startButton.setEnabled(false);
    stopButton.setEnabled(true);
    lapButton.setEnabled(true);
    stopwatchThread = new StopwatchThread();
    stopwatchThread.start();
  }
  private void stopStopwatch() {
    stopButton.setEnabled(false);
    lapButton.setEnabled(false);
    startButton.setEnabled(true);
    stopwatchThread.stopStopwatch();
  }
  private void lap() {
     long lapTime = stopwatchThread.getElapsedTime();
    int hours = (int)(lapTime / 3600000);
    int minutes = (int)(lapTime / 60000) % 60;
    int seconds = (int)(lapTime / 1000) % 60;
    int milliseconds = (int)(lapTime % 1000);
    String lapTimeString = String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds);
    System.out.println("Lap time: " + lapTimeString);
  }
  private class StopwatchThread extends Thread {
    private long startTime;
    private long elapsedTime;
    private boolean isRunning;
    public StopwatchThread() {
      startTime = System.currentTimeMillis();
      elapsedTime = 0;
      isRunning = true;
    }
    public void run() {
      while (isRunning) {
        elapsedTime = System.currentTimeMillis() - startTime;
        int hours = (int)(elapsedTime / 3600000);
        int minutes = (int)(elapsedTime / 60000) % 60;
        int seconds = (int)(elapsedTime / 1000) % 60;
        int milliseconds = (int)(elapsedTime % 1000);
        String timeString = String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds);
        timeLabel.setText(timeString);
        try {
          Thread.sleep(REFRESH_RATE);
        } catch (InterruptedException e) {
      }
      }
    }
    public void stopStopwatch() {
      isRunning = false;
    }
    public long getElapsedTime() {
      return elapsedTime;
    }
  }
  public static void main(String[] args) {
    new Stopwatch();
  }
}

