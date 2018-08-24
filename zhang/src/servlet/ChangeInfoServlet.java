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
@WebServlet("/ChangeInfoServlet")
public class ChangeInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private InfoDao infoDao = InfoDao.getInfoDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("sId");

        String name = request.getParameter("sName");
        byte[] data=name.getBytes("ISO-8859-1");
        name=new String(data,"utf-8");

        String sex = request.getParameter("sSex");
        byte[] data1=sex.getBytes("ISO-8859-1");
        sex=new String(data1,"utf-8");

        String grade = request.getParameter("sGrade");
        PrintWriter out = response.getWriter();


//        List<Info> infos = null;

        try {
            infoDao.change(id,name,sex,grade);
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