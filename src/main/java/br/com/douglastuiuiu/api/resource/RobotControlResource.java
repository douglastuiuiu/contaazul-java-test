package br.com.douglastuiuiu.api.resource;

import br.com.douglastuiuiu.api.enumeration.CommandType;
import br.com.douglastuiuiu.api.exception.ServiceException;
import br.com.douglastuiuiu.api.service.RobotControlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author douglasg
 * @since 20/03/2017
 */
@RestController
@RequestMapping("/api/v1/contaazul-java-test")
@CrossOrigin(origins = "*")
public class RobotControlResource {

    private static final Logger logger = LoggerFactory.getLogger(RobotControlResource.class);

    @Autowired
    private RobotControlService robotService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> moveRobot(@RequestBody CommandType commandType) throws ServiceException {
        String finalPosition = robotService.move(commandType);
        return new ResponseEntity<>(finalPosition, HttpStatus.OK);
    }

}