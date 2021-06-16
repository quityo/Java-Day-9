package kodlamaio.hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageDto {
    @JsonIgnore
    private int id;
    private int cvId;

    @NotBlank
    private String language;

    @Min(value = 1)
    @Max(value = 5)
    private int level;
}