package br.com.douglastuiuiu.api.exception;

/**
 * @author douglasg
 * @since 20/03/2017
 */
public class ServiceException extends Exception {

    private static final long serialVersionUID = 7088817136879617688L;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
