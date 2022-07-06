package ir.mapsa.student;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class StudentDTO {
    @ApiModelProperty(required = true, hidden = false)
    private String name;
    @ApiModelProperty(required = true, hidden = false)
    private String family;
    @ApiModelProperty(required = true, hidden = false)
    private String nationalCode;
    @ApiModelProperty(required = true, hidden = false)
    private String picture;
    @ApiModelProperty(required = true, hidden = false)
    private Date birthDate;
    @ApiModelProperty(required = false)
    private String sample1;
    @ApiModelProperty(required = false)
    private String sample2;
}
