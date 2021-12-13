package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {

    private List<Human> humans = new ArrayList<>();

    public void readHumansFromFile(Path path) {
        try {
            humans = getListOfHumans(Files.readAllLines(path));
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public void writeMaleHumansToFile(Path path) {
        try {
            List<String> result = getMales(humans);
            Files.write(path, result);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't write file!", ioe);
        }
    }

    private List<Human> getListOfHumans(List<String> result) {
        List<Human> humans = new ArrayList<>();
        for (String actual : result) {
            String[] part = actual.split(";");
            humans.add(new Human(part[0], part[1]));
        }
        return humans;
    }

    private List<String> getMales(List<Human> humans) {
        List<String> result = new ArrayList<>();
        for (Human actual : humans) {
            if (actual.getIdentityNumber().startsWith("1") || actual.getIdentityNumber().startsWith("3")) {
                result.add(actual.toString());
            }
        }
        return result;
    }

    public List<Human> getHumans() {
        return humans;
    }
}
