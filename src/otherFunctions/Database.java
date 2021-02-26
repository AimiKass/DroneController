package otherFunctions;

import models.RecordedKey;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// TODO: 2/24/2021 Create a class in order to establish if database exist
public class Database
{
	String pathOfRecordedFly = "src/database/recordedFly.txt";
	String pathOfBooleanForRecordingButton = "src/database/recordingButtonIs.txt";
	
	File recordedFlyFile = new File(pathOfRecordedFly);
	File recordingButtonIsFile = new File(pathOfBooleanForRecordingButton);
	
	
	
	
	public Database()
	{
		if (!recordedFlyFile.exists())
		{
			try {
				recordedFlyFile.createNewFile();
			} catch (IOException e)
			{
				// TODO: 2/24/2021 test it and you should
				//  create a whole new class for that purpose
				new File("src/database").mkdirs();
			}
		}
		
		if (!recordingButtonIsFile.exists())
		{
			try {
				recordingButtonIsFile.createNewFile();
			} catch (IOException e)
			{
				// TODO: 2/24/2021 test it and you should
				//  create a whole new class for that purpose
				new File("src/database").mkdirs();
			}
		}
		
	}
	
	public void setRecordedFly(String msg)
	{
		try {
			FileWriter fw = new FileWriter(pathOfRecordedFly, true);
			BufferedWriter writer = new BufferedWriter(fw);
			writer.append(msg);
			writer.newLine();
			writer.close();

		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public List<RecordedKey> getRecordedFly()
	{
		List<RecordedKey> keys = new ArrayList<>();
		Scanner scanner = null;
		try{
			scanner = new Scanner(recordedFlyFile);
			while (scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				keys.add(new RecordedKey(line.split("\\.")[0].charAt(0),Long.parseLong(line.split("\\.")[1])));
			}
			
		} catch (FileNotFoundException e)
		{
			System.out.println(scanner.nextLine());
			e.printStackTrace();
		}
		return keys;
	}
	
	public void eraseRecordedFly()
	{
		try {
			new FileWriter(pathOfRecordedFly,false).close();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
	
	
	public void setRecordingButtonIs(boolean recordingButtonIs)
	{
		String buttonIs = recordingButtonIs ? "True" : "False";
		
		try {
			FileWriter fw = new FileWriter(pathOfBooleanForRecordingButton);
			BufferedWriter writer = new BufferedWriter(fw);
			writer.append(buttonIs);
			writer.newLine();
			writer.close();
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean getRecordingButtonIs()
	{
		boolean recordingButtonIs;
		
		try{
			Scanner scanner = new Scanner(recordingButtonIsFile);
			
			if (scanner.nextLine().equals("True"))
				recordingButtonIs = true;
			else
				recordingButtonIs = false;
			
			
			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
			recordingButtonIs = false;
		}
		return recordingButtonIs;
	}
	
}