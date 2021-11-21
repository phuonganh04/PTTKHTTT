package dao.customerdao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import model.customer.Account;
import model.customer.Address;
import model.customer.Customer;
import model.customer.FullName;
import model.order.Order;

public class CustomerDAOImpl extends DAO implements CustomerDAO {

    public CustomerDAOImpl() {
        super();
    }

    @Override
    public boolean addCustomer(Customer customer) {
        boolean isSuccess = true;
        String sqlCustomer = "INSERT INTO customer (name,tel,fullName,email) VALUES (?,?,?,?)";
        String sqlAccount = "INSERT INTO account (username,password) VALUES (?,?)";
        String sqlAddress = "INSERT INTO address (city, noHome, district, street) VALUES (?,?,?,?)";
        String sqlFullname = "INSERT INTO fullname (firstname,lastname) VALUES (?,?)";
        try {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(sqlAccount, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getAccount().getUsername());
            ps.setString(2, customer.getAccount().getPassword());
            ps.setInt(3, customer.getId());
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                customer.getAccount().setId(keys.getInt(1));
            }

            ps = connection.prepareStatement(sqlAddress, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getAddress().getCity());
            ps.setString(2, customer.getAddress().getDistrict());
            ps.setString(3, customer.getAddress().getStreet());
            ps.setInt(4, customer.getAddress().getNoHome());
            ps.setInt(5, customer.getId());
            ps.executeUpdate();
            keys = ps.getGeneratedKeys();
            if (keys.next()) {
                customer.getAddress().setId(keys.getInt(1));
            }

            ps = connection.prepareStatement(sqlFullname, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getFullName().getFisrtName());
            ps.setString(2, customer.getFullName().getLastName());
            ps.executeUpdate();
            keys = ps.getGeneratedKeys();
            if (keys.next()) {
                customer.getFullName().setId(keys.getInt(1));
            }

            ps = connection.prepareStatement(sqlCustomer, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getFullName().toString());
            ps.setString(2, customer.getTel());
            ps.setString(2, customer.getEmail());
            ps.setString(2, customer.getName());
            ps.executeUpdate();

        } catch (SQLException e) {
            isSuccess = false;
            try {
                connection.rollback();
                isSuccess = false;
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                isSuccess = false;
                e.printStackTrace();
            }
        }
        return isSuccess;

    }

    @Override
    public Customer getCustomer(String username, String password) {
        Customer customer = null;
        String sql = "SELECT customer.*,address.*,fullname.*,account.* FROM customer,address,fullname,account WHERE customer.id=address.customerid AND customer.id=fullname.customerid AND customer.id=account.customerid AND username=? AND password=?";
        //String sql = "SELECT * FROM account WHERE username=? AND password=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Address address = new Address();
                address.setCustomerid(rs.getInt("customerID"));
                address.setCity(rs.getString("city"));
                address.setStreet(rs.getString("street"));
                address.setDistrict(rs.getString("district"));
                address.setNoHome(rs.getInt("noHome"));
                address.setId(rs.getInt("address.ID"));

                FullName fullname = new FullName();
                fullname.setCustomerid(rs.getInt("customerID"));
                fullname.setFisrtName("firstname");
                fullname.setLastName("lastname");
                fullname.setId(rs.getInt("fullname.ID"));

                Account account = new Account();
                account.setId(rs.getInt("account.ID"));
                account.setCustomerid(rs.getInt("customerID"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));

                customer = new Customer();
                customer.setId(rs.getInt("customer.ID"));
                customer.setFullName(fullname);
                customer.setTel(rs.getString("tel"));
                customer.setAccount(account);
                customer.setAddress(address);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;

    }

    @Override
    public List<Customer> findAll() {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT customer.*,address.*,fullname.*,account.* FROM customer,address,fullname,account WHERE customer.id=address.customerid AND customer.id=fullname.customerid AND customer.id=account.customerid";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Address address = new Address();
                address.setCity(rs.getString("city"));
                address.setStreet(rs.getString("street"));
                address.setDistrict(rs.getString("distict"));
                address.setNoHome(rs.getInt("noHome"));
                address.setCustomerid(rs.getInt("customerID"));
                address.setId(rs.getInt("address.ID"));

                Account account = new Account();
                account.setId(rs.getInt("account.ID"));
                account.setCustomerid(rs.getInt("customerID"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));

                FullName fullname = new FullName();
                fullname.setFisrtName("firstname");
                fullname.setLastName("lastname");
                fullname.setCustomerid(rs.getInt("customerID"));
                fullname.setId(rs.getInt("fullname.ID"));

                Customer customer = new Customer();
                customer.setId(rs.getInt("customer.ID"));
                customer.setFullName(fullname);
                customer.setTel(rs.getString("tel"));
                customer.setAccount(account);
                customer.setAddress(address);

                list.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Customer findCustomerByUsername(String username) {
        Customer customer = new Customer();
        String sql = "SELECT customer.*,address.*,fullname.*,account.* FROM customer,address,fullname,account WHERE customer.id=address.customerid AND customer.id=fullname.customerid AND customer.id=account.customerid AND username=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Address address = new Address();
                address.setCity(rs.getString("city"));
                address.setStreet(rs.getString("street"));
                address.setDistrict(rs.getString("distict"));
                address.setNoHome(rs.getInt("noHome"));
                address.setCustomerid(rs.getInt("customerID"));
                address.setId(rs.getInt("address.ID"));

                Account account = new Account();
                account.setId(rs.getInt("account.ID"));
                account.setCustomerid(rs.getInt("customerID"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));

                FullName fullname = new FullName();
                fullname.setFisrtName("firstname");
                fullname.setLastName("lastname");
                fullname.setCustomerid(rs.getInt("customerID"));
                fullname.setId(rs.getInt("fullname.ID"));

                customer.setId(rs.getInt("customer.ID"));
                customer.setFullName(fullname);
                customer.setTel(rs.getString("tel"));
                customer.setAccount(account);
                customer.setAddress(address);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void viewOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
