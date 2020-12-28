package display;

import javax.swing.*;
import java.awt.*;

public class Display
{
	
	private JFrame frame;
	private Canvas canvas;
	
	private JTextArea textArea;
	private JButton connectBtn;
	
	
	private String title;
	private  int width,height;
	
	
	
	public Display(String title, int width, int height)
	{
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	private void createDisplay()
	{
		frame = new JFrame(title);
		textArea = new JTextArea();
		
		frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); //window appears in the center of the screen
		frame.setVisible(true);
		
		
		int textAreaWidth = (int) (width/1.5);
		int textAreaHeight = (int) (height/1.5);
		
		textArea.setBounds(width/2-textAreaWidth/2,height/2-textAreaHeight/2,textAreaWidth,textAreaHeight); //Being in center
		textArea.setLineWrap(true);
		textArea.setVisible(true);
		
		frame.add(textArea);
		
		
		int buttonWidth = 150;
		int buttonHeight = 30;
		connectBtn = new JButton("Connect");
		connectBtn.setBounds((width/2)-buttonWidth/2, height-buttonHeight-20, buttonWidth, buttonHeight);
		frame.add(connectBtn);
		
		
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
		
	}
	
	
	public JFrame getFrame()
	{
		return frame;
	}
	
	public JTextArea getTextArea()
	{
		return textArea;
	}
	
	public JButton getConnectBtn()
	{
		return connectBtn;
	}
}
