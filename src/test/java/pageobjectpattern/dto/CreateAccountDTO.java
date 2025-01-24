package pageobjectpattern.dto;

import lombok.Builder;
import lombok.Getter;
import java.time.LocalDate;

@Builder
@Getter
public class CreateAccountDTO {

    private String firstNameText;

    private String lastNameText;

    private String passwordText;

    private LocalDate birthDate;


    public static CreateAccountDTO getDefaultCreateAnAccountDTO() {
        return CreateAccountDTO.builder()
                .firstNameText("Gary")
                .lastNameText("Black")
                .passwordText("1234567")
                .birthDate(BirthDateDTO.getDefaultBirthdayDTO().getBirthdate())
                .build();
    }
}
