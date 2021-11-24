package utils;

public interface Usage {
//customer
	//--- insert
	public String insertCustomer ="insert into customer (Tel,Fullname,Email) values (?,?,?)";
	public String insertAccount = "insert into account (CustomerID,Username,Password) values (?,?,?)";
	public String insertAddress = "insert into address (CustomerID,NoHome,City,Street,District) values (?,?,?,?,?)";
	public String insertFullname = "insert into fullname (CustomerID,Firstname,Lastname) values (?,?,?)";
	//--- select
	public String findAccountByUsername ="select & from account where Username=?";
	public String findAccount = "select * from account where Username =? and Password=?";
	public String getCustomerByAccount ="select customer.* , account.* , address.* , fullname.* from customer,account, address, fullname where customer.ID=? and account.CustomerID=? and address.CustomerID=? and fullname.CustomerID=?";

//Book
	public String getItemBookByID = "select * from itembook where ID=?";
	public String getAllItemBook = "select * from itembook";
	public String getBookByID ="select * from book where ID=?";
	public String getPublisherByID = "select * from publisher where ID=?";
	public String getAuthorIDByBookID ="select AuthorID from book_author where BookID =?";
	public String getAuthorByID= "select * from author where ID=?";
	public String getCategoryByBookID ="select * from category where BookID=?";
	
}
