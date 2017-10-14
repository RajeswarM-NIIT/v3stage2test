package com.test.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.model.UserDetails;

@Repository
public class UserDetailsDAOImpl implements UserDetailsDAOInt {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public UserDetails addUser(UserDetails userDetails) {
		try{
			userDetails.setUserid(generateUserId());
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(userDetails);			
			transaction.commit();
			session.close();
			return userDetails;
		}
		catch(Exception  ex){
			System.out.println("\nException in adduser : " + ex);
			return null;
		}
	}

	public UserDetails loginCheck(UserDetails userDetails) {
		return null;
	}
	
	
	
	public List<UserDetails> getAllUsers() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from UserDetails");
		List<UserDetails> data = query.list();
		session.close();
		return data;
		
	}

	private String generateUserId(){		
	String newUid="";
		Session ss = sessionFactory.openSession();		
		Query qq = ss.createQuery("from UserDetails");
		if(qq.list().isEmpty())
		{
			newUid="USR00001";
		}
		else{	
			Query q = ss.createQuery("select max(userid) from UserDetails");			
			String prevId = q.list().get(0).toString();
			//String prevId = data.get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);
			id=id+1;
			if(id<=9)
				newUid="USR0000"+id;
			else if(id<=99)
				newUid="USR000"+id;
			else if(id<=999)
				newUid="USR00"+id;
			else if(id<=9999)
				newUid="USR0"+id;
			else
				newUid="USR"+id;		
			System.out.print("\nGenerated : "+newUid);							
		}
		ss.close();	
		return newUid;
	}
}
