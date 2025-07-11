package com.aaslin.java.assignments.assignment_2;
class Library{
    class Book{
        String Aname;
        String title;
        void setBook(String Aname, String title){
            this.Aname=Aname;
            this.title=title;
        }
        void getBook(){
            System.out.println("Book author name is "+Aname+" and title is "+title);
        }
    }
}
class LibraryCls {
    public static void main(String[] args){
        Library lib = new Library();
        Library.Book book = lib.new Book();
        book.setBook("Games Gosling", "Java programming");
        book.getBook();

    }
}
