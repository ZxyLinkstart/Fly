package servlet;

import dao.InfoDao;

import entity.Info;


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
@WebServlet("/AddInfoServlet")
public class AddInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private InfoDao infoDao = InfoDao.getInfoDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("sId");
        byte[] data0=id.getBytes("ISO-8859-1");
        id=new String(data0,"utf-8");

        String name = request.getParameter("sName");
        byte[] data=name.getBytes("ISO-8859-1");
        name=new String(data,"utf-8");

        String sex = request.getParameter("sSex");
        byte[] data1=sex.getBytes("ISO-8859-1");
        sex=new String(data1,"utf-8");

        String grade = request.getParameter("sGrade");
        PrintWriter out = response.getWriter();

        try {
            List<Info> infos = InfoDao.findAll();
            for (int i = 0 ;i<infos.size();i++){
                if (id.equals(infos.get(i).getId())){
                    out.print("false");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            infoDao.add(id,name,sex,grade);
            out.print("true");

        } catch (Exception e) {
            e.printStackTrace();
        }
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