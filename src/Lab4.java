import java.util.*;

/**
 * Клас, що представляє абонента
 */
class Abonent {
    private String name;
    private String phoneNumber;

    /**
     * Конструктор класу Abonent
     * @param name ім'я абонента
     * @param phoneNumber номер телефону абонента
     */
    public Abonent(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Метод для отримання імені абонента
     * @return ім'я абонента
     */
    public String getName() {
        return name;
    }

    /**
     * Метод для отримання номера телефону абонента
     * @return номер телефону абонента
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber;
    }
}

/**
 * Клас-контейнер для телефонного довідника
 */
class PhoneDirectory {
    private Map<String, Abonent> directory;

    /**
     * Конструктор класу PhoneDirectory
     */
    public PhoneDirectory() {
        directory = new HashMap<>();
    }

    /**
     * Метод для додавання нового абонента до довідника
     * @param name ім'я абонента
     * @param phoneNumber номер телефону абонента
     */
    public void addAbonent(String name, String phoneNumber) {
        Abonent abonent = new Abonent(name, phoneNumber);
        directory.put(name, abonent);
    }

    /**
     * Метод для вилучення абонента з довідника
     * @param name ім'я абонента
     */
    public void removeAbonent(String name) {
        directory.remove(name);
    }

    /**
     * Метод для пошуку абонента за іменем
     * @param name ім'я абонента
     * @return абонент, якщо знайдено, або null, якщо не знайдено
     */
    public Abonent findAbonent(String name) {
        return directory.get(name);
    }

    /**
     * Метод для отримання списку всіх абонентів, відсортованих за іменем
     * @return список абонентів, відсортований за іменем
     */
    public List<Abonent> getAllAbonentsSortedByName() {
        List<Abonent> abonents = new ArrayList<>(directory.values());
        abonents.sort(Comparator.comparing(Abonent::getName));
        return abonents;
    }

    /**
     * Метод для отримання списку всіх абонентів, відсортованих за номером телефону
     * @return список абонентів, відсортований за номером телефону
     */
    public List<Abonent> getAllAbonentsSortedByPhoneNumber() {
        List<Abonent> abonents = new ArrayList<>(directory.values());
        abonents.sort(Comparator.comparing(Abonent::getPhoneNumber));
        return abonents;
    }
}

/**
 * Клас, що містить точку входу у програму
 */
public class Lab4 {

    /**
     * Точка входу у програму
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();

        phoneDirectory.addAbonent("John", "123456789");
        phoneDirectory.addAbonent("Alice", "987654321");
        phoneDirectory.addAbonent("Bob", "456789123");

        List<Abonent> abonentsByName = phoneDirectory.getAllAbonentsSortedByName();
        System.out.println("Sorted by name:");
        for (Abonent abonent : abonentsByName) {
            System.out.println(abonent);
        }

        List<Abonent> abonentsByPhoneNumber = phoneDirectory.getAllAbonentsSortedByPhoneNumber();
        System.out.println("\nSorted by phone number:");
        for (Abonent abonent : abonentsByPhoneNumber) {
            System.out.println(abonent);
        }
    }

}
