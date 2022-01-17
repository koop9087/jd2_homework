package beans;

import org.springframework.stereotype.Service;

@Service
public class CustomNotification implements Notification {
    @Override
    public void getHelloNotification() {
        System.out.println("Hello");
    }
}
