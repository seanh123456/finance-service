package io.wintry.finance;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class ApiController {

  @Autowired UserRepository repository;

  @GetMapping("/finance/")
  public Map<String, String> homepage() {
    Map<String, String> message = new HashMap<>();
    Users u = repository.findFirstByName("Louise Litt");
    message.put("message", "Hello from Finance!");
    message.put("income1", u.getSalary().toString());
    return message;
  }
}
