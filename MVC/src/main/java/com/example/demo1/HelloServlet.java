package com.example.demo1;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
// 属性名	类型	描述
// name	String	指定Servlet 的 name 属性，等价于 <servlet-name>。如果没有显式指定，则该 Servlet 的取值即为类的全限定名。
// value	String[]	该属性等价于 urlPatterns 属性。两个属性不能同时使用。
// urlPatterns	String[]	指定一组 Servlet 的 URL 匹配模式。等价于<url-pattern>标签。
// loadOnStartup	int	指定 Servlet 的加载顺序，等价于 <load-on-startup>标签。
// initParams	WebInitParam[]	指定一组 Servlet 初始化参数，等价于<init-param>标签。
// asyncSupported	boolean	声明 Servlet 是否支持异步操作模式，等价于<async-supported> 标签。
// description	String	该 Servlet 的描述信息，等价于 <description>标签。
// displayName	String	该 Servlet 的显示名，通常配合工具使用，等价于 <display-name>标签。
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}