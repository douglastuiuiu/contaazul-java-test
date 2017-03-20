package br.com.douglastuiuiu.api.service;

import br.com.douglastuiuiu.api.enumeration.CommandType;
import br.com.douglastuiuiu.api.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author douglasg
 * @since 20/03/2017
 */
@Service
public class RobotControlService {

    private final Logger logger = LoggerFactory.getLogger(RobotControlService.class);

    private static Integer columns = 5;
    private static Integer lines = 5;

    public String move(CommandType commandType) throws ServiceException {
        try {
            return "";
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
