package gz.xml2json;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            String xml = FileUtils.readFileToString(new File("group.xml"), "UTF-8");
            System.out.println(xml);
            XmlMapper mapper = new XmlMapper();
            Group group = mapper.readValue(xml, Group.class);
            System.out.println(group);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(group);
            FileUtils.writeStringToFile(new File("group.json"), json, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
