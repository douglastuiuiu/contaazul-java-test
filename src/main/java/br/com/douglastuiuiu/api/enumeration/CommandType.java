package br.com.douglastuiuiu.api.enumeration;

/**
 * @author douglasg
 * @since 20/03/2017
 */
public enum CommandType {
    MOVE("M"), LEFT("L"), RIGHT("R");

    CommandType(String value) {
        this.value = value;
    }

    private final String value;

    public String getValue() {
        return value;
    }
}
