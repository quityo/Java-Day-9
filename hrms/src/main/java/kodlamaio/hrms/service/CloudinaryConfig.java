package kodlamaio.hrms.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.helpers.abstracts.CloudinaryManager;
import kodlamaio.hrms.core.utilities.helpers.abstracts.CloudinaryService;

@Configuration
public class CloudinaryConfig {
	
	
	 	@Bean
	    public Cloudinary cloudinaryUser(){
	        return new Cloudinary(ObjectUtils.asMap(
	        		"cloud_name", "fufufu",
	                "api_key", "199629458285134",
	                "api_secret", "PBDuduN6yGUiL3Y8Qdz4cX2oNt8"));
	    }

	    @Bean
	    public CloudinaryService cloudinaryService(){
	        return new CloudinaryManager(cloudinaryUser());
	    }

}