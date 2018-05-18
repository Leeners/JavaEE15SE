package cn.edu.chzu.xxxy.se15.javaee.hibernate.service;

import java.util.List;
import java.util.Map;

import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import cn.edu.chzu.xxxy.se15.javaee.hibernate.dao.CustomerDAO;
import cn.edu.chzu.xxxy.se15.javaee.hibernate.po.Address;
import cn.edu.chzu.xxxy.se15.javaee.hibernate.po.Customer;

public class CustomerService {
	
	private Map<String, Object> request, session;
	
	public boolean login(Customer loginUser) {
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		request=(Map) ctx.get("request");
		String account = loginUser.getAccount();
		String password = loginUser.getPassword();
		String hql = "from Customer as user where account='" + account
				+ "' and password='" + password + "'";
		CustomerDAO dao = new CustomerDAO();
		List list = dao.findByHql(hql);
		dao.getSession().close();
		if (list.isEmpty())
			return false;
		else{
			session.put("user", account);
			request.put("tip", "��¼�ɹ���");
			loginUser=(Customer)list.get(0);
			request.put("loginUser", loginUser);
			return true;
		}
	}

	/*public boolean register(Customer loginUser) {
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		request=(Map) ctx.get("request");
		CustomerDAO dao = new CustomerDAO();
		try {
			Transaction tran = dao.getSession().beginTransaction();
			dao.save(loginUser);
			tran.commit();
			session.put("user", loginUser.getAccount());
			request.put("tip", "ע��ɹ���");
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			dao.getSession().close();
		}
	}
*/
	public void register(Customer loginUser) {
		CustomerDAO dao = new CustomerDAO();				
		dao.save(loginUser);
	}
	
	public boolean update(Customer loginUser) {
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		request=(Map) ctx.get("request");
		CustomerDAO dao = new CustomerDAO();
		try {
			Transaction tran = dao.getSession().beginTransaction();
			dao.update(loginUser);
			tran.commit();
			session.put("user", loginUser.getAccount());
			request.put("tip", "�޸ĸ�����Ϣ�ɹ���");
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			dao.getSession().close();
		}
	}

	public boolean delete(Customer loginUser) {
		ActionContext ctx= ActionContext.getContext();
		session=(Map) ctx.getSession();
		request=(Map) ctx.get("request");
		CustomerDAO dao = new CustomerDAO();
		try {
			Transaction tran = dao.getSession().beginTransaction();
			dao.delete(loginUser);
			tran.commit();
			session.remove("user");
			request.put("tip", "ɾ��������Ϣ�ɹ��������µ�¼��");
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			dao.getSession().close();
		}
	}
	/*public boolean addAddr(Customer loginUser, Address address) {
		ActionContext ctx= ActionContext.getContext();
		request=(Map) ctx.get("request");
		CustomerDAO c_dao = new CustomerDAO();
		loginUser = (Customer)c_dao.findById(loginUser.getCustomerId());
		address.setCustomer(loginUser);
		loginUser.getAddresses().add(address);

		try {
			Transaction tran = c_dao.getSession().beginTransaction();
			c_dao.update(loginUser);
			tran.commit();
			request.put("loginUser", loginUser);
			request.put("tip", "��ӵ�ַ�ɹ���");
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			c_dao.getSession().close();
		}
	}*/
}
