package Glava_5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Catalog {

    private List<IssueRecord> issueHistory;

    public Catalog() {
        issueHistory = new ArrayList<>();
    }

    public void addIssueRecord(String bookTitle, String readerName, Date issueDate) {
        IssueRecord record = new IssueRecord(bookTitle, readerName, issueDate);
        issueHistory.add(record);
    }

    public List<IssueRecord> getIssueHistory() {
        return issueHistory;
    }

    public class IssueRecord {
        private String bookTitle;
        private String readerName;
        private Date issueDate;

        public IssueRecord(String bookTitle, String readerName, Date issueDate) {
            this.bookTitle = bookTitle;
            this.readerName = readerName;
            this.issueDate = issueDate;
        }

        public String getBookTitle() {
            return bookTitle;
        }

        public String getReaderName() {
            return readerName;
        }

        public Date getIssueDate() {
            return issueDate;
        }

        @Override
        public String toString() {
            return "Название книги: " + bookTitle + ", Читатель: " + readerName + ", Дата выдачи: " + issueDate;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Catalog catalog = new Catalog();

        System.out.print("Введите название книги: ");
        String bookTitle = scanner.nextLine();

        System.out.print("Введите имя читателя: ");
        String readerName = scanner.nextLine();

        System.out.print("Введите дату выдачи (в формате dd-MM-yyyy): ");
        String dateString = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date issueDate = null;

        try {
            issueDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Неверный формат даты. Пожалуйста, используйте формат dd-MM-yyyy.");
            return;
        }

        catalog.addIssueRecord(bookTitle, readerName, issueDate);

        System.out.println("\nИстория выдачи книг:");
        for (IssueRecord record : catalog.getIssueHistory()) {
            System.out.println(record);
        }

        scanner.close();
    }
}
