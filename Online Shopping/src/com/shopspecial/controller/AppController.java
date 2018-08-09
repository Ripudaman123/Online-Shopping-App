package com.shopspecial.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopspecial.pojo.Item;
import com.shopspecial.service.ItemService;
import com.shopspecial.service.ItemServiceImpl;

/**
 * Servlet implementation class AppController
 */
@WebServlet("*.app")
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ItemService service = new ItemServiceImpl();

	public AppController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		HttpSession session = request.getSession();
		System.out.println(action);
		double sum=0.0;
		switch (action) {
		case "/addToCart.app":

			int itemId = Integer.parseInt(request.getParameter("itemId"));
			Item item1 = null;
			Collection<Item> item = service.viewAllItems();
			for (Item items : item) {
				if (items.getId() == itemId) {
					item1 = items;
				}
			}
			service.addNewItem(item1);
			Collection<Item> item2=service.cartItems();
			session.setAttribute("count", item2);
			for(Item item8 :item2)
			{
				sum+=item8.getCost();
			}
			session.setAttribute("sum",sum);
			response.sendRedirect("homePage.app");
			break;
		case "/cart.app":
			item = service.cartItems();
			session.setAttribute("count", item);
			request.setAttribute("item", item);
			for(Item item8 :item)
			{
				sum+=item8.getCost();
			}
			session.setAttribute("sum",sum);
			RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
			dispatcher.forward(request, response);
			break;
		case "/homePage.app":
			item = service.viewAllItems();
			request.setAttribute("item", item);
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
			break;
		case "/delete.app":

			itemId = Integer.parseInt(request.getParameter("itemId"));
			item1 = null;
			item = service.cartItems();
			for (Item items : item) {
				if (items.getId() == itemId) {
					item1 = items;
				}
			}
			service.delete(item1);
			response.sendRedirect("cart.app");
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
