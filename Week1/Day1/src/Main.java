import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        File directory = new File("C:\\Users\\gabriel.petrescu\\Desktop\\DB-Tech-School\\Facultate");

        List<String> result = getFiles(directory);
        List<Student> students = new ArrayList<Student>();
        for (String res : result)
            students.addAll(parseFile(res));


        //Collections.sort(students, (a, b) -> a.gpa < b.gpa ? -1 : a.gpa == b.gpa ? 0 : 1);//
        //Collections.sort(students, (a,b) -> a.firstName.compareToIgnoreCase(b.firstName));

        Collections.sort(students);

        for (Student b : students) {
            System.out.println(b);
        }

        Files.write(Paths.get(("C:\\Users\\gabriel.petrescu\\Desktop\\DB-Tech-School\\Facultate\\AllStudents.txt"), students));
    }


    public static List<String> getFiles(File file) {
        List<String> result = null;
        try (Stream<Path> walk = Files.walk(Paths.get("C:\\Users\\gabriel.petrescu\\Desktop\\DB-Tech-School\\Facultate"))) {

            result = walk.filter(Files::isRegularFile).map(x -> x.toString()).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Reading files: \n");
        result.forEach(System.out::println);
        System.out.println();
        return result;
    }

    public static List<Student> parseFile(String filepath) {

        List<Student> students = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filepath));
            String line = reader.readLine();
            while (line != null) {

                // read next line

                String[] attributes = line.split(",");
                Student student = createStudent(attributes);
                students.add(student);

                line = reader.readLine();

            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }

    private static Student createStudent(String[] metadata) {
        String firstName = metadata[0];
        String secondName = metadata[1];
        String email = metadata[2];
        int credits = Integer.parseInt(metadata[3]);
        double gpa = Double.parseDouble(metadata[4]);

        return new Student(firstName, secondName, email, credits, gpa);
    }


}





