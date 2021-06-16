package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertRequestDto {

	@NotNull
    private int cityId;

    @NotNull
    private int employerId;

    @NotNull
    private int jobPositionId;
    private int Id;

    @NotBlank
    @NotNull
    private String description;

    @NotNull
    private Date endDate;

    @NotNull
   @PositiveOrZero
    private int salaryMax;

    @NotNull
    @PositiveOrZero
    private int salaryMin;


    private boolean active;

    @NotNull
    private int workTimeId;
    @NotNull
    private int WorkingTypeId;
}
