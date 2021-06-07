package kodlamaio.hrms;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.helpers.CloudinaryManager;
import kodlamaio.hrms.core.utilities.helpers.abstracts.FileHelper;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HrmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmsApplication.class, args);
	}

	 @Bean
	    public ModelMapper modelMapper() {
	        ModelMapper modelMapper = new ModelMapper();
	        modelMapper.getConfiguration()
	            .setMatchingStrategy(MatchingStrategies.STRICT);
	        return modelMapper;
	    }
	    
		@Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.basePackage("kodlamaio.hrms"))                                     
	          .build();                                           
	    }
		
	    @Bean
	    public FileHelper helper(){
	        return new CloudinaryManager(cloudinaryManager());
	    }
	    
	    @Bean
	    public Cloudinary cloudinaryManager(){
	        return new Cloudinary(ObjectUtils.asMap(
	                "cloud_name", "fufufu",
	                "api_key", "199629458285134",
	                "api_secret", "PBDuduN6yGUiL3Y8Qdz4cX2oNt8"));
	    }

}