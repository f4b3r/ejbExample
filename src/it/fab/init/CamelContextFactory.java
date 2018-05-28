package it.fab.init;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.camel.util.jndi.JndiContext;

import it.fab.ejb.BillingBean;

public class CamelContextFactory {

	private static CamelContext context;

	private CamelContextFactory() {

	}

	public static synchronized CamelContext getInstance() {
		if (context != null)
			return context;
		
		SimpleRegistry registry = new SimpleRegistry(); 
		registry.put("BillingBean", new BillingBean()); 
		context = new DefaultCamelContext(registry); 
		try {
		JndiContext jndiContext = new JndiContext();
		

		jndiContext.bind("BillingBean", new BillingBean());
		context.addComponent("activemq", ActiveMQComponent.activeMQComponent("vm://localhost?broker.persistent=false"));
	
			context.addRoutes(new RouteBuilder() {
				@Override
				public void configure() throws Exception {
					from("activemq:queue:billing.queue").to("bean:BillingBean?method=bill");
				}
			});
		} catch (Exception e) {
			System.out.println(e);
		}
		return context;
	}
}
