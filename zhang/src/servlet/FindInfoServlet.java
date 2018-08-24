package servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InfoDao;
import entity.Info;

/**
 * Servlet implementation class InfoServlet
 * @author HP
 */
@WebServlet("/FindInfoServlet")
public class FindInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private InfoDao infoDao = InfoDao.getInfoDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        List<Info> infos = null;
        try {
            infos = infoDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("infos", infos);
//		不携带数据的页面跳转，在这里不可用
//		response.sendRedirect("jsp/info.jsp");
        request.getRequestDispatcher("jsp/info.jsp").forward(request, response);



    }

}
