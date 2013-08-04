
package picturecomparetwo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Twiztedcyph
 */
public class Frame extends JPanel
{
    private JFrame frame;
    private JButton imgLoadOne, imgLoadTwo;
    private JFileChooser fileChooser;
    private JSlider slider;
    private JLabel sliderLabel;
    private int errorTolerance;
    
    public Frame()
    {
        errorTolerance = 0;
        
        //Basic frame settings
        frame = new JFrame("Simple Image Compare by Twiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Frame not resizable.
        frame.setResizable(false);
        
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);
        
        frame.getContentPane().add(Frame.this);
        frame.setSize(new Dimension(1100, 900));
        frame.setLocationRelativeTo(null);
        
        buttonSetup();
        sliderSetup();
        
        
        frame.setVisible(true);
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        drawBorderLayout(g2d);
    }
    
    private void drawBorderLayout(Graphics2D g2d)
    {
        g2d.drawRect(12, 5, 530, 600);
        g2d.drawRect(551, 5, 530, 600);
        g2d.drawRect(12, 613, 530, 30);
        g2d.drawRect(551, 613, 530, 30);
    }
    
    private void buttonSetup()
    {
        //Load image buttons setup.
        imgLoadOne = new JButton("Load image one");
        imgLoadOne.setBounds(167, 650, 200, 30);
        imgLoadOne.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Load and then display image one from here....
            }
        });
        this.add(imgLoadOne);
        
        imgLoadTwo = new JButton("Load image two");
        imgLoadTwo.setBounds(727, 650, 200, 30);
        imgLoadTwo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Load and then display image two from here.....
            }
        });
        this.add(imgLoadTwo);
        
        //compare buttom setup.
    }
    
    private void sliderSetup()
    {
        sliderLabel = new JLabel("Error tolerance: " + errorTolerance);
        sliderLabel.setBounds(503, 660, 120, 20);
        this.add(sliderLabel);
        
        slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 0);
        slider.setMajorTickSpacing(5);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setBackground(Color.LIGHT_GRAY);
        slider.setBounds(423, 680, 250, 50);
        slider.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                errorTolerance = slider.getValue();
                sliderLabel.setText("Error tolerance: " + errorTolerance);
            }
        });
        this.add(slider);
    }
}
