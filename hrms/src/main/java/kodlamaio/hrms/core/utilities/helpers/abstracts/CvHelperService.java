package kodlamaio.hrms.core.utilities.helpers.abstracts;

import java.util.List;

import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.Skill;

public interface CvHelperService {
    public void setAllCvId(List<Education> edu, List<Language> lang, List<Skill> talent, List<Experience> exp, Cv cv);
}