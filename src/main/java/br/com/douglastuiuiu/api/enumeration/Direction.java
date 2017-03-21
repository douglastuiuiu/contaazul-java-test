package br.com.douglastuiuiu.api.enumeration;

/**
 * @author douglasg
 * @since 20/03/2017
 */
public enum Direction {
    NORTH("N"), SOUTH("S"), EAST("E"), WEST("W");

    Direction(String value) {
        this.value = value;
    }

    private final String value;

    public String getValue() {
        return value;
    }
}
