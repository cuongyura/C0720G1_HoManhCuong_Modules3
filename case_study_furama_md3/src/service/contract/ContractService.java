package service.contract;

import model.contract.Contract;

import java.util.List;

public interface ContractService {
    void createContract(Contract contract);
    List<Contract> getAllContract();
}
