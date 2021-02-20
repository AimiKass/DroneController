package display;

import managers.buttonManager.ButtonManager;
import managers.buttonManager.buttons.ConnectBtnActionListener;
import managers.keyManager.TextAreaKeyListener;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame
{
	
	private Canvas canvas;
	private JScrollPane scrollPane;
	
	private JTextArea textArea;
	private JButton connectBtn;
	
	
	private  int width,height;
	
	
	private TextAreaKeyListener textAreaKeyListener;
	private ButtonManager connectBtnManager;
	
	
	public Display(String title, int width, int height)
	{
		super(title);
		
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	private void createDisplay()
	{
		//==============JFrame=================
		setSize(width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setLocationRelativeTo(null); //window appears in the center of the screen
		setVisible(true);
		
		
		//==============JTextArea=================
		int textAreaWidth = (int) (width/1.5);
		int textAreaHeight = (int) (height/1.5);
		
		textArea = new JTextArea();
		
		textArea.setBounds(width/2-textAreaWidth/2,height/2-textAreaHeight/2,textAreaWidth,textAreaHeight); //Being in center
		textArea.setLineWrap(true);
		textArea.setVisible(true);
		
		textAreaKeyListener = new TextAreaKeyListener(textArea);
		textArea.addKeyListener(textAreaKeyListener);
		
		add(textArea);
		
		
		
		//==============JScrollPane=================
		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(width/2-textAreaWidth/2,height/2-textAreaHeight/2,textAreaWidth,textAreaHeight);

		add(scrollPane);
		
		
		
		//==============JButton=================
		int buttonWidth = 150;
		int buttonHeight = 30;
		connectBtn = new JButton("Connect");
		connectBtn.setBounds((width/2)-buttonWidth/2, height-buttonHeight-20, buttonWidth, buttonHeight);
		
		connectBtnManager = new ConnectBtnActionListener(connectBtn);
		connectBtn.addActionListener(connectBtnManager);
		
		add(connectBtn);
		
		
		//==============Canvas=================
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		canvas.setFocusable(false);
		
		add(canvas);
		
		
		pack();
	}
	
	
	public TextAreaKeyListener getTextAreaKeyListener()
	{
		return textAreaKeyListener;
	}
	
	public ButtonManager getConnectBtnManager()
	{
		return connectBtnManager;
	}
}
