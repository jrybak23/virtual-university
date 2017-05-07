package ua.km.khnu.virtual.university.error;

import org.springframework.http.HttpStatus;

/**
 * @author Igor Rybak
 */
public class NoAccountWithSuchDocumentNumber extends CustomException {
    @Override
    public int getCode() {
        return 1;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }

    @Override
    public String getDescription() {
        return "No student with such document number.";
    }
}
