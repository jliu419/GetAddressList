package getaddresslist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileIO {
	
	private ArrayList<EnvelopeAdd> list = new ArrayList<EnvelopeAdd>();
	private int totalclients; 
	
	public ArrayList<EnvelopeAdd> readFile(String inputfilename)  
	{
		try 
		{
			FileReader file = new FileReader(inputfilename);
			BufferedReader buff = new BufferedReader(file);
						
			boolean readable = true; 
			int findc = 0;  // count increase when ',' is found
			int lastlocation = -1; // index of ',' when it is last found

			String line; int linecount = 0; 
			
			while (readable) 
			{
				line = buff.readLine();		
				
				if (line == null) // finished reading
				{
					readable = false;
					break; 
				}

				// System.out.println(line);
				
				String fname1 = "", lname1 = "", fname2 = "", lname2 = "", add = ""; 
				String street = "", city = "", zip = ""; 
				
				for (int index = 0; index < line.length(); index ++)
				{
					if (line.charAt(index) == ',')
					{
						findc ++; 
						if (findc == 1)
						{
							fname1 = line.substring(0, index);
						}
						else if (findc == 2)
						{
							lname1 = line.substring(lastlocation, index);
						}
						else if (findc == 3)
						{
							fname2 = line.substring(lastlocation, index);
						}
						else if (findc == 4)
						{
							lname2 = line.substring(lastlocation, index);
						}
						else if (findc == 5)
						{
							street = line.substring(lastlocation, index);
						}
						else
						{
							city = line.substring(lastlocation, index); 
							zip = line.substring(index + 1); 
						}
						lastlocation = index + 1; 
					}
				}
				
				findc = 0; 
				lastlocation = 0; 
				fname1 = fname1.trim(); 
				lname1 = lname1.trim(); 
				fname2 = fname2.trim(); 
				lname2 = lname2.trim(); 
				street = street.trim(); 
				city = city.trim();

				zip.trim();
				add = street + ", " + city + ", " + zip; 
				list.add(new EnvelopeAdd(fname1, lname1, fname2, lname2, add));

				linecount ++; 
			}	
			buff.close();
			totalclients = linecount; 
			// System.out.println("\nTotal clients: " + linecount);
		}
		catch (IOException e) {
			System.out.println("Error " + e.toString());
		}		
		
		System.out.println("Read File Complete\n");

		
		return list;
	}
	
	public void writefile(String outputfilename)
	{
		String stufftowrite; 
		EnvelopeAdd contact; 
		
		try 
		{
			FileWriter file = new FileWriter(outputfilename);
			BufferedWriter buff = new BufferedWriter(file);
			for (int index = 0; index < list.size(); index ++)
			{
				contact = list.get(index);
				stufftowrite = contact.toString();
				
				System.out.println(stufftowrite);
				
				buff.write((String)(stufftowrite));
			}
			
			buff.write("Total Clients: " + totalclients);
			
			System.out.println("Total Clients: " + totalclients);
			
			buff.close();
		}
		catch(IOException e)
		{
			System.out.println("Error " + e.toString());
		}
	}
}
