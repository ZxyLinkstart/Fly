package servlet;

import dao.InfoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/MoveInfoServlet")
public class MoveInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private InfoDao infoDao = InfoDao.getInfoDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("ID");
        byte[] data0=id.getBytes("ISO-8859-1");
        id=new String(data0,"utf-8");
        PrintWriter out = response.getWriter();

        try {
            infoDao.move(id);
            out.print("true");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doGet(request, response);
    }

}