package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest18988")
public class BenchmarkTest18988 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = doSomething(param);
		
		String cmd = org.owasp.webgoat.benchmark.helpers.Utils.getOSCommandString("echo") + bar;
        
		String[] argsEnv = { "Foo=bar" };
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd, argsEnv);
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a95104 = param; //assign
		StringBuilder b95104 = new StringBuilder(a95104);  // stick in stringbuilder
		b95104.append(" SafeStuff"); // append some safe content
		b95104.replace(b95104.length()-"Chars".length(),b95104.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map95104 = new java.util.HashMap<String,Object>();
		map95104.put("key95104", b95104.toString()); // put in a collection
		String c95104 = (String)map95104.get("key95104"); // get it back out
		String d95104 = c95104.substring(0,c95104.length()-1); // extract most of it
		String e95104 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d95104.getBytes() ) )); // B64 encode and decode it
		String f95104 = e95104.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g95104 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g95104); // reflection
	
		return bar;	
	}
}