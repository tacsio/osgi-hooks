package hook;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.hooks.service.EventHook;
import org.osgi.framework.hooks.service.FindHook;

public class Hide implements EventHook, FindHook {

	final Bundle bundle;
	final ServiceReference reference;
	final BundleContext ctx;
	ServiceRegistration reg;

	public Hide(BundleContext ctx, ServiceReference reference, Bundle bundle) {
		this.ctx = ctx;
		this.reference = reference;
		this.bundle = bundle;
	}

	void open() throws BundleException {
		boolean active = (bundle.getState() == Bundle.ACTIVE);
		if (active) {
			bundle.stop(Bundle.STOP_TRANSIENT);
		}
		reg = ctx.registerService(new String[] { FindHook.class.getName(),
				EventHook.class.getName() }, this, null);

		if (active) {
			bundle.start(Bundle.START_TRANSIENT);
		}
	}

	public void close() {
		reg.unregister();
	}

	@Override
	public void find(BundleContext ctx, String name, String filter,
			boolean allServices, Collection refs) {
		System.out.println("Find Hook");
		
		if (ctx.getBundle() == this.bundle) {
			refs.remove(this.reference);
		}
	}

	@Override
	public void event(ServiceEvent event, Collection bundles) {
		System.out.println("Event Hook");
		
		if (event.getServiceReference().equals(this.reference)) {
			bundles.remove(this.bundle);
		}
	}
	
	

}
