package pageobjectpattern.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateAnAccountDTO {

    private String firstName;

    private String lastName;

    private String password;

    public static CreateAnAccountDTO getDefaultCreateAnAccountDTO() {
        return CreateAnAccountDTO.builder()
                .firstName("Mary")
                .lastName("Green")
                .password("1234567")
                .build();
    }


}
