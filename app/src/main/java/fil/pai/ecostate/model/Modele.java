package fil.pai.ecostate.model;

import java.util.ArrayList;
import java.util.List;

import fil.pai.ecostate.R;

public class Modele {

    public static final int QUIZ_DONE = 1;
    public static final int QUIZ_NOT_DONE = 0;
    private static final Modele ourInstance = new Modele();
    private List<Action> mAction = new ArrayList<>();
    private List<News> ln = new ArrayList<>();
    private List<Defi> mDefis = new ArrayList<>();
    private List<AstucesModel> mAstuces = new ArrayList<>();
    private int currentQuiz;


    private Modele() {

        Action a1 = new Action("Sauver les phoques");
        Action a2 = new Action("Trier ses déchets");
        Action a3 = new Action("Prendre une douche froide");
        Action a4 = new Action("Manger vegan");
        mAction.add(a1);
        mAction.add(a2);
        mAction.add(a3);
        mAction.add(a4);
        /*
        News n1 = new News("Le panda qui s'penda", R.drawable.panda, "Des experts de l'IUCN (Union internationale pour la conservation de la nature) ont lancé aujourd'hui un appel en faveur de la sauvegarde des ours polaires, menacés par le réchauffement climatique.");
        News n2 = new News("La tortue qui s'torture", R.drawable.panda, "Des experts de l'IUCN (Union internationale pour la conservation de la nature) ont lancé aujourd'hui un appel en faveur de la sauvegarde des ours polaires, menacés par le réchauffement climatique.");
        News n3 = new News("Le Paresseux... paresseu", R.drawable.panda, "Des experts de l'IUCN (Union internationale pour la conservation de la nature) ont lancé aujourd'hui un appel en faveur de la sauvegarde des ours polaires, menacés par le réchauffement climatique.");
        News n4 = new News("Le Mammouth polisson", R.drawable.panda, "Des experts de l'IUCN (Union internationale pour la conservation de la nature) ont lancé aujourd'hui un appel en faveur de la sauvegarde des ours polaires, menacés par le réchauffement climatique.");
        News n5 = new News("Le cochon qui sent bon", R.drawable.panda, "Des experts de l'IUCN (Union internationale pour la conservation de la nature) ont lancé aujourd'hui un appel en faveur de la sauvegarde des ours polaires, menacés par le réchauffement climatique.");
        News n6 = new News("Les sardines pas si serrées", R.drawable.panda, "Des experts de l'IUCN (Union internationale pour la conservation de la nature) ont lancé aujourd'hui un appel en faveur de la sauvegarde des ours polaires, menacés par le réchauffement climatique.");
        */
        News n1 = new News("Anticiper la sécheresse", R.drawable.secheresse,
                "Lors de la dernière réunion de suivi hydrologique, l'accent a été mis sur les risques d'augmentation  des sécheresses pluriannuelles et les pistes pour y faire face. Reste désormais à voir les orientations qui seront prises par le gouvernement.");


        News n2 = new News("Vers la fin du plastique jetable", R.drawable.plastique_jetable,
                "L'interdiction de certains articles jetables en plastique entrera en vigueur au printemps 2021. Le Parlement européen a en effet approuvé, mercredi 27 mars, le projet de directive validé par les Etats membres en janvier dernier.");


        News n3 = new News("Abeilles et pesticides", R.drawable.abeilles,
                "Depuis six ans, les discussions entre les Etats membres et la Commission européenne patinent pour durcir les tests d'homologation des pesticides, proposés par l'Efsa, pour protéger les abeilles. L'association Pollinis dénonce l'opacité des négociations.");


        News n4 = new News("Panneaux solaires et emplois", R.drawable.installateur,
                "Les installations solaires qui colonisent peu à peu les toits des particuliers et des entreprises reflètent bien une dynamique en pleine croissance. Le secteur est donc créateur d'emplois. ");

        News n5 = new News("Nucléaire : des failles signalées", R.drawable.centrale, "L'Autorité de sûreté nucléaire dresse un premier bilan de son plan de lutte contre les fraudes. Elle signale que 22 irrégularités lui ont été signalées en six mois via son nouveau dispositif dédié aux lanceurs d'alerte.\n");


        News n6 = new News("Le panda qui s'penda", R.drawable.panda, "Des experts de l'IUCN (Union internationale pour la conservation de la nature) ont lancé aujourd'hui un appel en faveur de la sauvegarde des ours polaires, menacés par le réchauffement climatique.");

        ln.add(n1);
        ln.add(n2);
        ln.add(n3);
        ln.add(n4);
        ln.add(n5);
        ln.add(n6);
        currentQuiz = QUIZ_NOT_DONE;

        Defi d1 = new Defi("Économiser 1000000L d'eau", R.drawable.centrale, 15, "Venez nous aider à sauver la planête en prenant des douches plus courtes, et en évitant le gaspillage d'eau ! ", 1000, "-20% Decathlon", "WaterSavings");
        Defi d2 = new Defi("Empêcher les pandas de se pendre", R.drawable.panda, 50, "Manger un panda, sauver les bambous", 50, "-20% Boucherie", "PandaSavings");
        Defi d3 = new Defi("Objectif 0 déchet", R.drawable.requin, 644, "Vivre un mois entier sans produire de déchet non recyclable (plastiques, produits issus du pétrole...", 1000, "-50% Humain", "ThanosSavings");
        mDefis.add(d1);
        mDefis.add(d2);
        mDefis.add(d3);

        AstucesModel am1 = new AstucesModel(("Utiliser des cotons lavables (à la place des cotons jetables)"), R.drawable.astuce_coton_lavable, "Recyclage");
        AstucesModel am2 = new AstucesModel(("Les ampoules et piles se recyclent dans ton supermarché !"), R.drawable.astuce_collecteur_magasin, "Recyclage");
        AstucesModel am3 = new AstucesModel(("Acheter une gourde en inox / verre ou plastique sans BPA"), R.drawable.astuce_gourde_inox, "Recyclage");
        AstucesModel am4 = new AstucesModel(("Installer un mousseur sur ton robinet pour diviser ta facture d’eau par deux "), R.drawable.astuce_mousseurs, "Energie");
        AstucesModel am5 = new AstucesModel(("Laver ses vêtements à moins de 30°"), R.drawable.astuce_machine_30, "Energie");
        AstucesModel am6 = new AstucesModel(("Mettre un couvercle sur une casserole d’eau qui chauffe"), R.drawable.astuce_couvercle_casseroles, "Energie");
        AstucesModel am7 = new AstucesModel(("Utiliser du vinaigre blanc est plus économique et fonctionne aussi bien pour nettoyer plutôt que des produits ménagers classiques"), R.drawable.astuce_vinaigre_blanc, "Nourriture");
        AstucesModel am8 = new AstucesModel(("Les produits en vrac dans ton supermarché sont plus économiques et n'utilisent pas de plastique inutiles"), R.drawable.astuce_produit_vrac, "Nourriture");
        AstucesModel am9 = new AstucesModel(("Emprunter des livres / DVD / magazines à la bibliothèque revient beaucoup moins cher que de les acheter"), R.drawable.astuce_bibliotheque, "Divers");
        AstucesModel am10 = new AstucesModel(("Mettre un filtre lavable dans la cafetière est plus économique sur le long terme"), R.drawable.astuce_filtre_lavable, "Divers");

        mAstuces.add(am1);
        mAstuces.add(am2);
        mAstuces.add(am3);
        mAstuces.add(am4);
        mAstuces.add(am5);
        mAstuces.add(am6);
        mAstuces.add(am7);
        mAstuces.add(am8);
        mAstuces.add(am9);
        mAstuces.add(am10);

    }

    public static Modele getInstance() {
        return ourInstance;
    }

    public List<Action> getmAction() {
        return mAction;
    }

    public List<News> getListNews() {
        return ln;
    }

    public int getCurrentQuiz() {
        return currentQuiz;
    }

    public void setCurrentQuiz(int currentQuiz) {
        this.currentQuiz = currentQuiz;
    }

    public List<Defi> getmDefis() {
        return mDefis;
    }

    public List<AstucesModel> getmAstuces() {
        return mAstuces;
    }
}
