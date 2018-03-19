package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="employees")
public class Employees {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int ID;
	    @Column(name = "firstName")
	    private String firstName;

	    @Column(name = "lastName")
	    private String lastName;

	    @ManyToOne
	    @JoinColumn(name="DepartmentID")
	    
	     private Department department;

	    public int getID() {
	        return ID;
	    }

	    public void setID(int iD) {
	        ID = iD;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public Department getDepartment() {
	        return department;
	    }

	    public void setDepartment(Department department) {
	        this.department = department;
	    }

		@Override
		public String toString() {
			return "Employees [ID=" + ID + ", firstName=" + firstName + ", lastName=" + lastName + ", department="
					+ department + ", getID()=" + getID() + ", getFirstName()=" + getFirstName() + ", getLastName()="
					+ getLastName() + ", getDepartment()=" + getDepartment() + "]";
		}

}
