import java.sql.SQLException;
import java.util.ArrayList;

import utility.persistence.MyDatabase;

public class Adapter implements AdapterInterface {

	private MyDatabase db;
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USER = "postgres";
	private static final String PASSWORD = "3721151327";

	
	public Adapter() throws ClassNotFoundException, SQLException
	{
		db = new MyDatabase(DRIVER, URL, USER, PASSWORD);
	}
	@Override
	public StudentList load() throws SQLException 
	{
		StudentList list = new StudentList();
		String sql = "SELECT * FROM Students";
		ArrayList<Object[]> result = db.query(sql);
		for (Object[] e: result)
		{
			int id = (int) e[0];
			String fName = (String) e[1];
			String lName = (String) e[2];
			int studentClass = (int) e[3];
			int parentId = (int) e[4];
			boolean isActive = (Boolean) e[5];
			list.addStudent(new Student(id, fName, lName, studentClass, parentId, isActive));
		}
		return list;
	}

	@Override
	public void save(ArrayList<Student> list) throws SQLException {
		for (Student e: list)
		{
			save(e);
		}
	}

	@Override
	public void save(Student student) throws SQLException {
		String sql = "INSERT INTO Students (";
		sql += student.getId()+",'";
		sql += student.getfName()+"','";
		sql += student.getlName()+"',";
		sql += student.getStudentClass()+",";
		sql += student.getParentId()+",";
		sql += student.isActive()+")";
		System.out.println("Number of updates for given student("+student.getId()+"): "+db.update(sql));
	}

	@Override
	public void remove(Student student) throws SQLException {
		String sql = "DELETE FROM Students WHERE studentId="+student.getId();
		System.out.println("Number of updates for given student("+student.getId()+"): "+db.update(sql));
	}

	@Override
	public void remove(ArrayList<Student> list) throws SQLException {
		for (Student e: list)
		{
			remove(e);
		}
	}

	@Override
	public void clear() throws SQLException {
		String sql = "DELETE FROM Students";
		System.out.println("Data deleted, number of updates "+db.update(sql));
	}

}
