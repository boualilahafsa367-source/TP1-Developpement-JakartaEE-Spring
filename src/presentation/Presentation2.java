
package presentation;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Presentation2 {

    public static void main(String[] args) throws Exception {

        // Lire le nom de la classe DAO
        Scanner scanner = new Scanner(new File("config.txt"));

        String daoClassName = scanner.nextLine();

        // Créer dynamiquement l'objet DAO
        Class<?> cDao = Class.forName(daoClassName);

        IDao dao = (IDao) cDao
                .getDeclaredConstructor()
                .newInstance();

        // Lire le nom de la classe Metier
        String metierClassName = scanner.nextLine();

        // Créer dynamiquement l'objet Metier
        Class<?> cMetier = Class.forName(metierClassName);

        IMetier metier = (IMetier) cMetier
                .getDeclaredConstructor()
                .newInstance();

        // Injecter DAO dans Metier par réflexion
        Method setDaoMethod = cMetier.getMethod("setDao", IDao.class);

        setDaoMethod.invoke(metier, dao);

        // Exécuter le calcul
        System.out.println("Résultats = " + metier.calcul());

        scanner.close();
    }
}
