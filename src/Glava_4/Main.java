package Glava_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    // Класс Звезда
    static class Zvezda {
        private String name;

        public Zvezda(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Zvezda zvezda = (Zvezda) obj;
            return Objects.equals(name, zvezda.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "Звезда: " + name;
        }
    }

    // Класс Планета
    static class Planeta {
        private String name;

        public Planeta(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Planeta planeta = (Planeta) obj;
            return Objects.equals(name, planeta.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "Планета: " + name;
        }
    }

    // Класс Луна
    static class Luna {
        private String name;

        public Luna(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Luna luna = (Luna) obj;
            return Objects.equals(name, luna.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "Луна: " + name;
        }
    }

    // Класс ЗвезднаяСистема
    static class ZvezdnayaSistema {
        private Zvezda zvezda;
        private List<Planeta> planeti;

        public ZvezdnayaSistema(Zvezda zvezda) {
            this.zvezda = zvezda;
            this.planeti = new ArrayList<>();
        }

        public void dobavitPlanetu(Planeta planeta) {
            planeti.add(planeta);
        }

        public int kolichestvoPlanet() {
            return planeti.size();
        }

        public String nazvanieZvezdy() {
            return zvezda.getName();
        }

        public void vivestiInformaciyu() {
            System.out.println("Звезда: " + zvezda.getName());
            System.out.println("Количество планет: " + kolichestvoPlanet());
            System.out.println("Планеты:");
            for (Planeta planeta : planeti) {
                System.out.println(planeta.getName());
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            ZvezdnayaSistema that = (ZvezdnayaSistema) obj;
            return zvezda.equals(that.zvezda) && planeti.equals(that.planeti);
        }

        @Override
        public int hashCode() {
            return Objects.hash(zvezda, planeti);
        }

        @Override
        public String toString() {
            return "Звездная система{" +
                    "Звезда=" + zvezda +
                    ", Планеты=" + planeti +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите название звезды: ");
        String nameZvezda = scanner.nextLine();
        Zvezda zvezda = new Zvezda(nameZvezda);

        ZvezdnayaSistema sistema = new ZvezdnayaSistema(zvezda);

        System.out.print("Введите количество планет: ");
        int kolichestvoPlaneta = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < kolichestvoPlaneta; i++) {
            System.out.print("Введите название планеты " + (i + 1) + ": ");
            String namePlaneta = scanner.nextLine();
            Planeta planeta = new Planeta(namePlaneta);
            sistema.dobavitPlanetu(planeta);
        }

        sistema.vivestiInformaciyu();

        scanner.close();
    }
}
