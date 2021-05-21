package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import VO.regVO;

public class regDAO {

	public void insert(regVO r) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			Statement sc = cn.createStatement();
			sc.executeUpdate("insert into details(fn,ln,un,pn) values('" + r.getFn() + "','" + r.getLn() + "','"
					+ r.getUn() + "','" + r.getPn() + "')");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(regVO r) {
		try {
			//int k=id;
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			Statement sc = cn.createStatement();
			sc.executeUpdate("delete from details where id='"+r.getId()+"'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<regVO> search()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			Statement sc=cn.createStatement();
			ResultSet rs=sc.executeQuery("select * from details");
			List<regVO> ls=new ArrayList<regVO>();
			while (rs.next()) 
			{
				regVO r=new regVO();
				int id =rs.getInt("id");
				String st1 = rs.getString("fn");
				String st2 = rs.getString("ln");
				String st3 = rs.getString("un");
				String st4 = rs.getString("pn");
				
				r.setId(id);
				r.setFn(st1);
				r.setLn(st2);
				r.setUn(st3);
				r.setPn(st4);
				ls.add(r);
			}
			return ls;
		}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//return null;
		return null;

	}
	
	public List<regVO> edit(regVO m)
	{
		try {
			//int m=id;
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			Statement sc=cn.createStatement();
			ResultSet rs=sc.executeQuery("select * from details where id='"+m.getId()+"'");
			List<regVO> ls=new ArrayList<regVO>();
			while (rs.next()) 
			{
				regVO r=new regVO();
				int id1 = rs.getInt("id");
				String st1 = rs.getString("fn");
				String st2 = rs.getString("ln");
				String st3 = rs.getString("un");
				String st4 = rs.getString("pn");
				
			    r.setId(id1);
				r.setFn(st1);
				r.setLn(st2);
				r.setUn(st3);
				r.setPn(st4);
				ls.add(r);
			}
			return ls;
		}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//return null;
		return null;
	}

	public void update(regVO r) {
try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			Statement st=cn.createStatement();
			st.executeUpdate("UPDATE details SET fn = '"+r.getFn()+"' , ln = '"+r.getLn()+"' , un = '"+r.getUn()+"' , pn = '"+r.getPn()+"' WHERE id = '"+r.getId()+"';");
			st.close();
			cn.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<regVO> forgot(regVO m) {
		// TODO Auto-generated method stub
try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
			Statement st=cn.createStatement();
			st.executeUpdate("UPDATE details SET pn = '"+m.getPn()+"' WHERE un = '"+m.getUn()+"';");
			ResultSet rs=st.executeQuery("select * from details where un='"+m.getUn()+"'");
			//st.executeUpdate("UPDATE details SET pn = '"+m.getPn()+"' WHERE un = '"+m.getUn()+"';");
			List<regVO> ls=new ArrayList<regVO>();
			while (rs.next()) 
			{
				//regVO r=new regVO();
				String st3 = rs.getString("un");
			    //r.setId(id1);
				m.setUn(st3);
				//r.setPn(st4);
				ls.add(m);
			}
			//st.executeUpdate("UPDATE details SET pn = '"+m.getPn()+"' WHERE un = '"+m.getUn()+"';");
			st.close();
			cn.close();
			return ls;
			
			
		//st.executeUpdate("UPDATE details SET pn = '"+m.getPn()+"' WHERE un = '"+m.getUn()+"';");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
return null;
		
	}

	public List<regVO> login(regVO r) {
		 List<regVO> ls=new ArrayList<regVO>();
		 try {
			Class.forName("com.mysql.jdbc.Driver");
		
		 Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		 Statement sc=cn.createStatement();
		 ResultSet rs=sc.executeQuery("select un,pn from details where un='"+r.getUn()+"' and pn='"+r.getPn()+"'");
		 //List<regVO> ls=new ArrayList<regVO>();
		 if(rs.next())
		 {  
			 regVO m=new regVO();
			String sa=rs.getString("un");
			String sb=rs.getString("pn");
			m.setUn(sa);
			m.setPn(sb);
			ls.add(r);
			return ls;
		   
		 }   
			 
		
		 } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ls;
		
	}
}