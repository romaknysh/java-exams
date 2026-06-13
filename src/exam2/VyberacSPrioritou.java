package exam2;

import java.util.Optional;

public class VyberacSPrioritou implements VyberacOperacie {
    @Override
    public int dajIndexOperacie(Vypocet vypocet) {
        Optional<Integer> index = vypocet.najdiPrvuOperaciu(new char[]{'*', '/'});
        if (index.isEmpty()) {
            index = vypocet.najdiPrvuOperaciu(new char[]{'+', '-'});
        }
        if (index.isEmpty()) throw new RuntimeException("Ziada operacia nenajdena");
        return index.get();
    }
}