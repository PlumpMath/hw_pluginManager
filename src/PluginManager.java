import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by balkh on 16.11.2016.
 */
public class PluginManager {
    private final String root;

    public PluginManager(String root) {
        this.root = root;
    }

    public Class<?> loadPlugin(String dirName, String className) {
        URL[] path = null;
        try {
            path = new URL[]{new URL("file://" + root + "/" + dirName)};
        } catch (MalformedURLException e) {
            throw new RuntimeException();
        }
        PluginLoader pluginLoader = new PluginLoader(path, className);
        try {
            return pluginLoader.loadClass(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }
}
