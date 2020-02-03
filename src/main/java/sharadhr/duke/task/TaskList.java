package sharadhr.duke.task;

import java.util.ArrayList;

public class TaskList
{
    private ArrayList<Task> tasks;

    public TaskList()
    {
        this.tasks = new ArrayList<Task>();
    }

    public TaskList(ArrayList<Task> tasks)
    {
        this.tasks = tasks;
    }

    /**
     * Adds a task to the list.
     * 
     * @param task A task to be added to the list.
     * @return {@code true} if task was successfully added (as specified by
     *         {@link ArrayList#add})
     * @throws IOException
     */
    public boolean addTask(Task task)
    {
        // Was the task successfully added to the list?
        boolean added = Task.tasks.add(task);
        
        Duke.writer.sayTaskAdded(task);
        Duke.fileRW.appendTask(task);
        
        return added;
    }

    private Task getTaskAtIndex(int index) throws IndexOutOfBoundsException
    {
        return tasks.get(index);
    }

    /**
     * Returns a task at {@code position}.
     * 
     * @param position The 1-indexed position of the task in the list
     * @return The task at the specified {@code position}
     * @throws IndexOutOfBoundsException if {@code position}
     *                                   ≥ size of tasks list + 1
     */
    public Task getTaskAtPosition(int position) throws IndexOutOfBoundsException
    {
        return this.getTaskAtIndex(position - 1);
    }

    /**
     * Deletes the task at the specified {@code position}.
     * 
     * @param position the (1-indexed) position of the task to be deleted
     */
    public void deleteTaskAtPosition(int position)
    {
        Duke.writer.sayTaskDeleted(this.getTaskAtPosition(position));
        tasks.remove(position - 1);
    }

    /**
     * Prints the tasks in this list.
     */
    public void listTasks()
    {
        if (!Task.tasks.isEmpty())
        {
            Duke.writer.say("Here are the tasks in your list:");
            
            int listNumber = 1;
            for (Task task : Task.tasks)
            {
                Duke.writer.add(String.format("%d.%s%n", listNumber++, task));
            }
            Duke.writer.say();
        }
        else Duke.writer.say("You have no tasks in your list.");
    }

	public int numberOfTasks()
	{
		return this.tasks.size();
	}
}