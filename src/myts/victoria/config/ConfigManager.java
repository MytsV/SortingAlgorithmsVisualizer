package myts.victoria.config;

public class ConfigManager<T extends Comparable<T>> {

    private static ConfigManager<?> manager;
    private VisualizationConfig<T> config;

    public static <S extends Comparable<S>> ConfigManager<S> getInstance() {
        if (manager == null) {
            manager = new ConfigManager<S>();
        }
        return (ConfigManager<S>) manager;
    }

    public VisualizationConfig<T> getConfig() {
        return config;
    }

    public void setConfig(VisualizationConfig<T> config) {
        this.config = config;
    }

}
