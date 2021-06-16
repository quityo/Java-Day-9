package kodlamaio.hrms.service;

import java.sql.Date;

public class FakeMernisService {
	public boolean ValidateByPersonalInfo(long nationalId, String firstName, String lastName, Date yearOfBirth)
	{
		System.out.println(firstName + " " + lastName + " is valid person." );
		return true;
	}
}