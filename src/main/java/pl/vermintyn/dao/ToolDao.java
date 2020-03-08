package pl.vermintyn.dao;

import pl.vermintyn.model.Tool;
import java.util.List;

public interface ToolDao {

    List<Tool> getAll();
    void setAvailability(Long id, boolean isAvailable);
}
