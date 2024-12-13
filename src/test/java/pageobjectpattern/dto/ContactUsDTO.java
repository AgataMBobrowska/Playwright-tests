package pageobjectpattern.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ContactUsDTO {

    private String subjectHeading;

    private String emailAddress;

    private String orderReference;

    private String fileToUpload;

    private String message;


    public static ContactUsDTO getDefaultContactUsDTO() {
        return ContactUsDTO.builder()
                .subjectHeading("Webmaster")
                .emailAddress("demo@demo.com")
                .orderReference("12345")
                .fileToUpload("uploads/upload_text.txt")
                .message("Sample message")
                .build();
    }
}
