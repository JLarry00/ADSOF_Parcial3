import Directories.*;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Create some files
        File file1 = new File("file1.txt", LocalDateTime.now(), "This is the content of file1.txt. " +
                "It contains detailed information about the file's purpose, usage, and other relevant data. " +
                "The content is designed to be comprehensive and informative, providing insights into the file's role " +
                "within the system and its interactions with other components.");
        File file2 = new File("file2.txt", LocalDateTime.now(), "This is the content of file2.txt. " +
                "It includes extensive documentation and examples to illustrate its functionality. " +
                "The text is structured to guide users through the file's features, ensuring a thorough understanding " +
                "of its capabilities and potential applications.");
        File file3 = new File("file3.txt", LocalDateTime.now(), "This is the content of file3.txt. " +
                "The file's content is rich with technical details and specifications, aimed at developers and engineers. " +
                "It serves as a reference point for implementing and integrating the file's features into larger systems, " +
                "highlighting best practices and common pitfalls.");
        File file4 = new File("file4.txt", LocalDateTime.now(), "This is the content of file4.txt. " +
                "The text delves into the historical context and evolution of the file's design, " +
                "offering a narrative that connects past iterations with current implementations. " +
                "It provides a deep dive into the rationale behind design choices and future directions.");
        File file5 = new File("file5.txt", LocalDateTime.now(), "This is the content of file5.txt. " +
                "It features a comprehensive analysis of the file's performance metrics and optimization strategies. " +
                "The content is tailored for performance analysts and system architects, " +
                "focusing on enhancing efficiency and scalability in various environments.");

        // Create a root directory
        Directory rootDir = new Directory("root", LocalDateTime.now());

        // Add files to the root directory
        rootDir.add(file1);
        rootDir.add(file2);

        // Create a subdirectory
        Directory subDir1 = new Directory("subDir1", LocalDateTime.now());
        Directory subDir2 = new Directory("subDir2", LocalDateTime.now());

        // Add files to the subdirectories
        subDir1.add(file3);
        subDir2.add(file4);
        subDir2.add(file5);

        // Create a nested subdirectory
        Directory nestedSubDir = new Directory("nestedSubDir", LocalDateTime.now());
        subDir1.add(nestedSubDir);

        // Add a file to the nested subdirectory
        File file6 = new File("file6.txt", LocalDateTime.now(), "This is the content of file6.txt");
        nestedSubDir.add(file6);

        // Add the subdirectories to the root directory
        rootDir.add(subDir1);
        rootDir.add(subDir2);

        // Print the content of the root directory
        System.out.println("Root Directory Content:");
        System.out.println(rootDir.getContent(0));

        // Print the size of the root directory
        System.out.println("\nTotal size of root directory: " + rootDir.size());

        // Print the number of files in the root directory
        System.out.println("Total number of files in root directory: " + rootDir.nFiles());
    }
}