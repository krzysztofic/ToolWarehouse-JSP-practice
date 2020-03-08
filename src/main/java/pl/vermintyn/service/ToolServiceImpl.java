package pl.vermintyn.service;

import pl.vermintyn.dao.ToolDao;
import pl.vermintyn.dao.ToolDaoImpl;
import pl.vermintyn.model.Tool;

import java.util.List;


public class ToolServiceImpl implements ToolService {

    private static ToolServiceImpl instance;
    public static ToolServiceImpl getInstance(){
        if(instance ==null){
            instance = new ToolServiceImpl();
        }
        return instance;
    }

    private ToolServiceImpl(){}

    private ToolDao toolDao = new ToolDaoImpl();


    @Override
    public List<Tool> getAll() {
        return toolDao.getAll();
    }

    @Override
    public void setAvailability(Long id, boolean isAvailable) {
        toolDao.setAvailability(id, isAvailable);

    }
}
