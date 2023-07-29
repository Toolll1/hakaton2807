package ru.hackathon2807.controllers.admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.hackathon2807.dto.BankCreateDto;
import ru.hackathon2807.dto.CreditDto;
import ru.hackathon2807.services.BankService;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/bank/admin")
public class BankControllerAdmin {

    private final BankService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BankCreateDto createBank(@Valid @RequestBody BankCreateDto dto) {

        log.info("Received a request to create a bank " + dto);

        return service.createBank(dto);
    }

    @PatchMapping("/{bankId}")
    public BankCreateDto updateBank(@RequestBody BankCreateDto dto,
                                   @PathVariable Long bankId) {

        log.info("Received a request to update a bank {}. bankId = {}", dto, bankId);

        return service.updateBank(dto, bankId);
    }

    @DeleteMapping("/{bankId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBank(@PathVariable Long bankId) {


        log.info("Received a request to delete a bank with an id " + bankId);

        service.deleteBank(bankId);
    }

    @GetMapping("/{bankId}")
    public BankCreateDto getBank(@PathVariable Long bankId) {

        log.info("Received a request to search bank for id {}", bankId);

        return service.getBank(bankId);
    }

    @GetMapping("/credits")
    public List<CreditDto> getCredits(@RequestParam(value = "from", defaultValue = "0") @Min(0) Integer from,
                                      @RequestParam(value = "size", defaultValue = "10") @Min(1) Integer size) {

        log.info("Received a request to search credits");

        return service.getCredits(from, size);
    }

    @GetMapping
    public List<BankCreateDto> getBanks(@RequestParam(value = "from", defaultValue = "0") @Min(0) Integer from,
                                       @RequestParam(value = "size", defaultValue = "10") @Min(1) Integer size) {

        log.info("Received a request to search all banks}");

        return service.getBanks(from, size);
    }
}