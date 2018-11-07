package com;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import javax.xml.ws.Endpoint;

public class Main {
        public static void main(String []args)
        {
            JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
            factory.setServiceClass(EmailServiceImp.class);
            factory.setAddress("http://localhost:7759/EmailService");

            Server server = factory.create();
            server.start();
            //Endpoint.publish("http://localhost:7759/EmailService", new EmailServiceImp());

            /*EmailServiceImp emailServiceImp=new EmailServiceImp();
            String address="http://localhost:8080/EmailService";
            javax.xml.ws.Endpoint.publish(address,emailServiceImp);*/
        }
}
