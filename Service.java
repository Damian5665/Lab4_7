import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
public class Service {

  public void addStudent(Student student) throws IOException {
    var f = new FileWriter("db.txt", true);
    var b = new BufferedWriter(f);
    b.append(student.ToString());
    b.newLine();
    b.close();
  }

  public Collection<Student> getStudents() throws IOException {
    var ret = new ArrayList<Student>();
    var f = new FileReader("db.txt");
    var reader = new BufferedReader(f);
    String line = "";
    while (true) {
      line = reader.readLine();
      if(line == null)
        break;
      ret.add(Student.Parse(line));
    }
    reader.close();
    return ret;
  }

  public List<Student> findStudentByName(String name) 
  {
    List<Student> students = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("db.txt"))) 
    {
            String line;
            while ((line = br.readLine()) != null) 
            {
                String[] data = line.split(" "); 
                if (data[0].equals(name)) 
                { 
                  Student student = new Student(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4]);
                  students.add(student);
                }
            }
        } 
        catch (IOException e) 
        {
          System.err.println("Błąd odczytu pliku: ");
        }
    return students;
  }
}