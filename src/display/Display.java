package display;

import managers.buttonManager.ButtonManager;
import managers.buttonManager.buttons.RecordingBtnActionListener;
import managers.buttonManager.buttons.StartRecordedFlyBtnActionListener;
import managers.keyManager.TextAreaKeyListener;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame
{
	
	private Canvas canvas;
	private JScrollPane scrollPane;
	
	private JTextArea textArea;
	private JButton recordingBtn,playRecordedFlyBtn;
	
	
	private  int width,height;
	
	
	private TextAreaKeyListener textAreaKeyListener;
	private ButtonManager recordingBtnManager,playRecordedFlyBtnManager;
	
	
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
		
//		addWindowListener(new WindowListener()
//		{
//			@Override
//			public void windowOpened(WindowEvent e)
//			{
//
//			}
//
//			@Override
//			public void windowClosing(WindowEvent e)
//			{
//				if (JOptionPane.showConfirmDialog(e.getWindow(),
//												  "Are you sure you want to close this window?", "Close Window?",
//												  JOptionPane.YES_NO_OPTION,
//												  JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
//				{
//					MainController.stopMainLoop();
//					System.exit(0);
//				}
//			}
//
//			@Override
//			public void windowClosed(WindowEvent e)
//			{
//
//			}
//
//			@Override
//			public void windowIconified(WindowEvent e)
//			{
//
//			}
//
//			@Override
//			public void windowDeiconified(WindowEvent e)
//			{
//
//			}
//
//			@Override
//			public void windowActivated(WindowEvent e)
//			{
//
//			}
//
//			@Override
//			public void windowDeactivated(WindowEvent e)
//			{
//
//			}
//		});
		
		
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
		
		
		
		//==============JRecordingBtn=================
		int buttonWidth = 150;
		int buttonHeight = 30;
		recordingBtn = new JButton("Start Recording");
		recordingBtn.setBounds((width/2)-buttonWidth, height-buttonHeight-20, buttonWidth, buttonHeight);
		
		
		recordingBtnManager = new RecordingBtnActionListener(recordingBtn);
		recordingBtn.addActionListener(recordingBtnManager);
		
		add(recordingBtn);
		
		
		//==============JPlayRecordedFlyBtn=================
		
		
		playRecordedFlyBtn = new JButton("Play Recorded Fly");
		playRecordedFlyBtn.setBounds((width/2)+buttonWidth/2, height-buttonHeight-20, buttonWidth, buttonHeight);
		
		playRecordedFlyBtnManager = new StartRecordedFlyBtnActionListener(playRecordedFlyBtn);
		playRecordedFlyBtn.addActionListener(playRecordedFlyBtnManager);

		add(playRecordedFlyBtn);
		
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
	
	public ButtonManager getRecordingBtnManager()
	{
		return recordingBtnManager;
	}
}
