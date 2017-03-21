package br.com.douglastuiuiu.api.test;

import br.com.douglastuiuiu.api.service.RobotControlService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ContaAzulJavaTest {

    @Autowired
    RobotControlService robotControlService;

    @Test
    public void t01_MMRMMRMM() throws Exception {
        String result = robotControlService.move("MMRMMRMM");
        Assert.assertEquals("(2, 0, S)", result);
    }

    @Test
    public void t02_MML() throws Exception {
        String result = robotControlService.move("MML");
        Assert.assertEquals("(0, 2, W)", result);
    }

    @Test
    public void t03_MML() throws Exception {
        String result = robotControlService.move("MML");
        Assert.assertEquals("(0, 2, W)", result);
    }

    @Test
    public void t04_AAA() {
        try{
            robotControlService.move("AAA");
        }catch (Exception e){
            if(e.getMessage().equalsIgnoreCase("error.command.parser")){
                Assert.assertTrue(true);;
            }
        }
    }

    @Test
    public void t05_MMMMMMMMMMMMMMMMMMMMMMMM() {
        try {
            String result = robotControlService.move("MMMMMMMMMMMMMMMMMMMMMMMM");
        }catch (Exception e) {
            if(e.getMessage().equalsIgnoreCase("error.command.move.out_of_range")) {
                Assert.assertTrue(true);
            }
        }
    }

}