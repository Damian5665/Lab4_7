public class Student {

  private String Name;
  private String Nazwisko;
  private int Age;

  public Student(String name, String nazwisko, int age) {
    Name = name;
    Nazwisko = nazwisko;
    Age = age;
  }

  public String GetName() {return Name;}
  public String GetSurname() {return Nazwisko;}
  public int GetAge() {return Age;}

  public String ToString() {
    return Name + " " + Nazwisko + " " + Integer.toString(Age);
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if(data.length != 3) 
      return new Student("Parse Error","Parse Error", -1);
    return new Student(data[0], data[1], Integer.parseInt(data[2]));
  }
}