class Student {
    private String id;
//    private String name;
//    private String email;
//    private int age;

    public Student(String id, String name, String email, int age) {
        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.age = age;
    }

    public String toString() {
        String studentInfo = "Student " + id;
//        studentInfo += ": " + name;
//        studentInfo += " - " + email;
//        studentInfo += " - " + age;
        return studentInfo;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student another = (Student) obj;
            if (this.id.equals(another.id))
//                    &&
//                    this.name.equals(another.name) &&
//                    this.email.equals(another.email) &&
//                    this.age == another.age)
                                    {
                return true;
            }
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        String s = "test";
        String s1 = "test";
        int a = 1, b = 1;
        System.out.println("s.equals(s1): " +  s.equals(s1));
        System.out.println("a.equals(b): " +  Integer.compare(a,b));
        Student student1 = new Student("123", "Cong", "cong@gmail.com", 22);
        Student student2 = new Student("123", "Cong", "cong@gmail.com", 22);
        Student student3 = new Student("456", "Dung", "dung@gmail.com", 18);

        System.out.println("student1 == student2: " + (student1 == student2));
        System.out.println("student1.equals(student2): "
                + (student1.equals(student2)));
        System.out.println("student2.equals(student3): "
                + (student2.equals(student3)));
    }
}