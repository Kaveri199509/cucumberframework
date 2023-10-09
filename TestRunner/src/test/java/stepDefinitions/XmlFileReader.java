package stepDefinitions;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class XmlFileReader {
   public static String XML_FILE_PATH = "C:\\QA_Automation\\TestRunner\\configs\\config.xml";
   public static String PROPERTIES_FILE_PATH = "C:\\QA_Automation\\TestRunner\\configs\\configuration.properties";
    private static XmlFileReader instance;
    private XmlFileReader() {

    }
    public static synchronized XmlFileReader getInstance() {
        if (instance == null) {
            instance = new XmlFileReader();
        }
        return instance;
    }

    public DataPropertiesProvider reader() {

// Load properties from properties file
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(PROPERTIES_FILE_PATH)) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

// Update XML file with property values
        try {
            File xmlFile = new File(XML_FILE_PATH);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("property");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String attributeName = element.getAttribute("name");

                    if (properties.containsKey(attributeName)) {
                        String propertyValue = properties.getProperty(attributeName);
                        element.setTextContent(propertyValue);
                    }
                }
            }

// Write updated XML to file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new FileOutputStream(xmlFile));
            transformer.transform(source, result);
        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
            e.printStackTrace();
            return null;
        }

// Write updated values to POJO class
        DataPropertiesProvider dataPropertiesProvider = new DataPropertiesProvider();
        dataPropertiesProvider.setAppUrl(properties.getProperty("APP_URL"));
        dataPropertiesProvider.setBrowser(properties.getProperty("BROWSER"));
        dataPropertiesProvider.setMinWait(properties.getProperty("MIN_WAIT"));
        dataPropertiesProvider.setMaxWait(properties.getProperty("MAX_WAIT"));
        dataPropertiesProvider.setAvgWait(properties.getProperty("AVG_WAIT"));
        dataPropertiesProvider.setBrowserVersion(properties.getProperty("BROWSER_VERSION"));
        dataPropertiesProvider.setPlatformName(properties.getProperty("PLATFORM_NAME"));
        dataPropertiesProvider.setPlatformName(properties.getProperty("BASE_URL"));
        dataPropertiesProvider.setMobile(properties.getProperty("MOBILE"));
        return dataPropertiesProvider;
        }
}

