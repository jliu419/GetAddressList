package getaddresslist;

public class Main {
	
	public static void main (String args[])
	{	
		FileIO file = new FileIO();
		String inputfile = "CrescentTerraceOwnerOccupied";
		file.readFile("SourceFiles/" + inputfile + ".txt");
		file.writefile(inputfile + " Output.txt");
	}
}
