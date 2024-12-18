package com.sallyf.sallyf;

import com.sallyf.sallyf.AccessDecisionManager.AccessDecisionManager;
import com.sallyf.sallyf.Authentication.AuthenticationManager;
import com.sallyf.sallyf.Container.Container;
import com.sallyf.sallyf.Container.ServiceDefinition;
import com.sallyf.sallyf.EventDispatcher.EventDispatcher;
import com.sallyf.sallyf.Exception.FrameworkException;
import com.sallyf.sallyf.ExpressionLanguage.ExpressionLanguage;
import com.sallyf.sallyf.FlashManager.FlashManager;
import com.sallyf.sallyf.FreeMarker.FreeMarker;
import com.sallyf.sallyf.JTwig.JTwig;
import com.sallyf.sallyf.Router.Route;
import com.sallyf.sallyf.Router.Router;
import com.sallyf.sallyf.Router.URLGenerator;
import com.sallyf.sallyf.Server.FrameworkServer;

import java.util.HashMap;

public class Kernel
{


    private Container container;

    public Kernel(Container container)
    {
        this.container = container;

        container.addAll(getDefaultServices());
    }

    public static Kernel newInstance()
    {
        return new Kernel(new Container());
    }

    private ServiceDefinition<?>[] getDefaultServices()
    {
        return new ServiceDefinition[]{
                new ServiceDefinition<>(EventDispatcher.class),
                new ServiceDefinition<>(FrameworkServer.class),
                new ServiceDefinition<>(Router.class),
                new ServiceDefinition<>(URLGenerator.class),
                new ServiceDefinition<>(FlashManager.class),
                new ServiceDefinition<>(AuthenticationManager.class),
                new ServiceDefinition<>(ExpressionLanguage.class),
                new ServiceDefinition<>(AccessDecisionManager.class),
                new ServiceDefinition<>(FreeMarker.class),
                new ServiceDefinition<>(JTwig.class),
        };
    }

    public Container getContainer()
    {
        return container;
    }

    public void boot()
    {
        container.instantiate();

        EventDispatcher eventDispatcher = container.get(EventDispatcher.class);

        eventDispatcher.dispatch(KernelEvents.BOOTED);

        eventDispatcher.register(KernelEvents.STARTED, (eventType) -> {
            FrameworkServer server = container.get(FrameworkServer.class);
            Router router = container.get(Router.class);

            HashMap<String, Route> routes = router.getRoutes();

            System.out.println(routes.size() + " routes registered:");
            for (Route route : routes.values()) {
                System.out.println(route.getName() + " -> " + route.toString());
            }
            System.out.println();

            System.out.println("Listening on " + server.getRootURL());
            System.out.println();
        });
    }

    public void start()
    {
        EventDispatcher eventDispatcher = container.get(EventDispatcher.class);

        eventDispatcher.dispatch(KernelEvents.START);

        FrameworkServer server = this.container.get(FrameworkServer.class);

        try {
            server.start();
            //server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        eventDispatcher.dispatch(KernelEvents.STARTED);
    }

    public void stop()
    {
        try {
            FrameworkServer server = container.get(FrameworkServer.class);

            if (null != server) {
                try {
                    server.stop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (FrameworkException ignored) {
        }
    }
}
