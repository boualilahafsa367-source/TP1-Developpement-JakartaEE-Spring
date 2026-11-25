
package metier;

import dao.IDao;

public class MetierImpl implements IMetier {

    private IDao dao;

    // Injection de la dépendance DAO
    public void setDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        return dao.getValue() * 2;
    }
}
