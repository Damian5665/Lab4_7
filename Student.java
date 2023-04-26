public class Student {

  private String Name;
  private String Nazwisko;
  private int Age;
  private String Ulica;

  public Student(String name, String nazwisko, int age, String ulica) {
    Name = name;
    Nazwisko = nazwisko;
    Age = age;
    Ulica = ulica;
  }

  public String GetName() {return Name;}
  public String GetSurname() {return Nazwisko;}
  public int GetAge() {return Age;}
  public String GetUlica() {return Ulica;}

  public String ToString() {
    return Name + " " + Nazwisko + " " + Integer.toString(Age)+ " " + Ulica;
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if(data.length != 4) 
      return new Student("Parse Error","Parse Error", -1,"Parse Error");
    return new Student(data[0], data[1], Integer.parseInt(data[2]),data[3]);
  }
}