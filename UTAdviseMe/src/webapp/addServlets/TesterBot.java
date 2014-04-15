package webapp.addServlets;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.servletunit.InvocationContext;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;

public class TesterBot {
	ServletRunner sr;
	ServletUnitClient sc;
	WebRequest request;
	InvocationContext ic;
	addCourseServlet ss;

	@Before
	public void setUp() {
		try {
			ServletRunner sr = new ServletRunner();
			System.out.println("1");

			ServletUnitClient sc = sr.newClient();

			System.out.println("22");
			WebRequest request = new PostMethodWebRequest("http://localhost:8888/addcourse");
			System.out.println(request.toString());
			System.out.println("333");
			InvocationContext ic = sc.newInvocation(request);
			System.out.println(ic.toString());
			System.out.println("4444");
			WebResponse response = ic.getServletResponse();
			System.out.println(response.toString());
			System.out.println("55555");
			System.out.println(ic.getServlet().toString());
			addCourseServlet ss = (addCourseServlet) ic.getServlet();
			System.out.println("fbiddd");
		} catch (Exception e) {
			System.out.println("DAMMMMMEEKLJDFKLJDS:");
		}
	}

	@Test
	public void test1() {
		assertNull("A session already exists", ic.getRequest()
				.getSession(false));
	}

	@Test
	public void test2() {
		try {
			ic.getRequest().setAttribute("coursename", "EE 302");
			ss.doPost(ic.getRequest(), ic.getResponse());
		} catch (IOException e) {
		}
	}

}
