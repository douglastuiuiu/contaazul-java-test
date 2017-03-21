package br.com.douglastuiuiu.api.util;

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
        return new ResponseEntity<>(message, status);
    }

}
