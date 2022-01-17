package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Console {
    @Autowired
    private Notification notification;

    public Notification getNotification() {
        return notification;
    }
}
