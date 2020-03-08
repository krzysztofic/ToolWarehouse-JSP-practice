package pl.vermintyn.dao;

import pl.vermintyn.model.Tool;
import pl.vermintyn.model.ToolType;

import java.util.Arrays;
import java.util.List;

public class ToolDaoImpl implements ToolDao{

    private static ToolDaoImpl instance;
    List<Tool> tools;

    public ToolDaoImpl(){
        tools = Arrays.asList(
                new Tool(1L, "Red Hammer", ToolType.HAMMER, true),
                new Tool(2L, "Sonic screwdriver", ToolType.SCREWDRIVER, true),
                new Tool(3L, "Pila", ToolType.SAW, true),
                new Tool(4L, "PilaII", ToolType.SAW, true));
        }

    private static ToolDaoImpl getInstance() {
        if(instance ==null){
            instance = new ToolDaoImpl();
        }
        return instance;
    }


    @Override
    public List<Tool> getAll() {
        return tools;
    }

    @Override
    public void setAvailability(Long id, boolean isAvailable) {

        tools.stream()
                .filter(tool -> tool.getId().equals(id))
                .findAny()
                .ifPresent(tool -> tool.setAvailability(isAvailable));
    }
}
