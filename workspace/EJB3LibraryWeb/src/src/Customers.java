/*
 *+------------------------------------------------------------------------+
 *| Licensed Materials - Property of IBM                                   |
 *|                                                                        |
 *| EJB 3.0 Online Library                                                 |
 *|                                                                        |
 *| Copyright IBM Corp. 2008.  All Rights Reserved.                  	   |
 *|                                                                        |
 *| US Government Users Restricted Rights - Use, duplication or disclosure |
 *| restricted by GSA ADP Schedule Contract with IBM Corp.                 |
 *|                                                                        |
 *| Use restricted, please refer to the "Restricted Materials" terms and   |
 *| conditions in the IBM International Program License Agreement.         |
 *+------------------------------------------------------------------------+
 */

package src;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sessions.admin.AdminManagerLocal;
import entities.Customer;

/**
 *
 * @author mbadr
 * @version
 */
public class Customers extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
    private AdminManagerLocal libraryManagerBean;
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Authors</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>List of Customers</h1>");
        
        out.println("<Table border=1>");
        out.println("<TR><TD><B>Customer ID</B></TD> <TD><B>Customer First Name</B></TD> <TD><B>customer Last Name</B></TD>");
        out.println("<TD><B>Address</B></TD> <TD><B>Phone</B></TD> <TD><B>email</B></TD></TR>");
        List<Customer> list = libraryManagerBean.getCustomers();
        for (Customer item:list) {
            out.println("<TR><TD>" + item.getCustomerId() + "</TD> <TD>" +item.getCustomerFirstName() + "</TD> <TD>" + item.getCustomerLastName() + "</TD>");
            out.println("<TD>" + item.getCustomerAddress() + "</TD> <TD>" +item.getCustomerPhoneNumber() + "</TD> <TD>" + item.getCustomerEmail() + "</TD></TR>");
        }
        out.println("</Table>");
        
        out.println("<a href=\"AddNewCustomer\" >Create New Customer</a>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
