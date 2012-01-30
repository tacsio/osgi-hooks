package hook;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

	private BundleContext ctx;

	@Override
	public void start(BundleContext ctx) throws Exception {

		this.ctx = ctx;
		Map<String, String> properties = new HashMap<String, String>();
		// TODO: Add properties and register service

		startProxy(null, null, null);
	}

	@Override
	public void stop(BundleContext ctx) throws Exception {

	}

	void startProxy(ServiceReference ref, Bundle bundle, Object proxy) {
		Hide hide = new Hide(ctx, ref, bundle);
		try {
			hide.open();
			ctx.registerService((String[]) ref.getProperty("ObjectClass"),
					proxy, cloneProperties(ref));

		} catch (BundleException e) {
			e.printStackTrace();
		}
	}

	public Dictionary<String, Object> cloneProperties(ServiceReference ref) {

		Dictionary<String, Object> properties = new Hashtable<String, Object>();

		for (String key : ref.getPropertyKeys()) {
			properties.put(key, ref.getProperty(key));
		}

		return properties;
	}

}
