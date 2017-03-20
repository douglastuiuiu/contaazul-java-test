package br.com.douglastuiuiu.api.resource.handler;

import br.com.douglastuiuiu.api.exception.ServiceException;
import br.com.douglastuiuiu.api.util.ApiUtil;
import br.com.douglastuiuiu.api.util.MessageLocale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author douglasg
 * @since 20/03/2017
 */
@ControllerAdvice(annotations = RestController.class)
public class ApiValidatorExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(ApiValidatorExceptionHandler.class);

    @Autowired
    private MessageLocale messageLocale;

    /**
     * Erros relacionados a regras de negócio
     *
     * @param error
     * @return
     */
    @ExceptionHandler(value = ServiceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<Object> handleServiceException(ServiceException error) {
        logger.error("ServiceException: " + error, error);
        return ApiUtil.responseError(error.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Pega Qualquer outro erro não tratado
     *
     * @param error
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<Object> handleException(Exception error) {
        logger.error("Erro não tratado: " + error, error);
        return ApiUtil.responseError(messageLocale.getMessage("error.generic_error"), HttpStatus.BAD_REQUEST);
    }
}
