package domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="department")
public class Department {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ID")
	    private int ID;
	    
	    @Column(name = "DepartName")
	    private String departName;
	    
	    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="department", orphanRemoval=true)
	    List<Employees> employees;

	    public int getID() {
	        return ID;
	    }

	    public void setID(int iD) {
	        ID = iD;
	    }

	    public String getDepartName() {
	        return departName;
	    }

	    public void setDepartName(String departName) {
	        this.departName = departName;
	    }

	    public List<Employees> getEmployees() {
	        return employees;
	    }

	    public void setEmployees(List<Employees> employees) {
	        this.employees = employees;
	    }

		@Override
		public String toString() {
			return "Department [ID=" + ID + ", departName=" + departName + ", employees=" + employees + ", getID()="
					+ getID() + ", getDepartName()=" + getDepartName() + ", getEmployees()=" + getEmployees() + "]";
		}
}
