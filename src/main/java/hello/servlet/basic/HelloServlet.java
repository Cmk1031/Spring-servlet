package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name="helloServlet", urlPatterns = "/hello")
// name: 서블릿 이름, urlPatterns: URL 매핑
public class HelloServlet extends HttpServlet {
    @Override //HTTP 요청을 통해 매핑된 URL이 호출되면 서블릿 컨테이너는 service 메서드를 실행한다.
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8"); // ContentType 과 CharEncoding 정보는 헤더 정보에 들어간다!
        response.getWriter().write("hello " + username); // -> Http 메시지 바디에 데이터가 들어간다!

    }
}
