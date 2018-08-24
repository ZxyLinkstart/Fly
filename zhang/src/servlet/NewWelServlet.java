package servlet;

import dao.WelcomeDao;
import entity.Welcome;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/NewWelServlet")
public class NewWelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Welcome infoDao = WelcomeDao.getInfoDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewWelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        byte[] data1=name.getBytes("ISO-8859-1");
        name=new String(data1,"utf-8");

        String password = request.getParameter("spassword");
        byte[] data0=password.getBytes("ISO-8859-1");
        password=new String(data0,"utf-8");
        PrintWriter out = response.getWriter();
        try {
            List<Welcome> infos = WelcomeDao.findAll();
            for (int i = 0 ;i<infos.size();i++){
                if (name.equals(infos.get(i).getName())){
                    out.print("false");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            WelcomeDao.newOne(name,password);
            out.print("true");
//            response.sendRedirect("../welcome.jsp");
//            request.getRequestDispatcher("formation.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }


//        List<Info> infos = null;
//        try {
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        response.sendRedirect("../Info.do");
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