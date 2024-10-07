import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bejegyzes {
    private String szerzo;
    private String tartalom;
    private int likeok;
    private LocalDateTime letrejott;
    private LocalDateTime szerkesztve;

    public Bejegyzes(String szerzo, String tartalom) {
        this.szerzo = szerzo;
        this.tartalom = tartalom;
    }

    public String getSzerzo() {
        return szerzo;
    }

    public String getTartalom() {
        return tartalom;
    }

    public void setTartalom(String tartalom, LocalDateTime szerkesztve) {
        this.tartalom = tartalom;
        this.szerkesztve = LocalDateTime.now();
    }

    public int getLikeok() {
        return likeok;
    }

    public LocalDateTime getLetrejott() {
        return letrejott;
    }

    public LocalDateTime getSzerkesztve() {
        return szerkesztve;
    }

    public void setLikeok(int likeok) {
        this.likeok = 0;
    }

    public void setLetrejott(LocalDateTime letrejott) {
        this.letrejott = LocalDateTime.now();
    }

    public void setSzerkesztve(LocalDateTime szerkesztve) {
        this.szerkesztve = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return szerzo + " - " + likeok + " - " + letrejott +
                "Szerkesztve: " + szerkesztve +
                tartalom;
    }

    private List<Bejegyzes> bejegyzesek1 = new ArrayList<>();
    private List<Bejegyzes> bejegyzesek2 = new ArrayList<>();

    Scanner myObj = new Scanner(System.in);

    public void ListaFeltoltes() {
        try {
            System.out.println("Adjon meg egy darabszámot!");
            int darabszam = Integer.parseInt(myObj.nextLine());
            for (int i = 0; i < darabszam; i++) {
                Bejegyzes b = new Bejegyzes("xy", "blabla");
                bejegyzesek1.add(b);
            }
        }
        catch (Exception e) {
            System.out.println("Nem egész számot adott meg!");
        }
    }

    public void Beolvasas(String fajlnev) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fajlnev));
            String sor = bufferedReader.readLine();
            while (sor != null && !sor.isEmpty()) {
                String[] adatok = sor.split(";");
                bejegyzesek2.add(new Bejegyzes(adatok[0], adatok[1]));
                sor = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
