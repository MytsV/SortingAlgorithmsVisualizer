package myts.victoria.configapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import myts.victoria.config.VisualizationConfig;

import java.io.InputStream;

public class FileConfiguration {

    private final VisualizationConfig<?> config;

    public FileConfiguration(VisualizationConfig<?> config) {
        this.config = config;
    }

    public void load() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = VisualizationConfig.class.getResourceAsStream("/config.json");
            VisualizationConfig<?> config = mapper.readValue(is, VisualizationConfig.class);
            this.config.copyFrom(config);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

}
