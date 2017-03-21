package br.com.douglastuiuiu.api.resource;

import br.com.douglastuiuiu.api.exception.ServiceException;
import br.com.douglastuiuiu.api.service.RobotControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author douglasg
 * @since 20/03/2017
 */
@RestController
@RequestMapping(RobotControlResource.BASE_URI)
@CrossOrigin(origins = "*")
public class RobotControlResource {

    public static final String BASE_URI = "/rest/mars/";

    @Autowired
    private RobotControlService robotService;

    @RequestMapping(value = "*", method = RequestMethod.POST)
    public ResponseEntity<Object> moveRobotPOST(HttpServletRequest request) throws ServiceException {
        String finalPosition = robotService.move(request.getRequestURI().replace(BASE_URI, ""));
        return new ResponseEntity<>(finalPosition, HttpStatus.OK);
    }

    @RequestMapping(value = "*", method = RequestMethod.GET)
    public ResponseEntity<Object> moveRobotGET(HttpServletRequest request) throws ServiceException {
        String finalPosition = robotService.move(request.getRequestURI().replace(BASE_URI, ""));
        return new ResponseEntity<>(finalPosition, HttpStatus.OK);
    }

}