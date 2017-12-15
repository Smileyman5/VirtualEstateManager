package com.vem.controller.dao.impl;

import com.vem.controller.dao.TaskDao;
import com.vem.controller.model.Task;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alex on 12/14/17.
 */
@Repository
public class TaskDaoImpl implements TaskDao {

    @Autowired
    private SessionFactory session;

    @Override
    public void add(Task task) {
        session.getCurrentSession().save(task);
    }

    @Override
    public void edit(Task task) {
        session.getCurrentSession().update(task);
    }

    @Override
    public void delete(Task task) {
        session.getCurrentSession().delete(task);
    }

    @Override
    public Task getTask(int taskId) {
        return session.getCurrentSession().get(Task.class, taskId);
    }

    @Override
    public List<Task> getAllTasks() {
        return session.getCurrentSession().createQuery("from Task").list();
    }
}
