package hook;

import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private BundleContext ctx;
	
	@Override
	public void start(BundleContext ctx) throws Exception {
		
		this.ctx = ctx;
		Map<String, String> properties  = new HashMap<String, String>();
		//TODO: Add properties and register service
		
		
	}

	@Override
	public void stop(BundleContext ctx) throws Exception {
		
	}

}
