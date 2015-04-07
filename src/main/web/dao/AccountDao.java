package dao;

import entity.Account;


import java.util.List;

//
public interface AccountDao {

    List<Account> getAccounts();

    Account getDisciplineById(int id);

    boolean updateAccount(Account account);

    boolean addAccount(Account account);

    boolean deleteeAccount(int id);

}
