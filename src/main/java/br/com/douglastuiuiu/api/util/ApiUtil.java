package br.com.douglastuiuiu.api.util;

import br.com.douglastuiuiu.api.validation.model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author douglasg
 * @since 20/03/2017
 */
public class ApiUtil {

    private ApiUtil() {
    }

    /**
     * Responta de erro padrão
     *
     * @param message
     * @param status
     * @return
     */
    public static ResponseEntity<Object> responseError(String message, HttpStatus status) {
        ErrorModel body = new ErrorModel(message);
        return new ResponseEntity<>(body, status);
    }

}
