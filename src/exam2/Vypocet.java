package exam2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Vypocet {
    private List<CastVyrazu> vyraz;
    private VyberacOperacie vyberac;

    public Vypocet(Iterable<CastVyrazu> vyraz, VyberacOperacie vyberac) {
        this.vyraz = new ArrayList<>();
        for (CastVyrazu cast : vyraz) {
            this.vyraz.add(cast);
        }
        this.vyberac = vyberac;
    }

    public boolean vykonajKrok() {
        if (this.vyraz.size() <= 1) return false;
        int index = this.vyberac.dajIndexOperacie(this);
        Operacia op = (Operacia) this.vyraz.get(index);
        Cislo lava = (Cislo) this.vyraz.get(index - 1);
        Cislo prava = (Cislo) this.vyraz.get(index + 1);
        double vysledok = op.vypocitaj(lava.getHodnota(), prava.getHodnota());
        this.vyraz.remove(index + 1);
        this.vyraz.remove(index);
        this.vyraz.set(index - 1, new Cislo(vysledok));
        return true;
    }

    public String getVyrazString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.vyraz.size(); i++) {
            if (i > 0) sb.append(" ");
            sb.append(this.vyraz.get(i).getReprezentacia());
        }
        return sb.toString();
    }

    public Optional<Integer> najdiPrvuOperaciu(char[] hladaneOperacie) {
        for (int i = 0; i < this.vyraz.size(); i++) {
            if (this.vyraz.get(i) instanceof Operacia op) {
                if (op.jeHladanaOperacia(hladaneOperacie)) return Optional.of(i);
            }
        }
        return Optional.empty();
    }
}