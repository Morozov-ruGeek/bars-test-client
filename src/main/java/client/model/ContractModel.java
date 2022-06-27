package client.model;

/**
 * @author Aleksey Morozov
 * @since 27.06.2022
 */
public class ContractModel {
    private String contractId;
    private String contractDate;
    private String updateAt;
    private boolean checkBox;

    private ContractModel() {
    }

    private ContractModel(String contractId, String contractDate, String updateAt, boolean checkBox) {
        this.contractId = contractId;
        this.contractDate = contractDate;
        this.updateAt = updateAt;
        this.checkBox = checkBox;
    }

    public String getContractId() {
        return contractId;
    }

    public String getContractDate() {
        return contractDate;
    }

    public String getUpdateAt() {
        return updateAt;
    }

    public boolean isCheckBox() {
        return checkBox;
    }

    public static ContractModel create(String contractId,
                                       String contractDate,
                                       String updateAt,
                                       boolean checkBox){
        return new ContractModel(contractId, contractDate, updateAt, checkBox);
    }

    @Override
    public String toString() {
        return "ContractModel{" +
                "contractId='" + contractId + '\'' +
                ", contractDate='" + contractDate + '\'' +
                ", updateAt='" + updateAt + '\'' +
                ", checkBox=" + checkBox +
                '}';
    }
}
