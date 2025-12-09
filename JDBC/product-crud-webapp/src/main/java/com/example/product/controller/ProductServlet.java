package com.example.product.controller;

import com.example.product.entity.Product;
import com.example.product.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private ProductService productService;

    @Override
    public void init() throws ServletException {
        super.init();
        productService = new ProductService();
    }

    // Handles GET requests (Read All and Read By ID)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list"; // Default action
        }

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertProduct(request, response);
                    break;
                case "delete":
                    deleteProduct(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateProduct(request, response);
                    break;
                case "view":
                    viewProduct(request, response);
                    break;
                default:
                    listProduct(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    // Handles POST requests (Create and Update)
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Since we are using a single servlet for all CRUD, we delegate to doGet to handle actions
        // In a real REST API, POST would be for Create, PUT for Update, DELETE for Delete.
        // For simplicity in this WebApp, we use a hidden 'action' parameter in forms.
        doGet(request, response);
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Product> listProduct = productService.getAllProducts();
        request.setAttribute("listProduct", listProduct);
        request.getRequestDispatcher("product-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("product-form.jsp").forward(request, response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        BigDecimal price = new BigDecimal(request.getParameter("price"));
        String description = request.getParameter("description");
        int stockQuantity = Integer.parseInt(request.getParameter("stockQuantity"));

        Product newProduct = new Product(0, name, price, description, stockQuantity);
        productService.createProduct(newProduct);
        response.sendRedirect("products");
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.deleteProduct(id);
        response.sendRedirect("products");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Optional<Product> existingProduct = productService.getProductById(id);
        if (existingProduct.isPresent()) {
            request.setAttribute("product", existingProduct.get());
            request.getRequestDispatcher("product-form.jsp").forward(request, response);
        } else {
            response.sendRedirect("products");
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        BigDecimal price = new BigDecimal(request.getParameter("price"));
        String description = request.getParameter("description");
        int stockQuantity = Integer.parseInt(request.getParameter("stockQuantity"));

        Product product = new Product(id, name, price, description, stockQuantity);
        productService.updateProduct(id, product);
        response.sendRedirect("products");
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Optional<Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            request.setAttribute("product", product.get());
            request.getRequestDispatcher("product-view.jsp").forward(request, response);
        } else {
            response.sendRedirect("products");
        }
    }
}
