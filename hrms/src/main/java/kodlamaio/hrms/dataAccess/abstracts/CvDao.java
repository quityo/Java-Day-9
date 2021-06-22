package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Cv;

public interface CvDao extends JpaRepository<Cv, Integer> {
    List<Cv>  getByJobseeker_UserId(int jobseekerId);
    
    @Query("Select new kodlamaio.hrms.entities.dtos.CvDto"
			+"(c.cvId,e.schoolName,e.department,e.startYearOfSchool,"
			+"e.endYearOfSchool,w.workingPlace,w.startYearOfWork,"
			+"w.endYearOfWork,f.language,f.level,c.githubAddress,c.linkedinAddress,"
			+"t.skillName,c.coverLetter)"
			+" From Cv c"
			+" Inner Join c.educations e"
			+" Inner Join c.experiences w"
			+" Inner Join c.languages f"
			+" Inner Join c.skills t"
			)
	List<CvDao> getCvDetails();
}

