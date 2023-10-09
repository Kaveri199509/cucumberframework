package stepDefinitions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataPropertiesProvider {
    private String appUrl;
    private String browser;
    private String  minWait;
    private String maxWait;
    private String avgWait;
    private String browserVersion;
    private String platformName;
    private String baseUrl;
    private String mobile;
}
