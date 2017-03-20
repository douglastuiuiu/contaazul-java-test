package br.com.douglastuiuiu.api.validation.model;

/**
 * erro genérico padrão
 *
 * @author douglasg
 * @since 20/03/2017
 */
public class ErrorModel {

    private Object message;

    public ErrorModel(Object message) {
        this.message = message;
    }

}
