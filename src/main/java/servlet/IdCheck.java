package servlet;

import dao.MemberDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/IdCheck.do")
public class IdCheck extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        MemberDAO dao = new MemberDAO();
        String reqID = req.getParameter("id");

        if (reqID.equals((""))) {
            out.print("");
        } else {
            if (dao.idDupCheck(reqID) == 0) {
                out.print("아이디가 중복되었습니다.");
            } else {
                out.print("사용가능한 아이디입니다.");
            }
        }
    }
}
