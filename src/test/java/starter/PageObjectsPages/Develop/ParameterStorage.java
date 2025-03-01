package starter.PageObjectsPages.Develop;

import java.util.HashMap;
import java.util.Map;

public class ParameterStorage {
    private Map<String, Parameter> parameterMap;

    public ParameterStorage(Map<String, Parameter> parameterMap) {
        this.parameterMap = parameterMap;
    }

    public Map<String, Parameter> getParameterMap() {
        return parameterMap;
    }

    public static void main(String[] args) {
        // Create parameter map
        Map<String, Parameter> parameterMap = new HashMap<>();
        parameterMap.put("R10520", new Parameter("D1", "ZMT",""));
        parameterMap.put("R10521", new Parameter("PEROUSE 1.8", "ZMT",""));
        parameterMap.put("R10159", new Parameter("C3.3", "ZMT",""));
        parameterMap.put("R10517", new Parameter("RX", "ZMT",""));
        parameterMap.put("R10518", new Parameter("GD", "ZMT",""));

        // Create ParameterStorage instance with the parameter map
        ParameterStorage storage = new ParameterStorage(parameterMap);

        // Example of accessing parameter map from another class
        Map<String, Parameter> storedParameterMap = storage.getParameterMap();
        for (Map.Entry<String, Parameter> entry : storedParameterMap.entrySet()) {
            String parameterNumber = entry.getKey();
            Parameter parameter = entry.getValue();
            System.out.println("Parameter " + parameterNumber + ":");
            System.out.println("Label: " + parameter.getLabel());
            System.out.println("Subfamily: " + parameter.getSubfamily());
        }
    }
}

class Parameter {
    private String label;
    private String subfamily;
    private String shortName;
    public Parameter(String label, String subfamily, String shortName) {
        this.label = label;
        this.subfamily = subfamily;
        this.shortName = shortName;
    }

    public String getLabel() {
        return label;
    }
    public String getShortName() {
        return shortName;
    }

    public String getSubfamily() {
        return subfamily;
    }
}