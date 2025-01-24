package pageobjectpattern.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Builder
@Getter
public class BirthDateDTO {

    private LocalDate birthdate;

    public static BirthDateDTO getDefaultBirthdayDTO() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return BirthDateDTO.builder()
                .birthdate(LocalDate.parse("09-12-2020", df))
                .build();
    }

}
