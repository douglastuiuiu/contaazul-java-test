package br.com.douglastuiuiu.api.service;

import br.com.douglastuiuiu.api.enumeration.CommandType;
import br.com.douglastuiuiu.api.enumeration.Direction;
import br.com.douglastuiuiu.api.exception.ServiceException;
import br.com.douglastuiuiu.api.util.ApplicationPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author douglasg
 * @since 20/03/2017
 */
@Service
public class RobotControlService {

    @Autowired
    private ApplicationPath applicationPath;

    private static final String ERROR_COMMAND_MOVE_OUT_OF_RANGE = "error.command.move.out_of_range";

    private Integer positionX = 0;
    private Integer positionY = 0;
    private Direction direction = Direction.NORTH;

    public String move(String uri) throws ServiceException {
        try {
            List<CommandType> commands = parseCommands(uri);
            processCommands(commands);
            String finalPosition = buildResultMessage();
            reset();
            return finalPosition;
        } catch (Exception e) {
            reset();
            throw new ServiceException(e.getMessage(), e);
        }
    }

    private String buildResultMessage() {
        StringBuilder finalPosition = new StringBuilder();
        finalPosition.append("(");
        finalPosition.append(positionX);
        finalPosition.append(", ");
        finalPosition.append(positionY);
        finalPosition.append(", ");
        finalPosition.append(direction.getValue());
        finalPosition.append(")");
        return finalPosition.toString();
    }

    private void reset() {
        positionX = 0;
        positionY = 0;
        direction = Direction.NORTH;
    }

    private void processCommands(List<CommandType> commands) throws ServiceException {
        for (CommandType command : commands) {
            if (command.compareTo(CommandType.MOVE) == 0) {
                if (direction.compareTo(Direction.NORTH) == 0) {
                    if (positionY < applicationPath.getMaxlines()) {
                        positionY++;
                    } else {
                        throw new ServiceException(ERROR_COMMAND_MOVE_OUT_OF_RANGE);
                    }
                } else if (direction.compareTo(Direction.EAST) == 0) {
                    if (positionX < applicationPath.getMaxColumns()) {
                        positionX++;
                    } else {
                        throw new ServiceException(ERROR_COMMAND_MOVE_OUT_OF_RANGE);
                    }
                } else if (direction.compareTo(Direction.SOUTH) == 0) {
                    if (positionY > applicationPath.getMinlines()) {
                        positionY--;
                    } else {
                        throw new ServiceException(ERROR_COMMAND_MOVE_OUT_OF_RANGE);
                    }
                } else if (direction.compareTo(Direction.WEST) == 0) {
                    if (positionX > applicationPath.getMinColumns()) {
                        positionX--;
                    } else {
                        throw new ServiceException(ERROR_COMMAND_MOVE_OUT_OF_RANGE);
                    }
                }
            } else if (command.compareTo(CommandType.LEFT) == 0) {
                if (direction.compareTo(Direction.NORTH) == 0) {
                    direction = Direction.WEST;
                } else if (direction.compareTo(Direction.WEST) == 0) {
                    direction = Direction.SOUTH;
                } else if (direction.compareTo(Direction.SOUTH) == 0) {
                    direction = Direction.EAST;
                } else if (direction.compareTo(Direction.EAST) == 0) {
                    direction = Direction.NORTH;
                }
            } else if (command.compareTo(CommandType.RIGHT) == 0) {
                if (direction.compareTo(Direction.NORTH) == 0) {
                    direction = Direction.EAST;
                } else if (direction.compareTo(Direction.EAST) == 0) {
                    direction = Direction.SOUTH;
                } else if (direction.compareTo(Direction.SOUTH) == 0) {
                    direction = Direction.WEST;
                } else if (direction.compareTo(Direction.WEST) == 0) {
                    direction = Direction.NORTH;
                }
            }
        }
    }

    private List<CommandType> parseCommands(String uri) throws ServiceException {
        List<CommandType> commands = new ArrayList<>();
        for (int i = 0; i < uri.length(); i++) {
            if (CommandType.MOVE.getValue().equalsIgnoreCase(new Character(uri.charAt(i)).toString())) {
                commands.add(CommandType.MOVE);
            } else if (CommandType.LEFT.getValue().equalsIgnoreCase(new Character(uri.charAt(i)).toString())) {
                commands.add(CommandType.LEFT);
            } else if (CommandType.RIGHT.getValue().equalsIgnoreCase(new Character(uri.charAt(i)).toString())) {
                commands.add(CommandType.RIGHT);
            } else {
                throw new ServiceException("error.command.parser");
            }
        }
        return commands;
    }
}
