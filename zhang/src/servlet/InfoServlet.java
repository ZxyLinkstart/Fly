package servlet;

import dao.WelcomeDao;
import entity.Info;
import entity.Welcome;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/InfoServlet")
public class InfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    private Welcome infoDao = WelcomeDao.getInfoDao();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("sname");
        String password = request.getParameter("spassword");
        String check = request.getParameter("chekBox");
        Boolean flag = false;

        if (name.equals("")||password.equals("")){
            request.getRequestDispatcher("jsp/welcome.jsp").forward(request, response);
        }
        try {
            List<Welcome> infos = WelcomeDao.findAll();
            for (int i = 0 ;i<infos.size();i++){
                if(name.equals(infos.get(i).getName())){
                    if (password.equals(infos.get(i).getPassword())){
                        flag = true;
                    }
                }
            }

            PrintWriter out = response.getWriter();
            if(flag){

                if (check != null && check.equals("1")) {
                    //新建cookie
                    Cookie cookie1 = new Cookie("coolusername", name);
                    Cookie cookie2 = new Cookie("coolpassword", password);
                    //设置cookie的有效期
                    cookie1.setMaxAge(60*100);
                    cookie2.setMaxAge(60*100);
                    //保存cookie到客户端
                    response.addCookie(cookie1);
                    response.addCookie(cookie2);
                    //请求转发
                    out.print("true");
                } else {
                    //表示不记录cookie
                    out.print("true");
                }
            }
            else{
                out.print("false");
            }
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