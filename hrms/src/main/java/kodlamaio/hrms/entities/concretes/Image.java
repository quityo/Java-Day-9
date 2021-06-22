package kodlamaio.hrms.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "images")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "user" })
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_id")
	private int imageId;

	@Column(name = "name")
	private String name;

	@Column(name = "url")
	private String url;

	@Column(name = "public_id")
	private String publicId;

	@JsonProperty(access = Access.WRITE_ONLY)
	@JoinColumn(name = "user_id")
	@OneToOne()
	private User user;

	public Image(String name, String url, String publicId) {
		this.name = name;
		this.url = url;
		this.publicId = publicId;

	}

}