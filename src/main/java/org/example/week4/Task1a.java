class Person{
    private String name;
    private String address;

    Person(String name, String adrress){
        this.name = name;
        this.address = adrress;
    }
    public String toString(){
        return this.name + "\n  " + this.address;
    }
}


public void main(String[] args) {
    Person pekka = new Person("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa");
    Person esko = new Person("Esko Ukkonen", "Mannerheimintie Street 15 00100 Helsinki");
    System.out.println(pekka);
    System.out.println(esko);
}
