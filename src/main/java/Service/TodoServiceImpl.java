package Service;

import model.ToDo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TodoServiceImpl implements TodoService {

    private ArrayList<ToDo> toDos;
    private Scanner scanner;

    public TodoServiceImpl(ArrayList<ToDo> toDos, Scanner scanner) {
        this.toDos = toDos;
        this.scanner = scanner;
    }

    public TodoServiceImpl(ArrayList<ToDo> toDos) {
        this.toDos = toDos;
    }

    @Override
    public void addTodo() {
        System.out.println("AddTodo");
        System.out.println("******");
        System.out.println("Enter your item :");
        String itemName = scanner.next();
        //todo
        ToDo todo = new ToDo();
        todo.setId(toDos.size() + 1);
        todo.setItemName(itemName);
        todo.setComplete(false);
        toDos.add(todo);
        System.out.println("*******");
    }

    @Override
    public void viewTodo() {
        System.out.println("ViewTodo");
        System.out.println("*******");
        for (ToDo todo : toDos) {
            System.out.println(todo.getId() + "." + todo.getItemName() + " Completed Status " + (todo.isComplete() ? "Yes" : "No"));
        }
        System.out.println("*******");
    }

    @Override
    public void updateTodo() {
        System.out.println("UpdateTodo");
        System.out.println("********");
        for (ToDo todo : toDos) {
            System.out.println(todo.getId() + "." + todo.getItemName() + " Completed Status " + (todo.isComplete() ? "Yes" : "No"));
        }
        System.out.println("Enter your choice :");
        int choice = scanner.nextInt();
        ToDo toDo = toDos.get(choice-1);
        toDo.setComplete(true);
        System.out.println("*******");


    }

    public void printMainMenu() {
        while (true) {
            System.out.println("1.Add ToDo");
            System.out.println("2.View ToDo");
            System.out.println("3.Update ToDo");
            System.out.println("4.Exit");
            System.out.println("Enter your choice");

            int choice = 0;
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        addTodo();
                        break;
                    case 2:
                        viewTodo();
                        break;
                    case 3:
                        updateTodo();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice");

                }
            } catch (InputMismatchException exception) {
                System.out.println("Invalid choice");

            }
        }
    }
}
