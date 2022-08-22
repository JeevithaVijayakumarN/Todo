import Service.TodoService;
import Service.TodoServiceImpl;
import model.ToDo;
import utils.ToDoUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoUtils toDoUtils = new ToDoUtils();
        ArrayList<ToDo> todos = toDoUtils.getTodos();
        TodoServiceImpl todoServiceImpl = new TodoServiceImpl(todos,scanner);
        todoServiceImpl.printMainMenu();

    }
}
