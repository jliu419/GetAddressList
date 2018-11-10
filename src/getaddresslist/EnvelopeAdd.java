package getaddresslist;


public class EnvelopeAdd {
	
	private String fname1, lname1, fname2, lname2, add; 
	
	public EnvelopeAdd (String fname1, String lname1, String fname2, String lname2, String address)
	{
		this.fname1 = fname1; 
		this.lname1 = lname1; 
		this.fname2 = fname2;
		this.lname2 = lname2;
		add = address; 
	}
	
	public String getFirstname() 
	{
		return fname1;
	}

	public void setFirstname(String firstname) 
	{
		this.fname1 = firstname;
	}

	public String getLastname() 
	{
		return lname1;
	}

	public void setLastname(String lastname) 
	{
		this.lname1 = lastname;
	}

	public String getFname2() 
	{
		return fname2;
	}

	public void setFname2(String fname2) 
	{
		this.fname2 = fname2;
	}

	public String getLname2() 
	{
		return lname2;
	}

	public void setLname2(String lname2) 
	{
		this.lname2 = lname2;
	}

	public String getAdd() 
	{
		return add;
	}

	public void setAdd(String add) 
	{
		this.add = add;
	}
	
	public String toString()
	{
		String result ; 
		if (fname2.equals("") && lname2.equals(""))
		{
			result = "\t    " + fname1 + " " + lname1 + "\n" + add + "\n\n\n\n";
		}
		else
		{
			result = "\t" + fname1 + " " + lname1 + " & " 
					+ fname2 + " " + lname2 + "\n" + add + "\n\n\n\n";
		}
		return result; 
	}
}
