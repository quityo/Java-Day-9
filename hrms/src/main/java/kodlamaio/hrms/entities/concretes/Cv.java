package kodlamaio.hrms.entities.concretes;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "candidates_cv ")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cv"})

public class Cv {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(targetEntity = Jobseeker.class)
    @JoinColumn(name = "Jobseeker_id", referencedColumnName = "id", nullable = false)
    private Jobseeker jobseeker;

    @Column(name = "github_address")
    private String githubAddress;

    @Column (name = "linkedin_address")
    private  String linkedinAddress;

    @Length(max = 300)
    @Column(name = "description")
    private  String description;

    @Column(name = "created_date", columnDefinition = "Date default CURRENT_DATE")
    private final LocalDateTime createdDate = LocalDateTime.now();

    @Column (name = "is_active")
    private boolean isActive;

    @Column(name = "image")
    private String image;


    @OneToMany(mappedBy = "cv")
    private List<Skill> skills;


    @OneToMany(mappedBy = "cv")
    private List<Education> educations;


    @OneToMany(mappedBy = "cv")
    private List<Experience> experiences;


    @OneToMany(mappedBy = "cv")
    private List<Language> languages;




}