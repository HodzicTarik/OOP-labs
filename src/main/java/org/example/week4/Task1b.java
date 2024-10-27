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
        return this.credits;
    }

    public void study(){
        this.credits++;
    }

    public String toString(){
        return this.firstName + "\n " + super.address;
    }
}


public void main(String[] args) {
    Student olli = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki");
    System.out.println(olli);
    System.out.println("credits " + olli.credits());
    olli.study();
    System.out.println("credits "+ olli.credits());
}

