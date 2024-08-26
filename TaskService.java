package module;

import java.util.ArrayList;

public class TaskService {
	private ArrayList<Task> tasks;
	
	public TaskService() {
		 tasks = new ArrayList<Task>();
	}
	
	public Task GetTask(String _taskId) {
		for( Task task : tasks ) {
			if(task.taskId.equals(_taskId))
				return task;
		}
		return null;
	}
	
	public void AddTask(String _taskId, String _name, String _description) {
		tasks.add(new Task(_taskId, _name, _description));
	}
	
	public void AddTask(Task c) {
		tasks.add(c);
	}
	
	public void DeleteTask(String _taskId) {
		Task toDelete = null;
		for( Task task : tasks ) {
			if(task.taskId.equals(_taskId)) {
				toDelete = task;
				break;
			}
		}
		tasks.remove(toDelete);
	}
	
	public void UpdateTask(Task c) {
		for( Task task : tasks ) {
			if(task.taskId.equals(c.taskId))
			{
				tasks.get(tasks.indexOf(task)).name = c.name;
				tasks.get(tasks.indexOf(task)).description = c.description;
			}
		}
	}
}
