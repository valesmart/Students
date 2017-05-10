
package listener;

import org.apache.log4j.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;



import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;


/**
 * Created by Валера on 07.04.2017.
 */

@WebListener
public class ListenerSession implements HttpSessionListener {

    private static final Logger LOGGER = Logger.getLogger(ListenerSession.class);

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        LOGGER.info("star session" + httpSessionEvent.getSession().getId());
        System.out.println();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        LOGGER.info("stop session" + httpSessionEvent.getSession().getId());
    }
}
