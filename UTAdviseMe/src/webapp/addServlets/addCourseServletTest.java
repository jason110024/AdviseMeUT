package webapp.addServlets;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;

public class addCourseServletTest{
	private final Mockery context = new Mockery(){
		{
		setImposteriser(ClassImposteriser.INSTANCE);
		}
	};
	@Test
	public void test1() throws IOException, ServletException {
		final HttpServletRequest req= context.mock(HttpServletRequest.class);
		final HttpServletResponse resp= context.mock(HttpServletResponse.class);

		context.checking(new Expectations(){
			{
				oneOf(req); with(IOException.class);
			}
		});
		new addCourseServlet().doPost(req, resp);
			context.assertIsSatisfied();
	}
	
}
