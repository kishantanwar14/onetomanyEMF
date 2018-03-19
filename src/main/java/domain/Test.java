package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Test {
	 public static void main(String[] args) {
		 
	       addNewMasterAndDetail();
	       //updateOnlyMaster();
	       //deleteOnlyMaster();
	       }
	    public static void addNewMasterAndDetail()
	    {
	    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("domain");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			System.out.println("Starting Transaction");
			entityManager.getTransaction().begin();
	        
			
	        Department d1 = new Department();		// Now let us create Department
	        d1.setDepartName("Accounts");
	        entityManager.persist(d1);
	       
	        System.out.println("Generated Department = " + d1.getDepartName());
	        System.out.println("Saving Department to Database");
	        
	        //ArrayList<Employees> empList = new ArrayList<Employees>();
	        List<Employees> empList = new ArrayList<Employees>();
	        Employees e1 = new Employees();

	        e1.setFirstName("John");
	       // e1.setLastName("Michel");
	        e1.setFirstName("Mike");
	        
	       //e1.setLastName("Grey");
	        e1.setDepartment(d1);
	        empList.add(e1);

	        e1 = new Employees();
	        e1.setFirstName("Smith");
	        e1.setFirstName("Robert");
	        System.out.println("FirstName = " + e1.getFirstName());
	        e1.setLastName("Peter");
	        e1.setDepartment(d1);
	        empList.add(e1);

	        d1.setEmployees(empList);
	        
			entityManager.getTransaction().commit();
			entityManager.close();			
			entityManagerFactory.close();
	        
	    }
	    
	  
	    public static void updateOnlyMaster() 
	    {
	        //Now Let us update the master alone i.e Department
	    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("domain");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			System.out.println("Starting Transaction");
			entityManager.getTransaction().begin();
			String hql = "update Department d set d.departName=:dname where d.ID=2";
			Query query = entityManager.createQuery(hql);
			query.setParameter("dname","Accounts modified");
			int status=query.executeUpdate(); 
			
			entityManager.persist(status);
			entityManager.getTransaction().commit();
            entityManager.close();
			entityManagerFactory.close();
	    }
	    
	    
	    /*public static void updateonlyDetail() 
	    {
	        //Now Let us update the detail alone i.e Employee
		   EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("domain");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			System.out.println("Starting Transaction");
			entityManager.getTransaction().begin();
			String hql = "update Department d set d.departName=:dname where d.ID=2";
			Query query = entityManager.createQuery(hql);
			query.getEmployees().get(0).setFirstName("changed first name");
	  //	entityManager.save(d2);
	        entityManager.getTransaction().commit();
          	entityManager.close();
		    entityManagerFactory.close();
	    }*/
	    
	    
	   public static void deleteOnlyMaster()
	   {
		   	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("domain");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			System.out.println("Starting Transaction");
			entityManager.getTransaction().begin();
			Query query=entityManager.createQuery("delete from Department d where d.id=1");  
			//specifying class name (Emp) not tablename  
			query.executeUpdate(); 
			entityManager.getTransaction().commit();
			entityManager.close();
		    entityManagerFactory.close();
	   }
}
