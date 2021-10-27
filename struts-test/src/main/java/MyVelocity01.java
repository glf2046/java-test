import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.VelocityContext;
import java.util.Properties;

public class MyVelocity01 extends HttpServlet {
    private static final long serialVersionUID = -7279280346755614812L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Properties properties=new Properties();
        properties.setProperty("resource.loader", "class");
        properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        //properties.setProperty("input.encoding", "UTF-8");
        //properties.setProperty("output.encoding", "UTF-8");
        properties.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
        properties.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
        properties.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
        VelocityEngine velocityEngine = new VelocityEngine(properties);
        VelocityContext context=new VelocityContext();
        context.put("name", "test123  ");
        StringWriter sw = new StringWriter();
        velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);
        //velocityEngine.mergeTemplate("templates/test.vm", "utf-8", context, sw);      //这样就会出现两次
        out.println(sw.toString());
    }
}