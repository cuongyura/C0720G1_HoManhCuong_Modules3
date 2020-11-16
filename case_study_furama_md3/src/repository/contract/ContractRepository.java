package repository.contract;

import model.contract.Contract;

import java.util.List;

public interface ContractRepository {
    void createContract(Contract contract);
    List<Contract> getAllContract();
}
