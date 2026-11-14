package benakka.metier;

public interface IMetierBanque {
    void addCompte(Compte cp);
    void verser(Long code, double mantant);
    void retirer(Long code, double mantant);
    Compte consulter(Long code);
}
