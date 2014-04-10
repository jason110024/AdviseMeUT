package webapp.addServlets;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.datastoreObjects.Course;

import com.googlecode.objectify.ObjectifyService;

@SuppressWarnings("serial")
public class addCourseServlet extends HttpServlet{
	static{ObjectifyService.register(Course.class);}
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//String schoolName = req.getParameter("schoolname");
		//String collegeName = req.getParameter("collegename");
		//String departmentName = req.getParameter("departmentname");
		String courseName = req.getParameter("coursename");
		String courseTitle = req.getParameter("coursetitle");
		String courseDescription = req.getParameter("coursedescription");
		String upperDivision = req.getParameter("division");
		String professorList = req.getParameter("professorList");
		String semesterTaught = req.getParameter("semestersTaught");
		String prereqs = req.getParameter("prereqs");
		
		try{
		/*if(schoolName==null){
			//Should be impossible?
		}else if(schoolName.isEmpty()){
			//Should be impossible?
		}else if(collegeName==null){
			//Should be impossible?
		}else if(collegeName.isEmpty()){
			//Should be impossible?
		}else if(departmentName==null){
			//Should be impossible?
		}else if(departmentName.isEmpty()){
			//Should be impossible?
		}else if(courseName==null){
			//Should be impossible?
		}else if(courseName.isEmpty()){
			//Should be impossible?
		}else{//TODO: Need to create check to make sure not adding duplicate courses within departments
			*/
		if(courseName==null||courseName.isEmpty()){
			throw new Exception("Must provide a valid Course Name!");
		}
		if(courseTitle==null||courseTitle.isEmpty()){
			throw new Exception("Must provide a valid Course Title!");
		}
		if(courseDescription==null||courseDescription.isEmpty()){
			throw new Exception("Must provide a valid Course Description!");
		}
		if(upperDivision==null||upperDivision.isEmpty()){
			throw new Exception("Must select Upper/Lower Division!");
		}
		if(professorList==null||professorList.isEmpty()){
			throw new Exception("Must provide professors!");
		}
		if(semesterTaught==null||semesterTaught.isEmpty()){
			throw new Exception("Must provide semesters taught!");
		}
		if(prereqs==null||prereqs.isEmpty()){
			throw new Exception("Must provide textbooks!");
		}
		boolean upper;
			if(upperDivision.equals("upper")){
				upper = true;
				
			}else{
				upper=false;
			}
			Course course = new Course(courseName,courseTitle,courseDescription,upper);
			//TODO: Need to parse the list correctly and add the professors correctly
			course.getProfessorList().add(professorList);
			course.getSemesterTaught().add(semesterTaught);
			course.getPrereq().add(prereqs);
			
		
			//for(School school: schoolList){
			//	if(school.getName().equals(schoolName)){
			//		for(College colleges: school.getCollegeList()){
			//			if(colleges.getName().equals(collegeName)){
			//				for(Department departments: colleges.getDepartmentList()){
			//					if(departments.getName().equals(departmentName)){
			//						departments.addCourse(course);
			//						ofy().save().entity(school).now();
			//						resp.sendRedirect("/home.jsp");
			//					}
			//				}
			//			}
			//		}
			//	}
			//}
			ofy().save().entity(course).now();
			
			resp.sendRedirect("/home.jsp");
		//}
		} catch (Exception e){
			String logMsg = "Exception in processing request: " + e.getMessage();
			throw new IOException(logMsg);
		}
	}
}
