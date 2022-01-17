package beans;

import org.springframework.stereotype.Service;

@Service("customErrorNotification")
public class CustomErrorNotification implements Notification {
    @Override
    public void getHelloNotification() {
        System.out.println("ERROR !!!!");
    }
}
