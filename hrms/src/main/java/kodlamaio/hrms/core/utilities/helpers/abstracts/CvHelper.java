package kodlamaio.hrms.core.utilities.helpers.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceDao;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.dataAccess.abstracts.SkillDao;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.Skill;

@Service
public class CvHelper implements CvHelperService {
    private EducationDao educationDao;

    private SkillDao skillDao;

    private LanguageDao languageDao;

    private ExperienceDao experienceDao;

    public CvHelper(EducationDao educationDao, SkillDao skillDao, LanguageDao languageDao,
                    ExperienceDao experienceDao) {
        super();
        this.educationDao = educationDao;
        this.skillDao = skillDao;
        this.languageDao = languageDao;
        this.experienceDao = experienceDao;
    }


    public void setAllCvId(List<Education> edu, List<Language> lang, List<Skill> skill, List<Experience> exp, Cv cv) {
        setCvEId(edu, cv);
        setCvLId(lang, cv);
        setCvTId(skill, cv);
        setCvJId(exp, cv);
    }

    private void setCvEId(List<Education> mapResume, Cv cvv) {
        if (mapResume == null) {

        } else {
            for (Education data : mapResume) {
                data.setCv(cvv);
                this.educationDao.save(data);
            }
        }


    }

    private void setCvLId(List<Language> mapResume, Cv cvv) {
        if (mapResume == null) {

        } else {

            for (Language data : mapResume) {
                data.setCv(cvv);
                this.languageDao.save(data);
            }
        }
    }


    private void setCvTId(List<Skill> mapResume, Cv cvv) {
        if (mapResume == null) {

        } else {

            for (Skill data : mapResume) {
                data.setCv(cvv);
                this.skillDao.save(data);
            }
        }
    }

    private void setCvJId(List<Experience> mapResume, Cv cvv) {
        if (mapResume == null) {

        } else {

            for (Experience data : mapResume) {
                data.setCv(cvv);
                this.experienceDao.save(data);
            }
        }

    }
}