package service;

import database.DataService;
import entity.Account;
import entity.Role;
import exeptions.WebtasksDataException;

import java.util.List;

/**
 * Created by Валера on 14.04.2017.
 */

import database.DataService;
import entity.Account;
import entity.Role;
import exeptions.WebtasksDataException;
//import org.apache.log4j.Logger;

import java.util.List;

    public class LoginService {

        //private static final Logger LOGGER = Logger.getLogger(LoginService.class);

        public Account login(DataService dataService, String login, String password, int role) throws WebtasksDataException {

            Account accountByLogin = dataService.getAccountByLogin(login);

            if (accountByLogin.getId() == 0)
                throw new WebtasksDataException("notFound");
            if (!password.equals(accountByLogin.getPassword()))
                throw new WebtasksDataException("invPass");

            List<Role> roles = accountByLogin.getRoleList();
            Role currentRole = dataService.getRoleById(role);


            if (!roles.contains(currentRole)) {
               // LOGGER.error("authentication error");
                throw new WebtasksDataException("role");
            }
            //LOGGER.info("authentication ok " + currentRole.getName());
            return accountByLogin;
        }

    }


