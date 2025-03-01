package starter.PageObjectsPages;

public class PVSPGPData {

    private String serialNumber;
    private String productType;
    private String productCategory;
    private String productVariantIdentifier;
    private String sellableProductIdentifier;
    private String globalProductIdentifier;
    private String pecoNumber;
    private String pvJsonId;
    private String spJsonId;
    private String gpJsonId;

    public String getPvIntegrationResponse() {
        return pvIntegrationResponse;
    }

    public void setPvIntegrationResponse(String pvIntegrationResponse) {
        this.pvIntegrationResponse = pvIntegrationResponse;
    }

    public String getSpIntegrationResponse() {
        return spIntegrationResponse;
    }

    public void setSpIntegrationResponse(String spIntegrationResponse) {
        this.spIntegrationResponse = spIntegrationResponse;
    }

    public String getGpIntegrationResponse() {
        return gpIntegrationResponse;
    }

    public void setGpIntegrationResponse(String gpIntegrationResponse) {
        this.gpIntegrationResponse = gpIntegrationResponse;
    }

    private String pvIntegrationResponse;
    private String spIntegrationResponse;
    private String gpIntegrationResponse;
    private String errorMessage;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductVariantIdentifier() {
        return productVariantIdentifier;
    }

    public void setProductVariantIdentifier(String productVariantIdentifier) {
        this.productVariantIdentifier = productVariantIdentifier;
    }

    public String getSellableProductIdentifier() {
        return sellableProductIdentifier;
    }

    public void setSellableProductIdentifier(String sellableProductIdentifier) {
        this.sellableProductIdentifier = sellableProductIdentifier;
    }

    public String getGlobalProductIdentifier() {
        return globalProductIdentifier;
    }

    public void setGlobalProductIdentifier(String globalProductIdentifier) {
        this.globalProductIdentifier = globalProductIdentifier;
    }

    public String getPecoNumber() {
        return pecoNumber;
    }

    public void setPecoNumber(String pecoNumber) {
        this.pecoNumber = pecoNumber;
    }

    public String getPvJsonId() {
        return pvJsonId;
    }

    public void setPvJsonId(String pvJsonId) {
        this.pvJsonId = pvJsonId;
    }

    public String getSpJsonId() {
        return spJsonId;
    }

    public void setSpJsonId(String spJsonId) {
        this.spJsonId = spJsonId;
    }

    public String getGpJsonId() {
        return gpJsonId;
    }

    public void setGpJsonId(String gpJsonId) {
        this.gpJsonId = gpJsonId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
