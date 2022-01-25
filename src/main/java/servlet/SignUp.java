package servlet;

import dao.MemberDAO;
import dto.MemberDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/signUp.do")
public class SignUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();

        MemberDAO dao = new MemberDAO();
        MemberDTO member = new MemberDTO(req.getParameter("id"), req.getParameter("pw"), req.getParameter("name"));

        if (dao.signUp(member)) {
            out.println("<script>alert('등록에 성공했습니다.'); window.location.href='index.jsp'</script>");
        } else {
            out.println("<script>alert('등록에 실패했습니다.'); window.location.href='index.jsp'</script>");
        }
    }
}
