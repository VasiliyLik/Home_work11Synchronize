import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Store store = new Store(3); // количество касс, указано 3, при этом в массиве начинается с 1 -го

        List<Buyer> buyers = new ArrayList<>();
        for (int i = 1; i < 11; i++) { // количество покупателей, начинается с 1, чтобы номера касс начинались с 1
            buyers.add(new Buyer("Buyer " + i, store));
        }

        buyers.forEach(Thread::start); // стартуем работу наших независимых покупателей
        buyers.forEach(buyer -> {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }); // и подождем, пока они все не обслужатся.
    }
}
