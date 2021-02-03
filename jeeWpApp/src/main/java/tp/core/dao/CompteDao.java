package tp.core.dao;

import java.util.List;

import tp.core.entity.Compte;

/*
 * DAO = Data Access Object
 * (ici un cas particulier d'EJB)
 * avec methodes CRUD .
 * 
 * En cas de problème 
 * throws RuntimeException implicite
 * 
 */


public interface CompteDao {
     public Compte  findById(Long numero);
     public List<Compte> findAll();
     public List<Compte> findByNumClient(Long numClient);
     public Compte  save(Compte cpt); //save or update
     public void deleteById(Long numero);
}
