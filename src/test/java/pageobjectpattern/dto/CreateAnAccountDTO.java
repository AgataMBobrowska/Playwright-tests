package pageobjectpattern.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateAnAccountDTO {

    private String firstNameText;

    private String lastNameText;

    private String passwordText;


    public static CreateAnAccountDTO getDefaultCreateAnAccountDTO() {
        return CreateAnAccountDTO.builder()
                .firstNameText("Gary")
                .lastNameText("Black")
                .passwordText("1234567")
                .build();
    }
}
