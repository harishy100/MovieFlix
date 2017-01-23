package sample.project1;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import sample.project1.APIConfig;
import sample.project1.JPAConfig;

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { APIConfig.class,JPAConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/api/*" };
	}
}
