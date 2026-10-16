package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class SpringIntroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIntroApplication.class, args);

        MessageService service = new MessageService();
        service.showMessage();
    }
}

@Service
class MessageService {

    public void showMessage() {
        System.out.println("Hello, Spring Boot!");
    }
}