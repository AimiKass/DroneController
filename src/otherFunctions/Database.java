package otherFunctions;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// TODO: 2/24/2021 Create a class in order to establish if database exist
public class Database
{
	String path_OfRecordedFly = "src/database/recordedFly.txt";
	String path_OfBooleanForRecordingButton = "src/database/recordingButtonIs.txt";
	
	File file_recordedFly = new File(path_OfRecordedFly);
	File file_recordingButtonIs = new File(path_OfBooleanForRecordingButton);
	
	
	
	public Database()
	{
		if (!file_recordedFly.exists())
		{
			try {
				file_recordedFly.createNewFile();
			} catch (IOException e)
			{
				// TODO: 2/24/2021 test it and you should
				//  create a whole new class for that purpose
				new File("src/database").mkdirs();
			}
		}
		
		if (!file_recordingButtonIs.exists())
		{
			try {
				file_recordingButtonIs.createNewFile();
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
			FileWriter fw = new FileWriter(path_OfRecordedFly, true);
			BufferedWriter writer = new BufferedWriter(fw);
			writer.append(msg);
			writer.newLine();
			writer.close();

		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public List<ArrayList<Integer>> getRecordedFly()
	{
		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		
		Scanner scanner = null;
		try{
			scanner = new Scanner(file_recordedFly);
			
			int i=0;
			list.add(new ArrayList<>());
			
			while (scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				if (line.equals("."))
				{
					list.add(new ArrayList<>());
					i++;
				}else
				{
					list.get(i).add(Integer.parseInt(line));
				}
				
			}
			
		} catch (FileNotFoundException e)
		{
			System.out.println(scanner.nextLine());
			e.printStackTrace();
		}
		return list;
	}
	
	
	public void eraseRecordedFly()
	{
		try {
			new FileWriter(path_OfRecordedFly, false).close();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
	
	
	public void setRecordingButtonIs(boolean recordingButtonIs)
	{
		String buttonIs = recordingButtonIs ? "True" : "False";
		
		try {
			FileWriter fw = new FileWriter(path_OfBooleanForRecordingButton);
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
			Scanner scanner = new Scanner(file_recordingButtonIs);
			
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