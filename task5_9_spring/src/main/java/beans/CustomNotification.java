package beans;

import org.springframework.stereotype.Service;

@Service("customNotification")
public class CustomNotification implements Notification {
    @Override
    public void getHelloNotification() {
        System.out.println("Hello");
    }
}
