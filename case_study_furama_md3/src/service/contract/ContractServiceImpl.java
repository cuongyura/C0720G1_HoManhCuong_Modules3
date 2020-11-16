package service.contract;

import model.contract.Contract;
import repository.contract.ContractRepository;
import repository.contract.ContractRepositoryImpl;

import java.util.List;

public class ContractServiceImpl implements ContractService {
    private ContractRepository contractRepository = new ContractRepositoryImpl();
    @Override
    public void createContract(Contract contract) {
        contractRepository.createContract(contract);
    }

    @Override
    public List<Contract> getAllContract() {
        return contractRepository.getAllContract();
    }
}
