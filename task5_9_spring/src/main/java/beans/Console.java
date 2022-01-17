package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Console {
    @Autowired
    @Qualifier("customErrorNotification")
    private Notification notification;

    public Notification getNotification() {
        return notification;
    }
}
