package th.ac.ku.bankaccount.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import th.ac.ku.bankaccount.data.BankAccountRepository;
import th.ac.ku.bankaccount.model.BankAccount;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/bankaccount")
public class BankAccountRestController {

    private BankAccountRepository repository;

    public BankAccountRestController(BankAccountRepository repository){
        this.repository  = repository;
    }

    @GetMapping
    public List<BankAccount> getAll(){
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public BankAccount getOne(@PathVariable int id){
        try {
            return repository.findById(id).get();
        }catch (NoSuchElementException e){
            return null;
        }
    }
}

