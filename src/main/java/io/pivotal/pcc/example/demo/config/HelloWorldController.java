package io.pivotal.pcc.example.demo.config;

import io.pivotal.pcc.example.demo.service.HelloWorldService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  private static Logger logger = LogManager.getLogger(HelloWorldController.class);

  private final HelloWorldService helloWorldService;

  @Autowired
  public HelloWorldController(
      HelloWorldService helloWorldService) {
    this.helloWorldService = helloWorldService;
  }

  @RequestMapping("/hello")
  public String sayHello(){
    logger.info("**Received request**");
    return "Key: HelloWorld cached with value: " + helloWorldService.sayHelloWorld("HelloWorld");
  }

  @RequestMapping("/")
  public String ping(){
    logger.info("**Received request**");

    return "<h1>Pong<h1>";
  }

}
