package menuClasses;

import dataManager.DMComponent;
import ioManagementClasses.IOComponent;

public class DeleteFromListAction implements Action {

	@Override
	public void execute(Object args) {
		DMComponent dm = (DMComponent)args;
        IOComponent io = IOComponent.getComponent();
        dm.showListsNames();
        String list = io.getInput("\nEnter name of the list to be removed: ");
        dm.removeList(list);
    }

}
