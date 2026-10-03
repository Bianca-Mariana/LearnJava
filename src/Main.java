import interfaces.Phone;
import models.IPhone15;
import models.SamsungGalaxy6;

public class Main {
    public static void main(String[] args) {
        // Phone phone = new Samsung(); // Nu compileaza pentru ca Samsung este clasa abstracta

        Phone phone = new SamsungGalaxy6();

        phone.addContact("1", "0722123456", "Ion", "Popescu");
        phone.addContact("2", "0733987654", "Maria", "Ionescu");

        phone.getFirstContact();
        phone.getLastContact();

        // Trimitere mesaje catre primul contact
        phone.sendMessage("0722123456", "Buna, ramane valabila iesirea de diseara la piesa de teatru?");
        phone.sendMessage("0722123456", "Sa nu uiti sa aduci biletele");

        phone.getFirstMessage("0722123456");
        phone.getSecondMessage("0722123456");

        // Apel catre al doilea contact
        phone.call("0733987654");

        phone.viewHistory();

        System.out.println();

        // Testare al doilea brand / model
        Phone iphone = new IPhone15();
        iphone.addContact("1", "0744111222", "Alex", "Radu");
        iphone.addContact("2", "0755333444", "Elena", "Dumitru");

        iphone.sendMessage("0744111222", "Buna, te-ai apucat de proiectul la geografie?");
        iphone.sendMessage("0744111222", "Nu cred ca am notat corect toata cerinta, poti sa mi-o trimiti si mie te rog ? ");
        iphone.getFirstMessage("0744111222");
        iphone.getSecondMessage("0744111222");

        iphone.call("0755333444");
        iphone.viewHistory();
    }
}
