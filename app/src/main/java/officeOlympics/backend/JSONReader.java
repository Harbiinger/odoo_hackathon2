package officeOlympics.backend;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

/**
 * The <code>JSONReader</code> is a support for reading .json files. The methods and constructors make it very easy
 * to read object in the json file.
 */
public class JSONReader {
    JSONObject obj;

    /**
     * <code>JSONReader</code> Constructor.
     * It opens the json file and prepares it to read its content.
     *
     * @param fileName The name of the JSON file
     */
    public JSONReader(String fileName) throws IOException, ParseException {
        String path = System.getProperty("user.dir");
        System.out.println(path);
        JSONParser jsonparser = new JSONParser();
        FileReader reader = new FileReader(path + "/src/main/resources/back/" + fileName);
        this.obj = (JSONObject) jsonparser.parse(reader);
    }

    /**
     * @param key The name of the key we want to read the value
     * @return The Object value associated to the key
     */
    public JSONObject getObject(String key) {
        return (JSONObject) this.obj.get(key);
    }

    public JSONArray getArray(String key) {
        return (JSONArray) this.obj.get(key);
    }

    /**
     * @param key The name of the key we want to read the value
     * @return The string value associated to the key
     */
    public String getString(String key) {
        return this.obj.get(key).toString();
    }

    /**
     * @param key The name of the key we want to read the value
     * @return The Int value associated to the key
     */
    public int getInt(String key) {
        return Integer.parseInt(this.obj.get(key).toString());
    }

    /**
     * @param key The name of the key we want to read the value
     * @return The Boolean value associated to the key
     */
    public boolean getBoolean(String key) {
        return Boolean.getBoolean(this.obj.get(key).toString());
    }

    /**
     * @param key The name of the key we want to read the value
     * @return The Byte value associated to the key
     */
    public byte getByte(String key) {
        return Byte.parseByte(this.obj.get(key).toString());
    }


}