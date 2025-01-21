package pageobjectpattern.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BirthDateDTO {

    private String day, month, year;


}
