package configFileReader;

import constants.LogImplementation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class CSVFileReader {
    private static Object convertToObject(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            try {
                return Double.parseDouble(value);
            } catch (NumberFormatException ex) {
                return value;
            }
        }
    }

    public static int convertToInt(Object value) {
        if (value == null) {
            return 0;
        }

        if (value instanceof Integer) {
            return (int) value;
        } else if (value instanceof BigDecimal) {
            return ((BigDecimal) value).intValue();
        } else if (value instanceof Double) {
            return ((Double) value).intValue();
        } else if (value instanceof String) {
            try {
                return Integer.parseInt((String) value);
            } catch (NumberFormatException e) {
                return 0;
            }
        } else {
            throw new IllegalArgumentException("Unsupported type for conversion: " + value.getClass());
        }
    }

    public static Double convertToDouble(Object value) {
        if (value == null) {
            return 0.0;
        }

        if (value instanceof Double) {
            return (Double) value;
        } else if (value instanceof BigDecimal) {
            return ((BigDecimal) value).doubleValue();
        } else if (value instanceof String) {
            try {
                return Double.parseDouble((String) value);
            } catch (NumberFormatException e) {
                return 0.0;
            }
        } else {
            throw new IllegalArgumentException("Unsupported type for conversion: " + value.getClass());
        }
    }

    public List<Map<String, Object>> readCSVData(String filePath, String delimiter) {
        List<Map<String, Object>> csvData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String[] headers = null;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                if (headers == null) {
                    headers = values;
                } else {
                    Map<String, Object> rowData = new HashMap<>();
                    Object[] objectArray = Arrays.stream(values)
                            .map(CSVFileReader::convertToObject)
                            .toArray();

                    for (int i = 0; i < values.length; i++) {
                        rowData.put(headers[i], objectArray[i]);
                    }

                    csvData.add(rowData);
                }
            }
        } catch (IOException e) {
            LogImplementation.info(e.getMessage());
        }

        return csvData;
    }


}

