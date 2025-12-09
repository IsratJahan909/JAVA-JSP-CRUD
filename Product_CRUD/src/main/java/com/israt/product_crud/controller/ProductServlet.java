package com.israt.product_crud.controller;

import com.israt.product_crud.entity.Product;
import com.israt.product_crud.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private ProductService service;

    @Override
    public void init() throws ServletException {
        service = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "add":
                showAddForm(req, resp);
                break;

            case "edit":
                showEditForm(req, resp);
                break;

            case "delete":
                deleteProduct(req, resp);
                break;

            default:
                listProducts(req, resp);
                break;
        }
    }

    private void listProducts(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Product> products = service.getAllProducts();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/views/list.jsp").forward(req, resp);
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("products", new Product()); // empty form
        req.getRequestDispatcher("/views/add.jsp").forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product existingProduct = service.getProductById(id);
        req.setAttribute("product", existingProduct);
        req.getRequestDispatcher("/views/edit.jsp").forward(req, resp);
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        service.deleteProduct(id);
        resp.sendRedirect(req.getContextPath() + "/products");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idParam = req.getParameter("id");
        String name = req.getParameter("name");
        BigDecimal price = new BigDecimal(req.getParameter("price"));
        String description = req.getParameter("description");
        int stockQuantity = Integer.parseInt(req.getParameter("stockQuantity"));

        Product product = new Product(name, price, description, stockQuantity);

        if (idParam == null || idParam.isEmpty()) {
            // add new product
           
            service.addProduct(product);
        } else {
            // update existing
            product.setId(Integer.parseInt(idParam));
            
            service.updateProduct(product);
        }

        resp.sendRedirect(req.getContextPath() + "/products");
    }
}
