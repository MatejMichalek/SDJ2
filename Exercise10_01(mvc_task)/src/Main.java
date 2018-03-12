import java.util.Scanner;

import tasklist.controller.TaskListController;
import tasklist.domain.mediator.TaskListModel;
import tasklist.domain.mediator.TaskListModelManager;
import tasklist.domain.model.Task;
import tasklist.domain.model.TaskList;
import tasklist.view.TaskListConsole;
import tasklist.view.TaskListView;

public class Main
{
   public static void main(String args[])
   {
     TaskListModel model=new TaskListModelManager();
     TaskListView view=new TaskListConsole();
     TaskListController controller= new TaskListController(model, view);
     view.startView(controller);
   }
}
