import java.util.ArrayList;
import java.util.List;

class Person{
    private String name;
    private String address;

    Person(String address){

        this.address = address;
    }

    Person(String name, String adrress){
        this.name = name;
        this.address = adrress;
    }
    public String toString(){
        return this.name + "\n  " + this.address;
    }
}

class Student extends Person{
    private String firstName;
    private int credits;


    Student(String firstName, String adrress){
        super(adrress);
        this.firstName = firstName;
    }

    public int credits(){
        return this.credits = 0;
    }

    public void study(){
        this.credits++;
    }

    public String toString(){
        return this.firstName + "\n " + super.address + "\n " + "credits " + this.credits;
    }
}

class Teacher extends Person{
    private int salary;

    Teacher(String name, String adrress, int salary){
        super(name, adrress);
        this.salary = salary;
    }

    public String toString(){
        return super.name + "\n " + super.address + "\n " + "salary " + this.salary + " euros/month";
    }
}

public void main(String[] args) {
    Teacher pekka = new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200);
    Teacher esko = new Teacher("Esko Ukkonen", "Mannerheimintie 15 Street 00100 Helsinki", 5400);
    System.out.println( pekka );
    System.out.println( esko );




    Student olli = new Student("Olli", "Ida Albergintie 1 Street 00400 Helsinki");
    for ( int i=0; i < 25; i++ ) {
        olli.study();
    }
    System.out.println( olli );

}

