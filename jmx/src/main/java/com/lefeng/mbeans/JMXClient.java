package com.lefeng.mbeans;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;

public class JMXClient {
    public static final String HOST = "localhost";
    public static final String PORT = "1234";

    //-Dcom.sun.management.jmxremote.port=8008 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false
    public static void main(String[] args) throws IOException, MalformedObjectNameException {
        JMXServiceURL url =
                new JMXServiceURL("service:jmx:rmi:///jndi/rmi://" + HOST + ":" + PORT + "/jmxrmi");

        JMXConnector jmxConnector = JMXConnectorFactory.connect(url);
        MBeanServerConnection mbeanServerConnection = jmxConnector.getMBeanServerConnection();
        //ObjectName should be same as your MBean name
        ObjectName mbeanName = new ObjectName("com.lefeng.mbeans:type=SystemConfig");

        //Get MBean proxy instance that will be used to make calls to registered MBean
        SystemConfigMBean mbeanProxy = MBeanServerInvocationHandler.newProxyInstance(
                        mbeanServerConnection, mbeanName, SystemConfigMBean.class, true);

        //let's make some calls to mbean through proxy and see the results.
        System.out.println("Current SystemConfig::" + mbeanProxy.doConfig());

        mbeanProxy.setSchemaName("NewSchema");
        mbeanProxy.setThreadCount(5);

        System.out.println("New SystemConfig::" + mbeanProxy.doConfig());

        //let's terminate the mbean by making thread count as 0
        mbeanProxy.setThreadCount(0);

        //close the connection
        jmxConnector.close();
    }
}
