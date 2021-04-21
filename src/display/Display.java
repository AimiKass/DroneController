package display;

import managers.buttonManager.ButtonManager;
import managers.buttonManager.buttons.ConnectionBtnActionListener;
import managers.buttonManager.buttons.RecordingBtnActionListener;
import managers.buttonManager.buttons.StartRecordedFlyBtnActionListener;
import managers.keyManager.TextAreaKeyListener;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame
{
	
	private Canvas canvas;
	private JScrollPane scrollPane;
	
	private JTextArea textArea, iPTextArea,portTextArea;
	private JButton recordingBtn,playRecordedFlyBtn, connectBtn;
	private JLabel portLabel,IPLabel;
	
	
	private  int width,height;
	
	
	private TextAreaKeyListener textAreaKeyListener;
	private ButtonManager recordingBtnManager,playRecordedFlyBtnManager,connectionBtnManager;
	
	
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
		int mainTextAreaWidth = (int) (width/1.3);
		int mainTextAreaHeight = (int) (height/1.7);
		
		textArea = new JTextArea();
		
		textArea.setBounds(width/2-mainTextAreaWidth/2,height/2-mainTextAreaHeight/2,mainTextAreaWidth,mainTextAreaHeight); //Being in center
		textArea.setLineWrap(true);
		textArea.setVisible(true);
		
		textAreaKeyListener = new TextAreaKeyListener(textArea);
		textArea.addKeyListener(textAreaKeyListener);
		
		add(textArea);
		
		//=============IPTextArea==========================
		iPTextArea = new JTextArea("192.168.1.9");
		int secondaryTextAreaWidth = 150;
		int secondaryTextAreaHeight = 20;
		
		
		iPTextArea.setBounds((width/2)+(secondaryTextAreaWidth/2),secondaryTextAreaHeight,secondaryTextAreaWidth,secondaryTextAreaHeight);
		
		
		//=========portTextArea===========================
		portTextArea = new JTextArea("1234");
		
		portTextArea.setBounds((width/2)+(secondaryTextAreaWidth/2),secondaryTextAreaHeight*3,secondaryTextAreaWidth,secondaryTextAreaHeight);
		
		//==============JScrollPane=================
		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(width/2-mainTextAreaWidth/2,height/2-mainTextAreaHeight/2,mainTextAreaWidth,mainTextAreaHeight);

		//================PortLabel=======================
		int portLabelWidth = 75;
		int portLabelHeight = 15;
		portLabel = new JLabel("Port:");
		portLabel.setBounds((width/2)+(secondaryTextAreaWidth/2)-portLabelWidth,secondaryTextAreaHeight*3,portLabelWidth,portLabelHeight);
		
		//================IPLabel=======================
		int IPLabelWidth = 75;
		int IPLabelHeight = 15;
		IPLabel = new JLabel("IP:");
		IPLabel.setBounds((width/2)+(secondaryTextAreaWidth/2)-IPLabelWidth,secondaryTextAreaHeight,IPLabelWidth,IPLabelHeight);
		
		//==============JRecordingBtn=================
		int buttonWidth = 150;
		int buttonHeight = 30;
		recordingBtn = new JButton("Start Recording");
		recordingBtn.setBounds(width/2-mainTextAreaWidth/2, height-buttonHeight-20, buttonWidth, buttonHeight);
		
		
		recordingBtnManager = new RecordingBtnActionListener(recordingBtn);
		recordingBtn.addActionListener(recordingBtnManager);
		
		
		
		//==============JPlayRecordedFlyBtn=================
		
		
		playRecordedFlyBtn = new JButton("Play Recorded Fly");
		playRecordedFlyBtn.setBounds((width/2-mainTextAreaWidth/2)+mainTextAreaWidth-buttonWidth, height-buttonHeight-20, buttonWidth, buttonHeight);
		
		playRecordedFlyBtnManager = new StartRecordedFlyBtnActionListener(playRecordedFlyBtn);
		playRecordedFlyBtn.addActionListener(playRecordedFlyBtnManager);

		
		//==============JPlayRecordedFlyBtn=================
		
		connectBtn = new JButton("Connect");
		connectBtn.setBounds(width/2-mainTextAreaWidth/2, buttonHeight+10, buttonWidth, buttonHeight);
		
		connectionBtnManager = new ConnectionBtnActionListener(connectBtn,iPTextArea,portTextArea);
		connectBtn.addActionListener(connectionBtnManager);
		
		
		
		//==============Canvas=================
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		canvas.setFocusable(false);
		
		
		add(iPTextArea);
		add(IPLabel);
		add(portTextArea);
		add(portLabel);
		add(connectBtn);
		add(playRecordedFlyBtn);
		add(recordingBtn);
		add(scrollPane);
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
