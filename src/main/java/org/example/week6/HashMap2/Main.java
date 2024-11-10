package org.example.week6.HashMap2;

public class Main {
    public static void main(String[] args) {
        PromissoryNote mattisNote = new PromissoryNote();
        mattisNote.setLoan("Arto", 51.5);
        mattisNote.setLoan("Mikael", 30);
        System.out.println(mattisNote.howMuchIsTheDebt("Arto"));   // Output: 51.5
        System.out.println(mattisNote.howMuchIsTheDebt("Joel"));   // Output: 0.0

        mattisNote.setLoan("Arto", 10.5);
        System.out.println(mattisNote.howMuchIsTheDebt("Arto"));
    }
}
