package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertDto {

	 private int id;
	    private String companyName;
	    private String description;
	    private String jobTitle;
	    private String cityName;
	    private String title;
	    private String type;
	    private Date endDate;

	
}
