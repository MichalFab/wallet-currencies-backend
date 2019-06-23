package net.devdiaries.wallet.controllers;

import net.devdiaries.wallet.domain.Currency;
import net.devdiaries.wallet.domain.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CurrencyController {

    private final CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyController(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @GetMapping("/currencies")
    public Iterable<Currency> getCurrencies() {
        return currencyRepository.findAll();
    }

    @DeleteMapping("/currencies/{id}")
    void deleteCurrency(@PathVariable Long id) {
        currencyRepository.deleteById(id);
    }

    @PostMapping("/currencies")
    void addCurrency(@RequestBody Currency currency) {
        currencyRepository.save(currency);
    }

    @PutMapping("/currencies")
    void updateCurrency(@RequestBody Currency currency) {
        currencyRepository.save(currency);
    }
}
