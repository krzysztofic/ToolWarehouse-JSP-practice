package pl.vermintyn.service;

import pl.vermintyn.model.Tool;
import java.util.List;

public interface ToolService {

    List<Tool> getAll();
    void setAvailability(Long id, boolean isAvailable);
}
