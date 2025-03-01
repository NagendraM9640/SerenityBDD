package starter.PageObjectsPages;

public class PartData {
    private int rowNumber;
    private String serialNum;
    private String itemType;
    private String subfamily;
    private String productGroup;
    private String itemCode;
    private String ecoItemCode;
    private String jsonID;
    private String integrationResponse;
    private String errorMsg;


    private String pTempCode;


    // Getters and setters

    public String getpTempCode() {
        return pTempCode;
    }

    public void setpTempCode(String pTempCode) {
        this.pTempCode = pTempCode;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public String getItemType() {
        return itemType;
    }

    public String getJsonID() {
        return jsonID;
    }

    public void setJsonID(String jsonID) {
        this.jsonID = jsonID;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getSubfamily() {
        return subfamily;
    }

    public void setSubfamily(String subfamily) {
        this.subfamily = subfamily;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getEcoItemCode() {
        return ecoItemCode;
    }

    public void setEcoItemCode(String ecoItemCode) {
        this.ecoItemCode = ecoItemCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getIntegrationResponse() {
        return integrationResponse;
    }

    public void setIntegrationResponse(String integrationResponse) {
        this.integrationResponse = integrationResponse;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    @Override
    public String toString() {
        return "PartData{" +
                "rowNumber=" + rowNumber +
                ", itemType='" + itemType + '\'' +
                ", subfamily='" + subfamily + '\'' +
                ", productGroup='" + productGroup + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", ecoItemCode='" + ecoItemCode + '\'' +
                ", JSON ID ='" + jsonID + '\'' +
                ", integrationResponse='" + integrationResponse + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
