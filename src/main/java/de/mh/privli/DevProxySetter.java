package de.mh.privli;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevProxySetter {

    @PostConstruct
    public void init() {
        ProxySelector.setDefault(new ProxySelector() {
            @Override
            public List<Proxy> select(URI uri) {
                return Collections.singletonList(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 3128)));
            }

            @Override
            public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "could not connect via proxy", ioe);
            }
        });
    }
}
